package dank.mvc.method;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dank.mvc.dao.SecurityDao;
import dank.mvc.vo.security.Security_CardVO;
import dank.mvc.vo.security.Security_Card_RegVO;

@Repository
public class SecurityCode {

	@Autowired
	private SecurityDao securityDao;

	// 입력한 숫자만큼 자릿수가 랜덤한 숫자로 생성된다.
	// 예 ) 4 => 5249
	public String securityCodeMaking(int len) {
		StringBuffer emailSecuCode = new StringBuffer();
		int a = len / 2;
		String front = "";
		String back = "";
		int random = 0;

		// 앞자리와 뒷자리의 숫자가 같으면 뒷자리의 다시 돌린다.
		do {
			front = "";
			back = "";
			// 앞 자리의 숫자를 랜덤으로 입력한다.
			for (int i = 0; i < a; i++) {
				if (i == 0) {
					random = (int) (Math.random() * 9 + 1);
					front += random;
				} else {
					random = (int) (Math.random() * 9);
					front += random;
				}

			}
			// 뒷 자리의 숫자를 랜덤으로 입력한다.
			for (int i = 0; i < a; i++) {
				random = (int) (Math.random() * 9);
				back += random;
			}
		} while (front.equals(back));

		emailSecuCode.append(front).append(back);
		System.out.println(emailSecuCode.toString());
		return emailSecuCode.toString();
	}

	public String[][] cardNumControll(Security_CardVO vo) {

		// 일련번호 or 몇번째코드, 앞자리 or 뒷자리, 번호
		String[][] securityCheckData = new String[3][3];

		int fronBack = 0;
		int randomNum = 0;

		String subStringCode = "";
		String code = "";
		String fb = "";
		xx: for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					switch (j) {
					case 0:
						securityCheckData[i][j] = "일련번호";
						break;
					case 1:
						fronBack = (int) (Math.random() * 2 + 1);
						fb = (fronBack == 1) ? "앞" : "뒤";
						securityCheckData[i][j] = fb;
						break;
					case 2:
						code = String.valueOf(vo.getSc_code());
						subStringCode = (securityCheckData[i][j - 1].equals("앞")) ? code.substring(0,2)
								: code.substring(code.length() - 2, code.length());
						securityCheckData[i][j] = subStringCode;
						break;
					default:
						break;
					}
				} else if (i == 1) {
					switch (j) {
					case 0:
						randomNum = (int) (Math.random() * 30 + 1);
						securityCheckData[i][j] = String.valueOf(randomNum);
						break;
					case 1:
						fronBack = (int) (Math.random() * 2 + 1);
						fb = (fronBack == 1) ? "앞" : "뒤";
						securityCheckData[i][j] = fb;
						break;
					case 2:
						code = String.valueOf(vo.getSc_detcode()[randomNum - 1]);
						subStringCode = (securityCheckData[i][j - 1].equals("앞")) ? code.substring(0,2)
								: code.substring(code.length() - 2, code.length());
						securityCheckData[i][j] = subStringCode;
						break;
					default:
						break;
					}
				} else if (i == 2) {
					switch (j) {
					case 0:
						randomNum = (int) (Math.random() * 30 + 1);
						securityCheckData[i][j] = String.valueOf(randomNum);
						if (securityCheckData[i - 1][j].equals(securityCheckData[i][j])) {
							continue xx;
						}
 
						break;
					case 1:
						fronBack = (int) (Math.random() * 2 + 1);
						fb = (fronBack == 1) ? "앞" : "뒤";
						securityCheckData[i][j] = fb;
						break;
					case 2:
						code = String.valueOf(vo.getSc_detcode()[randomNum - 1]);
						subStringCode = (securityCheckData[i][j - 1].equals("앞")) ? code.substring(0,2)
								: code.substring(code.length() - 2, code.length());
						securityCheckData[i][j] = subStringCode;
						break;
					default:
						break;
					}
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("securityCheckData[" + i + "][" + j + "] : " + securityCheckData[i][j]);
			}
		}
		return securityCheckData;

	}

	// 보안카드 제작
	public Security_CardVO securityCardCreate() {
		Security_CardVO vo = new Security_CardVO();
		// 일련번호를 넣어준다.
		String priCode = "";
		do {
			priCode = securityCodeMaking(8);
			vo.setSc_code(Integer.parseInt(priCode));
		} while (securityDao.priCodeChk(vo) == 1);

		// 30개의 번호를 넣어준다.
		String[] subCode = new String[30];
		for (int i = 0; i < 30; i++) {
			subCode[i] = securityCodeMaking(4);
		}
		vo.setSc_detcode_1(subCode[0]);
		vo.setSc_detcode_2(subCode[1]);
		vo.setSc_detcode_3(subCode[2]);
		vo.setSc_detcode_4(subCode[3]);
		vo.setSc_detcode_5(subCode[4]);
		vo.setSc_detcode_6(subCode[5]);
		vo.setSc_detcode_7(subCode[6]);
		vo.setSc_detcode_8(subCode[7]);
		vo.setSc_detcode_9(subCode[8]);
		vo.setSc_detcode_10(subCode[9]);
		vo.setSc_detcode_11(subCode[10]);
		vo.setSc_detcode_12(subCode[11]);
		vo.setSc_detcode_13(subCode[12]);
		vo.setSc_detcode_14(subCode[13]);
		vo.setSc_detcode_15(subCode[14]);
		vo.setSc_detcode_16(subCode[15]);
		vo.setSc_detcode_17(subCode[16]);
		vo.setSc_detcode_18(subCode[17]);
		vo.setSc_detcode_19(subCode[18]);
		vo.setSc_detcode_20(subCode[19]);
		vo.setSc_detcode_21(subCode[20]);
		vo.setSc_detcode_22(subCode[21]);
		vo.setSc_detcode_23(subCode[22]);
		vo.setSc_detcode_24(subCode[23]);
		vo.setSc_detcode_25(subCode[24]);
		vo.setSc_detcode_26(subCode[25]);
		vo.setSc_detcode_27(subCode[26]);
		vo.setSc_detcode_28(subCode[27]);
		vo.setSc_detcode_29(subCode[28]);
		vo.setSc_detcode_30(subCode[29]);
		return vo;
	}

	public String securityCardSend(Security_CardVO vo, String name) {
		StringBuffer content = new StringBuffer();
		content.append(
				"<table class=\"__se_tbl\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" _se2_tbl_template=\"1\" style=\"background-color: rgb(199, 199, 199);\">\r\n"
						+ "	<tbody>\r\n" + "	<tr>\r\n"
						+ "		<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 852px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\" colspan=\"8\" rowspan=\"1\">\r\n"
						+ "			<p>&nbsp;<span style=\"font-size: 24pt;\">HD 보안카드<span style=\"font-size: 14pt;\"><i>");
		content.append(name).append("님");
		content.append("</i></span></span></p>\r\n" + "		</td>\r\n"
				+ "		<td style=\"text-align: center; padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 284px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\" colspan=\"4\" rowspan=\"1\">\r\n"
				+ "			<span style=\"font-size: 12pt;\"><b>&nbsp;일련번호 : ");
		content.append(vo.getSc_code()).append("</b></span>\r\n" + "		</td>\r\n" + "	</tr>");
		content.append("<tr>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("1");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_1());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("2");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_2());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("3");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_3());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("4");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_4());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("5");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_5());
		content.append("</p></td>");
		content.append("</tr><tr>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("6");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_6());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("7");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_7());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("8");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_8());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("9");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_9());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("10");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_10());
		content.append("</p></td>");
		content.append("</tr><tr>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("11");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_11());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("12");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_12());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("13");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_13());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("14");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_14());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("15");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_15());
		content.append("</p></td>");
		content.append("</tr><tr>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("16");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_16());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("17");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_17());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("18");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_18());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("19");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_19());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("20");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_20());
		content.append("</p></td>");
		content.append("</tr><tr>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("21");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_21());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("22");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_22());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("23");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_23());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("24");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_24());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("25");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_25());
		content.append("</p></td>");
		content.append("</tr><tr>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("26");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_26());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("27");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_27());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("28");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_28());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("29");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_29());
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">");
		content.append("30");
		content.append("</p></td>");
		content.append(
				"<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">");
		content.append(vo.getSc_detcode_30());
		content.append("</p></td>");
		content.append("</tr></tbody></table>");

		return content.toString();
	}
}
