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
					 <a href="new" class="btn btn-white btn-sm btn-border mr-1">신규</a> 
					 </h5>
				</div>
				<div class="ml-md-auto py-2 py-md-0">
					<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
					<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 하단 컨텐츠 시작 -->
	
	<div class="page-inner mt--5 col-10  ml-auto mr-auto">
		<div class="row row-card-no-pd">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<div class="card-head-row card-tools-still-right">
							<h4 class="card-title">${ins.ins_name}</h4>
							<div class="card-tools">
								<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-angle-down"></span></button>
								<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
							</div>
						</div>
						<p class="card-catrgory">적금 상품 / 가입</p>
					</div>
					<!-- 카드 바디 시작 -->
					<div class="card-body">
					
						<!-- 상단 기간 금액 최고 카드 시작 -->
						<div class="row">
							<div class="col-md-11 ml-auto mr-auto">
								<div class="row row-card-no-pd">
									<!-- 기간 파란 카드 시작 -->
									<div class="col-4">
										<div class="card card-stats card-round">
											<div class="card-body">
												<div class="row">
													<div class="col-5">
														<div class="icon-big text-center">
															<i class="fas fa-calendar-alt  text-primary"></i>
														</div>
													</div>
													<div class="col-7 col-stats">
														<div class="numbers">
															<p class="card-category">기간</p>
															<c:choose>
																<c:when test="${ins.qua_code != 0}">
																	<h4 class="card-title">${ins.qualificationVO.qua_minperiod }~${ins.qualificationVO.qua_maxperiod }개월<br/></h4>
																</c:when>
																<c:when test="${ins.qua_code == 0}">
																	<h4 class="card-title">제한없음</h4>
																</c:when>
															</c:choose>
															
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- 기간 파란 카드 끝 -->
									
									<!-- 금액 하늘색 카드 시작 -->
									<div class="col-4">
										<div class="card card-stats card-round">
											<div class="card-body">
												<div class="row">
													<div class="col-5">
														<div class="icon-big text-center text-warning">
															<i class="fas fa-donate"></i>
														</div>
													</div>
													<div class="col-7 col-stats">
														<div class="numbers">
															<p class="card-category">금액</p>
															<h4 class="card-title">${ins.qualificationVO.qua_minmoney }원 이상<br/></h4>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- 금액 하늘색 카드 끝 -->
									
									<!-- 최고 초록색 카드 시작 -->
									<div class="col-4">
										<div class="card card-stats card-round">
											<div class="card-body ">
												<div class="row">
													<div class="col-5">
														<div class="icon-big text-center">
															<i class="fas fa-external-link-square-alt text-success"></i>
														</div>
													</div>
													<div class="col-7 col-stats">
														<div class="numbers">
															<p class="card-category">최고</p>
															<h4 class="card-title">연 ${ins.ins_interestrate }% <span class="h6">(${ins.qualificationVO.qua_maxperiod}개월)</span></h4>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- 최고 초록색 카드 끝 -->										
								</div>
							</div>
						</div>	
						<!-- 상단 기간 금액 최고 카드 끝 -->
						<div class="card-body">
							<div class="row">
								<div class="col-md-4 ml-auto">
									<div class="row">
										<div class="col-md-4 ml-auto">
										<!-- 취소 버튼 -->
											<button class="btn btn-danger" onclick="location='new'">취소</button>
										</div>
										<div class="col-3">
											<form method="post" action="ins_new">
												<input type="hidden" id="ins_code" name="ins_code" value="${ins.ins_code }">
												<input type="hidden" id="deptype" name="deptype" value="300">
												<!-- 신청 버튼 -->
													<c:if test="${ins.ins_online != 0}">
														<input type="submit" class="btn btn-primary" value="신청">
													</c:if>
											</form>
										</div>
									</div>
									
								</div>
							</div>
						</div>
					</div>
					<!-- 카드 바디 끝 -->
				</div>
			</div>
		</div>
	</div>
	<!-- 하단 컨텐츠 끝 -->
</div>
<script>
</script>

