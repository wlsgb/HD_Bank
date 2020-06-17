<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page trimDirectiveWhitespaces="true" %>
	
	<c:forEach var="e" items="${atlist }">
	<table border="1">
	<tr>
		<td colspan="5"><marquee behavior="alternate" direction="up" width="700" height="60" bgcolor="white" scrolldelay="5" scrollamount="30"><marquee behavior="alternate" scrollamount="10">임<marquee behavior="alternate" scrollamount="10">성<marquee behavior="alternate" scrollamount="10">윤</marquee></marquee></marquee></marquee></td>
	</tr>
	
	<tr>
		<td rowspan="2" >출금정보</td><td>출금계좌정보</td><td>${e.ac_num }</td><td>보내는분</td><td>${e.myname }</td>
	</tr>
	<tr>
		<td>출금통장표시내역</td><td>${e.ata_myacmemo }</td><td>HD</td><td>HD</td>
	</tr>
	
	<tr>
		<td rowspan="2" >입금정보</td><td>입금계좌정보</td><td>${e.ata_yourac }</td><td>받는분</td><td>${e.yourname }</td>
	</tr>
	<tr>
		<td>입금통장표시내역</td><td>${e.ata_youracmemo }</td><td>HD</td><td>HD</td>
	</tr>
	<tr>
		<td rowspan="4" >자동이체정보</td><td>시작일</td><td>${e.ata_startdate }</td><td>종료일</td><td><!-- ${e.ata_stopdate } -->//</td>
	</tr>
	<tr>
		<td>이체금액</td><td>${e.ata_setmoney }</td><td>이체일자</td><td><!-- ${e.ata_dterm } -->//</td>
	</tr>
	<tr>
		<td>이체시간</td><td>${e.ata_time }</td><td>진행상황</td><td>${e.ata_ing }</td>
	</tr>
	<tr>
		<td>종료여부</td><td>
		<c:if test="${e.ata_check eq 1}"> 이체댐</c:if>
		<c:if test="${e.ata_check eq 0}"> 아직이체안댐</c:if>
		<c:if test="${e.ata_check eq -1}"> 돈부족</c:if>
		
		</td><td>HD</td><td>HD</td>
	</tr>
	</table>
	
	</c:forEach>