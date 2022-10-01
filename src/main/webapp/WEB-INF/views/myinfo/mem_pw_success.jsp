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
									<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home" /></a> 
										<span class="h2 mr-1"> > </span> 
										<a href="mem_pw_reset_input" class="btn btn-white btn-sm btn-border mr-1">이메일 인증</a> 
										<span class="h2 mr-1"> > </span> 
										<a href="mem_pw_reset" class="btn btn-white btn-sm btn-border mr-1">암호 재설정</a>
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
										<h4 class="card-title">암호 재설정</h4>
									</div>
									<p class="card-category">재설정 완료</p>
								</div>
								
								<div class="card-body">
									<div class="row">
										<div class="col-md-6 ml-auto mr-auto" style="text-align: center;">
											<table>
												<thead>
													<tr>
														<th>
															<span class="h1">축하드립니다.</span><br>
															<span class="h2">암호 재설정이 완료되었습니다.</span>
														</th>
													</tr>
												</thead>
												<tfoot>
												<tr>
													<th>
														<div class="row">
															<div class="col-md-12 ml-auto mr-auto" style="text-align: center;">
																<button class="btn btn-success" id="success">확인</button>
															</div>
														</div>
													</th>
												</tr>
											</tfoot>
											</table>
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
			location = "index";
		});
	</script>

