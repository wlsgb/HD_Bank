<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">고객정보관리</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="security" class="btn btn-white btn-sm btn-border mr-1">보안카드 / OTP</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<!-- 상단의 푸른색 공간 끝 -->
				<div class="page-inner mt--5">
				<c:if test="${error=='f' }">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div>
										<span class="h1 text-danger">이미 신청되어있습니다.</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if> 
				<!-- 페이지 레이아웃 시작 -->
				<div class="row justify-content-center align-items-center mb-5">
				<div class="col-md-3 pl-md-0">
							<div class="card-pricing2 card-success">
								<div class="pricing-header">
									<h3 class="fw-bold">보안카드</h3>
									<span class="sub-title">신청 / 재발급</span>
								</div>
								<div class="price-value">
									<div class="value">
									</div>
								</div>
								<ul class="pricing-content">
								</ul>
								<a href="securitycard" class="btn btn-success btn-border btn-lg w-75 fw-bold mb-3">보안카드 신청</a>
							</div>
						</div>
					<div class="col-md-3 pl-md-0 pr-md-0">
						<div class="card-pricing2 card-primary">
							<div class="pricing-header">
								<h3 class="fw-bold">OTP</h3>
								<span class="sub-title">신청 / 해지</span>
							</div>
							<div class="price-value">
								<div class="value" >
								</div>
							</div>
							<ul class="pricing-content">
							</ul>
							<a href="securityotp" class="btn btn-primary btn-border btn-lg w-75 fw-bold mb-3">OTP 신청</a>
						</div>
					</div>
					
				</div>
					<!-- 페이지 레이아웃 끝 -->
				</div>
			</div>


			
			
	<script>
		$("#checkBalance").click(function() {
			location = "checkBalance";
		});
		
		$(function() {
			
		})
	</script>

