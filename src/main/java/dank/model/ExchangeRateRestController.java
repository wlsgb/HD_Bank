package main.java.dank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.dank.method.ExchangeRate;

@RestController
public class ExchangeRateRestController {

	@Autowired
	private ExchangeRate exchangeRate;

	@RequestMapping(value = "exchangeRateJson", produces = "application/text; charset=euc-kr")
	public String exchangeRateJson() {
		String erj = exchangeRate.exchangeRateJson();
		return erj;
	}
}
