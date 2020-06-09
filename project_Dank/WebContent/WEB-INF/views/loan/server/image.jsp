<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page contentType="text/html;images/jpg;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.*" %>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="org.springframework.ui.Model" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
 
</head>
<body>
<%
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
 
    String imagePath = new String(request.getAttribute("path").toString().getBytes("utf-8"), "ISO-8859-1");
 
    File file = new File(imagePath);
    int size = (int) file.length();
 
    // out.clear();
    bos = new BufferedOutputStream(response.getOutputStream());
    byte b[] = new byte[2048];
    int read = 0;
    if (size > 0 && file.isFile()) {
        bis = new BufferedInputStream(new FileInputStream(file));
        while ((read = bis.read(b)) != -1) {
            bos.write(b, 0, read);
        }
    }
    bos.close();
    out.clear();
    out = pageContext.pushBody();
%>
</body>
</html>

 