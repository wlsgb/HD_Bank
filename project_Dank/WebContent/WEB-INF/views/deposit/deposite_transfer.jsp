<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


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
										<form action="transfer_process" method="post">
											<div class="form-group">
												<label for="email2">출금계좌번호</label>
												<input type="text" name="myac" class="form-control" style="width: 400px; margin-left: 10%;" id="email2" placeholder="110-111-12345 : 보통예금">
<!-- 														<select class="form-control" style="width: 400px; margin-left: 10%;" > -->
<!-- 														  <option>국민 : 1111-2555-7444</option> -->
<!-- 														  <option>기업 : 11188584-547-445</option> -->
<!-- 														  <option>신한 : 116-56-54456-45</option> -->
<!-- 														  <option selected="selected">제주 : 11155-99-88775</option> -->
														  
<!-- 														</select> -->
											</div>
											<hr class="my-0">
											
											<div class="form-group " >
												<label for="email2" >입금계좌번호</label>
												<br />
												  <div class="selectgroup w-40 " style="margin-left: 10%;" >
													<label class="selectgroup-item"  >
														<input type="radio"  value="50" class="selectgroup-input" >
														<span class="selectgroup-button" style="width: 200px;">+100만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio"  value="200" class="selectgroup-input">
														<span class="selectgroup-button" style="width: 200px;">+50만</span>
													</label>
													
											
												</div>
												<div class="form-inline" style="margin-left: 10%;" >
												<input type="text" placeholder="국민" class="form-control" style=" text-align:center; width: 100px;" />
												<input type="text" name="yourac" placeholder="입금 계좌 번호" class="form-control" style=" text-align:center; width: 300px;"/>
												<input type="text" name="youracmem" placeholder="멤버코드" class="form-control" style=" text-align:center; background-color:red; width: 300px;"/>
												    </div>
												 </div>
												 <hr class="my-0">
												 <div class="form-group " >
												<label for="email2" >이체금액</label>
												<br />
												  <div class="selectgroup w-30 " style="margin-left: 11%;" >
													<label class="selectgroup-item"  >
														<input type="radio"  value="50" class="selectgroup-input" >
														<span class="selectgroup-button">+100만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio"  value="200" class="selectgroup-input">
														<span class="selectgroup-button">+50만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio"  value="200" class="selectgroup-input">
														<span class="selectgroup-button">+10만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio"  value="200" class="selectgroup-input">
														<span class="selectgroup-button">+5만</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio"  value="200" class="selectgroup-input">
														<span class="selectgroup-button">전액</span>
													</label>
											
												</div>
												<div class="form-inline" style="margin-left: 10%;" >
												
												<input type="text" name="trmoney" placeholder="이체 금액" class="form-control" style=" text-align:center; width: 360px;"/>
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
												 <input type="submit" value="확인" class="btn btn-success  btn-lg" style="margin-left: 20%; width: 25%; "/>
												
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
		Circles.create({
			id:'circles-1',
			radius:45,
			value:60,
			maxValue:100,
			width:7,
			text: 5,
			colors:['#f1f1f1', '#FF9E27'],
			duration:400,
			wrpClass:'circles-wrp',
			textClass:'circles-text',
			styleWrapper:true,
			styleText:true
		})

		Circles.create({
			id:'circles-2',
			radius:45,
			value:70,
			maxValue:100,
			width:7,
			text: 36,
			colors:['#f1f1f1', '#2BB930'],
			duration:400,
			wrpClass:'circles-wrp',
			textClass:'circles-text',
			styleWrapper:true,
			styleText:true
		})

		Circles.create({
			id:'circles-3',
			radius:45,
			value:40,
			maxValue:100,
			width:7,
			text: 12,
			colors:['#f1f1f1', '#F25961'],
			duration:400,
			wrpClass:'circles-wrp',
			textClass:'circles-text',
			styleWrapper:true,
			styleText:true
		})

		var totalIncomeChart = document.getElementById('totalIncomeChart').getContext('2d');

		var mytotalIncomeChart = new Chart(totalIncomeChart, {
			type: 'bar',
			data: {
				labels: ["S", "M", "T", "W", "T", "F", "S", "S", "M", "T"],
				datasets : [{
					label: "Total Income",
					backgroundColor: '#ff9e27',
					borderColor: 'rgb(23, 125, 255)',
					data: [6, 4, 9, 5, 4, 6, 4, 3, 8, 10],
				}],
			},
			options: {
				responsive: true,
				maintainAspectRatio: false,
				legend: {
					display: false,
				},
				scales: {
					yAxes: [{
						ticks: {
							display: false //this will remove only the label
						},
						gridLines : {
							drawBorder: false,
							display : false
						}
					}],
					xAxes : [ {
						gridLines : {
							drawBorder: false,
							display : false
						}
					}]
				},
			}
		});

		$('#lineChart').sparkline([105,103,123,100,95,105,115], {
			type: 'line',
			height: '70',
			width: '100%',
			lineWidth: '2',
			lineColor: '#ffa534',
			fillColor: 'rgba(255, 165, 52, .14)'
		});
	</script>

