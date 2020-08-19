package dank.mvc.model;


import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.LoanDao;
import dank.mvc.service.LoanService;
import dank.mvc.vo.FilenameVO;
import dank.mvc.vo.LoanApplicationVO;
import dank.mvc.vo.LoanCaculatorVO;
import dank.mvc.vo.LoanCheckVO;
import dank.mvc.vo.LoanFileVO;
import dank.mvc.vo.LoanProductVO;
import dank.mvc.vo.LoanRepayLogVO;
import dank.mvc.vo.LoanRepayVO;
import dank.mvc.vo.MemberVO;
import dank.mvc.vo.deposit.AccountVO;
import dank.mvc.vo.deposit.TransferDTO;

@Controller
public class LoanController {
	//최호현
	
	@Autowired
	private LoanDao loanDao;
	
	@Autowired
	private LoanService loanService;
	@Autowired
	private BangkingDao bangkingdao;
	
	
	//대출 상품 정보 가져오기
	@RequestMapping(value = "/product")
	public String product(Model model) {
		List<LoanProductVO> list = loanDao.getLoanProductList();
		model.addAttribute("list", list);
		return "loan/product";
	}
	
	//대출 상품 디테일 ajax로 가져오기
	@RequestMapping(value = "/productinfo")
	public ModelAndView productinfo(int lp_num) {
		ModelAndView mav = new ModelAndView("loan/server/productserver");
		LoanProductVO vo = loanDao.getProductInfo(lp_num);	
		mav.addObject("vo", vo);
		
		return mav;
	}
	//대출 신청
	@RequestMapping(value = "/application")
	public String application(Model model) {
		List<LoanProductVO> list = loanDao.getLoanProductList();
		model.addAttribute("list", list);
		return "loan/application";
	}
	//대출 신청폼
	@RequestMapping(value = "/applicationform")
	public String applicationform(Model model,int lp_num,HttpSession session) {
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //세션 정보가 존재한다면 home 으로 
			session.setAttribute("pageName", "application");
			return "login/login";
		}		
		LoanProductVO vo = loanDao.getProductInfo(lp_num);
		model.addAttribute("vo", vo);
		return "loan/applicationform";
	}
	//대출 신청
	@RequestMapping(value = "/applicationsuccess",method = RequestMethod.POST)
	public String applicationsuccess(LoanCheckVO vo,LoanApplicationVO avo) {
		loanService.addloanaplication(avo, vo);
		return "redirect:success";
	}
	//대출 성공 페이지
	@RequestMapping(value = "/success")
	public String success() {
		return "loan/applicationsuccess";
	}
	//신청 대출 정보 리스트
	@RequestMapping(value = "/check")
	public ModelAndView check(HttpSession session) {
		ModelAndView mav = new ModelAndView("loan/check");

		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //세션 정보가 존재한다면 home 으로 
			session.setAttribute("pageName", "check");
			mav.setViewName("login/login");
			return mav;
		}	
		
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		List<LoanCheckVO> list =loanDao.checkdetailList(mem_code);
		mav.addObject("list", list);
		return mav;
	}
	
	//신청 정보 디테일
	@RequestMapping(value = "/checkdetail")
	public ModelAndView checkdetail(int lc_num,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loan/checkdetail");
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		LoanCheckVO vo = new LoanCheckVO();
		vo.setLc_num(lc_num);
		vo.setMem_code(mem_code);
		mav.addObject("vo",loanDao.checkdetail(vo));
		return mav;
	}

	@RequestMapping(value = "/checkfile")
	public ModelAndView checkfile(int lc_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("lc_num", lc_num);
		List<FilenameVO> list = loanDao.filelist();
		mav.addObject("list", list);
		mav.setViewName("loan/checkfile");
		for(FilenameVO e: list) {
			System.out.println(e);
			System.out.println("***********((((((((((((((");
		}
		return mav;
	}
	@RequestMapping(value = "/checkrefile")
	public ModelAndView checkrefile(int lc_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("lc_num", lc_num);
		mav.setViewName("loan/checkrefile");
		return mav;
	}
	
	
	//파일 업로드 리스트
	@RequestMapping(value = "/fileuploadhome")
	public ModelAndView fileuploadhome(HttpSession session) {
		ModelAndView mav = new ModelAndView("loan/fileuploadhome");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //세션 정보가 존재한다면 home 으로 
			session.setAttribute("pageName", "fileuploadhome");
			mav.setViewName("login/login");
			return mav;
		}	
		
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		List<LoanCheckVO> list =loanDao.checkdetailList(mem_code);
		mav.addObject("list", list);
		return mav;
	}
	//제출 파일 디테일
	@RequestMapping(value = "/checkfiledetail")
	public ModelAndView checkfiledetail(int lc_num) {
		ModelAndView mav = new ModelAndView("loan/checkfiledetail");
		List<LoanFileVO> list = loanDao.filelist(lc_num);
		mav.addObject("list",list);
		mav.addObject("lc_num",lc_num);
		for(LoanFileVO e: list) {
			System.out.println(e.getLf_oriname());
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
		}
		return mav;
	}
	//대출 실행
	@RequestMapping(value = "/loanstart")
	public  ModelAndView loanstart(int lc_num,String ac_num,HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:check");
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		LoanCheckVO v = new LoanCheckVO();
		v.setMem_code(mem_code);
		v.setLc_num(lc_num);
		LoanCheckVO check = loanDao.checkdetail(v);
		LoanRepayVO vo = new LoanRepayVO();
		vo.setLc_num(check.getLc_num());
		vo.setLr_amount(check.getLoanApplicationVO().getLa_hamount());
		vo.setLr_balance(vo.getLr_amount());
		Calendar cal = Calendar.getInstance();
		vo.setLr_repaydate(cal.get(Calendar.DAY_OF_MONTH));
		int livingterm = Integer.parseInt(check.getLoanApplicationVO().getLa_livingterm().substring(0,1));
		cal.add(Calendar.YEAR, livingterm);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day= cal.get(Calendar.DAY_OF_MONTH);
		vo.setLr_firstdate(year+"/"+month+"/"+day);
		vo.setLr_reaccount(ac_num);
		
		
		
		TransferDTO my_tr =new TransferDTO();
		my_tr.setAc_num("9001111111");
		my_tr.setHd_code("2");
		my_tr.setAt_dps_ac(ac_num);
		my_tr.setAt_set_mony(String.valueOf(vo.getLr_amount()));
		my_tr.setSp_name(check.getLoanProductVO().getLp_name());
		
		
		TransferDTO your_tr = new TransferDTO();
		your_tr.setAc_num(vo.getLr_reaccount());
		your_tr.setMem_code(String.valueOf(mem_code));
		your_tr.setAt_dps_ac("9001111111");
		your_tr.setAt_set_mony(String.valueOf(vo.getLr_amount()));
		your_tr.setSp_name(check.getLoanProductVO().getLp_name());
		
		

		
		
		
		if(bangkingdao.trtrAcChk("9001111111") >=1) {
			if(bangkingdao.trtrAcChk(ac_num) >=1) {
				if(Long.parseLong(bangkingdao.trbalChkadmin(my_tr)) >=Long.parseLong(String.valueOf(vo.getLr_amount()))) {
					loanService.startrepay(vo, my_tr,your_tr);
				}
			}
		}
		
		return mav;
	}
	//대출 상환 폼
	@RequestMapping(value = "/repaymentloan")
	public ModelAndView repayloan(HttpSession session,int lc_num) {
		ModelAndView mav = new ModelAndView("loan/repaymentloan");
		LoanCheckVO v = new LoanCheckVO();
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		v.setLc_num(lc_num);
		v.setMem_code(mem_code);
		
		LoanCheckVO vo = loanDao.checkdetail(v);
		mav.addObject("vo", vo);
		
		
		List<AccountVO> list = loanDao.repayaccount(mem_code);
		mav.addObject("list", list);
		return mav;
	}
	//대출 상환
	
	@RequestMapping(value = "/loanrepay")
	public ModelAndView loanrepay(HttpSession session,String lr_balance,String ac_num,String lp_name,int lc_num,int lp_cancelfee) {
		ModelAndView mav = new ModelAndView("redirect:check");
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		LoanRepayVO vo = new LoanRepayVO();
		double balance = Double.parseDouble(lr_balance);
		double bal1 = (double)(balance/100);
		System.out.println("bal1:"+bal1);
		double bal2 = bal1*(100-lp_cancelfee);
		System.out.println("bal2"+bal2);
		int bal = (int)Math.round(bal2);
		System.out.println("bal="+bal);
		
		vo.setLc_num(lc_num);
		vo.setLr_balance(bal);		

		LoanRepayLogVO logVO = new LoanRepayLogVO();
		logVO.setLc_num(lc_num);
		logVO.setLrl_amount(bal);
		logVO.setLrl_interest(Integer.parseInt(lr_balance)-bal);
		logVO.setLrl_total(Integer.parseInt(lr_balance));
		
		
		TransferDTO my_tr =new TransferDTO();
		my_tr.setAc_num(ac_num);
		my_tr.setMem_code(String.valueOf(mem_code));
		my_tr.setAt_dps_ac("9002222222");
		my_tr.setAt_set_mony(lr_balance);
		my_tr.setSp_name(lp_name+" 상환");

		
		TransferDTO your_tr = new TransferDTO();
		your_tr.setAc_num("9002222222");
		your_tr.setHd_code("2");
		your_tr.setAt_dps_ac(ac_num);
		your_tr.setAt_set_mony(lr_balance);
		your_tr.setSp_name(lp_name+" 상환");
		
		

		
		if(bangkingdao.trtrAcChk("9001111111") >=1) {
			if(bangkingdao.trtrAcChk(ac_num) >=1) {
				if(Long.parseLong(bangkingdao.trbalChk(my_tr)) >=Long.parseLong(lr_balance)) {
					loanService.repayloan(my_tr,your_tr,vo,logVO);
				
			}
		}
		}
		return mav;
	}
	//대출 실행 폼
	@RequestMapping(value = "/repaymentstart")
	public ModelAndView repaymentstart(int lc_num,HttpSession session) {
		ModelAndView mav = new ModelAndView("loan/repaymentstart"); 
		LoanCheckVO v = new LoanCheckVO();
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		v.setLc_num(lc_num);
		v.setMem_code(mem_code);
		
		LoanCheckVO vo = loanDao.checkdetail(v);
		mav.addObject("vo", vo);
		
		
		List<AccountVO> list = loanDao.repayaccount(mem_code);
		mav.addObject("list", list);
		return mav;
	}
	//이자 계산기 계산
	@RequestMapping(value = "/caculator", method = RequestMethod.POST)
	public ModelAndView caculator(LoanCaculatorVO vo) {
		ModelAndView mav = new ModelAndView("loan/server/caculatorserver");
		List<LoanCaculatorVO> list = new ArrayList<LoanCaculatorVO>();
		
		int m = vo.getM();
		int g = vo.getG();
		float r = vo.getR()/100;
		int n = vo.getN();
		if(vo.getTerm()==1) {
			n *=12;
		}
		if(vo.getTerm2()==1) {
			g*=12;
		}
		int totalterm = n+g;
		
		if(vo.getType()==1) {
			for (int i = 0; i < totalterm; i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				if(i<g) {
					v.setRepayM(0);
					v.setRepayR((int)Math.ceil((m*(r/12))));
					v.setRepayMR(v.getRepayM()+v.getRepayR());
				}else {
					v.setRepayM(m/n);
					v.setRepayR((int) Math.ceil((m-((i-g)*m/n))*r/n));
					v.setRepayMR(v.getRepayM()+v.getRepayR());
					if(i==totalterm-1) {
						v.setRepayMR(list.get(list.size()-1).getBalance()+v.getRepayR());
					}
				}
				
				if(i==0) {
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
				}else {
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
				}
				
				list.add(v);
			
			}
			
		}else if(vo.getType()==2) {
			
			for(int i =0;i<totalterm;i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				if(i<g) {
					v.setRepayR((int) Math.ceil((m*(r/12))));
					v.setRepayMR(v.getRepayR());
					v.setRepayM(0);
				}else {
					if(i==0) {
						v.setRepayR((int) Math.ceil((m*(r/12))));
					}else {	
						v.setRepayR((int) Math.ceil(list.get(list.size()-1).getBalance()*(r/12)));
					}	
					
					v.setRepayMR((int) (((m*r/12)*(Math.pow((1+r/12), n)))/((Math.pow((1+r/12), n))-1)));
					v.setRepayM(v.getRepayMR()-v.getRepayR());
					if(i==totalterm-1) {
						v.setRepayMR(list.get(list.size()-1).getBalance()+v.getRepayR());
					}
				}
				
				if(i==0) {
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
				}else {
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
				}
				list.add(v);
			}
		}else if(vo.getType()==3) {
			for (int i = 0; i < totalterm; i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				v.setRepayR((int) (m*r/12));
				if(i!=totalterm-1) {
					v.setRepayM(0);
					v.setRepayMR(v.getRepayR());
				}else {
					v.setRepayM(m);
					v.setRepayMR(v.getRepayR()+v.getRepayM());
				}
				
				if(i==0) {
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
				}else {
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
				}
				
				list.add(v);
			}
		}
		int sumM = 0;
		int sumR = 0;
		int sumT = 0;
				
		for(LoanCaculatorVO e: list) {
			sumM += e.getRepayM();
			sumR += e.getRepayR();
			sumT += e.getRepayMR();
		}
		mav.addObject("list", list);
		mav.addObject("m",m);
		mav.addObject("sumM",sumM);
		mav.addObject("sumR",sumR);
		mav.addObject("sumT",sumT);
		return mav;
	}
	
	@RequestMapping(value = "/caculatorchart", method = RequestMethod.POST)
	public ModelAndView caculatorchart(LoanCaculatorVO vo) {
		ModelAndView mav = new ModelAndView("loan/server/caculatorchartserver");
		List<LoanCaculatorVO> list = new ArrayList<LoanCaculatorVO>();
		JSONObject json = new JSONObject();
		JSONArray mlist = new JSONArray();
		JSONArray rlist = new JSONArray();
		JSONArray mrlist = new JSONArray();
		JSONArray tlist = new JSONArray();
		mlist.add("납입원금");
		rlist.add("대출이자");
		mrlist.add("월상환금");
		tlist.add("대출잔금");
		int m = vo.getM();
		int g = vo.getG();
		float r = vo.getR()/100;
		int n = vo.getN();
		if(vo.getTerm()==1) {
			n *=12;
		}
		if(vo.getTerm2()==1) {
			g*=12;
		}
		int totalterm = n+g;
		
		if(vo.getType()==1) {
			for (int i = 0; i < totalterm; i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				if(i<g) {
					
					v.setRepayM(0);
					v.setRepayR((int)Math.ceil((m*(r/12))));
					v.setRepayMR(v.getRepayM()+v.getRepayR());
					mlist.add(v.getRepayM());
					rlist.add(v.getRepayR());
					mrlist.add(v.getRepayMR());
				}else {
					
					
					v.setRepayM(m/n);
					v.setRepayR((int) Math.ceil((m-((i-g)*m/n))*r/n));
					mlist.add(v.getRepayM());
					rlist.add(v.getRepayR());
					if(i==totalterm-1) {
						v.setRepayMR(list.get(list.size()-1).getBalance()+v.getRepayR());
						mrlist.add(v.getRepayMR());
					}else {
						v.setRepayMR(v.getRepayM()+v.getRepayR());
						mrlist.add(v.getRepayMR());
					}
				}
				
				if(i==0) {
					
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
					tlist.add(v.getBalance());
				}else {
					
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
					tlist.add(v.getBalance());
				}
				
				list.add(v);
				json.put("m", mlist);
				json.put("r", rlist);
				json.put("mr", mrlist);
				json.put("t", tlist);
			}
			
		}else if(vo.getType()==2) {
			
			for(int i =0;i<totalterm;i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				if(i<g) {
					v.setRepayR((int) Math.ceil((m*(r/12))));
					v.setRepayMR(v.getRepayR());
					v.setRepayM(0);
					mlist.add(v.getRepayM());
					rlist.add(v.getRepayR());
					mrlist.add(v.getRepayMR());
				}else {
					if(i==0) {
						v.setRepayR((int) Math.ceil((m*(r/12))));
						rlist.add(v.getRepayR());
					}else {	
						v.setRepayR((int) Math.ceil(list.get(list.size()-1).getBalance()*(r/12)));
						rlist.add(v.getRepayR());
					}	
					if(i==totalterm-1) {
						v.setRepayMR(list.get(list.size()-1).getBalance()+v.getRepayR());
						mrlist.add(v.getRepayMR());
					}else {
						v.setRepayMR((int) (((m*r/12)*(Math.pow((1+r/12), n)))/((Math.pow((1+r/12), n))-1)));
						mrlist.add(v.getRepayMR());
					}
					v.setRepayM(v.getRepayMR()-v.getRepayR());
					mlist.add(v.getRepayM());
					
				}
				
				if(i==0) {
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
					tlist.add(v.getBalance());
				}else {
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
					tlist.add(v.getBalance());
				}
				list.add(v);
				json.put("m", mlist);
				json.put("r", rlist);
				json.put("mr", mrlist);
				json.put("t", tlist);
			}
		}else if(vo.getType()==3) {
			for (int i = 0; i < totalterm; i++) {
				LoanCaculatorVO v = new LoanCaculatorVO();
				v.setRepayR((int) (m*r/12));
				rlist.add(v.getRepayR());
				if(i!=totalterm-1) {
					v.setRepayM(0);
					v.setRepayMR(v.getRepayR());
					mlist.add(v.getRepayM());
					mrlist.add(v.getRepayMR());
				}else {
					v.setRepayM(m);
					v.setRepayMR(v.getRepayR()+v.getRepayM());
					mlist.add(v.getRepayM());
					mrlist.add(v.getRepayMR());
				}
				
				if(i==0) {
					v.setBalance(m+v.getRepayR()-v.getRepayMR());
					tlist.add(v.getBalance());
				}else {
					v.setBalance(list.get(list.size()-1).getBalance()+v.getRepayR()-v.getRepayMR());
					tlist.add(v.getBalance());
				}
				
				list.add(v);
				json.put("m", mlist);
				json.put("r", rlist);
				json.put("mr", mrlist);
				json.put("t", tlist);
			}
		}
		int sumM = 0;
		int sumR = 0;
		int sumT = 0;
				
		for(LoanCaculatorVO e: list) {
			sumM += e.getRepayM();
			sumR += e.getRepayR();
			sumT += e.getRepayMR();
		}
		mav.addObject("json", json);
		return mav;
	}
	
	
	
	
	//대출 상환 리스트
	@RequestMapping(value = "/repayment")
	public ModelAndView repayment(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("loan/repayment");

		MemberVO member = (MemberVO)session.getAttribute("member");
		if(member == null) { //세션 정보가 존재한다면 home 으로 
			mav.setViewName("login/login");
			return mav;
		}	
		
		int mem_code =((MemberVO)session.getAttribute("member")).getMem_code();
		List<LoanCheckVO> list =loanDao.checkdetailList(mem_code);
		mav.addObject("list", list);
		return mav;		
	}
	//이자 계산기 이동
	@RequestMapping(value = "/caculator")
	public String caculator() {
		return "loan/caculator";
	}
	// 제출서류 다운로드
	 @RequestMapping(value = "/Download.do")
	   public String fileDown(HttpServletRequest req , ModelMap modelMap) throws Exception {
	     String fileName = req.getParameter("fileName");
	     String fileDir =  req.getParameter("fileDir");
	     //String a = URLDecoder.decode(fileName, "EUC-KR");
	     //System.out.println("디코더 : "+a);
	     System.out.println("*********************");
	      System.out.println(fileName);
	     modelMap.put("fileName", fileName);
	     modelMap.put("fileDir", fileDir);
	     
	     return "/loan/server/filedown";
	   }
	 //제출 서류 등록
	 @RequestMapping(value = "/fileupload",method =  RequestMethod.POST)
	 public ModelAndView fileupload(LoanFileVO vo,HttpServletRequest request) {
		 ModelAndView mav = new ModelAndView("redirect:check");
		 HttpSession session = request.getSession();
			String r_path = session.getServletContext().getRealPath("/");
			String img_path ="resources\\upload\\";
		 		try {
		 			 File ff = null; 
					 ff = new File(r_path+img_path+vo.getLc_num());
					 System.out.println(r_path+img_path+vo.getLc_num());
					 if(!ff.exists()) {
						 ff.mkdirs();
					 }
					 for(LoanFileVO e: vo.getList()) {
						 if(e.getMfile().getOriginalFilename()!="") {
							 StringBuffer path = new StringBuffer();
							 path.append(r_path).append(img_path).append(vo.getLc_num()).append("\\").append(e.getMfile().getOriginalFilename());
							 ff = new File(path.toString());
							 e.getMfile().transferTo(ff);
							 e.setLf_oriname(e.getMfile().getOriginalFilename());
							 e.setLc_num(vo.getLc_num());
							 loanDao.fileup(e);
						 }
					 }
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
		 		loanDao.stateupdate(vo.getLc_num());
		 		
		 		
		 return mav;
	 }
	 

}