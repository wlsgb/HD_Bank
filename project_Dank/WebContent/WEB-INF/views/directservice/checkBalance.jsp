<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">Dank</h2>
								<h5 class="text-white op-7 mb-2">어서오세요. Dank 빠른페이지입니다.</h5>
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
						<!-- 좌측 버튼 4개 시작 -->
						<div class="col-md-2">
							<!-- 계좌 조회 -->
							<div class="card card-primary bg-primary-gradient" href="#pills-home-nobd">
								<div class="card-body">
									<h2 class="mb-2">계좌 조회</h2>
									<p class="d-flex justify-content-between pb-1 pt-1">Check balance</p>
								</div>
							</div>
							<!-- 계좌 조회 -->
							<!-- 계좌 이체 -->
							<div class="card" id="transfer">
								<div class="card-body pb-0">
									<h2 class="mb-2">계좌 이체</h2>
									<p class="text-muted">Wire money</p>
								</div>
							</div>
							<!-- 계좌 이체 -->
							<!-- 분석 -->
							<div class="card" id="analysis">
								<div class="card-body pb-0">
									<h2 class="mb-2">분석</h2>
									<p class="text-muted">Analysis</p>
								</div>
							</div>
							<!-- 분석 -->
							<!-- 환율 조회 -->
							<div class="card" id="exchangeRate">
								<div class="card-body pb-0">
									<h2 class="mb-2">환율 조회</h2>
									<p class="text-muted">Exchange rate</p>
								</div>
							</div>
							<!-- 환율 조회 -->
						</div>
						<!-- 좌측 버튼 4개 끝 -->
						<div class="col-md-10">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row">
										<div class="card-title">계좌조회</div>
									</div>
								</div>
								<div class="card-body">
									<div class="chart-container" style="min-height: 425px">
									
									<div class="row">
									<div class="col-5">
									
									<form action="chkvalue" method="post" >
										<table class="table mt-1">
											<tbody>
												<tr>
													<th scope="col">계좌 번호</th>
													<td>
														<div class="col-md-12 p-0">
															<input type="text" class="form-control input-full" 
															id="accountNumber" name="accountNumber" placeholder="(-없이 입력)" maxlength="10">
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">계좌 암호</th>
													<td>
														<div class="col-md-12 p-0">
															<input type="password" class="form-control input-full" 
															id="accountPassword" name="accountPassword" placeholder="(4자리)" maxlength="4">
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">주민번호</th>
													<td>
														<div class="col-md-12 p-0">
															<input type="text" class="form-control input-full" 
															id="cnn" name="cnn" placeholder="(앞 6자리)" maxlength="6">
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">조회구분</th>
													<td>
														<div class="col-md-12 p-0">
															<label class="form-radio-label">
																<input class="form-radio-input" type="radio" name="type" checked="checked" value="0">
																<span class="form-radio-sign">전체</span>
															</label>
															<label class="form-radio-label ml-12">
																<input class="form-radio-input" type="radio" name="type" value="1">
																<span class="form-radio-sign">입금</span>
															</label>
															<label class="form-radio-label ml-12">
																<input class="form-radio-input" type="radio" name="type" value="2">
																<span class="form-radio-sign">출금</span>
															</label>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">조회 날짜</th>
													<td>
														<div class="col-md-12 p-0">
															<input class="form-control" type="date" id="searchDate" name="searchDate">
														</div>
													</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<th colspan="2">
														<div class="row">
															<div class="col-md-6 ml-auto mr-auto">
																<input type="submit" value="조회" class="btn btn-success"/>
															</div>
														</div>
													</th>
												</tr>
											</tfoot>
										</table>
										</form>
									</div>
									
									<div class="col-md-7">
										<table class="table mt-1">
											<thead>
												<tr>
													<th scope="col">날짜</th>
													<th scope="col">비고</th>
													<th scope="col">사용금액</th>
												</tr>
											</thead>
											
											<tbody>
												<tr>
													<c:if test="${type!=null}">
														<td>2020.05.22</td>
														<td>안양고용부</td>
														<td>
															<p class="blockquote blockquote-primary">284,000원</p>
															<span class="h6" style="text-align: left;">620,520원</span>
														</td>
													</c:if>
												</tr>
												
											</tbody>
										</table>
									</div>
								</div>
										<canvas id="statisticsChart"></canvas>
									</div>
									<div id="myChartLegend">
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
			/* 페이지 이동 자바스크립트 시작 */
			$("#checkBalance").click(function() {
				location = "checkbalance";
			});
			$("#transfer").click(function() {
				location = "transfer";
			});
			$("#analysis").click(function() {
				location = "analysis";
			});
			$("#exchangeRate").click(function() {
				location = "exchangerate";
			});
			/* 페이지 이동 자바스크립트 끝 */
			
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

