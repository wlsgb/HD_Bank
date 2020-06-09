<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
			<div class="content">	
	<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">대출</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="check" class="btn btn-white btn-sm btn-border mr-1">대출현황 조회</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<!--대출 신청 조회  -->
		<form action="" class="form-horizontal">
				<div class="row mt--4">
				<div class="col-sm-6 col-md-2"></div>
						<div class="col-sm-6 col-md-8">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
										<h2>&nbsp;&nbsp;&nbsp;&nbsp;대출 신청 현황</h2>
											<table class="table table-hover">
												<thead>
													<tr>
														<th>상품명</th>
														<th>신청날짜</th>
														<th>신청금액</th>
														<th>결과여부</th>
														<th>서류제출</th>
														
													</tr>
												</thead>
												<tbody>
												<c:forEach items="${list }" var="e">
													<tr>
													 <td>${e.loanProductVO.lp_name}</td>
														<td>${e.loanApplicationVO.la_sysdate }</td>
														<td>${e.loanApplicationVO.la_hamount }</td>
														<td>${e.lc_state }</td>
														
														<c:choose>
															<c:when test="${e.lc_state eq '심사대기중'}">
														<td><button type="button" class="btn btn-lg btn-primary" disabled="disabled">심사대기</button></td>														
															</c:when>
															<c:when test="${e.lc_state eq '서류제출대기' }">
														<td><button type="button" class="btn btn-lg btn-primary file" value="${e.lc_num }">서류제출하기</button></td>
															</c:when>
															<c:when test="${e.lc_state eq '서류제출완료' }">
														<td><button type="button" class="btn btn-lg btn-primary refile" value="${e.lc_num }">서류다시제출하기</button></td>
															
															</c:when>
															<c:otherwise>
														<td><button type="button" class="btn btn-lg btn-primary" disabled="disabled">대출실행</button></td>
															
															</c:otherwise>
														</c:choose>	
													</tr>
												</c:forEach>
													
												</tbody>
											</table>
										
										</div>
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-2"></div>
			
						</div>
		
		</form>
		
		
			</div>
		
			

			
			
			<script>
		
		$('.file').click(function() {
			location='checkfile?lc_num='+$(this).val();
		})
		$('.refile').click(function() {
			location='checkfiledetail?lc_num='+$(this).val();
		})
	</script>

