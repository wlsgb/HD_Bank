<<<<<<< HEAD
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
							<div class="card-title">공유계좌 신청</div>
						</div>
					</div>
					<div class="card-body">
						<div class="chart-container" style="min-height: 425px">
							<div class="row">
								<div class="col-md-4 ml-auto">
									<span class="h3">${sessionScope.member.mem_name} 고객님</span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-10">
									<form action="" method="post" id="go">
									<input type="hidden" name="shas_code" value="${shas_code}">
									<input type="hidden" name="deptype" value="${deptype}">
									<input type="hidden" name="sav_code" value="${sav_code}">
										<table class="table mt-1">
											<thead>

											</thead>
											<tbody>
												<tr>
													<th scope="col">상대방 이름</th>
													<td>
														<div class="row">
															<div class="col-md-5">
																<input type="text" class="form-control input-full" id="your_name" name="your_name"
																	placeholder="Enter Input">
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">상대방 전화번호</th>
													<td>
														<div class="row">
															<div class="phone col-3">
																<input type="text" class="form-control" id=""
																	value="010">
															</div>
															<div class="phone col-3">
																<input type="text" class="form-control" id="">
															</div>
															<div class="phone col-3">
																<input type="text" class="form-control" id="">
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">상대방 이메일</th>
													<td>
														<div class="row">
															<div class="col-8">
																<input type="email" name="your_email"
																	class="form-control" id="your_email"
																	placeholder="Enter Email">
															</div>
															<div class="col-4">
																<button type="button" class="btn btn-primary"
																	id="emailBtn">인증하기</button>
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<td colspan="2">
														<div class="row">
															<div class="col-md-6 ml-auto mr-auto">
																<button class="btn btn-primary" type="button"
																	id="submit">확인</button>
																<button type="button" class="btn btn-danger"
																	onclick="location='new'">취소</button>
															</div>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
									</form>
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

	</div>
</div>




<script>
	$(document).ready(
			function() {
				var num = 0;
				$("#submit").click(function() {
					if (num === 1) {
						document.getElementById("go").action="share_new_res";
						var phone = "";
						$('.phone input').val().each(function(i, element) {
							phone += element;
						});
						$('#go').html("<input type='hidden' name='phone' value='"+phone+"'>");
						$(this).attr("type", "submit");
						$(this).submit();
					} else {
						alert("등록된 이메일이 아닙니다.");
					}
				});

				$('#emailBtn').click(
						function(e) {
							email = $("#your_email").val();
							console.log(email);
							$.ajax({
								url : "checkEmail?email=" + email,
								success : function(data) {
									num = data;
									if (data === 1) {
										$('#emailBtn').removeClass().addClass(
												"btn btn-success");
										$('#emailBtn').html("성공");
										function idchk(num) {

											$("idchk1").attr("action",
													"share_new_res");
											$("idchk1").submit();

											alert("존재하지 않는 아이디입니다.");

										}
									} else {
										$('#emailBtn').removeClass().addClass(
												"btn btn-danger");
										$('#emailBtn').html("실패");
									}
								}
							});

						});
			});
</script>


=======
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
							<div class="card-title">공유계좌 신청</div>
						</div>
					</div>
					<div class="card-body">
						<div class="chart-container" style="min-height: 425px">
							<div class="row">
								<div class="col-md-4 ml-auto">
									<span class="h3">${sessionScope.member.mem_name} 고객님</span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-10">
									<form action="" method="post" id="go">
									<input type="hidden" name="shas_code" value="${shas_code}">
									<input type="hidden" name="deptype" value="${deptype}">
									<input type="hidden" name="sav_code" value="${sav_code}">
										<table class="table mt-1">
											<thead>

											</thead>
											<tbody>
												<tr>
													<th scope="col">상대방 이름</th>
													<td>
														<div class="row">
															<div class="col-md-5">
																<input type="text" class="form-control input-full" id="your_name" name="your_name"
																	placeholder="Enter Input">
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">상대방 전화번호</th>
													<td>
														<div class="row">
															<div class="phone col-3">
																<input type="text" class="form-control" id=""
																	value="010">
															</div>
															<div class="phone col-3">
																<input type="text" class="form-control" id="">
															</div>
															<div class="phone col-3">
																<input type="text" class="form-control" id="">
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">상대방 이메일</th>
													<td>
														<div class="row">
															<div class="col-8">
																<input type="email" name="your_email"
																	class="form-control" id="your_email"
																	placeholder="Enter Email">
															</div>
															<div class="col-4">
																<button type="button" class="btn btn-primary"
																	id="emailBtn">인증하기</button>
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<td colspan="2">
														<div class="row">
															<div class="col-md-6 ml-auto mr-auto">
																<button class="btn btn-primary" type="button"
																	id="submit">확인</button>
																<button type="button" class="btn btn-danger"
																	onclick="location='new'">취소</button>
															</div>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
									</form>
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

	</div>
</div>




<script>
	$(document).ready(
			function() {
				var num = 0;
				$("#submit").click(function() {
					if (num === 1) {
						document.getElementById("go").action="share_new_res";
						var phone = "";
						$('.phone input').val().each(function(i, element) {
							phone += element;
						});
						$('#go').html("<input type='hidden' name='phone' value='"+phone+"'>");
						$(this).attr("type", "submit");
						$(this).submit();
					} else {
						alert("등록된 이메일이 아닙니다.");
					}
				});

				$('#emailBtn').click(
						function(e) {
							email = $("#your_email").val();
							console.log(email);
							$.ajax({
								url : "checkEmail?email=" + email,
								success : function(data) {
									num = data;
									if (data === 1) {
										$('#emailBtn').removeClass().addClass(
												"btn btn-success");
										$('#emailBtn').html("성공");
										function idchk(num) {

											$("idchk1").attr("action",
													"share_new_res");
											$("idchk1").submit();

											alert("존재하지 않는 아이디입니다.");

										}
									} else {
										$('#emailBtn').removeClass().addClass(
												"btn btn-danger");
										$('#emailBtn').html("실패");
									}
								}
							});

						});
			});
</script>


>>>>>>> refs/remotes/origin/backupmaster
