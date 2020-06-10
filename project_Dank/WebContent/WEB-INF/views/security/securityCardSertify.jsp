<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold"><!--  -->보안카드 인증</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="securitycard" class="btn btn-white btn-sm btn-border mr-1">보안카드</a>
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
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">보안카드</h4>
									</div>
									<p class="card-category">인증</p>
								</div>
								
								<div class="card-body">
									<div class="row">
										<div class="col-md-12 ml-auto mr-auto" style="text-align: center;">
											<form action="" method="post">
												<table class="table table-bordered">
													<thead>
														<tr>
															<th colspan="8" style="text-align: left;">
																<span class="h1">보안카드</span>
																<span class="h6" style="font-style: italic;">${name}님</span>
															</th>
															<th colspan="2" style="text-align: right;">일련번호 : ${scrVo.sc_code}</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">1</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_1 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">2</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_2 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">3</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_3 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">4</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_5 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">5</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_6 }</td>
														</tr>
														<tr>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">6</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_6 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">7</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_7 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">8</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_8 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">9</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_9 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">10</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_10 }</td>
														</tr>
														<tr>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">11</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_11 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">12</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_12}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">13</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_13 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">14</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_14 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">15</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_15 }</td>
														</tr>
														<tr>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">16</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_16}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">17</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_17}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">18</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_18 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">19</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_19}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">20</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_20 }</td>
														</tr>
														<tr>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">21</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_21}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">22</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_22}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">23</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_23 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">24</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_24}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">25</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_25 }</td>
														</tr>
														<tr>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">26</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_26}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">27</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_27}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">28</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_28 }</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">29</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_29}</td>
															<td style="text-align: center; font-style: italic; background-color: #F2F2F2;">30</td>
															<td style="text-align: center;">${scrVo.secCard.sc_detcode_30 }</td>
														</tr>
													</tbody>
													
												</table>
												
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 페이지 레이아웃 끝 -->
				</div>
			</div>


	
			
			
			<script>
			$("#success").click(function() {
				location = "security";
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

