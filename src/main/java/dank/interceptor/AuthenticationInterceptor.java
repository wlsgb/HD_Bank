package main.java.dank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import main.java.dank.dao.VisitorDao;
import main.java.dank.vo.Curr_VisitorVO;
import main.java.dank.vo.MemberVO;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private VisitorDao visitorDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ��ó����� Ŭ���̾�Ʈ���� ��Ʈ�ѷ��� ��û�� �� ����ä�� ���̴�. ���� ���� ��Ʈ�ѷ��� ȣ��Ǳ� ���� ����Ǵ� �޼����̴�.
//		System.out.println("AuthenticationInterceptor ����");
		Curr_VisitorVO vo = new Curr_VisitorVO();
		
		// ip ������ �޾ƿ´�.
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
//		System.out.println("ip����: " + ip);
		
		// �����ڰ� ��� �������� �̵��ߴ��� �����ش�.
		String path = request.getServletPath();
//		System.out.println("path: " + path);
		if (path.length()>=10) {
			if (path.substring(0, 10).equals("/resources")) {
//				System.out.println("���� ����");
				return true;
			}
		}
		// �������� agent�� �����ش�.
		String ua = request.getHeader("user-agent");
//		System.out.println("ua:"+ua);
		
		
//		String query = request.getQueryString(); // �Ķ���Ͱ� �ִ��� ������
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
		// ��ó����� ��Ʈ�ѷ����� Ŭ���̾�Ʈ�� ��û�� �� ����ä�� ���̴�. ���� ���� ��Ʈ�ѷ��� ȣ��ǰ� �� �Ŀ� ����Ǵ� �޼����̴�.
//		System.out.println("postHandle ����");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// ��Ʈ�ѷ��� ó���� ������ ȭ��ó������ ��� ������ ����Ǵ� �޼����̴�.
//		System.out.println("afterCompletion ����");
		super.afterCompletion(request, response, handler, ex);
	}
}
