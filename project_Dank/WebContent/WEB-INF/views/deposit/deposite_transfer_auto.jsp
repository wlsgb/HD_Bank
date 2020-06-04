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
								<div class="card-header">
<!-- 									<div class="card-title">Hoverable Table</div> -->
									<table style="margin: auto; width: 400px; height: 30px;"  >
									<tr>
									<td>계좌번호</td><td><input type="text" placeholder="110-111-12345 : 보통예금" style="width: 300px; margin-left: 20%;"/></td>
									</tr>
									</table>
								</div>
								<div class="card-body">
									<table class="table table-hover">
										
										
										
										
										<tbody>
									
											<tr>
												<td>
													<table>
													<tr  >
														<td style="border-style: none;">▶</td ><td colspan="2"  style="border-style: none;">슈퍼 정기 예금</td>
														
													</tr>
													<tr>
														<td style="border-style: none;"></td><td style="border-style: none;" colspan="2">카카오 123-12-1558-52</td>
														
													</tr>
													<tr >
														<td style="border-style: none;"></td><td style="border-style: none;">매월 10일 </td><td>| 홍길동</td>
														
													</tr>
													</table>
												
											</tr>
											<tr>
												<td>
													<table>
													<tr  >
														<td style="border-style: none;">▶</td ><td colspan="2"  style="border-style: none;">주택청약적금</td>
														
													</tr>
													<tr>
														<td style="border-style: none;"></td><td style="border-style: none;" colspan="2">국민 123-12-1558-52</td>
														
													</tr>
													<tr >
														<td style="border-style: none;"></td><td style="border-style: none;">매월 20일 </td><td>| 임성</td>
														
													</tr>
													</table>
												</td>
											</tr>
											
										</tbody>
									</table>
										<div style="margin-left: 40%; margin-bottom: 20px;">
											<button class="btn btn-default btn-xs" type="submit">1</button>
											<button class="btn btn-default btn-xs" type="submit">2</button>
											<button class="btn btn-default btn-xs" type="submit">3</button>
											<button class="btn btn-default btn-xs" type="submit">4</button>
										</div>
										
										
								<div style="margin-left: 35%;">
								<button type="button" class="btn btn-info ">확인</button>
								
								<a href="transfer_auto_apply"><button type="button" class="btn btn-info ">자동이체 신청</button></a>
								
								</div>
								
								
								</div>
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
