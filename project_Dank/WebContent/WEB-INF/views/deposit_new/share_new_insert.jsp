<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<div class="content">
	<!-- 상단의 푸른색 공간 시작 -->
	<div class="panel-header bg-primary-gradient">
		<div class="page-inner py-5">
			<div
				class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
				<div>
					<h2 class="text-white pb-2 fw-bold">예금</h2>
					<h5 class="text-white op-7 mb-2">
						<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span
							class="flaticon-home" /></a> <span class="h2 mr-1"> > </span> <a
							href="search" class="btn btn-white btn-sm btn-border mr-1">공유계좌</a>
					</h5>
				</div>
				<div class="ml-md-auto py-2 py-md-0">
					<a href="checkbalance"
						class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a> <a
						href="qna" class="btn btn-secondary btn-round">고객센터</a>
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
							<div class="card-title">공유계좌 정보입력</div>
						</div>
					</div>
					<div class="card-body">
						<div class="chart-container" style="min-height: 425px">
							<div class="row">
								<div class="col-md-4 ml-auto">
									<span class="h3">홍길동 고객님</span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-5">
									<table class="table mt-1">
										<thead>

										</thead>
										<tbody>
											<tr>
												<th scope="col">기본 정보 등록</th>
												<td>
													<form action="share_new_req" method="post">
														<input type="hidden" name="shas_code"
															value="${shas_code}"> <input type="hidden"
															name="deptype" value="${deptype}">
														<div class="row">
															<div class="col-md-5">
																<button class="btn btn-default" type="submit">정보
																	등록</button>
															</div>
														</div>
													</form>
												</td>
											</tr>
											<tr>
												<th scope="col">희망 시작일</th>
												<td>
													<div class="row">
														<div class="col-9">
															<input type="text" class="form-control" id=""
																value="2020년 5월 31일">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th colspan="2">
													<form action="share_new_check" method="post">
														<input type="hidden" name="shas_code"
															value="${shas_code}"> <input type="hidden"
															name="deptype" value="${deptype }"> <input
															type="hidden" name="your_name" value="${your_name}">
														<input type="hidden" name="mem_name" value="${mem_name}">
														<button class="btn btn-primary" type="submit">확인</button>
													</form>
												</th>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<canvas id="statisticsChart"></canvas>
						</div>
						<div id="myChartLegend"></div>
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
		id : 'circles-1',
		radius : 45,
		value : 60,
		maxValue : 100,
		width : 7,
		text : 5,
		colors : [ '#f1f1f1', '#FF9E27' ],
		duration : 400,
		wrpClass : 'circles-wrp',
		textClass : 'circles-text',
		styleWrapper : true,
		styleText : true
	})

	Circles.create({
		id : 'circles-2',
		radius : 45,
		value : 70,
		maxValue : 100,
		width : 7,
		text : 36,
		colors : [ '#f1f1f1', '#2BB930' ],
		duration : 400,
		wrpClass : 'circles-wrp',
		textClass : 'circles-text',
		styleWrapper : true,
		styleText : true
	})

	Circles.create({
		id : 'circles-3',
		radius : 45,
		value : 40,
		maxValue : 100,
		width : 7,
		text : 12,
		colors : [ '#f1f1f1', '#F25961' ],
		duration : 400,
		wrpClass : 'circles-wrp',
		textClass : 'circles-text',
		styleWrapper : true,
		styleText : true
	})

	var totalIncomeChart = document.getElementById('totalIncomeChart')
			.getContext('2d');

	var mytotalIncomeChart = new Chart(totalIncomeChart, {
		type : 'bar',
		data : {
			labels : [ "S", "M", "T", "W", "T", "F", "S", "S", "M", "T" ],
			datasets : [ {
				label : "Total Income",
				backgroundColor : '#ff9e27',
				borderColor : 'rgb(23, 125, 255)',
				data : [ 6, 4, 9, 5, 4, 6, 4, 3, 8, 10 ],
			} ],
		},
		options : {
			responsive : true,
			maintainAspectRatio : false,
			legend : {
				display : false,
			},
			scales : {
				yAxes : [ {
					ticks : {
						display : false
					//this will remove only the label
					},
					gridLines : {
						drawBorder : false,
						display : false
					}
				} ],
				xAxes : [ {
					gridLines : {
						drawBorder : false,
						display : false
					}
				} ]
			},
		}
	});

	$('#lineChart').sparkline([ 105, 103, 123, 100, 95, 105, 115 ], {
		type : 'line',
		height : '70',
		width : '100%',
		lineWidth : '2',
		lineColor : '#ffa534',
		fillColor : 'rgba(255, 165, 52, .14)'
	});
</script>
