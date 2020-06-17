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
								 <a href="transfer" class="btn btn-white btn-sm btn-border mr-1">이체</a> 
								 <span class="h2 mr-1"> > </span>
								 <a href="transfer" class="btn btn-white btn-sm btn-border mr-1">이체하기</a>
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
							
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">이체</div>
								</div>
								<div class="card-body" style="margin-bottom: 20px;">
									<div class="row">
									<div class="col-md-2 col-lg-2"></div>
										<div class="col-md-8 col-lg-8">
										<form action="transfer_process" method="post" id="needform">
											<div class="form-group">
												<label for="email2">출금계좌번호</label>
<!-- 												<input type="text" name="myac" class="form-control" style="width: 400px; margin-left: 10%;" id="email2" placeholder="110-111-12345 : 보통예금"> -->
														<select class="form-control" style="width: 400px; margin-left: 10%;" name="myac" id="myac" form="needform" >
														<c:forEach var="k" items="${myaclist }">
														  <option value="${k}">${k}</option>
<!-- 														  <option>기업 : 11188584-547-445</option> -->
<!-- 														  <option>신한 : 116-56-54456-45</option> -->
<!-- 														  <option selected="selected">제주 : 11155-99-88775</option> -->
														  </c:forEach>
														</select>
											</div>
											<hr class="my-0">
											
											<div class="form-group " >
												<label for="email2" >입금계좌번호</label>
												<br />
												  
												<div class="form-inline" style="margin-left: 10%;" >
												<input type="text" placeholder="HD" class="form-control" style=" text-align:center; width: 60px;" />
												<input type="text" name="yourac" placeholder="입금 계좌 번호" id="inputacval" maxlength="10" class="form-control" style=" text-align:center; width: 200px;"/>
												<select class='form-control' style='width: 140px; margin-left: 0%; ' id='selectyourname'>
													<option>대상이름</option>
												</select>
												<input type="hidden" name="youracmem" placeholder="멤버코드" id="trmem" class="form-control" style=" text-align:center; background-color:red; width: 300px;"/>
												<div id="ajaxtarget"></div>
												    </div>
												 </div>
												 <hr class="my-0">
												 <div class="form-group " >
												<label for="email2" >이체금액</label>
												<br />
												 
												<div class="selectgroup w-30" style="margin-left: 11%;" id="moneyselect">
													<label class="selectgroup-item">
														<input type="radio" name="mselect" value="100000" class="selectgroup-input">
														<span class="selectgroup-button">10만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="mselect" value="50000" class="selectgroup-input">
														<span class="selectgroup-button">5만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="mselect" value="30000" class="selectgroup-input">
														<span class="selectgroup-button">3만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="mselect" value="10000" class="selectgroup-input">
														<span class="selectgroup-button">1만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="mselect" value="all" class="selectgroup-input">
														<span class="selectgroup-button">전액</span>
													</label>
												</div>
												<div class="form-inline" style="margin-left: 10%;" >
												
												<input type="text" name="trmoney" id="trmoney" placeholder="이체 금액" class="form-control" style=" text-align:center; width: 360px;"/>
												    </div>
												 </div>
												 <hr class="my-0">
												 <div class="form-group " >
												<label for="email2" >받는분 통장 표시</label>
												<br />
												  
												<div class="form-inline" style="margin-left: 10%;" >
												
												<input type="text" name="youracwrite" placeholder="10자 이내" maxlength="10" class="form-control" style=" text-align:center; width: 360px;"/>
												    </div>
												 </div>
											
												 <div class="form-group " >
												<label for="email2" >내 통장 표시</label>
												<br />
												  
												<div class="form-inline" style="margin-left: 10%;" >
												
												<input type="text" name="myacwrite" placeholder="10자 이내"  maxlength="10" class="form-control" style=" text-align:center; width: 360px;"/>
												    </div>
												 </div>
												 
												 <div class="form-group "  >
												 <a href="transfer_auto"><button type="button" class="btn btn-success  btn-lg" style="margin-left: 2%; width: 25%; ">자동이체</button></a>
												 <input type="button" id="gogonext" value="확인" class="btn btn-success  btn-lg" style="margin-left: 20%; width: 25%; "/>
												
												 </div>
											
											</form>
											
											
											
											
											</div>
											
											
											
							

										
									</div>
								</div>
								
							</div>
						</div>
						</div>
						

						

				
				</div>
				
			</div>


	
			
			
	<script>
		var getarr =null;
		 
		
		
		
		$(document).ready(function() {
			$('#inputacval').keyup(function() {
				
				document.getElementById('ajaxtarget').innerHTML ="";
				var add = "";
				$.ajax({
					url:'getmemcodewhentr?acnum='+$('#inputacval').val(),
					success: function (data) {
								getarr=data;
								console.log(typeof(data))
								
								data.forEach(function(item, index) {
									add +="<option value="+item.mem_code+">";
									if(item.mem_code==='0'){
										add +="대상이름";
									}else{
										add +=item.mem_name
									}
									
									add +="</option>";
								})
								document.getElementById('selectyourname').innerHTML = add;
								
								$('#trmem').val($('#selectyourname').val())
					}

				})
				
				
				
				
			})
			
			$('#selectyourname').change(function() {
				$('#trmem').val("0");
				var youracvar =$('#selectyourname').val();
				console.log(typeof(youracvar))
				$('#trmem').val(youracvar);
				console.log("히드값은"+$('#trmem').val());
			})
			
			$("input:radio[name=mselect]").click(function() {
				$('#trmoney').val($(this).val())
				var radioval =$(this).val()
				var radiovalint =parseInt($(this).val())
				console.log("라디오갑"+radioval)
				
				$.ajax({
					url:'getmybalwhentr?ac_num='+$('#myac').val(),
					success: function (data) {
						console.log(data)
						console.log(typeof(data))
						console.log(typeof(radiovalint))
						let money = parseInt(data)
						
						if(radiovalint > money || radioval==='all'){
							$('#trmoney').val(money)
						}else{
							$('#trmoney').val(radioval)
						}
						
					}
				})
				
			})
			
			$('#trmoney').keyup(function() {
				console.log($(this).val())
				
				$.ajax({
					url:'getmybalwhentr?ac_num='+$('#myac').val(),
					success: function (data) {

						if(parseInt($('#trmoney').val()) > parseInt(data)){
							$('#trmoney').val(data)
						}
						
					}
				})
							
					

			})
				
			$('#gogonext').mouseover(function() {
				if((($('#trmem').val() === "0")===false) && (($('#atapplymem').val() === "")=== false) ){
					
					$('#gogonext').attr('type','submit')
				}else {
					
					$('#gogonext').attr('type','button')
				}

			})
		
			
		})
	</script>

