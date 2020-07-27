package dank.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dank.mvc.dao.VisitorDao;
import dank.mvc.vo.Curr_VisitorVO;
import dank.mvc.vo.MemberVO;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private VisitorDao visitorDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 전처리기는 클라이언트에서 컨트롤러로 요청할 때 가로채는 것이다. 쉽게 말해 컨트롤러가 호출되기 전에 실행되는 메서드이다.
//		System.out.println("AuthenticationInterceptor 진입");
		Curr_VisitorVO vo = new Curr_VisitorVO();
		
		// ip 정보를 받아온다.
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
//		System.out.println("ip정보: " + ip);
		
		// 접속자가 어느 페이지로 이동했는지 보여준다.
		String path = request.getServletPath();
//		System.out.println("path: " + path);
		if (path.length()>=10) {
			if (path.substring(0, 10).equals("/resources")) {
//				System.out.println("리턴 실패");
				return true;
			}
		}
		// 접속자의 agent를 보여준다.
		String ua = request.getHeader("user-agent");
//		System.out.println("ua:"+ua);
		
		
//		String query = request.getQueryString(); // 파라미터가 있는지 없는지
//		System.out.println("query: " + query);
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		vo.setCv_ip(ip);
		vo.setCv_page(path);
		vo.setCv_url("/project_Dank"+path);
		vo.setCv_referer("-");
		vo.setCv_agent(ua);
//		System.out.println("obj: " + obj);
		if (obj != null) {
			int memCode = ((MemberVO)session.getAttribute("member")).getMem_code();
			vo.setMem_code(memCode);
//			response.sendRedirect("/project_Dank/loginPage");
//			return false;
			visitorDao.addvisitor(vo);
			return true;
		}
		vo.setMem_code(-1);
		visitorDao.addvisitor(vo);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 후처리기는 컨트롤러에서 클라이언트로 요청할 때 가로채는 것이다. 쉽게 말해 컨트롤러가 호출되고 난 후에 실행되는 메서드이다.
//		System.out.println("postHandle 진입");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 컨트롤러의 처리가 끝나고 화면처리까지 모두 끝나면 실행되는 메서드이다.
//		System.out.println("afterCompletion 진입");
		super.afterCompletion(request, response, handler, ex);
	}
}
