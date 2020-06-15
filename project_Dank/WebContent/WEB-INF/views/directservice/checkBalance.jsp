<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">HD Bank</h2>
								<h5 class="text-white op-7 mb-2">어서오세요. HD Bank 메인 페이지입니다.</h5>
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
						<!-- 좌측 버튼 4개 시작 -->
						<div class="col-md-2">
							<!-- 계좌 조회 -->
							<div class="card card-primary bg-primary-gradient" href="#pills-home-nobd">
								<div class="card-body">
									<h2 class="mb-2">계좌 조회</h2>
									<p class="d-flex justify-content-between pb-1 pt-1">Check balance</p>
								</div>
							</div>
							<!-- 계좌 조회 -->
							<!-- 계좌 이체 -->
							<div class="card" id="transfer">
								<div class="card-body pb-0">
									<h2 class="mb-2">계좌 이체</h2>
									<p class="text-muted">Wire money</p>
								</div>
							</div>
							<!-- 계좌 이체 -->
							<!-- 분석 -->
							<div class="card" id="analysis">
								<div class="card-body pb-0">
									<h2 class="mb-2">분석</h2>
									<p class="text-muted">Analysis</p>
								</div>
							</div>
							<!-- 분석 -->
							<!-- 환율 조회 -->
							<div class="card" id="exchangeRate">
								<div class="card-body pb-0">
									<h2 class="mb-2">환율 조회</h2>
									<p class="text-muted">Exchange rate</p>
								</div>
							</div>
							<!-- 환율 조회 -->
						</div>
						<!-- 좌측 버튼 4개 끝 -->
						<div class="col-md-10">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row">
										<div class="card-title">계좌조회</div>
									</div>
								</div>
								<div class="card-body">
									<div class="chart-container" style="min-height: 425px">
									
									<div class="row">
									<div class="col-5">
									
									<form action="chkvalue" method="post" >
										<table class="table mt-1">
											<tbody>
												<tr>
													<th scope="col">계좌 번호</th>
													<td>
														<div class="col-md-12 p-0">
															<input type="text" class="form-control input-full" required="required"
															id="ac_num" name="ac_num" placeholder="(-없이 입력)" maxlength="10">
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">계좌 암호</th>
													<td>
														<div class="col-md-12 p-0">
															<input type="password" class="form-control input-full"  required="required"
															id="ac_pwd" name="ac_pwd" placeholder="(4자리)" maxlength="4">
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">주민번호</th>
													<td>
														<div class="col-md-12 p-0">
															<input type="text" class="form-control input-full"  required="required"
															id="membirth" name="membirth" placeholder="(앞 6자리)" maxlength="6">
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">조회구분</th>
													<td>
														<div class="col-md-12 p-0">
															<label class="form-radio-label">
																<input class="form-radio-input" type="radio" name="type" checked="checked" value="1">
																<span class="form-radio-sign">전체</span>
															</label>
															<label class="form-radio-label ml-12">
																<input class="form-radio-input" type="radio" name="type" value="2">
																<span class="form-radio-sign">입금</span>
															</label>
															<label class="form-radio-label ml-12">
																<input class="form-radio-input" type="radio" name="type" value="3">
																<span class="form-radio-sign">출금</span>
															</label>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">조회 날짜</th>
													<td>
														<div class="col-md-12 p-0">
															<input class="form-control" type="date" id="searchDate" name="searchDate" required="required">
														</div>
													</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<th colspan="2">
														<div class="row">
															<div class="col-md-6 ml-auto mr-auto">
																<input type="hidden" id="check" value="${check }" />
																<input type="submit" value="조회" class="btn btn-success"/>
															</div>
														</div>
													</th>
												</tr>
											</tfoot>
										</table>
										</form>
									</div>
									<!-- 우측 테이블 시작 -->
									<c:if test="${history !=null}">
									<div class="col-md-7">
										<table class="table mt-1">
											<thead>
												<tr>
													<th scope="col" colspan="4" style="text-align: center;">계좌번호 : ${ac_num }</th>
													
												</tr>
												<tr>
													<th scope="col">날짜</th>
													<th scope="col">사용</th>
													<th scope="col">잔액</th>
													<th scope="col">비고</th>
												</tr>
											</thead>
											
											<tbody>
												<tr>
													<c:forEach var="e" items="${history}">
														<tr>
															<%-- <td scope="col">${e.r_num }</td> --%>
															<td scope="col">${e.dealdate }</td>
															<c:choose>
																<c:when test="${e.dep_money!=null }">
																<td scope="col"><span class="text-primary">+ ${e.dep_money }</span></td>
																</c:when>
																<c:when test="${e.wit_money!=null }">
																<td scope="col"><span class="text-danger">- ${e.wit_money }</span></td>
																</c:when>
															</c:choose>
															<td scope="col">${e.balance }</td>
															<td scope="col">${e.name }</td>
														
														</tr>
													</c:forEach>
												</tr>
												
											</tbody>
										</table>
										<!-- 페이지번호 시작 -->
										<div style="display: block; text-align: center;">
										<c:if test="${paging.startPage != 1 }">
										<!--이전페이지 -->
											<a href="inquire_detail?ac_num=${ac_num }&nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"><</a>
										</c:if>
										<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
											var="p">
											<c:choose>
												<c:when test="${p == paging.nowPage }">
													<b>${p }</b>
												</c:when>
												<c:when test="${p != paging.nowPage }">
													<a href="inquire_detail?ac_num=${ac_num }&nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
												</c:when>
											</c:choose>
										</c:forEach>
										<c:if test="${paging.endPage != paging.lastPage}">
											<a href="inquire_detail?ac_num=${ac_num }&nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">></a>
										</c:if>
									</div>
									<!-- 페이지번호 끝 -->
									</div>
									</c:if>
									
								</div>
										<canvas id="statisticsChart"></canvas>
									</div>
									<div id="myChartLegend">
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
		/* 페이지 이동 자바스크립트 시작 */
		$("#checkBalance").click(function() {
			location = "checkbalance";
		});
		$("#transfer").click(function() {
			location = "transfer";
		});
		$("#analysis").click(function() {
			location = "analysis";
		});
		$("#exchangeRate").click(function() {
			location = "exchangerate";
		});
		/* 페이지 이동 자바스크립트 끝 */
		
		$(function() {
			if ($("#check").val()=="no") {
				chk();
			}
		})
			
		function chk() {
			email = $("#mem_email").val();
			swal({
				title: '입력한 값이 틀렸습니다.',
				type: 'warning',
				buttons:{
					confirm: {
						text : '확인',
						className : 'btn btn-success'
					}
					
				}
			})
		}
	</script>

