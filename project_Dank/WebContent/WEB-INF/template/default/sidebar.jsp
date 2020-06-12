<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Sidebar -->
		<div class="sidebar sidebar-style-2">			
			<div class="sidebar-wrapper scrollbar scrollbar-inner">
				<div class="sidebar-content">
					<!-- 로그인 창 시작 -->
					<div class="form-group">
						<label for="email2">이메일</label>
						<input type="email" class="form-control" id="email2" placeholder="Enter Email">
					</div>
					<div class="form-group">
						<label for="password">패스워드</label>
						<input type="password" class="form-control" id="password" placeholder="Password">
					</div>
					<div class="form-group">
						<a href="loginPage" class="btn btn-primary btn-block">
							<span class="btn-label mr-2"></span>로그인
						</a>
					</div>
					<div class="form-group">
						<a href="#" class="btn btn-primary btn-block">
							<span class="btn-label mr-2"></span>회원가입
						</a>
					</div>
					
					<!-- 로그인 창 끝 -->
					<!-- 로그인 한 후 시작 -->
					<div class="user">
						<div class="avatar-sm float-left mr-2">
							<img src="resources/img/profile.jpg" alt="..." class="avatar-img rounded-circle">
						</div>
						<div class="info">
							<a data-toggle="collapse" href="#collapseExample" aria-expanded="true">
								<span>
									
									<span class="user-level">홍길동</span>
									<span class="caret"></span>
								</span>
							</a>
							<div class="clearfix"></div>

							<div class="collapse in" id="collapseExample">
								<ul class="nav">
									<li>
										<a href="#profile">
											<span class="link-collapse">마이페이지</span>
										</a>
									</li>
									<li>
										<a href="#edit">
											<span class="link-collapse">로그아웃</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- 로그인 후 끝 -->
					<ul class="nav nav-primary">
						
						<li class="nav-item">
							<a data-toggle="collapse" href="#deposit">
								<i class="fas fa-layer-group"></i>
								<p>예금</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="deposit">
								<ul class="nav nav-collapse">
									<li>
										<a href="inquire">
											<span class="sub-item">조회</span>
										</a>
									</li>
									<li>
										<a href="transfer">
											<span class="sub-item">이체</span>
										</a>
									</li>
									<li>
										<a href="new">
											<span class="sub-item">신규</span>
										</a>
									</li>
									<li>
										<a href="deposite_cancle">
											<span class="sub-item">해지</span>
										</a>
									</li>
									<li>
										<a href="analysis">
											<span class="sub-item">분석</span>
										</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a data-toggle="collapse" href="#sidebarLayouts">
							<i class="fas fa-layer-group"></i>
							<p>대출</p>
							<span class="caret"></span>
							</a>
							<div class="collapse" id="sidebarLayouts">
								<ul class="nav nav-collapse">
									<li>
										<a href="product">
											<span class="sub-item">상품소개</span>
										</a>
									</li>
									<li>
										<a href="application">
											<span class="sub-item">대출 신청</span>
										</a>
									</li>
									<li>
										<a href="fileuploadhome">
											<span class="sub-item">서류 제출</span>
										</a>
									</li>
									<li>
										<a href="check">
											<span class="sub-item">대출 현황 조회</span>
										</a>
									</li>
									<li>
										<a href="repayment">
											<span class="sub-item">대출 상환</span>
										</a>
									</li>
									<li>
										<a href="caculator">
											<span class="sub-item">이자 계산기</span>
										</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a data-toggle="collapse" href="#forms">
								<i class="fas fa-layer-group"></i>
								<p>고객센터</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="forms">
								<ul class="nav nav-collapse">
									<li>
										<a href="qna">
											<span class="sub-item">자주 찾는 질문</span>
										</a>
									</li>
									<li>
										<a href="1on1question_prichk">
											<span class="sub-item">1:1 문의하기</span>
										</a>
									</li>
									<li>
										<a href="forms/forms.jsp">
											<span class="sub-item">나의 문의글</span>
										</a>
									</li>
									<li>
										<a href="forms/forms.jsp">
											<span class="sub-item">가까운 ATM 조회</span>
										</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a data-toggle="collapse" href="#tables">
								<i class="fas fa-layer-group"></i>
								<p>고객 정보 관리</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="tables">
								<ul class="nav nav-collapse">
									<li>
										<a href="pri_info_chk">
											<span class="sub-item">고객 정보 조회 / 수정</span>
										</a>
									</li>
									<li>
										<a href="tap">
											<span class="sub-item">ID 조회</span>
										</a>
									</li>
									<li>
										<a href="mem_pw_reset_input">
											<span class="sub-item">사용자 암호 재설정</span>
										</a>
									</li>
									<li>
										<a href="security">
											<span class="sub-item">보안카드 / OTP</span>
										</a>
									</li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- End Sidebar -->