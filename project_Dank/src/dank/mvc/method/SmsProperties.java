
package dank.mvc.method;

import java.util.HashMap;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
@Repository
public class SmsProperties {

	public boolean sendSms(String mem_phn, String content) {
		/**
		 * @class ExampleSend
		 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API
		 *        PHP
		 */
		
//		if(true) {
//			System.out.println("메세지 전송기능은 일시정지되어있습니다.");
//			return false;
//		}
		String api_key = "NCSNJETH2DZH45LE";
		String api_secret = "HPUX3CCLXEEJSLEWMVS3JTSDNIWVHDNZ";
		Message coolsms = new Message(api_key, api_secret);

		String[] phoneNumList = mem_phn.split("-");
		String phoneNum = "";
		for(String e : phoneNumList){
			phoneNum += e;
		}
		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phoneNum);
		params.put("from", "01039475130");
		params.put("type", "SMS");
		params.put("text", content);
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		return true;
	}

}
