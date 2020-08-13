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
								 <a href="deposite_cancle" class="btn btn-white btn-sm btn-border mr-1">가입내역</a>
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
									<div class="row">
									<div class="col-md-1 col-lg-1"></div>
										<div class="col-md-10 col-lg-10">
											
										<!-- 예금 해지 구간 -->
											<c:if test="${savlist != null}">
												<table class="table">
													<thead>
														<tr><th colspan="4" style="border-style: none;" ><span class="h2">입출식 예금 상품</span></th></tr>
													</thead>
													<tbody>
														<c:forEach items="${savlist }" var="e">
														<form action="cancel_input_info" method="post">
														<tr>
															<td style="border-style: none; width: 60px; ">▶</td >
															<td  style="border-style: none; width: 140px;">${e.saving.sav_name }</td>
															<td style="width: 400px; border-style: none;">계좌번호 : ${e.ac_num }</td>
															<td style="border-style: none;">
																<input type="hidden" id="ac_code" name="ac_code" value="${e.ac_code }">
																<input type="submit" class="btn btn-info" value="해지하기">
															</td>
														</tr>
														</form>
														<tr>
															<td style="border-style: none;"></td><td style="border-style: none;" >가입날짜 :</td>
															<td style="border-style: none;"> ${e.ac_start_date }</td>
														</tr>
														<tr>
															<td style="border-style: none;"></td>
															<td style="border-style: none;">잔액 : </td>
															<td style="border-style: none;">${e.ac_balance }원</td>
															<td style="border-style: none;"><a href="deposite_cancle_check_select">예금해지 예상 보러가기</a></td>
														</tr>
														</c:forEach>
													</tbody>
												</table>
											</c:if>
										<!-- 적금 해지 구간 -->
											<c:if test="${inslist != null}">
													<table class="table">
														<thead>
															<tr><th colspan="4" style="border-style: none;" ><span class="h2">적금식 예금 상품</span></th></tr>
														</thead>
														<tbody>
															<form action="cancel_input_info" method="post">
															<c:forEach items="${inslist }" var="e">
															<tr>
																<td style="border-style: none; width: 60px; ">▶</td >
																<td  style="border-style: none; width: 140px;">${e.ins.ins_name }</td>
																<td style="width: 400px; border-style: none;">계좌번호 : ${e.ac_num }</td>
																<td style="border-style: none;">
																	<input type="hidden" id="ac_code" name="ac_code" value="${e.ac_code }">
																	<input type="submit" class="btn btn-info" value="해지하기">
																</td>
															</tr>
															<tr>
																<td style="border-style: none;"></td><td style="border-style: none;" >가입날짜 :</td>
																<td style="border-style: none;"> ${e.ac_start_date }</td>
															</tr>
															<tr>
																<td style="border-style: none;"></td><td style="border-style: none;">잔액 : </td>
																<td style="border-style: none;">${e.ac_balance }원</td>
																<td style="border-style: none;"><a href="deposite_cancle_check_select">예금해지 예상 보러가기</a></td>
															</tr>
															</c:forEach>
															</form>
														</tbody>
													</table>
											</c:if>
										</div>
									</div>
								</div>
								
							</div>
						</div>
						</div>
					<!-- 우측 컨텐츠 끝 -->
					
					<!-- 페이지 레이아웃 끝 -->
				</div>
			</div>

			
	<script>
			
	</script>
