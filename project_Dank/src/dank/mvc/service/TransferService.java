package dank.mvc.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.TransferDao;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class TransferService {
	@Autowired
	private TransferDao transferdao;
	
	public void transferprocess(int trmoney,Map<String, Integer> mapmy,Map<String, String> mapmysp,
										Map<String, Integer> mapyour,Map<String, String> mapyoursp) {
		transferdao.pluswit(trmoney);
		transferdao.pluswittr(mapmy);
		transferdao.plusspwit(mapmysp);
		transferdao.trwitupbal(mapmy);
		
		transferdao.plusdep(trmoney);
		transferdao.plusdeptr(mapyour);
		transferdao.plusspdep(mapyoursp);
		transferdao.trdepupbal(mapyour);
	}
}
