<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


		<div class="content">
			<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">고객센터</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="search" class="btn btn-white btn-sm btn-border mr-1">자주 찾는 실문</a>
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
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<div class="card-head-row">
									<div class="card-title col-3">자주 찾는 질문</div>

									<div class="container-fluid">
										<div class="collapse" id="search-nav">
											<form class="navbar-left navbar-form nav-search mr-md-3">
												<div class="input-group">
													<div class="input-group-prepend">
														<button type="submit" class="btn btn-search pr-1">
															<i class="fa fa-search search-icon"></i>
														</button>
													</div>
													<input type="text" placeholder="Search ..."
														class="form-control">

													<button type="button" class="btn btn-focus btn-xs"
														id="alert_demo2" style="background: orange;">검색</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="card-body">
								<button type="button" class="btn btn-focus btn-xs"
									id="alert_demo2" style="width: 130px;">전체</button>

								<button type="button" class="btn btn-focus btn-xs"
									id="alert_demo2" style="width: 130px;">예금</button>
								<button type="button" class="btn btn-focus btn-xs"
									id="alert_demo2" style="width: 130px;">대출</button>
								<button type="button" class="btn btn-focus btn-xs"
									id="alert_demo2" style="width: 130px;">회원정보</button>
								<button type="button" class="btn btn-focus btn-xs"
									id="alert_demo2" style="width: 130px;">기타</button>
							</div>
							<div class="card-body">
								<a data-toggle="collapse" href="#action_mw1" style="color:  black; font-size: 30px;"> 
									<span style="display: block;">1. 입금은 어떻게 하나요?</span>
								</a>
								<div class="collapse" id="action_mw1">
									<blockquote style="margin-left: 50px; background: gray; color: white;"> 내용들거갈곳 내용들거갈곳내용들거갈곳내용들거갈곳내용들거갈곳내용들거갈곳내용들거갈곳내용들거갈곳내용들거갈곳</blockquote>
								</div>
							</div>
							
							<div class="card-body">
								<a data-toggle="collapse" href="#action_mw2" style="color:  black; font-size: 30px;"> 
									<span style="display: block; ">2. 출금은 어떻게 하나요?</span>
								</a>
								<div class="collapse" id="action_mw2">
									<blockquote style="margin-left: 50px; background: gray; color: white;" >내용들어갈곳</blockquote>
								</div>
							</div>
							<div class="card-body">
								<a data-toggle="collapse" href="#action_mw3" style="color:  black; font-size: 30px;"> 
									<span style="display: block;">3. 조회는 어떻게 하나요?</span>
								</a>
								<div class="collapse" id="action_mw3">
									<blockquote style="margin-left: 50px; background: gray; color: white;">내용들어갈곳</blockquote>
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
