<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">예금</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="inquire" class="btn btn-white btn-sm btn-border mr-1">조회</a> 
								 <span class="h2 mr-1"> > </span>
								 <a href="inquire" class="btn btn-white btn-sm btn-border mr-1">계좌조회</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<div class="page-inner mt--5">
					<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">입출금</h4>
										<div class="card-tools">
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-angle-down"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
											
										</div>
									</div>


								
								</div>
								<div class="card-body">
								<table class="table">
													<thead>
														<tr>
															<th>상품명</th>
															<th>별명</th>
															<th>계좌번호</th>
															<th class="text-right">
																잔액
															</th>
															
															<th class="text-right">
																비고
															</th>
														</tr>
														
													</thead>
													<tbody>
													<c:forEach var="e" items="${aclist}" varStatus="i">
													
													<c:if test="${e.saving.sav_name != '0'}">
													
														<tr>
																<td>${e.saving.sav_name }</td>
																<td>${e.ac_name }</td>
																<td id="savac${i.index}">${e.ac_num }</td>
																<td class="text-right">
																	${e.ac_balance }
																</td>
																
																<td class="text-right">
																	<form action="inquire_detail" method="post" style="display: inline-block;">
																	<input type="hidden" value="${e.ac_num }" name="ac_num">
																	<input type="submit" value="조회"  style="display: inline-block;" />
																	</form>
																	<form action="transfer" method="post" style="display: inline-block;">
																	<input type="hidden" value="${e.ac_num }" name="ac_num">
																	<input type="submit" value="이체" />
																	</form>
<!-- 																	<form action="deposit" method="post" style="display: inline-block;"> -->
<%-- 																	<input type="hidden" value="${e.ac_num }" name="ac_num"> --%>
<%-- 																	<input type="submit" value="입금" id="depbtn${i.index}"  /> --%>
<!-- 																	</form> -->
<!-- 																	<form action="withdraw" method="post" style="display: inline-block;"> -->
<%-- 																	<input type="hidden" value="${e.ac_num }" name="ac_num"> --%>
<!-- 																	<input type="submit" value="출금" /> -->
<!-- 																	</form> -->
			
																</td>
														</tr>
													</c:if>
													</c:forEach>

													
													
													</tbody>
								</table>
								</div>

							</div>
						</div>
					</div>
					<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">적금</h4>
										<div class="card-tools">
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-angle-down"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
											
										</div>
									</div>


								
								</div>
								<div class="card-body">
								<table class="table">
													<thead>
														<tr>
															<th>상품명</th>
															<th>별명</th>
															<th>계좌번호</th>
															<th class="text-right">
																잔액
															</th>
															
															<th class="text-right">
																비고
															</th>
														</tr>
														
													</thead>
													<tbody>
													<c:forEach var="e" items="${aclist}" varStatus="i">
													<c:if test="${e.ins.ins_name != '0'}">
													<tr>
															<td>${e.ins.ins_name }</td>
															<td>${e.ac_name}</td>
															<td>${e.ac_num }</td>
															<td class="text-right">
																${e.ac_balance }
															</td>
															
															<td class="text-right">
																<form action="inquire_detail" method="post" style="display: inline-block;">
																	<input type="hidden" value="${e.ac_num }" name="ac_num">
																	<input type="submit" value="조회"  style="display: inline-block;" />
																	</form>
<!-- 																<input type="button" value="두섬팅" id="dosomething" /> -->
<!-- 																<a href="#"><input type="button" value="입금" /></a> -->
<!-- 																<a href="#"><input type="button" value="출금" /></a> -->
															</td>
														</tr>
														</c:if>
													</c:forEach>
													
													
													</tbody>
								</table>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>


		
			
			
			<script>
// $(document).ready(function() {
// 	setInterval(function() {
// 		$.ajax({
// 			url:'dosomething',
// 			success:function(data){
// 				console.log("두섭튕")
// 				$.ajax({
// 					url:'dosomething2',
// 					success:function(data){
// 						console.log("두솜팅 22");
// 					}
// 				})
// 			}		
// 		})
// 	}, 1000)
// })
			
			
		
	</script>

