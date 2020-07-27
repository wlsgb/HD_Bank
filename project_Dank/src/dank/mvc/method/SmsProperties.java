package dank.mvc.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SmsProperties {
	
	@RequestMapping(value = "/sendSMS")
	public String sendSMS(String userPhoneNumber) {
		String api_key="NCSNJETH2DZH45LE";
		String api_secret = "HPUX3CCLXEEJSLEWMVS3JTSDNIWVHDNZ";
		
		
		return "";
	}
}
