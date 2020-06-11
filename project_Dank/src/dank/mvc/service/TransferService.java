package dank.mvc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dank.mvc.dao.TransferDao;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class TransferService {

	private TransferDao transferdao;
}
