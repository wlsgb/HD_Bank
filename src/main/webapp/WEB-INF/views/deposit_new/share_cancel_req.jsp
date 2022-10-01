<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">예금</h2>
								<h5 class="text-white op-7 mb-2">예금>신규>공유계좌</h5>
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
									<div class="card-head-row">
										<div class="card-title">공유계좌 신청</div>
									</div>
								</div>
								<div class="card-body">
									<div class="chart-container" style="min-height: 425px">
									<div class="row ">
										<div class="col-md-9">
											<div class="card full-height">
												<div class="card-body">
													<div class="card-title">입출금식 예금 상품</div>
													<div class="row">
														<div class="card-category">슈퍼 정기 예금</div>
													</div>								
													<div class="flex-1 ml-3 pt-1">
														<h6 class="text-uppercase fw-bold mb-1">가입날짜 : 2020.05.31</h6>
														<h6 class="text-uppercase fw-bold mb-1">계좌번호 : 110-123-78999</h6>
														<h6 class="text-uppercase fw-bold mb-1">잔액 : 5,000,000</h6>
													</div>
													<hr>
													<div class="row">
														<div class="col-2">
															<h6 class="text-uppercase fw-bold mb-1">비밀번호</h6>
														</div>
														<div class="col-7">
															<input type="text" class="form-control input-full" id="" placeholder="내용을 입력해주세요">
														</div>
													</div>
													<div class="row">
														<div class="col-2">
															<h6 class="text-uppercase fw-bold mb-1">입금 계좌번호</h6>
														</div>
														<div class="col-7">
															<input type="text" class="form-control input-full" id="" placeholder="내용을 입력해주세요">
														</div>
													</div>
													<div class="row">
														<div class="col-md-4 ml-auto">
															<button class="btn btn-default">취소</button>	
															<button class="btn btn-default">해지하기</button>	
														<div class="col-7">
													</div>
												</div>
											</div>
										</div>
									</div>
									<!--  -->
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
