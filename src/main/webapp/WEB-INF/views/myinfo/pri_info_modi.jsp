<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">고객정보관리</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								  <span class="h2 mr-1"> > </span>
								 <a href="pri_info_chk" class="btn btn-white btn-sm btn-border mr-1">고객정보 조회</a>
								 <span class="h2 mr-1"> > </span>
								 <a href="pri_info_modi" class="btn btn-white btn-sm btn-border mr-1">고객정보 수정</a>
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
				<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									
									
								</div>
								
								<div class="card-body">
									<div class="row">
										<div class="col-md-10">
											<div class="table-responsive table-hover table-sales">
											<div  style="margin: auto;">
									
									
									
									
									
										
										
										
										<div class="card-body" style="">
									
									<table class="table mt-3">
										<thead>
											<tr>
												<th colspan="4">기본정보</th>

											</tr>
										</thead>
										<tbody>
											<tr>
												<td>이름</td>
												<td><div class="col-md-9 p-0">
													<input type="text" class="form-control input-full" id="inlineinput" placeholder="Enter Input">
												</div></td>
												
											</tr>
												<tr>
													<th scope="col">전화번호</th>
													<td>
														<div class="row">
															<div class="col-2">
																<select class="form-control" id="exampleFormControlSelect1">
																	<option>SKT</option>
																	<option>KT</option>
																	<option>LGU</option>
																</select>
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
														</div>
													</td>
												</tr>
											
										</tbody>
									</table>
									
									<table class="table mt-3">
										<thead>
											<tr>
												<th scope="col">자택정보</th>
												<th scope="col"></th>
												<th scope="col"></th>
												<th scope="col"></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>자택 주소</td>
												<td><div class="col-md-9 p-0">
													<input type="text" class="form-control input-full" id="inlineinput" placeholder="우편번호">
													<input type="text" class="form-control input-full" id="inlineinput" placeholder="주소">
												</div></td>
												
											</tr>
											<tr>
												<td>자택 전화번호</td>
												<td><div class="col-md-9 p-0">
													<input type="text" class="form-control input-full" id="inlineinput" placeholder="Enter Input">
												</div></td>
												
											</tr>
											
										</tbody>
									</table>
									
									<table class="table mt-1">
										<thead>
											<tr>
												<th scope="col">기타정보</th>
												<th scope="col"></th>
												<th scope="col"></th>
												<th scope="col"></th>
												
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>sms수신여부</td>
												<td><div class="form-check">
												
												<label class="form-radio-label">
													<input class="form-radio-input" type="radio" name="optionsRadios" value="" checked="">
													<span class="form-radio-sign">동의</span>
												</label>
												<label class="form-radio-label ml-3">
													<input class="form-radio-input" type="radio" name="optionsRadios" value="">
													<span class="form-radio-sign">동의안함</span>
												</label>
											</div></td>
												
										
											
										</tbody>
									</table>
									
									<div id="buttons" style="text-align: center;">
									<a href="pri_info_chk"><button class="btn btn-primary btn-round">취소</button></a>
									<button class="btn btn-primary btn-border btn-round">확인</button>
									</div>
									
								</div>
										
										
										
										
										
										
										
									
									
									
									
									
									
								</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="mapcontainer">
												<div id="map-example" class="vmap"></div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="card-body">
								
								</div>
							</div>
						</div>
					</div>
					
					<!-- 페이지 레이아웃 끝 -->
				</div>
			</div>


			
			
			<script>$("#checkBalance").click(function() {
				location = "checkBalance";
			});
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
