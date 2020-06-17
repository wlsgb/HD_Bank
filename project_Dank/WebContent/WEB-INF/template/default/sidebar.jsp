<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar -->
		<div class="sidebar sidebar-style-2">			
			<div class="sidebar-wrapper scrollbar scrollbar-inner">
				<div class="sidebar-content">
					<c:choose>
						<c:when test="${member.mem_email==null }">
							<!-- 로그인 창 시작 -->
							<form method="post" action="login" >
								<div class="form-group">
									<input type="submit" class="btn btn-primary btn-block" value="로그인" />
								</div>
							</form>
							<!-- 로그인 창 끝 -->
						</c:when>
						<c:otherwise>
							<!-- 로그인 정보 시작 -->
							<div class="user">
								<div class="info">
									<a data-toggle="collapse" href="#collapseExample" aria-expanded="true">
										<span>
											
											<span class="user-level">${member.mem_name }님</span>
											<span class="caret"></span>
										</span>
									</a>
									<div class="clearfix"></div>
		
									<div class="collapse in" id="collapseExample">
										<ul class="nav">
											<li>
												<a href="pri_info_chk">
													<span class="link-collapse">마이페이지</span>
												</a>
											</li>
											<li>
												<a href="logout">
													<span class="link-collapse">로그아웃</span>
												</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<!-- 로그인 정보 끝 -->
						</c:otherwise>
					</c:choose>
					
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
										<a href="cancel">
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
										<a href="1on1question_princhk">
											<span class="sub-item">1:1 문의하기</span>
										</a>
									</li>

									<!-- <li>
										<a href="forms/forms.jsp">
											<span class="sub-item">나의 문의글</span>
										</a>
									</li> -->
									<!-- <li>
										<a href="forms/forms.jsp">
											<span class="sub-item">가까운 ATM 조회</span>
										</a>
									</li> -->
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a data-toggle="collapse" href="#tables">
								<i class="fas fa-layer-group"></i>
								<p>개인 정보 관리</p>
								<span class="caret"></span>
							</a>
							<div class="collapse" id="tables">
								<ul class="nav nav-collapse">
									<li>
										<a href="pri_info_chk">
											<span class="sub-item">개인 정보 조회 / 수정</span>
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