package main.java.dank.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.dank.dao.SecurityDao;
import main.java.dank.vo.security.Security_CardVO;

@Repository
public class SecurityCode {

	@Autowired
	private SecurityDao securityDao;

	// �Է��� ���ڸ�ŭ �ڸ����� ������ ���ڷ� �����ȴ�.
	// �� ) 4 => 5249
	public String securityCodeMaking(int len) {
		StringBuffer emailSecuCode = new StringBuffer();
		int a = len / 2;
		String front = "";
		String back = "";
		int random = 0;

		// ���ڸ��� ���ڸ��� ���ڰ� ������ ���ڸ��� �ٽ� ������.
		do {
			front = "";
			back = "";
			// �� �ڸ��� ���ڸ� �������� �Է��Ѵ�.
			for (int i = 0; i < a; i++) {
				if (i == 0) {
					random = (int)(Math.random() * 9 + 1);
					front += random;
				} else {
					random = (int)(Math.random() * 9);
					front += random;
				}

			}
			// �� �ڸ��� ���ڸ� �������� �Է��Ѵ�.
			for (int i = 0; i < a; i++) {
				random = (int)(Math.random() * 9);
				back += random;
			}
		} while (front.equals(back));

		emailSecuCode.append(front).append(back);
		System.out.println(emailSecuCode);
		return emailSecuCode.toString();
	}

	public String[][] cardNumControll(Security_CardVO vo) {

		// �Ϸù�ȣ or ���°�ڵ�, ���ڸ� or ���ڸ�, ��ȣ
		String[][] securityCheckData = new String[3][3];

		int fronBack = 0;
		int randomNum = 0;

		String subStringCode = "";
		String code = "";
		String fb = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					switch (j) {
						case 0:
							securityCheckData[i][j] = "�Ϸù�ȣ";
							break;
						case 1:
							fronBack = (int)(Math.random() * 2 + 1);
							fb = "��";
							securityCheckData[i][j] = fb;
							break;
						case 2:
							code = String.valueOf(vo.getSc_code());
							subStringCode = (securityCheckData[i][j - 1].equals("��")) ? code.substring(0, 2)
								: code.substring(code.length() - 2);
							securityCheckData[i][j] = subStringCode;
							break;
						default:
							break;
					}
				} else if (i == 1) {
					switch (j) {
						case 0:
							randomNum = (int)(Math.random() * 30 + 1);
							securityCheckData[i][j] = String.valueOf(randomNum);
							break;
						case 1:
							fronBack = (int)(Math.random() * 2 + 1);
							fb = "��";
							securityCheckData[i][j] = fb;
							break;
						case 2:
							code = String.valueOf(vo.getSc_detcode()[randomNum - 1]);
							subStringCode = (securityCheckData[i][j - 1].equals("��")) ? code.substring(0, 2)
								: code.substring(code.length() - 2);
							securityCheckData[i][j] = subStringCode;
							break;
						default:
							break;
					}
				} else if (i == 2) {
					switch (j) {
						case 0:
							do {
								randomNum = (int)(Math.random() * 30 + 1);
								securityCheckData[i][j] = String.valueOf(randomNum);
							} while (securityCheckData[i - 1][j].equals(securityCheckData[i][j]));
							break;
						case 1:
							fronBack = (int)(Math.random() * 2 + 1);
							fb = "��";
							securityCheckData[i][j] = fb;
							break;
						case 2:
							code = String.valueOf(vo.getSc_detcode()[randomNum - 1]);
							subStringCode = (securityCheckData[i][j - 1].equals("��")) ? code.substring(0, 2)
								: code.substring(code.length() - 2);
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

	// ����ī�� ����
	public Security_CardVO securityCardCreate() {
		Security_CardVO vo = new Security_CardVO();
		// �Ϸù�ȣ�� �־��ش�.
		String priCode = "";
		do {
			priCode = securityCodeMaking(8);
			vo.setSc_code(Integer.parseInt(priCode));
		} while (securityDao.priCodeChk(vo) == 1);

		// 30���� ��ȣ�� �־��ش�.
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
		String content =
			"<table class=\"__se_tbl\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" _se2_tbl_template=\"1\" style=\"background-color: rgb(199, 199, 199);\">\r\n"
				+ "	<tbody>\r\n" + "	<tr>\r\n"
				+ "		<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 852px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\" colspan=\"8\" rowspan=\"1\">\r\n"
				+ "			<p>&nbsp;<span style=\"font-size: 24pt;\">HD ����ī��<span style=\"font-size: 14pt;\"><i>"
				+ name + "��"
				+ "</i></span></span></p>\r\n" + "		</td>\r\n"
				+ "		<td style=\"text-align: center; padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 284px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\" colspan=\"4\" rowspan=\"1\">\r\n"
				+ "			<span style=\"font-size: 12pt;\"><b>&nbsp;�Ϸù�ȣ : "
				+ vo.getSc_code() + "</b></span>\r\n" + "		</td>\r\n" + "	</tr>"
				+ "<tr>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "1"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_1()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "2"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_2()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "3"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_3()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "4"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_4()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "5"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_5()
				+ "</p></td>"
				+ "</tr><tr>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "6"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_6()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "7"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_7()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "8"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_8()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "9"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_9()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "10"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_10()
				+ "</p></td>"
				+ "</tr><tr>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "11"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_11()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "12"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_12()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "13"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_13()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "14"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_14()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "15"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_15()
				+ "</p></td>"
				+ "</tr><tr>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "16"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_16()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "17"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_17()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "18"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_18()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "19"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_19()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "20"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_20()
				+ "</p></td>"
				+ "</tr><tr>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "21"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_21()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "22"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_22()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "23"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_23()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "24"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_24()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "25"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_25()
				+ "</p></td>"
				+ "</tr><tr>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "26"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_26()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "27"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_27()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "28"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_28()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "29"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_29()
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(235, 235, 235);\" class=\"\"><p style=\"text-align: center; \">"
				+ "30"
				+ "</p></td>"
				+ "<td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 113px; height: 25px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \">"
				+ vo.getSc_detcode_30()
				+ "</p></td>"
				+ "</tr></tbody></table>";

		return content;
	}
}
