<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page trimDirectiveWhitespaces="true" %>
<input type="hidden" id="lp_num" value="${vo.lp_num }">
		<div class="col-md-12">
		<h1 class="text-center">${vo.lp_name }</h1><br>
		</div>
		<div class="col-md-12">
		<p class="text-center">이자율 : ${vo.lp_interestrate }%</p><br>
		</div>
		<div class="col-md-12">
		<p class="text-center">최대 대출 금액 : ${vo.lp_maximum }원</p><br>
		</div>
		<div class="col-md-12">
		<p class="text-center">중도 해지 수수료 : ${vo.lp_cancelfee }%</p>
		</div>