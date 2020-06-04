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
								 <a href="" class="btn btn-white btn-sm btn-border mr-1">예금</a> 
								 <span class="h2 mr-1"> > </span>
								 <a href="" class="btn btn-white btn-sm btn-border mr-1">분석</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="#" class="btn btn-secondary btn-round">고객센터</a>
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
										<h4 class="card-title">오늘까지 쓴 돈</h4>
										<div class="card-tools">
											<a data-toggle="collapse" href="#todayPay" class="collapsed" aria-expanded="false">
												<button class="btn btn-icon btn-link btn-primary btn-xs">
													<span class="fa fa-angle-down"></span>
												</button>
											</a>
											<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-times"></span></button>
										</div>
									</div>
								</div>
								<div class="card-body collapse" id="todayPay">
									<div class="row">
										<div class="col-md-10">
											<div class="card">
											<div class="card-header">
												<div class="card-title">4월 총 지출 : 500,000,000원</div>
												<div class="card-title">5월 총 지출 : 2,500,000,000원</div>
											</div>
												<div class="card-body">
													<div class="chart-container">
														<canvas id="barChart"></canvas>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 소비달력 시작 -->
					<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<div class="col-md-1 p-0">
											<h4 class="card-title">소비달력</h4>
										</div>
										
										<div class="col-md-2 p-0">
															<select class="form-control" id="exampleFormControlSelect1">
																<option>5월</option>
																<option>4월</option>
																<option>3월</option>
																<option>2월</option>
																<option>1월</option>
															</select>
														</div>
										<div class="card-tools">
											<a data-toggle="collapse" href="#calPay" class="collapsed" aria-expanded="false">
												<button class="btn btn-icon btn-link btn-primary btn-xs">
													<span class="fa fa-angle-down"></span>
												</button>
											</a>
											<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-times"></span></button>
										</div>
									</div>
								</div>
								<div class="card-body collapse" id="calPay">
									<div class="row">
										<div class="col-md-12">
											<div class="card">
											<div class="card-header">
												<div class="card-title text-primary">5월 총 소비 : 5,700,000원</div>
												<div class="card-title text-danger">5월 총 수입 : 6,000,000원</div>
											</div>
												<div class="card-body">
													<table class="table table-bordered table-head-bg-info table-bordered-bd-info mt-0" id="consumptionCalendar">
														<thead>
															<tr>
																<th colspan="7" style="text-align: center;">
																<span class="h1">5월</span>
																</th>
															</tr>
															<tr>
																<th scope="col" style="text-align: center;">일</th>
																<th scope="col" style="text-align: center;">월</th>
																<th scope="col" style="text-align: center;">화</th>
																<th scope="col" style="text-align: center;">수</th>
																<th scope="col" style="text-align: center;">목</th>
																<th scope="col" style="text-align: center;">금</th>
																<th scope="col" style="text-align: center;">토</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
																<td>1<p class="text-primary">60,000</p></td>
																<td>2</td>
															</tr>
															<tr>
																<td>3</td>
																<td>4<p class="text-primary">90,000</p></td>
																<td>5</td>
																<td>6</td>
																<td>7</td>
																<td>8</td>
																<td>9<p class="text-primary">20,000</p></td>
															</tr>
															<tr>
																<td>10<p class="text-danger">6,000,000</p></td>
																<td>11<p class="text-primary">30,000</p></td>
																<td>12<p class="text-primary">20,000</p></td>
																<td>13<p class="text-primary">10,000</p></td>
																<td>14<p class="text-primary">50,000</p></td>
																<td>15<p class="text-primary">60,000</p></td>
																<td>16<p class="text-primary">380,000</p></td>
															</tr>
															<tr>
																<td>17</td>
																<td>18</td>
																<td>19</td>
																<td>20</td>
																<td>21</td>
																<td>22</td>
																<td>23</td>
															</tr>
															<tr>
																<td>24</td>
																<td>25</td>
																<td>26</td>
																<td>27</td>
																<td>28</td>
																<td>29</td>
																<td>30</td>
															</tr>
															<tr>
																<td>31</td>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 소비달력 끝 -->
					<!-- 카테고리별 소비 시작 -->
					<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<div class="col-md-2 p-0">
											<h4 class="card-title">카테고리별 소비</h4>
										</div>
										
										<div class="col-md-2 p-0">
															<select class="form-control" id="exampleFormControlSelect1">
																<option>5월</option>
																<option>4월</option>
																<option>3월</option>
																<option>2월</option>
																<option>1월</option>
															</select>
														</div>
										<div class="card-tools">
											<a data-toggle="collapse" href="#catePay" class="collapsed" aria-expanded="false">
												<button class="btn btn-icon btn-link btn-primary btn-xs">
													<span class="fa fa-angle-down"></span>
												</button>
											</a>
											<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-times"></span></button>
										</div>
									</div>
								</div>
								<div class="card-body collapse" id="catePay">
									<div class="row">
										<div class="col-md-10">
											<div class="card">
											<div class="card-header">
												<div class="card-title">5월 총 지출 : 2,500,000,000원</div>
											</div>
												<div class="card-body">
													<div class="chart-container">
														<canvas id="doughnutChart" style="width: 50%; height: 50%"></canvas>
													</div>
													<div class="row">
														<div class="col-4">
															<table class="table table-hover">
																<thead>
																	
																</thead>
																<tbody>
																	<tr>
																		<th><span class="h3 text-danger">식비</span></th>
																		<td><span class="h3 text-danger">50,000</span></td>
																	</tr>
																	<tr>
																		<th><span class="h3 text-warning">쇼핑</span></th>
																		<td><span class="h3 text-warning">300,000</span></td>
																	</tr>
																	<tr>
																		<th><span class="h3 text-primary">교통비</span></th>
																		<td><span class="h3 text-primary">90,000</span></td>
																	</tr>
																</tbody>
															</table>
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
					<!-- 카테고리별 소비 끝 -->
					<!-- 페이지 레이아웃 끝 -->
				</div>
			</div>


		
			<script>
			$(function() {
				$("#checkBalance").click(function() {
					location = "checkBalance";
				});
				
				var barChart = document.getElementById('barChart').getContext('2d'),
				doughnutChart = document.getElementById('doughnutChart').getContext('2d');

				var myBarChart = new Chart(barChart, {
					type: 'bar',
					data: {
						labels: ["4월 1주", "4월 2주", "4월 3주", "4월 4주", "5월 1주", "5월 2주", "5월 3주", "5월 4주"],
						datasets : [{
							label: "억",
							backgroundColor: 'rgb(23, 125, 255)',
							borderColor: 'rgb(23, 125, 255)',
							data: [10.5, 20.3, 5, 16, 15, 30, 24, 15],
						}],
					},
					options: {
						responsive: true, 
						maintainAspectRatio: false,
						scales: {
							yAxes: [{
								ticks: {
									beginAtZero:true
								}
							}]
						},
					}
				});

				var myDoughnutChart = new Chart(doughnutChart, {
					type: 'doughnut',
					data: {
						datasets: [{
							data: [50000, 300000, 90000],
							backgroundColor: ['#f3545d','#fdaf4b','#1d7af3']
						}],

						labels: [
						'식비',
						'쇼핑',
						'교통비'
						]
					},
					options: {
						responsive: true, 
						maintainAspectRatio: false,
						legend : {
							position: 'bottom'
						},
						layout: {
							padding: {
								left: 20,
								right: 20,
								top: 20,
								bottom: 20
							}
						}
					}
				});
			})
			
	</script>
