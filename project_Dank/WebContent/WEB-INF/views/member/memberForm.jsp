<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- article 영역 시작 -->
<div id="article">
	<div id="header2">
		<h1>SurveyClient 예제</h1>
		<p id="time">Oct 1th, 2020</p>
	</div>
	<div id="section2">
		<div id="header4">
			<h2> Dank 회원가입</h2>
		</div>
		<%-- Content 내용들어 갈자리 --%>
		
		<form method="post" action="memberIn">
			<table>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="mem_email" maxlength="10">
					</td>
				<tr>
				<tr>
					<td colspan="2" id="target"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mem_pwd" maxlength="10">
					</td>
				</tr>
				</td>
				</tr>

				<tr>
					<td>이름</td>
					<td><input type="text" name="mem_name" maxlength="10">
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="mem_phn" maxlength="10">
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="mem_birth" maxlength="10">
					</td>
				</tr>
				<tr>
					<td>성별</td>

					<td><input type="radio" name=mem_gender value="남자"
						checked="checked"> 남자 <input type="radio"
						name="mem_gender" value="여자"> 여자</td>
				</tr>

				<tr>
					<td>주소</td>
					<td><input type="text" name="mem_loc" maxlength="10">
					</td>
				</tr>
				<tr>
					<td>개인정보 동의</td>
					<td><input type="radio" name="mem_prichk" value="수신">
						수신 <input type="radio" name="mem_prichk" value="거부"> 거부<br>



					</td>
				</tr>
				<tr>
				<tr>
					<td colspan="2"><input type="submit" NAME="signup"
						value="가입하기"></td>
				</tr>


			</table>
		</form>
		<%-- Content 내용들어 갈자리 --%>

		<div id="footer2"></div>
	</div>
	<div id="footer3">Article Footer</div>
</div>
<!-- article 영역 끝 -->
<div id="aside">
	<div id="header5">
		<h1>(주)Dank 어서오세요^^</h1>
	</div>

</div>