<%@ page contentType="application/unknown; charset=euc-kr" %><%@ page
import="java.util.*,java.io.*"%><%

/* 아파치 톰캣연동 혹은 톰캣 단독으로 쓰일때의 한글 파일 다운로드
 * 
 * 손권남 (kwon37xi_a#T_yahoo.co.kr)
 * 
 * http://www.okjsp.pe.kr에 올라온 많은 예제들을 참고하고, 나름대로
 * 경험에 의한 법칙등을 적용하연 만든 것임.
 * 이것은 예제일 뿐, 경로나 파일 이름 받아들이는 방법등은 자신에 맞게
 * 수정할 것.
 *
 * 맨위의 charset=euc-kr을 빼먹으면 안된다.!!!!!!
 * 
 * 빼먹을 경우 이 JSP 페이지가 EUC_KR로 해석되지 않아서 이 JSP페이지 내의
 * 한글이 모두 깨져버린다. 물론.. 여기서는 한글이 안쓰여서 별 상관은
 * 없지만..
 */

/*
 * 다운로드 관련 페이지는 Servlet으로 만드는게 원칙이다.
 * 이것은 그냥 쉬운 예제를 보여주는 것 뿐이다.
 *
 * 또한, JSP로 만들 경우에 각 태그 사이에 빈공간이 있어서는 안된다.
 * 그럴경우 다운로드되는 파일이 변경될 수 있다. 그러니 그냥 서블릿으로
 * 만들기를 권함.
 */

request.setCharacterEncoding("euc-kr");

 String filename = request.getParameter("fileName");
 String fileDir = request.getParameter("fileDir");
 String filePath = request.getRealPath("") + fileDir + "/" + filename;
 System.out.println(filename);
 System.out.println(filePath);
if (filename == null) {
 return;
}

String mime = getServletContext().getMimeType(filename);

if (mime == null) {
 mime = "application/octet-stream;";
}

// 자신에게 맞게 수정할 것.
File file =
 new File(filePath);

byte b[] = new byte[2048];


//response.setHeader("Content-Transfer-Encoding", "7bit");
// 위 부분을 아래와 같이 수정함. 2005/01/17
response.setContentType(mime + "; charset=euc-kr"); 

/*
 * URLEncoder의 사용에 주의할것. J2SDK 1.3x 이하에서는
 * java.net.URLEncoder.encode(filename) 으로 수정할 것.
 *
 * MS IE 5.5에는 버그가 있어서 atatchment 부분을 빼줘야한다.
 *
 */
String aa =file.getName();
if (request.getHeader("User-Agent").indexOf("MSIE 5.5") > -1) {
 response.setHeader("Content-Disposition",
   "filename=" +java.net.URLEncoder.encode(filename, "EUC-KR") + ";");
} else {
 response.setHeader("Content-Disposition",
   "attachment; filename=" + java.net.URLEncoder.encode(filename, "EUC-KR") + ";");
}
System.out.println("filename="+filename);
/*
 * 지금까지 많은 사람들이 한글 파일명을 latin1으로 바꾼뒤 보냈는데,
 * 톰캣 단독으로 쓰이는 경우에는 상관없을 수 있지만 아파치등 웹 서버와 연동할 경우
 * latin1(8bit) 으로 된 파일이름을 그대로 보내면 한글 파일 이름이 깨진다.
 * 아파치가 (혹은 아파치와 톰캣을 연동하는 모듈이) 헤더에서 latin1으로된 문자를
 * 자기 맘대로 변형시키는 것으로 보인다.(실제 telnet 으로 접속해서 헤더의
 * 파일이름부분을 톰캣단독과 아파치+톰캣 일때 보면 latin1으로 보낼경우에 서로
 * 다르게 나온다)
 * 
 * 꼭 URLEncoding을 해서 보내야 언제나 제대로된 한글 이름으로 다운로드가 된다.
 *
 * 그러나 이것은 모질라에서는 작동하지 않았다.
 * 
 * URLencoding 된 파일이름이 너무 길경우에도 다운로드되지 않는다.
 * 모질라에서는 비록 한글파일이름은 깨져도 다운로되 되는것으로 보아
 * IE 5.x, 6.x 의 버그로 여겨진다. - 이문제에 대한 해결책 누구 없수?
 */

response.setHeader("Content-Length", "" + file.length() );

if (file.isFile() && file.length() > 0) // 파일 크기가 0보다 커야 한다.
{
 BufferedInputStream fin = new BufferedInputStream(new
 FileInputStream(file));
 BufferedOutputStream outs = new
 BufferedOutputStream(response.getOutputStream());
 int read = 0;
 
 while ((read = fin.read(b)) != -1){
  outs.write(b,0,read);
 }

 outs.close();
 fin.close();
 
}
%>
