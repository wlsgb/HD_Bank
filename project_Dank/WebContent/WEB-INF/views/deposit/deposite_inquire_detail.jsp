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
								 <a href="inquire_detail" class="btn btn-white btn-sm btn-border mr-1">상세조회</a>
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


					
							
							
							
							
							<div class="row">
							<div class="col-md-2"></div>
						<div class="col-md-8">
							<div class="card">
								<div class="card-header">
									<div class="card-title">상세조회</div>
								</div>
								<div class="card-body">
									<div class="row">
									<div class="col-md-2 col-lg-2"></div>
										<div class="col-md-8 col-lg-8">
											<div class="form-group">
												<label for="email2">상품명</label>
												<input type="text" style="width: 400px;" class="form-control" id="email2" placeholder="110-111-12345 : 보통예금">
											</div>
											<hr class="my-0">
											<div class="form-group " >
												<label for="email2" >월별조회</label>
												  <div class="form-inline">
												    <label class="col-xs-4">
												    <input type="text" class="form-control" style="width: 40%; margin: 10px;" placeholder="2020"><span style="margin: 3px;">년</span>
												    <input type="text" class="form-control"  style="width: 40%; margin: 10px;"  placeholder="05">월
												    </label>
												    
												  </div>
											<hr class="my-0">
											</div>
											
											
											<div class="form-group">
												<label class="form-label">조회기간</label><br />
											
												<div class="selectgroup w-30 " style="margin-left:20%" >
													<label class="selectgroup-item" >
														<input type="radio" name="value" value="50" class="selectgroup-input" >
														<span class="selectgroup-button">당일</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="value" value="100" class="selectgroup-input">
														<span class="selectgroup-button">1주일</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="value" value="200" class="selectgroup-input">
														<span class="selectgroup-button">1개월</span>
													</label>
											
										</div>
										 <div class="form-inline">
												    <label class="col-xs-4">
												    <input type="text" class="form-control" style="width: 40%; margin: 10px;" placeholder="2020 02 04"><span style="margin: 3px;">~</span>
												    <input type="text" class="form-control"  style="width: 40%; margin: 10px;"  placeholder="2020 04 22">
												    </label>
												    
												  </div>
												 <button type="button" class="btn btn-success" style="margin-left: 35%">조회하기</button>
											
											
											
											
											
											
										</div>

										
									</div>
								</div>
								
							</div>
						</div>
						</div>
						

						<div class="col-md-12">
						<div class="card">
								<div class="card-header">
									<table>
									<tr>
									<td style="width: 400px; text-align: center;">
									<select class="form-control" style="width: 40%; margin-left: 30px;">
									    <option selected="selected"
									    >전체</option>
									    <option >일별</option>
									    <option >월별</option>
									    <option >기타</option>
									</select>
									</td>
									<td style="width: 400px; text-align: center;">총입금금액 (100건) 5,000,000 원</td>
									<td style="width: 400px; text-align: center;">총출금금액 (10건) 200,000 원</td>
									</tr>
									</table>
								</div>
								<div class="card-body">
									<table class="table table-hover">
										<thead>
											<tr>
												<th scope="col">숫자</th>
												<th scope="col">거래일시</th>
												<th scope="col">입금액(원)</th>
												<th scope="col">출금액(원)</th>
												<th scope="col">잔액(원)</th>
												<th scope="col">송금메모</th>
												
											</tr>
										</thead>
										<tbody>
										
	
										
										<c:forEach var="e" items="${history}">
											<tr>
												<td scope="col">${e.r_num }</td>
												<td scope="col">${e.dealdate }</td>
												<td scope="col">${e.dep_money }</td>
												<td scope="col">${e.wit_money }</td>
												<td scope="col">${e.balance }</td>
												<td scope="col">${e.name }</td>
												
											
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
								
											<div style="display: block; text-align: center;">
												<c:if test="${paging.startPage != 1 }">
											<!-- 	이전페이지 -->
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
								<div style="margin:10px auto;">
								<button type="button" class="btn btn-info btn-sm">엑셀 내리기</button>
<!-- 								<div id="result" style="position: absolute; background: #000; width: 30px; height: 30px; opacity: 0.4; border-radius: 100%;"> </div> -->


								</div>
							</div>
							</div>

					</div>
				
			</div>

</div>

	
			
			
			<script>
// 			function resultFun(x) {
// 				 var positionLeft = x.clientX;
// 				  var positionTop = x.clientY;
// 				   document.getElementById('result').style.left = positionLeft - 10 + "px";
// 				    document.getElementById('result').style.top = positionTop - 10 +"px"; 
// 				    }
// 		     if (document.addEventListener) {
// 			      document.addEventListener("mousemove", resultFun); 
// 			      } else if (document.attachEvent) {
// 				       document.attachEvent("onmousemove", resultFun);
// 				        //attachEvent는 IE8이하와 오페라에서 사용하는 명령어이다
// 				         };

$(document).ready(function() {
	$('tbody').children().children().mouseover(function() {
// 		console.log($(this).text())
	})

})


	

			

		
	</script>

