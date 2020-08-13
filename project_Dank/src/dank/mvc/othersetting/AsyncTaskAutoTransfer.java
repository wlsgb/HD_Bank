package dank.mvc.othersetting;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.velocity.tools.config.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import dank.mvc.dao.BangkingDao;
import dank.mvc.service.BangkingService;
import dank.mvc.vo.deposit.At_applicationVO;
import dank.mvc.vo.deposit.TransferDTO;

@Service("asyncTaskAutoTransfer")
public class AsyncTaskAutoTransfer {
	
	@Autowired
	Boolean autoTransferChk;
	
	
	@Autowired
	BangkingDao bangkingdao;
	
	@Autowired
	BangkingService bangkingservice;
	
//	Timer timer = new Timer();
//	TimerTask timertask = new TimerTask() {
//		
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			System.out.println("testprint");
//			//timer.schedule(timertask, 5000);
//			List<At_applicationVO> atlist = bangkingdao.atloadval();
//			System.out.println("자동이체 리스트 갯수"+atlist.size());
//			for (At_applicationVO e : atlist) {
//				System.out.println(e.getAc_code());
//			}
//			
//		}
//	};
	
	@Async("autoTransferExecutor")
	public void executorAutotrnsfer(String str) {
		System.out.println("==============>>>>>>>>>>>> THREAD START");
        
        System.out.println(str);
        while(true) {
		try {
			Thread.sleep(5000);
			List<At_applicationVO> atlist = bangkingdao.atloadval();
			System.out.println("자동이체 리스트 갯수"+atlist.size());
//			for (At_applicationVO e : atlist) {
//				System.out.println(e.getAc_num());
//				System.out.println(e.getAta_myacmemo());
//			}
			//자동이체 할께 있다면 true
			if(atlist.size() >0) {
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd-HH-mm");
				
				String nowtime_full=sdf.format(new Date()).toString();
				
//				System.out.println(nowtime_full);
				
				String[] nowtime_piece=nowtime_full.split("-");
				int nowtime_year = Integer.parseInt(nowtime_piece[0]);//현재 년도
				int nowtime_month =Integer.parseInt(nowtime_piece[1]);//현재 월
				int nowtime_date=Integer.parseInt(nowtime_piece[2]);//현재 일
				int nowtime_hour=Integer.parseInt(nowtime_piece[3]);//현재 시간
				int nowtime_minute=Integer.parseInt(nowtime_piece[4]);//현재 분
				
				int attime_year=0;//적힌년도
				int attime_month=0;//적힌월
				int attime_date=0;//적힌일
				int attime_hour=0;//적힌시간
				int attime_minute=0;//적힌분
				
//				System.out.println("현재년도>>"+nowtime_year);
//				System.out.println("현재 월  >>"+nowtime_month);
//				System.out.println("현재 일  >>"+nowtime_date);
//				System.out.println("현재 시  >>"+nowtime_hour);
//				System.out.println("현재 분  >>"+nowtime_minute);
				for(At_applicationVO e : atlist) {//리스트 있는것만큼 반복
//					System.out.println(e.getAta_time());
//					System.out.println(e.getAta_startdate());
					attime_year=Integer.parseInt(e.getAta_startdate().split("-")[0]);
					attime_month=Integer.parseInt(e.getAta_startdate().split("-")[1]);
					attime_date=Integer.parseInt(e.getAta_startdate().split("-")[2]);
					attime_hour=Integer.parseInt(e.getAta_time().split(":")[0]);
					attime_minute=Integer.parseInt(e.getAta_time().split(":")[1]);
//					System.out.println("통장년도 >>"+attime_year);
//					System.out.println("통장 월   >>"+attime_month);
//					System.out.println("통장 일   >>"+attime_date);
//					System.out.println("통장 시   >>"+attime_hour);
//					System.out.println("통장 분   >>"+attime_minute);
					String myacwrite =null;
					String youracwrite=null;
					
					if(attime_year <= nowtime_year) {
						if(attime_month <= nowtime_month) {
							if(attime_date < nowtime_date) {
							}else if(attime_date == nowtime_date) {
								if(attime_hour < nowtime_hour) {
								}else if(attime_hour == nowtime_hour) {
									if(attime_minute < nowtime_minute) {
									}else if(attime_minute == nowtime_minute) {
										/////자동이체실행
										try {
											myacwrite = URLDecoder.decode(e.getAta_myacmemo(), "UTF-8");
											youracwrite = URLDecoder.decode(e.getAta_youracmemo(), "UTF-8");
										} catch (UnsupportedEncodingException f) {
											// TODO Auto-generated catch block
											f.printStackTrace();
										}
										
										TransferDTO my_tr = new TransferDTO();
										my_tr.setAc_num(e.getAc_num());
										my_tr.setMem_code(String.valueOf(e.getAta_mymemcode()));
										my_tr.setAt_dps_ac(e.getAta_yourac());
										my_tr.setSp_name(myacwrite);
										my_tr.setAt_set_mony(String.valueOf(e.getAta_setmoney()));
										my_tr.setAta_code(String.valueOf(e.getAta_code()));
										
//										System.out.println("mytr>>"+my_tr.toString());
//										System.out.println("mytr>>"+my_tr.getAc_num());
//										System.out.println("mytr>>"+my_tr.getMem_code());
//										System.out.println("mytr>>"+my_tr.getAt_dps_ac());
//										System.out.println("mytr>>"+my_tr.getSp_name());
//										System.out.println("mytr>>"+my_tr.getAt_set_mony());
//										System.out.println("mytr>>"+my_tr.getAta_code());

										TransferDTO your_tr = new TransferDTO();
										your_tr.setAc_num(e.getAta_yourac());
										your_tr.setMem_code(String.valueOf(e.getAta_yourmemcode()));
										your_tr.setAt_dps_ac(e.getAc_num());
										your_tr.setSp_name(youracwrite);
										your_tr.setAt_set_mony(String.valueOf(e.getAta_setmoney()));
										your_tr.setAta_code(String.valueOf(e.getAta_code()));
										
//										System.out.println("yourtr>>"+your_tr.toString());
//										System.out.println("yourtr>>"+your_tr.getAc_num());
//										System.out.println("yourtr>>"+your_tr.getMem_code());
//										System.out.println("yourtr>>"+your_tr.getAt_dps_ac());
//										System.out.println("yourtr>>"+your_tr.getSp_name());
//										System.out.println("yourtr>>"+your_tr.getAt_set_mony());
//										System.out.println("yourtr>>"+your_tr.getAta_code());

										
										
										
										
										if(bangkingdao.trtrAcChk(my_tr.getAc_num()) >=1) {
											System.out.println("1");
											if(bangkingdao.trtrAcChk(your_tr.getAc_num()) >=1) {

												System.out.println("2");
												
												if(Long.parseLong(bangkingdao.trbalChk(my_tr)) >= Long.parseLong(my_tr.getAt_set_mony()) ) {
													bangkingservice.transferprocess(my_tr, your_tr);
													System.out.println("자동이체실행댐");
												}else {
													bangkingdao.ifnomoneywhenat(String.valueOf(e.getAta_code()));
												}
											}
										}
										
//										System.out.println("자동이체실행");
										
										
										
										
									}
								}
							}
						}
						
						
					}
					
					
					
				}
				
				
			}
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("AsyncTaskAutoTransfer쪽에서 난 에러"+autoTransferChk);
			autoTransferChk=true;
		}
//		timer.schedule(timertask, 5000);
		
		
		}
        
        
        //System.out.println("==============>>>>>>>>>>>> THREAD END");
	
	}

}
