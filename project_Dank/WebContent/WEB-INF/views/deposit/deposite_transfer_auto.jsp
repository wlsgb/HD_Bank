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
								 <a href="transfer_auto" class="btn btn-white btn-sm btn-border mr-1">자동이체신청내역</a>
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
									<div class="card-title">자동이체 신청내역</div>
								</div>
								<div class="card-body" style="margin-bottom: 20px; margin-top: 0">
									<div class="row">
									<div class="col-md-1 col-lg-1"></div>
										<div class="col-md-10 col-lg-10">
										
							<div class="card">
							<form action="transfer_auto_apply" method="post">
								<div class="card-header">
<!-- 									<div class="card-title">Hoverable Table</div> -->
									<table style="margin: auto; width: 400px; height: 30px;"  >
									<tr>
									<td>계좌번호</td>
									<td>
<!-- 									<input type="text" placeholder="110-111-12345 : 보통예금" style="width: 300px; margin-left: 20%;"/> -->
										<select name="ac_num" id="ac_num" class="form-control" >
										<c:forEach var="e" items="${aclist }" varStatus="i">
										<c:if test="${e.saving.sav_name != '0'}">
											<c:if test="${i.index eq 0 }">
											<option value="" selected="selected">선택</option>
											</c:if>
											<option>${e.ac_num }</option>
											</c:if>
											</c:forEach>
										</select>
									</td>
									</tr>
									</table>
								</div>
								<div class="card-body">
									<table class="table table-bordered">
										
										
										
										
										<tbody style="border: 2px solid black;" id="ajaxtarget">
											
										
											
											
										</tbody>
																		
										
									</table>
<!-- 										<div style="margin-left: 40%; margin-bottom: 20px;"> -->
<!-- 											<button class="btn btn-default btn-xs" type="submit">1</button> -->
<!-- 											<button class="btn btn-default btn-xs" type="submit">2</button> -->
<!-- 											<button class="btn btn-default btn-xs" type="submit">3</button> -->
<!-- 											<button class="btn btn-default btn-xs" type="submit">4</button> -->
<!-- 										</div> -->
										
										
								<div style="margin-left: 35%;">
								<button type="button" class="btn btn-info ">확인</button>
								
								<button type="submit" class="btn btn-info ">자동이체 신청</button>
								
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
				
			</div>


		
			
			
			<script>
			
		$(document).ready(function() {
			
			
			setInterval(function() {
				
				$.ajax({
					url:"atloadval",
					success:function(data1){
						
						$.each(data1, function(index, item) {
							
							var nowtimehour =String(new Date().getHours());
							var nowtimeminute = String(new Date().getMinutes());
							
							if (nowtimehour.length < 2) nowtimehour = '0' + nowtimehour;
							if (nowtimeminute.length < 2) nowtimeminute = '0' + nowtimeminute;
							
							var nowtimeyear = String(new Date().getFullYear());
							var nowtimemonth = String(new Date().getMonth()+1);
							var nowtimedate = String(new Date().getDate());
							
							if (nowtimemonth.length < 2) nowtimemonth = '0' + nowtimemonth;
							if (nowtimedate.length < 2) nowtimedate = '0' + nowtimedate;
							
							
							
							
							let myac = item.ac_num;
							let yourac = item.ata_yourac;
							let youracmem = item.ata_yourmemcode;
							let trmoney = item.ata_setmoney;
							let youracwrite =item.ata_youracmemo;
							let myacwrite = item.ata_myacmemo;
							let memcode = item.ata_mymemcode;
							let atacode = item.ata_code;
							
							var ajax2param = new Object();
							ajax2param.myac = myac;
							ajax2param.yourac = yourac;
							ajax2param.youracmem = youracmem;
							ajax2param.trmoney = trmoney;
							ajax2param.youracwrite = youracwrite;
							ajax2param.myacwrite = myacwrite;
							ajax2param.memcode = memcode;
							ajax2param.atacode = atacode;
							
							
							console.log(JSON.stringify(ajax2param));
							
							
							let ajaxtimearr = String(item.ata_time).split(":");
							let ajaxdatearr = String(item.ata_startdate).split("-");
							
							console.log("---------------------")
							console.log(myac)
							console.log(yourac)
							console.log(youracmem)
							console.log(trmoney)
							console.log(youracwrite)
							console.log(myacwrite)
							console.log("---------------------")
							console.log(nowtimemonth)
							console.log(item.ata_myacmemo)
							console.log(nowtimeyear+"vs"+ajaxdatearr[0])
							console.log(nowtimemonth+"vs"+ajaxdatearr[1])
							console.log(nowtimedate+"vs"+ajaxdatearr[2])
							console.log(nowtimehour+"vs"+ajaxtimearr[0])
							console.log(nowtimeminute+"vs"+ajaxdatearr[1])
							
							
							if(parseInt(ajaxdatearr[0]) <= parseInt(nowtimeyear)){
								console.log('오케이 년 통과')
								if(parseInt(ajaxdatearr[1]) <= parseInt(nowtimemonth)){
									console.log('오케이 월 통과')
									
									if(parseInt(ajaxdatearr[2]) < parseInt(nowtimedate)){
										console.log('해당달의 오늘이전')
										console.log('자동이체 되야함 (대충자동이체메서드)')
									}else if(parseInt(ajaxdatearr[2]) === parseInt(nowtimedate)){
										console.log('오늘')
										console.log('시간이되면 자동이체해야댐')
										
										
										if(parseInt(ajaxtimearr[0]) < parseInt(nowtimehour)){
											console.log('시간 지남 자동이체 해야 했어야함')
										}else if(parseInt(ajaxtimearr[0]) === parseInt(nowtimehour)){
											console.log('시간이 같네? 이제 분 비교하자')
											if(parseInt(ajaxtimearr[1]) < parseInt(nowtimeminute)){
												console.log('분이 지남 자동이체 해야 했엇음')
											}else if(parseInt(ajaxtimearr[1]) === parseInt(nowtimeminute)){
												console.log('time is 자동이체')
												$.ajax({
													type:"POST",
													url:"atprocess",
													dataType:"json",
													data:JSON.parse(JSON.stringify(ajax2param)),
													success: function(){
														console.log("서블릿으로 보냄 ^^")
													}
													
												})

											}
											
										}

									}else if(parseInt(ajaxdatearr[2]) >= parseInt(nowtimedate)){
										console.log('해당달의오늘이후')
										console.log('자동이체 하면 안댐')
									}
									
									
									
								}else {
									console.log("나가뤼")
								}
							}else {
								console.log("나가뤼")
								
							}
							
							
							
							console.log("현재시각"+nowtimehour+":"+nowtimeminute)
							console.log(ajaxdatearr[0]+"//"+ajaxdatearr[1]+"//"+ajaxdatearr[2]+"//"+ajaxtimearr[0]+"//"+ajaxtimearr[1]+"//")
						})
					}
				})
				
			}, 5000)
			
			
			
			
			
			///////////////////////////////////////////////////
			
	
			
			
			
			
			
			
			
			
			
			
			$('#ac_num').change(function() {
				console.log("SSS")
				$('#ajaxtarget').html("");
				$.ajax({
					url:'deposit_transfer_auto_server?ac_num='+$('#ac_num').val(),
					success:function(data){
						$('#ajaxtarget').html(data);
					}
				})
			})
		})
	</script>
	
	
	
	
