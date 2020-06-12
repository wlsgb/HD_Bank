%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="<c:url value="/fileDown.do?fileDir=/resources/upload/3&fileName=file1.PNG"/>">
<img src="resources/upload/3/file1.PNG" width="300" height="210">
</a>

</body>
</html>