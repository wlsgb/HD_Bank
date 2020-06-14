package dank.mvc.method;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.dao.BangkingDao;
import dank.mvc.dao.DepositDao;
import dank.mvc.vo.deposit.ProSavInsDto;
import dank.mvc.vo.deposit.ProductVO;

@Repository
public class AccountNum {
	@Autowired
	private BangkingDao bangkingDao;
	@Autowired
	private SqlSessionTemplate ss;
	
	//7자리 랜덤숫자 생성
	public String randomNum() {
		String randomNum="";
		for(int i=0;i<7;i++) {
			int random = (int) (Math.random() * 9 + 1);
			randomNum+=random;
		}
		return randomNum;
	}
	//10자리 계좌번호 생성
	public String createAcNum(int deptype) {
		String acNum = "";
		int acCnt=0;
		do{
			acNum = "";
			acNum+=deptype;
			acNum+=randomNum();
			acCnt=bangkingDao.depcheckac(Integer.parseInt(acNum));
		}while(acCnt != 0) ;
		return acNum;
	}
	
	public int getPro_codeNum(ProSavInsDto psi) {
		int deptype = psi.getDeptype();
		switch (deptype) {
		case 100:
		case 500:
			return ss.selectOne("deposit.pro_codeNum", psi.getSav_code());
		case 300:
		case 700:
			return ss.selectOne("deposit.pro_codeNum", psi.getIns_code());
		default:
			return 0;
		}
	}
}
