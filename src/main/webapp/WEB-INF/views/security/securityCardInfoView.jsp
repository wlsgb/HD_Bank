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
								 <span class="h2 mr-1"> > </span>
								 <a href="securitycard" class="btn btn-white btn-sm btn-border mr-1">보안카드</a>
								 <span class="h2 mr-1"> > </span>
								 <a href="securitycard" class="btn btn-white btn-sm btn-border mr-1">신청</a>
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
				<!-- 페이지 레이아웃 시작 -->
				<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">보안카드</h4>
									</div>
									<p class="card-category">
									신청 개인정보 확인</p>
								</div>
								
								<div class="card-body">
									<div class="row">
										<div class="col-12">
										
										
										
										<!-- 보안카드 신청 form 시작 -->
											<form action="securitycardcreate" method="post">
												<table class="table mt-1">
												<tbody>
													<tr>
														<th scope="col">
															본인 계좌 번호
														</th>
														<td>
															<div class="row">
																<div class="col-12">
																	<input type="text" value="${acNameNum }" readonly="readonly"
																	class="form-control input-full"/>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<th scope="col">이메일</th>
														<td>
															<div class="row">
																<div class="col-12">
																	<input type="text" name="emailId" value="${mem_email }"
																	class="form-control input-full" readonly="readonly">
																</div>
															</div>
														</td>
													</tr>
												</tbody>
												<tfoot>
													<tr>
														<th colspan="2">
															<div class="row">
																<div class="col-md-6 ml-auto mr-auto">
																	<button type="button" class="btn btn-danger" id="cancel">재입력</button>
																	<input type="submit" class="btn btn-success" value="확인">
																</div>
															</div>
														</th>
													</tr>
												</tfoot>
											</table>
										</form>
										<!-- 보안카드 신청 form 끝 -->
										
										
										
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 페이지 레이아웃 끝 -->
				</div>
			</div>


			
			
			
	<script>
		$(function() {
			//$(function() 시작
			$("#cancel").click(function() {
				console.log("왜 안돼")
				location = "securitycard";
			});
		//$(function() 끝
		})
			
	</script>
