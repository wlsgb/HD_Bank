<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- article 영역 시작 -->

	<div class="content">
		<!-- 상단의 푸른색 공간 시작 -->
		<div class="panel-header bg-primary-gradient">
			<div class="page-inner py-5">
				<div
					class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
					<div>
						<h2 class="text-white pb-2 fw-bold">계정</h2>
						<h5 class="text-white op-7 mb-2">
							<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span
								class="flaticon-home"></span></a> <span class="h2 mr-1"> > </span>
							<a href="momo3" class="btn btn-white btn-sm btn-border mr-1">로그인</a>

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
			<div class="row col-md-6 ml-auto mr-auto">
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-md-12">
									<div class="table-responsive table-hover table-sales">
										<div style="margin: auto;">
											<!-- 로그인 기능 시작 -->
											<form method="post" action="login" >
												<div class="form-group">
													<label for="email2">이메일</label>
													<input type="email" class="form-control" id="mem_email" name="mem_email" placeholder="Enter Email" >
												</div>
												<div class="form-group">
													<label for="password">패스워드</label>
													<input type="password" class="form-control" id="mem_pwd" name="mem_pwd" placeholder="Password" >
												</div>
												<div class="form-group">
													<input type="submit" class="btn btn-primary btn-block" value="로그인" />
												</div>
											</form>
											<!-- 로그인 기능 끝 -->
											<div id="abutton" style="text-align: center; margin-top: 20px;">
												<a href="memberForm"><button class="btn btn-primary btn-xs"
														id="ab1">회원가입</button></a>&nbsp;&nbsp;&nbsp;&nbsp; <a
													href="tap"><button class="btn btn-primary btn-xs"
														id="ab2">아이디/비밀번호찾기</button></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="card-body"></div>
					</div>
				</div>
			</div>

			<!-- 페이지 레이아웃 끝 -->
		</div>
	</div>





	<script>
		
	</script>