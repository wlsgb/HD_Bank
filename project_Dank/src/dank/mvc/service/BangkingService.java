package dank.mvc.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.BangkingDao;
import dank.mvc.vo.deposit.TransferDTO;

@Service
@Transactional
public class BangkingService  {
	@Autowired
	private BangkingDao bangkingdao;
	
	public void depositprocess(String money,Map<String, String> paramapsp,Map<String, String> paramapbal) {
		bangkingdao.depplusdep(money);
		bangkingdao.depplussp(paramapsp);
		bangkingdao.depdepupbalance(paramapbal);
	}
	public void withdrawprocess(String money,Map<String, String> paramapsp,Map<String, String> paramapbal) {
		bangkingdao.witpluswit(money);
		bangkingdao.witplussp(paramapsp);
		bangkingdao.witwitupbalance(paramapbal);
	}
	
	public void transferprocess(TransferDTO my_tr,TransferDTO your_tr) {
		bangkingdao.trpluswit(my_tr.getAt_set_mony());
		bangkingdao.trpluswittr(my_tr);
		bangkingdao.trplusspwit(my_tr);
		bangkingdao.trtrwitupbal(my_tr);
		
		bangkingdao.trplusdep(your_tr.getAt_set_mony());
		bangkingdao.trplusdeptr(your_tr);
		bangkingdao.trplusspdep(your_tr);
		bangkingdao.trtrdepupbal(your_tr);
		//자동이체
		if(my_tr.getAta_code() != null) {
			bangkingdao.afterchkup(your_tr.getAta_code());
		}
		
	}


	
	
	
	
//	public void autotransferprocess(String trmoney,Map<String, String> mapmy,Map<String, String> mapmysp,
//			Map<String, String> mapyour,Map<String, String> mapyoursp, String atacode) {
//			bangkingdao.trpluswit(trmoney);
//			bangkingdao.trpluswittr(mapmy);
//			bangkingdao.trplusspwit(mapmysp);
//			bangkingdao.trtrwitupbal(mapmy);
//			
//			bangkingdao.trplusdep(trmoney);
//			bangkingdao.trplusdeptr(mapyour);
//			bangkingdao.trplusspdep(mapyoursp);
//			bangkingdao.trtrdepupbal(mapyour);
//			
//			bangkingdao.afterchkup(atacode);
//		}

}
