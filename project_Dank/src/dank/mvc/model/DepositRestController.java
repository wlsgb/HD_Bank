package dank.mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dank.mvc.dao.DepositDao;
import dank.mvc.vo.deposit.Installment_savingVO;
import dank.mvc.vo.deposit.SavingVO;

@RestController
public class DepositRestController {
	@Autowired
	private DepositDao depositDao;
	
	@RequestMapping(value = "/savlist")
	public List<SavingVO> savlist() {
		return depositDao.getSavlist();
	}
	
	@RequestMapping(value = "/inslist")
	public List<Installment_savingVO> inslist() {
		return depositDao.getInslist();
	}
}
