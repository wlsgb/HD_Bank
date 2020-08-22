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
				<form method="post" name="myform">
				
				<div class="row mt--4">
				<div class="col-sm-6 col-md-2"></div>
						<div class="col-sm-6 col-md-8">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
										<h2>&nbsp;&nbsp;&nbsp;&nbsp;대출 상환</h2>
											<table class="table table-hover">
												
													<tr>
														<th>대출명</th>
														<td><input type="text" readonly="readonly" name="lp_name" value="${vo.loanProductVO.lp_name }"> </td>
													</tr>
													<tr>
														<th>대출번호</th>
														<td><input type="text" name="lc_num" value="${vo.lc_num }" readonly="readonly"> </td>
													</tr>
													<tr>
														<th>대출이율</th>
														<td><input type="text" readonly="readonly" value="${vo.loanProductVO.lp_interestrate }"></td>
													</tr>
													<tr>
														<th>중도상환수수료</th>
														<td><input type="text" readonly="readonly" value="${vo.loanProductVO.lp_cancelfee }" name="lp_cancelfee" id="lp_cancelfee"></td>
													</tr>	
													<tr>
														<th>대출신청액</th>
														<td><input type="text" readonly="readonly" value="${vo.loanApplicationVO.la_hamount }"></td>
													</tr>
													<tr>
														<th>대출잔액</th>
														<td><input type="text" readonly="readonly" value="${vo.loanRepayVO.lr_balance }" id="repaybal"></td>
													</tr>
													<tr>
														<th>거치기간</th>
														<td><input type="text" readonly="readonly" value="${vo.loanApplicationVO.la_livingterm }"></td>
													</tr>
													<tr>
														<th>상환기간</th>
														<td><input type="text" readonly="readonly" value="${vo.loanApplicationVO.la_repayterm }"></td>
													</tr>
													<tr>
														<th>상환계좌</th>
														<td>
														<select name="ac_num" id="ac_num">
														<c:forEach items="${list }" var="e">
															<option>${e.ac_num }</option>
														</c:forEach>
														</select>
														</td>
													</tr>
													<tr>
														<th>최대 상환 금액</th>
														<td><p id="target"></p></td>
													</tr>
													<tr>
														<th>상환금액</th>
														<td><input type="text" name="lr_balance" id="bal"></td>
													</tr>	
													
													<tr>
														<td colspan="2">
											<p class="text-center"><button type="button" class="btn btn-lg btn-primary repay" value="${vo.lc_num }" onclick="check()">상환하기</button></p>
														
														</td>
													</tr>	
												
											</table>

										
										</div>
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-2">
		</div>
			
						</div>
		</form>
		
		
			</div>
		
			

			
			
			<script>
			
		
			
		function check(){
			var myform = document.myform;
			var bal = Number($('#bal').val())
			var repaybal = Number($('#repaybal').val())
			var can = Number($('#lp_cancelfee').val())
			if((bal/100)*(100-can)>repaybal){
				alert('상환 금액이 대출 잔액보다 큽니다.')
				return;
			}
			myform.action = 'loanrepay'
			bal = $('#bal').val().replace(/,/g,"")
			$('#bal').val(bal)
			myform.submit() 
			
		}
		
		$('#bal').keyup(function() {
			x = $(this).val()
	        x = x.replace(/[^0-9]/g,'');
	        x = x.replace(/,/g,'');
	        if(parseInt(x)>parseInt($('#target').text().replace(/,/g,''))){
	        	alert('상환 가능 최대 금액을 초과해서 입력하셨습니다.')
	        	$(this).val($('#target').text().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
	        }else{
	        	$(this).val(x.replace(/\B(?=(\d{3})+(?!\d))/g, ","));	
	        }
			
		})
		
		
		window.onload = function(){
			var repaybal = Number($('#repaybal').val())
			var can = Number($('#lp_cancelfee').val())
			var max = (repaybal*100)/(100-can)
			
			max = Math.floor(max)
			max = max + ""
			document.getElementById('target').innerHTML = max.replace(/\B(?=(\d{3})+(?!\d))/g, ",")
		}
		
	</script>

