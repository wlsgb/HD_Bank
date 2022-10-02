package main.java.dank.method;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.dao.BangkingDao;
import main.java.dank.vo.deposit.ProSavInsDto;

@Repository
public class AccountNum {
	@Autowired
	private BangkingDao bangkingDao;
	@Autowired
	private SqlSessionTemplate ss;

	//7�ڸ� �������� ����
	public String randomNum() {
		String randomNum = "";
		for (int i = 0; i < 7; i++) {
			int random = (int)(Math.random() * 9 + 1);
			randomNum += random;
		}
		return randomNum;
	}

	//10�ڸ� ���¹�ȣ ����
	public String createAcNum(int deptype) {
		String acNum = "";
		int acCnt = 0;
		do {
			acNum = "";
			acNum += deptype;
			acNum += randomNum();
			acCnt = bangkingDao.depcheckac(acNum);
		} while (acCnt != 0);
		return acNum;
	}

	public int getPro_codeNum(ProSavInsDto psi) {
		int deptype = psi.getDeptype();
		switch (deptype) {
			case 100:
			case 500:
				return ss.selectOne("deposit.pro_codeNum", psi);
			case 300:
			case 700:
				return ss.selectOne("deposit.pro_codeNum", psi);
			default:
				return 0;
		}
	}
}
