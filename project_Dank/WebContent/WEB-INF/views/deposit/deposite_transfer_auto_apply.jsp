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
								 <a href="transfer_auto_apply" class="btn btn-white btn-sm btn-border mr-1">자동이체신청</a>
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
								<div class="card-title">자동이체신청</div>
							</div>
							<div class="card-body" style="margin-bottom: 20px;">
								<div class="row">
									<div class="col-md-2 col-lg-2"></div>
									<div class="col-md-8 col-lg-8">
									<form action="transfer_auto_apply_process" method="post">
										<div class="form-group">
											<label for="email2">계좌번호</label> 
											<select name="ac_num" id="ac_num" class="form-control" style="width: 360px; margin-left: 10%;">
											<c:forEach var="e" items="${myaclist }">
											
											<option value="${e }">${e }</option>
											
											</c:forEach>
											
											</select>
<!-- 											<input type="text" name="ac_num" -->
<!-- 												class="form-control" id="email2" -->
<!-- 												style="width: 400px; margin-left: 10%;" -->
<!-- 												placeholder="110-111-12345 : 보통예금"> -->
										</div>
										<hr class="my-0">

										<div class="form-group ">
											<label for="email2">입금계좌번호</label>

											<div class="form-inline" style="margin-left: 10%;">
												<input type="text" placeholder="HD" class="form-control"
													style="text-align: center; width: 60px;" />
												 <input name="ata_yourac" maxlength="10"
													type="text" placeholder="입금 계좌 번호" class="form-control"
													style="text-align: center; width: 200px;"
													id="inputacval"
													 />
													<select name="" id="selectyourname" class="form-control" >
													
													<option value="">대상이름</option>
													
													</select>
													<input type="hidden" name="ata_yourmemcode" placeholder="멤버코드" id="atapplymem" class="form-control" style=" text-align:center; background-color:red; width: 300px;"/>
												<div id="ajaxtarget"></div>
											</div>
										</div>
										<hr class="my-0">
										<div class="form-group ">
											<label for="email2">자동이체금액설정</label> <br />
						
											<div class="form-inline" style="margin-left: 10%;">

												<input type="text" name="ata_setmoney" id="ata_setmoney" placeholder="이체 금액" class="form-control"
													style="text-align: center; width: 360px;" />
											</div>
										</div>
										<hr class="my-0">
										
										
										<div class="form-group ">
											<label for="email2">시작일/이체시간 설정</label> <br />
												
											<div class="form-inline" style="margin-left: 10%;">
														<input type="date" id="ata_startdate" class="form-control" name="ata_startdate" />
														<input type="time" id="ata_time" name="ata_time"  class="form-control">
											</div>
										</div>
										<div class="form-group ">
											
											<div class="form-inline" >
													<label for="email2">받는분통장에 쓸 내용</label> <br />
													<input type="text" name="atayouracmemo" class="form-control"  placeholder="받는분통장에 쓸 내용" style="text-align: center; width: 300px;"/>
											</div>
											<div class="form-inline">
													<label for="email2">보내는분통장에 쓸 내용</label> <br />
													<input type="text" name="atamyacmemo" class="form-control" placeholder="보내는분통장에 쓸 내용" style="text-align: center; width: 300px;" />
											</div>
										</div>
										<input type="hidden" name="atacheck" value="0" />
										<input type="hidden" name="ataing" value="0" />
										
													  
													  <input type="button" data-toggle="collapse" data-target="#demo" value="매달"/>
			
			
			
														<!--// 숨겨지는 영역 -->
														
														<div id="demo" class="collapse">
															<div class="form-group ">
															<label for="email2">이체주기</label> <br />
				
															<div class="form-inline" style="margin-left: 10%;">
				
																<input type="text" placeholder="매월 19일" class="form-control"
																	style="text-align: center; width: 360px;" name="atadterm" />
															</div>
															</div>
															<div class="form-group ">
															<label for="email2">종료일</label> <br />
				
															<div class="form-inline" style="margin-left: 10%;">
																<input type="date" class="form-control"  name="atastopdate"/>
															</div>
															</div>
																		    
														
														  </div>
														<!-- 숨겨지는 영역 //-->
										
										
										

										

										<div class="form-group ">
											<div class="form-inline">
											
										
												<a href="transfer_auto"><button type="button" class="btn btn-danger "
													style="margin-left: 10%; width: 200px;">취소</button></a>
											
													<input type="button" id="gogonext" class="btn btn-success " value="신청" style="margin-left: 10%; width: 200px;" />
											</div>
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
		var settime="";
		 
		
		
		
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
								
								$('#atapplymem').val($('#selectyourname').val())
					}

				})
				
				
				
				
			})
			
			$('#selectyourname').change(function() {
				$('#atapplymem').val("0");
				var youracvar =$('#selectyourname').val();
				console.log(typeof(youracvar))
				$('#atapplymem').val(youracvar);
				console.log("히드값은"+$('#atapplymem').val());
			})
			
			
			
			
			
			$('#ata_startdate').change(function() {
				settime="0";
				let year=String(new Date().getFullYear());
				let month=String(new Date().getMonth()+1);
				
				let date = String(new Date().getDate());
				
				
				if (month.length < 2) month = '0' + month;
				if (date.length < 2) date = '0' + date;
// 				console.log("몬스는"+month)

				
				let startdatearr = $('#ata_startdate').val().split("-");
				
<<<<<<< HEAD
				console.log("오늘은"+year+"-"+month+"-"+date)
				console.log("고른날짜"+startdatearr[0]+"~"+startdatearr[1]+"~"+startdatearr[2])
				console.log($('#ata_startdate').val())	
=======
// 				console.log("오늘은"+year+"-"+month+"-"+date)
// 				console.log("고른날짜"+startdatearr[0]+"~"+startdatearr[1]+"~"+startdatearr[2])
// 				console.log($('#ata_startdate').val())	
>>>>>>> refs/remotes/origin/master


				if(parseInt(year) <= parseInt(startdatearr[0])){
// 					console.log('오케이 년 통과')
					if(parseInt(year) ===parseInt(startdatearr[0])){
						if(parseInt(month)<=parseInt(startdatearr[1])){
// 							console.log('오케이 달통과')
							if(parseInt(month)===parseInt(startdatearr[1])){
								if(parseInt(date)<=parseInt(startdatearr[2])){
// 									console.log('오케이 일 통과')
									
								}else {
// 									console.log('나가뤼')
									$('#ata_startdate').val(year+'-'+month+'-'+date)
									settime="1";
									checktime();
								}
							}
						}else {
// 							console.log("나가뤼")
							$('#ata_startdate').val(year+'-'+month+'-'+date)
							settime="1";
							checktime();
						}
					}
				}else {
// 					console.log("나가뤼")
					$('#ata_startdate').val(year+'-'+month+'-'+date)
					settime="1";
					checktime();
				}
				
				
				
			})
			
			$('#ata_time').change(function() {
				 checktime();
			})
			
			function checktime(){
// 				console.log("셋타임은? "+settime);
				let hour = String(new Date().getHours());
				let minute = String(new Date().getMinutes());
				
				if (hour.length < 2) hour = '0' + hour;
				if (minute.length < 2) minute = '0' + minute;
				
				let timearr = $('#ata_time').val().split(":");
// 				console.log($('#ata_time').val())
// 				console.log(hour+"s"+minute+"///"+timearr[0]+"sdfa"+timearr[1])
				if(settime ==="1"){
					if(parseInt(hour) <= parseInt(timearr[0])){
// 						console.log('오케이 시간통과')
						if(parseInt(hour) === parseInt(timearr[0])){
							if(parseInt(minute) <=parseInt(timearr[1])){
// 								console.log('오케이 분 통과')
							}else {
// 								console.log('나가리')
								$('#ata_time').val(hour+":"+minute)
							}
						}
						
					}else {
// 						console.log('나가리')
						$('#ata_time').val(hour+":"+minute)
					}
				}
			}
			

			$('#ata_setmoney').keyup(function() {
				console.log($(this).val())
				
				$.ajax({
					url:'getmybalwhentr?ac_num='+$('#ac_num').val(),
					success: function (data) {
// 						console.log(data)
// 						console.log($('#trmoney').val())
						if(parseInt($('#ata_setmoney').val()) > parseInt(data)){
							$('#ata_setmoney').val(data)
						}
						
					}
				})
							
					

			})
				
			
			$('#inputacval').change(function() {
// 				console.log((($('#atapplymem').val() === "0")===false))
// 				console.log((($('#atapplymem').val() === "")===false))
				//console.log($('#atapplymem').val())
				if((($('#atapplymem').val() === "0")===false) && (($('#atapplymem').val() === "")===false) ){
// 					console.log('섬밋이어야함')
					$('#gogonext').attr('type','submit')
				}else {
					
// 					console.log('버튼이여야함')
					$('#gogonext').attr('type','button')
				}
// 				$('#gogonext').attr('type','button')
			})
			
		
			
		})
	</script>

