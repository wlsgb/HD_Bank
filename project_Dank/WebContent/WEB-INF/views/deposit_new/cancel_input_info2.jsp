<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">예금</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="deposite_cancle" class="btn btn-white btn-sm btn-border mr-1">해지</a> 
								 <span class="h2 mr-1"> > </span>
								 <a href="deposite_cancle_input_info" class="btn btn-white btn-sm btn-border mr-1">해지정보입력</a>
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
				<div class="row">
							
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">해지</div>
								</div>
								<div class="card-body" style="margin-bottom: 20px; margin-top: 0">
								<form action="cancel_check" method="post">
									<div class="row">
										<div class="col-md-10 col-lg-10">
											<table class="table">
												<thead>
													<tr><th colspan="2" style="border-style: none;" >
														<c:choose>
															<c:when test="${account.saving.sav_code != 0 }">
																<span class="h2">입출식 예금 상품</span>
															</c:when>
															<c:when test="${account.ins.ins_code != 0 }">
																<span class="h2">적금식 예금 상품</span>
															</c:when>
														</c:choose>
													</th></tr>
												</thead>
												<tbody>
												<c:choose>
													<c:when test="${account.saving.sav_code != 0 }">
														<tr>
															<td style="border-style: none; width: 60px; ">▶</td >
															<td  style="border-style: none; width: 140px;">${account.saving.sav_name}</td>
															<td style="width: 400px; border-style: none;">계좌번호 : ${account.ac_num}</td>
														</tr>
														<tr>
															<td style="border-style: none;"></td>
															<td style="border-style: none;" >가입날짜 :</td>
															<td style="border-style: none;">${account.ac_start_date}</td>
															
														</tr>
														<tr >
															<td style="border-style: none;"></td>
															<td style="border-style: none;">잔액 : </td>
															<td style="border-style: none;">${account.ac_balance}</td>
														</tr>
													</c:when>
													<c:when test="${account.ins.ins_code != 0 }">
														<tr>
															<td style="border-style: none; width: 60px; ">▶</td >
															<td  style="border-style: none; width: 140px;">${account.ins.ins_name}</td>
															<td style="width: 400px; border-style: none;">계좌번호 : ${account.ac_num}</td>
														</tr>
														<tr>
															<td style="border-style: none;"></td>
															<td style="border-style: none;" >가입날짜 :</td>
															<td style="border-style: none;">${account.ac_start_date}</td>
															
														</tr>
														<tr >
															<td style="border-style: none;"></td>
															<td style="border-style: none;">잔액 : </td>
															<td style="border-style: none;">${account.ac_balance}</td>
														</tr>
													</c:when>
												</c:choose>
												</tbody>
											</table>
									
									<hr/>
									
									<div class="form-inline" style="margin-left: 10%;">
										<span>입금 계좌번호</span>
										<input type="text" class="form-control" style="width: 400px; margin-left: 30px;" placeholder="계좌번호를 입력해주세요"/>
									</div>
									<div class="form-inline" style="margin-left: 10%;">
										<span>계정 비밀번호</span>
										<input type="text" class="form-control" style="width: 400px; margin-left: 30px;" placeholder="비밀번호를 입력해주세요"/>
									</div>
									<div style="margin-left: 60%; margin-top: 30px;" >
										<input type="button" class="btn btn-info" value="취소" id="cancel">
										<input type="hidden" id="ac_code" name="ac_code" value="${ac_code }">
										<input type="submit" class="btn btn-info" value="해지하기">
									</div>
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- 우측 컨텐츠 끝 -->
					
			<!-- 페이지 레이아웃 끝 -->
		</div>
	</div>

			
			
	<script>
		$('#cancel').click(function() {
			location='index';
		});
	</script>
