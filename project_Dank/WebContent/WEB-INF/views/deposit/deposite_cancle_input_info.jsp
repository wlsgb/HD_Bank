<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">예금</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="deposite_cancle" class="btn btn-white btn-sm btn-border mr-1">해지</a> 
								 <span class="h2 mr-1"> > </span>
								 <a href="deposite_cancle_input_info" class="btn btn-white btn-sm btn-border mr-1">해지정보입력</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<!-- 상단의 푸른색 공간 끝 -->
				<div class="page-inner mt--5">
				<!-- 페이지 레이아웃 시작 -->
				<div class="row">
							
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">해지</div>
								</div>
								<div class="card-body" style="margin-bottom: 20px; margin-top: 0">
									<div class="row">
									<div class="col-md-1 col-lg-1"></div>
										<div class="col-md-10 col-lg-10">
										
<!-- 							<div class="card"> -->
<!-- 								<div class="card-header"> -->
<!-- <!-- 									<div class="card-title">Hoverable Table</div> --> 
									
<!-- 								</div> -->
<!-- 								<div class="card-body"> -->
									<table class="table table-hover">
										
										
										
										
										
													<thead>
													<tr>
													<th colspan="2" style="border-style: none;" >
													<span >입출식 예금 상품</span>
													</th>
													</tr>
													</thead>
													
													
													<tbody>
													<tr>
														<td style="border-style: none; width: 60px; ">▶</td >
														<td  style="border-style: none; width: 140px;">슈퍼 정기 예금</td>
														<td style="width: 400px; border-style: none;">계좌번호 : 110-123-789998</td>
														<td style="border-style: none;">
<!-- 															<button type="button" class="btn btn-info ">해지하기</button> -->
														</td>
														
													</tr>
													<tr>
														<td style="border-style: none;"></td>
														<td style="border-style: none;" >가입날짜 :</td>
														<td style="border-style: none;"> 2020.09.09</td>
														
													</tr>
													<tr >
														<td style="border-style: none;"></td>
														<td style="border-style: none;">잔액 : </td>
														<td style="border-style: none;"> 700원</td>
														<td style="border-style: none;">
<!-- 															<a href="">예금해지 예상 보러가기</a> -->
														</td>
														
													</tr>
												
									</table>
									
									<hr />
									
									 <div class="form-inline" style="margin-left: 10%;">
									<span>입금 계좌번호</span><input type="text" class="form-control" style="width: 400px; margin-left: 30px;" placeholder="계좌번호를 입력해주세요"/>
									</div>
									 <div class="form-inline" style="margin-left: 10%;">
									<span>계정 비밀번호</span><input type="text" class="form-control" style="width: 400px; margin-left: 30px;" placeholder="비밀번호를 입력해주세요"/>
									</div>
									
									<div style="margin-left: 60%; margin-top: 30px;" >
									<a href="deposite_cancle"><button type="button" class="btn btn-info ">취소</button></a>
									<a href="deposite_cancle_check_select"><button type="button" class="btn btn-info ">해지하기</button></a>
								
								
								</div>
								
								
<!-- 								</div> -->
<!-- 							</div> -->
							
							
						
											
										</div>
											
											
											
							

										
									</div>
								</div>
								
							</div>
						</div>
						</div>
					<!-- 우측 컨텐츠 끝 -->
					
					<!-- 페이지 레이아웃 끝 -->
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
