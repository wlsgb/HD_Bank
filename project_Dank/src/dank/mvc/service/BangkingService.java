package dank.mvc.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.BangkingDao;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class BangkingService {
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

	public void transferprocess(String trmoney,Map<String, String> mapmy,Map<String, String> mapmysp,
		Map<String, String> mapyour,Map<String, String> mapyoursp) {
		bangkingdao.trpluswit(trmoney);
		bangkingdao.trpluswittr(mapmy);
		bangkingdao.trplusspwit(mapmysp);
		bangkingdao.trtrwitupbal(mapmy);
		
		bangkingdao.trplusdep(trmoney);
		bangkingdao.trplusdeptr(mapyour);
		bangkingdao.trplusspdep(mapyoursp);
		bangkingdao.trtrdepupbal(mapyour);
	}
	public void autotransferprocess(String trmoney,Map<String, String> mapmy,Map<String, String> mapmysp,
			Map<String, String> mapyour,Map<String, String> mapyoursp, String atacode) {
			bangkingdao.trpluswit(trmoney);
			bangkingdao.trpluswittr(mapmy);
			bangkingdao.trplusspwit(mapmysp);
			bangkingdao.trtrwitupbal(mapmy);
			
			bangkingdao.trplusdep(trmoney);
			bangkingdao.trplusdeptr(mapyour);
			bangkingdao.trplusspdep(mapyoursp);
			bangkingdao.trtrdepupbal(mapyour);
			
			bangkingdao.afterchkup(atacode);
		}
}
