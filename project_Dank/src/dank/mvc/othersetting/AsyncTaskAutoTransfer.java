package dank.mvc.othersetting;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import dank.mvc.dao.BangkingDao;
import dank.mvc.vo.deposit.At_applicationVO;

@Service("asyncTaskAutoTransfer")
public class AsyncTaskAutoTransfer {
	
	@Autowired
	Boolean autoTransferChk;
	
	
	@Autowired
	BangkingDao bangkingdao;
	
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
			for (At_applicationVO e : atlist) {
				System.out.println(e.getAc_num());
				System.out.println(e.getAta_myacmemo());
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
