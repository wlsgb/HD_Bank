package dank.mvc.model;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dank.mvc.dao.BangkingDao;
import dank.mvc.othersetting.AsyncConfig;
import dank.mvc.othersetting.AsyncTaskAutoTransfer;
import dank.mvc.vo.deposit.At_applicationVO;

@Controller
public class IndexController {
		//스레드_성윤
		@Resource(name = "asyncTaskAutoTransfer")
		private AsyncTaskAutoTransfer asyncTaskAutoTransfer;
		//AsyncConfig_성윤
		@Resource(name = "asyncConfig")
		private AsyncConfig asyncConfig;
		@Autowired//스레드_성윤
		boolean autoTransferChk;
		@Autowired//스레드_성윤
		private BangkingDao bangkingdao;
	
		@RequestMapping(value= {"/","/index"})

		public String indexPage(HttpSession session) throws Exception {
			HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			String ip = req.getHeader("X-FORWARDED-FOR");
			if (ip==null) {
				ip = req.getRemoteAddr();
			}
			System.out.println("ip정보: "+ip);

			session.removeAttribute("error");
			session.removeAttribute("pageName");
			
			

			//자동이체 스레드_성윤------
			try {
				
	            // 등록 가능 여부 체크_성윤
	            if (asyncConfig.isTaskExecute()) {
	            	//두번실행 방지_성윤
	            	if(autoTransferChk) {
	            		autoTransferChk=false;
		            	Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		            	for (Thread e : threadSet) {
		            		System.out.println(e.getName()+autoTransferChk);
		            	}
		            	System.out.println("now thread name"+Thread.currentThread().getName());
		            	asyncTaskAutoTransfer.executorAutotrnsfer("atr");
	            	}
	            } else {
	                System.out.println("==============>>>>>>>>>>>> THREAD 개수 초과");
	            }
	        } catch (Exception e) {
	            // TaskRejectedException : 개수 초과시 발생
	            System.out.println("==============>>>>>>>>>>>> THREAD ERROR");
	            System.out.println("TaskRejectedException : 등록 개수 초과");
	            System.out.println("==============>>>>>>>>>>>> THREAD ENDs");
	        }
			
			//자동이체 스레드_성윤------
			return "index/index";
		}

}
