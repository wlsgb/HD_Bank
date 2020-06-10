<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<div class="page-inner mt--5">

					<div style="color: red;">
					<span>계좌세션심기</span>
						<form action="getsession" method="post">
						<input type="text" placeholder="멤버코드입력" name="mem_code">
						<input type="submit" value="ㄱㄱ">
						</form>
<!-- 						<br/> -->
<!-- 						<br/> -->
<!-- 						<input type="text" placeholder="입금액" id="dep_money"> -->
<!-- 						<input type="text" placeholder="출금액" id="wit_money"> -->
					
					</div>
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


								
								</div>
								<div class="card-body">
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
													<c:forEach var="e" items="${aclist}" varStatus="i">
													
													<c:if test="${e.saving.sav_name != '0'}">
													
														<tr>
																<td>${e.saving.sav_name }</td>
																<td id="savac${i.index}">${e.ac_num }</td>
																<td class="text-right">
																	${e.ac_balance }
																</td>
																
																<td class="text-right">
																	<a href="inquire_detail"><input type="button" value="조회"  /></a>
																	<a href="transfer"><input type="button" value="이체" /></a>
																	<a href="deposit?ac_num=${e.ac_num }"><input type="button" value="입금" id="depbtn${i.index}"  /></a>
																	<a href="#"><input type="button" value="출금" /></a>
																</td>
														</tr>
													</c:if>
													</c:forEach>

													
													
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


								
								</div>
								<div class="card-body">
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
													<c:forEach var="e" items="${aclist}" varStatus="i">
													<c:if test="${e.ins.ins_name != '0'}">
													<tr>
															<td>${e.ins.ins_name }</td>
															<td>${e.ac_num }</td>
															<td class="text-right">
																${e.ac_balance }
															</td>
															
															<td class="text-right">
																<a href="inquire_detail"><input type="button" value="조회"  /></a>
																<a href="transfer"><input type="button" value="이체" /></a>
																<a href="#"><input type="button" value="입금" /></a>
																<a href="#"><input type="button" value="출금" /></a>
															</td>
														</tr>
														</c:if>
													</c:forEach>
													
													
													</tbody>
								</table>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>


		
			
			
			<script>
// 			$('#savdeposit').click(function() {
// 				console.log($('#savacnumid').val())
//  				location="deposit"
// 			})
// 			$(document).ready(function() {
// 				console.log("sss")
// 				var getId =$(this).attr("id");
// 				console.log(getId)
// 			})
			
			
			
			
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

