<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page language="java"%>
<%@ page import="java.io.BufferedInputStream"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.ServletOutputStream"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%
String contextRealPath = "C:/ikosmo64/spring/hdspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/project_Dank/";
String savePath = contextRealPath + "resources/upload/101";
String name = "g1.jpg";
String filename = new String(name.getBytes("iso8859-1"), "UTF-8");
 byte[] buffer = new byte[1024];
 ServletOutputStream out_stream = null;
 BufferedInputStream in_stream = null;
 File fis = new File(savePath + "/" + filename); 
if(fis.exists()){
	System.out.println(fis);
 try{
  response.setContentType("utf-8");
  response.setContentType("application/octet;charset=utf-8");
  response.setHeader("Content-Disposition", "attachment;filename=" + filename);
  
  out.clear();
  out = pageContext.pushBody();
  
  out_stream = response.getOutputStream();
  in_stream = new BufferedInputStream(new FileInputStream(fis));
  int n = 0;
  while ((n = in_stream.read(buffer, 0, 1024)) != -1) {
	  System.out.println("1122334455");
   out_stream.write(buffer, 0, n);
  }// while
 } catch (Exception e) {
  e.printStackTrace();
  System.out.println("¿©±â1");
 } finally {
  if (in_stream != null) {
	  System.out.println("123");
   try {
    in_stream.close();
   } catch (Exception e) {
	   e.printStackTrace();
   }
  }
  if (out_stream != null) {
	  System.out.println("456");
   try {
    out_stream.close();
   } catch (Exception e) {
	   e.printStackTrace();
   }
  }
 }
}else{
	System.out.println("11111111111");
  response.sendRedirect("unknownfile");
}
%>