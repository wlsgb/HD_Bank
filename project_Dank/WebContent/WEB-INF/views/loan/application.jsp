<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


			<div class="content">
			<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">대출</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="application" class="btn btn-white btn-sm btn-border mr-1">대출신청</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="#" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<!--대출 목록   -->
				<form action="" class="form-horizontal">
				<div class="radio">
				<div class="row mt--4">
				<div class="col-3"></div>
				<div class="row row-card-no-pd col-6">
						
						<c:forEach items="${list }" var="e" >
						<div class="col-sm-10 col-md-10">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
											<div class="col-1"></div>
											<div class="col-3">
												<div class="icon-big text-center">
													<i class="flaticon-coins text-success"></i>
												</div>
											</div>
											<div class="col-5 col-stats">
												<div class="numbers">
													<p class="card-category">무담보 대출</p>
													<h4 class="card-title">${e.lp_name }1</h4>
												</div>
											</div>
										</div>
									</div>
											
								</div>
							</div>
		
			
			<div class="col-sm-2 col-md-2 row">
			<h6 style="color: white;">투명1</h6>
			<div class="col-8"></div>						
			<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
			
			</div>
			</c:forEach>
			
			
			
							<div class="col-sm-10 col-md-10">
								<div class="card card-stats card-round">
									<div class="card-body ">
										<div class="row">
										<div class="col-1"></div>
											<div class="col-3">
												<div class="icon-big text-left">
													<i class="flaticon-coins text-success"></i>
												</div>
											</div>
											<div class="col-5 col-stats">
												<div class="numbers">
													<p class="card-category">무담보 대출</p>
													<h4 class="card-title">교육생 대출</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							
							<div class="col-sm-2 col-md-2 row">
			<h6 style="color: white;"> 투명</h6>
			<div class="col-8"></div>	
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
			</div>
			
			
							<div class="col-sm-10 col-md-10">
								<div class="card card-stats card-round">
							
									<div class="card-body">
										<div class="row">
										<div class="col-1"></div>
											<div class="col-3">
												<div class="icon-big text-center">
													<i class="flaticon-coins text-success"></i>
												</div>
											</div>
											<div class="col-5 col-stats">
												<div class="numbers">
													<p class="card-category">무담보 대출</p>
													<h4 class="card-title">신용 대출</h4>
												</div>
											</div>
										</div>
									</div>
								
								</div>
							</div>
							
							<div class="col-sm-2 col-md-2 row">
			<h6 style="color: white;"> 투명</h6>
			<div class="col-8"></div>	
							<input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">
			</div>
			
							<div class="col-sm-10 col-md-10">
								<div class="card card-stats card-round">
						
									<div class="card-body">
										<div class="row">
										<div class="col-1"></div>
											<div class="col-3">
												<div class="icon-big text-center">
													<i class="flaticon-coins text-success"></i>
												</div>
											</div>
											<div class="col-5 col-stats">
												<div class="numbers">
													<p class="card-category">무담보 대출</p>
													<h4 class="card-title">억만장자 대출</h4>
												</div>
											</div>
										</div>
									</div>
								
								</div>
								</div>
							<div class="col-sm-2 col-md-2 row">
			<h6 style="color: white;"> 투명</h6>
			<div class="col-8"></div>			
							<input type="radio" name="optionsRadios" id="optionsRadios4" value="option4">
							</div>
						</div>
						</div>
				</div>	
				</form>
			<p class="text-center"><button type="button" class="btn btn-info" onclick="location='applicationform'">대출 신청</button></p>
		
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

