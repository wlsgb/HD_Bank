package dank.mvc.method;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.dao.DepositDao;
import dank.mvc.vo.deposit.ProSavInsDto;
import dank.mvc.vo.deposit.ProductVO;

@Repository
public class AccountNum {
	@Autowired
	private DepositDao depositDao;
	@Autowired
	private SqlSessionTemplate ss;
	
	//7자리 계좌번호 생성
	public String randomNum() {
		String randomNum="";
		for(int i=0;i<7;i++) {
			int random = (int) (Math.random() * 9 + 1);
			randomNum+=random;
		}
		return randomNum;
	}
	public String AcNum(ProSavInsDto psi) {
		StringBuffer acNum = new StringBuffer();
		if(psi.getSav_code() != 0) {
			if(psi.getShas_code() == 0) {
				acNum.append("100");
				acNum.append(randomNum());
				return acNum.toString();
			}else {
				acNum.append("500");
				acNum.append(randomNum());
				return acNum.toString();
			}
			
		}else if(psi.getIns_code() != 0) {
			if(psi.getShac_code() == 0) {
				acNum.append("300");
				acNum.append(randomNum());
				return acNum.toString();
			}else {
				acNum.append("700");
				acNum.append(randomNum());
				return acNum.toString();
			}
		}else {
			return "계좌를 만들수 없음";
		}
		
	}
	public String createAcNum(ProductVO product) {
		
		int acNumCnt = ss.selectOne(".");
		
		
		return "";
	}
	
}
