<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">고객정보관리</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="pri_info_chk" class="btn btn-white btn-sm btn-border mr-1">고객정보 조회</a>
								  <span class="h2 mr-1"> > </span>
								 <a href="pri_info_chk" class="btn btn-white btn-sm btn-border mr-1">고객정보 수정</a>
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
								</div>
								<div class="card-body">
									
									<!-- 기본 정보 테이블 시작 -->
										<form action="updatemyinfo" method="post">
											<table class="table mt-3">
												<tbody>
												<!-- 기본 정보 -->
													<tr>
														<th scope="col" colspan="2"><span class="h3">개인 정보</span></th>
													</tr>
													<tr>
														<td>이름</td>
														<td>
															<div class="row">
																<div class="col-12">
																	<input type="text" id="mem_name" name="mem_name" value="${memberVO.mem_name}" required="required" class="form-control input-full"/>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td>이메일</td>
														<td>
															<div class="row">
																<div class="col-12">
																	<input type="text" id="mem_email" name="mem_email" value="${memberVO.mem_email}" required="required" class="form-control input-full"/>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td>전화번호</td>
														<td>
															<div class="row">
																<div class="col-12">
																	<input type="text" id="mem_phn" name="mem_phn" value="${memberVO.mem_phn}" required="required" class="form-control input-full"/>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td>생년월일</td>
														<td>
															<div class="row">
																<div class="col-12">
																	<input type="text" id="mem_birth" name="mem_birth" value="${memberVO.mem_birth}" maxlength="6" required="required" class="form-control input-full"/>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td>주소</td>
														<td>
															<div class="row">
																<div class="col-12">
																	<input type="text" id="mem_loc" name="mem_loc" value="${memberVO.mem_loc}" required="required" class="form-control input-full"/>
																</div>
															</div>
														</td>
													</tr>
												<!-- 상세 정보 -->
												
													<tr>
														<th scope="col" colspan="2"><span class="h3">상세 정보</span></th>
													</tr>
													<tr>
														<td>가입날짜</td>
														<td>${memberVO.mem_in_date}</td>
													</tr>
													<tr>
														<td>개인정보동의</td>
														<td>
														<c:choose>
															<c:when test="${memberVO.mem_pri_chk==1 }">
																동의
															</c:when>
															<c:otherwise>
																비동의
															</c:otherwise>
														</c:choose>
														</td>
													</tr>
													<tr>
														<td>메일전송동의</td>
														<td>
														<c:choose>
															<c:when test="${memberVO.mem_email_chk==1 }">
																동의
															</c:when>
															<c:otherwise>
																비동의
															</c:otherwise>
														</c:choose>
														</td>
													</tr>
													<tr>
														<td>보안카드신청</td>
														<td>
														<c:choose>
															<c:when test="${scurityCardYN==1 }">
																있음
															</c:when>
															<c:otherwise>
																없음
															</c:otherwise>
														</c:choose>
														</td>
													</tr>
													<tr>
														<td>OTP신청</td>
														<td>
														<c:choose>
															<c:when test="${otpYN==1 }">
																있음
															</c:when>
															<c:otherwise>
																없음
															</c:otherwise>
														</c:choose>
														</td>
													</tr>
												</tbody>
												<tfoot>
													<tr>
														<th colspan="2">
															<div class="row">
																<div class="col-md-4 ml-auto">
																	<button type="button" class="btn btn-warning" id="update">비밀번호 수정하기</button>
																</div>
																<div class="col-md-8 ml-auto mr-auto">
																	<button class="btn btn-danger" id="cancel">취소</button>
																	<input type="submit" class="btn btn-success" value="확인">
																</div>
															</div>
														</th>
													</tr>
												</tfoot>
											</table>
											</form>
										<!-- 기본 정보 테이블 끝 -->
								</div>
							</div>
						</div>
					</div>
					<!-- 페이지 레이아웃 끝 -->
				</div>
			</div>
	<script>
	$(function() {
		$("#update").click(function() {
			location = "mem_pw_reset";
		})
		
	})
	</script>
