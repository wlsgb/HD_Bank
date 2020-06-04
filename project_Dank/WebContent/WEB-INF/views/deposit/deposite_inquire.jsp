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
								 <a href="inquire" class="btn btn-white btn-sm btn-border mr-1">조회</a> 
								 <span class="h2 mr-1"> > </span>
								 <a href="inquire" class="btn btn-white btn-sm btn-border mr-1">계좌조회</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="#" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<div class="page-inner mt--5">

					<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">입출금</h4>
										<div class="card-tools">
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-angle-down"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
											
										</div>
									</div>


								<table class="table">
													<thead>
														<tr>
															<th>상품명</th>
															<th>계좌번호</th>
															<th class="text-right">
																잔액
															</th>
															<th class="text-right">
																비고
															</th>
														</tr>
														
													</thead>
													<tbody>
													<tr>
															<td>보통예금</td>
															<td>110-111-12345</td>
															<td class="text-right">
																40,000,000
															</td>
															<td class="text-right">
																<a href="inquire_detail"><input type="button" value="조회"  /></a>
																<a href="transfer"><input type="button" value="이체" /></a>
															</td>
														</tr>
														<tr>
															<td>저축예금</td>
															<td>110-111-45625</td>
															<td class="text-right">
																10,000,000
															</td>
															<td class="text-right">
																<a href="inquire_detail"><input type="button" value="조회"  /></a>
																<a href="transfer"><input type="button" value="이체" /></a>
															</td>
														</tr>
														<tr>
															<td>국민예금</td>
															<td>110-111-78966</td>
															<td class="text-right">
																30,000,000
															</td>
															<td class="text-right">
																<a href="inquire_detail"><input type="button" value="조회"  /></a>
																<a href="transfer"><input type="button" value="이체" /></a>
															</td>
														</tr>
													
													
													</tbody>
								</table>
								</div>

							</div>
						</div>
					</div>
					<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">적금</h4>
										<div class="card-tools">
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-angle-down"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
											
										</div>
									</div>


								<table class="table">
													<thead>
														<tr>
															<th>상품명</th>
															<th>계좌번호</th>
															<th class="text-right">
																잔액
															</th>
															<th class="text-right">
																비고
															</th>
														</tr>
														
													</thead>
													<tbody>
													<tr>
															<td>주택청약적금</td>
															<td>110-111-12345</td>
															<td class="text-right">
																40,000,000
															</td>
															<td class="text-right">
																<a href="inquire_detail"><input type="button" value="조회"  /></a>
																<a href="transfer"><input type="button" value="이체" /></a>
															</td>
														</tr>
														<tr>
															<td>나라사랑적금</td>
															<td>110-111-45625</td>
															<td class="text-right">
																10,000,000
															</td>
															<td class="text-right">
																<a href="inquire_detail"><input type="button" value="조회"  /></a>
																<a href="transfer"><input type="button" value="이체" /></a>
															</td>
														</tr>
														<tr>
															<td>대한민국적금</td>
															<td>110-111-78966</td>
															<td class="text-right">
																30,000,000
															</td>
															<td class="text-right">
																<a href="inquire_detail"><input type="button" value="조회"  /></a>
																<a href="transfer"><input type="button" value="이체" /></a>
															</td>
														</tr>
													
													
													</tbody>
								</table>
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

