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
										
											
<!-- 											<div class="form-group " > -->
<!-- 												<label for="email2" >월별조회</label> -->
<!-- 												  <div class="form-inline"> -->
<!-- 												    <label class="col-xs-4"> -->
<!-- 												    <input type="text" class="form-control" style="width: 40%; margin: 10px;" placeholder="2020"><span style="margin: 3px;">년</span> -->
<!-- 												    <input type="text" class="form-control"  style="width: 40%; margin: 10px;"  placeholder="05">월 -->
<!-- 												    </label> -->
												    
<!-- 												  </div> -->
<!-- 											<hr class="my-0"> -->
<!-- 											</div> -->
											
											
											<div class="form-group">
												<label class="form-label">조회기간</label><br />
											
<!-- 												<div class="selectgroup w-30 " style="margin-left:20%" > -->
<!-- 													<label class="selectgroup-item" > -->
<!-- 														<input type="radio" name="value" value="50" class="selectgroup-input" > -->
<!-- 														<span class="selectgroup-button">당일</span> -->
<!-- 													</label> -->
<!-- 													<label class="selectgroup-item"> -->
<!-- 														<input type="radio" name="value" value="100" class="selectgroup-input"> -->
<!-- 														<span class="selectgroup-button">1주일</span> -->
<!-- 													</label> -->
<!-- 													<label class="selectgroup-item"> -->
<!-- 														<input type="radio" name="value" value="200" class="selectgroup-input"> -->
<!-- 														<span class="selectgroup-button">1개월</span> -->
<!-- 													</label> -->
											
<!-- 												</div> -->
													<form action="inquire_detail_slct" method="post">
													 <div class="form-inline">
												    <label class="col-xs-4">
												    <input type="date" class="form-control" name="startdate" id="startdate" style="width: 50%; margin: 10px;"><span style="margin: 3px;">~</span>
												    <input type="date" class="form-control" name="lastdate" id="lastdate" style="width: 50%; margin: 10px;"  >
												    </label>
												    
												  </div>
												  	<input type="hidden" name="ac_num"  value="${ac_num }"/>
												 	<button type="submit" class="btn btn-success" style="margin-left: 35%">조회하기</button>
													</form>
											
											
											
											
											
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
									
									</td>
<!-- 									<td style="width: 400px; text-align: center;">총입금금액 (100건) 5,000,000 원</td> -->
<!-- 									<td style="width: 400px; text-align: center;">총출금금액 (10건) 200,000 원</td> -->
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
										
	
<!-- 										<a data-toggle="modal" data-target="#myModal">s</a> -->
										<c:forEach var="e" items="${history}">
										<!-- Button trigger modal -->


											
											<tr class="modalclick" data-toggle="modal" data-id="${e.sp_code}" data-target="#myModal">
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
<!-- 								<div style="margin:10px auto;"> -->
<!-- 								<button type="button" class="btn btn-info btn-sm">엑셀 내리기</button> -->
<!-- 								<div id="result" style="position: absolute; background: #000; width: 30px; height: 30px; opacity: 0.4; border-radius: 100%;"> </div> -->


<!-- 								</div> -->
							</div>
							</div>

					</div>
				
			</div>

</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">상세보기</h4>
      </div>
      <div class="modal-body">
        <div id="testbody">
        <table class="table table-bordered table-dark">
	        <tr>
	        	<th>거래구분</th><td id="modal1"></td>
	        </tr>
	        <tr>
        		<th>거래일시</th><td id="modal2"></td>
       		</tr>
       		<tr>
        		<th>거래내용</th><td id="modal3"></td>
       		</tr>
       		<tr>
        		<th>금액</th><td id="modal4"></td>
       		</tr>
       		<tr>
        		<th>상대은행</th><td >HD</td>
       		</tr>
       		<tr>
        		<th>상대계좌</th><td id="modal5"></td>
       		</tr>
        
        </table>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
<!-- Button trigger modal end-->
	
			
			
			<script>
			$(document).on("click", ".modalclick", function () {
			     var myId = $(this).data('id');
			     //$(".modal-body #testbody").html(myId)
			     // As pointed out in comments, 
			     // it is unnecessary to have to manually call the modal.
			     // $('#addBookDialog').modal('show');
			     
			     $.ajax({
			 			url:'sp_codeis?sp_code='+myId,
			 			success:function(data){
			 				//console.log(data)
			 				
			 				if(data[0].classified==='이체거래'){
			 					$('#modal1').html(data[0].classified)
				 				$('#modal2').html(data[0].at_date)
				 				$('#modal3').html(data[0].sp_name)
				 				$('#modal4').html(data[0].at_set_mony)
				 				$('#modal5').html(data[0].at_dps_ac)
			 				}else if(data[0].classified==='입금거래'){
			 					$('#modal1').html(data[0].classified)
				 				$('#modal2').html(data[0].dep_date)
				 				$('#modal3').html(data[0].sp_name)
				 				$('#modal4').html(data[0].dep_money)
				 				$('#modal5').html('-')
			 				}else{
			 					$('#modal1').html(data[0].classified)
				 				$('#modal2').html(data[0].wit_date)
				 				$('#modal3').html(data[0].sp_name)
				 				$('#modal4').html(data[0].wit_money)
				 				$('#modal5').html('-')
			 				}
			 				
			 			}		
			     
			 		})
			});


	

			

		
	</script>

