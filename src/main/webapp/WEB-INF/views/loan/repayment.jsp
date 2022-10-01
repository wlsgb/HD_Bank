<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<div class="content">
					<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">대출</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="repayment" class="btn btn-white btn-sm btn-border mr-1">대출상환</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
		
		<!--상환해야하는 대출  -->
		<div class="row mt--4">
				<div class="col-sm-6 col-md-2"></div>
						<div class="col-sm-6 col-md-8">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
											<table class="table table-hover">
											<h2>&nbsp;&nbsp;&nbsp;&nbsp;대출 상환 현황</h2>
												<thead>
													<tr>
														<th>상품명</th>
														<th>대출날짜</th>
														<th>대출원금</th>
														<th>대출잔액</th>
														<th>대출상환</th>
														<th>상세보기</th>
													</tr>
												</thead>
												<tbody>
												 <c:forEach items="${list }" var="e">
													<c:if test="${e.lc_state eq '실행완료'}">
													<tr>
														<td>${e.loanProductVO.lp_name}</td>
														<td>${e.loanRepayVO.lr_startdate }</td>
														<td>${e.loanRepayVO.lr_amount }</td>
														<td>${e.loanRepayVO.lr_balance }</td>
														<td><button type="button" class="btn btn-lg btn-primary repay" value="${e.lc_num }">상환하기</button></td>
														<td><button type="button" class="btn btn-lg btn-primary checkdetail" value="${e.lc_num }">상세보기</button></td>
													</tr>
													
													</c:if>
												 </c:forEach>
												</tbody>
											</table>
										
										</div>
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-2"></div>
			
						</div>
			</div>
		
			


			
			
			
			<script>
			
			$('.checkdetail').click(function() {
				location='checkdetail?lc_num='+$(this).val();
			})
			$('.repay').click(function() {
			location='repaymentloan?lc_num='+$(this).val();
		})
	</script>

