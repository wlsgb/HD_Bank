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
								 <a href="securitycard" class="btn btn-white btn-sm btn-border mr-1">보안카드</a>
								 <span class="h2 mr-1"> > </span>
								 <a href="securitycard" class="btn btn-white btn-sm btn-border mr-1">신청</a>
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
								<input type="text"  placeholder="세션 회원 번호" id="mem_num" name="mem_num"/>
								<input type="button" class="btn" id="sessionBtn" />
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">보안카드</h4>
									</div>
									<p class="card-category">
									신청</p>
								</div>
								
								<div class="card-body">
									<div class="row">
										<div class="col-8">
										
										
										
										<!-- 보안카드 신청 form 시작 -->
											<form action="securitycardinfoView" method="post">
											<input type="hidden" value="${mem_num}" />
												<table class="table mt-1">
												<tbody>
													<tr>
														<th scope="col">
															본인 계좌 번호
														</th>
														<td>
															<div class="row">
																<div class="col-8">
																	<select class="form-control" id="accSel" name="ac_num">
																		<option>주거래 통장 - 110-12356</option>
																		<option>슈퍼거래통장 - 120-12556</option>
																	</select>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<th scope="col">계좌 비밀번호</th>
														<td>
															<div class="row">
																<div class="col-4">
																	<input type="password" id="accPwd" name="ac_pwd" required="required"
																	class="form-control input-full" placeholder="(4자리)" maxlength="4">
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<th scope="col">이메일</th>
														<td>
															<div class="row">
																<div class="col-4">
																	<input type="text" id="emailId" name="emailId" required="required"
																	class="form-control input-full" placeholder="Email">
																</div>
																<div class="col-4">
																	<select class="form-control" id="emailBack" name="emailBack">
																		<option>@naver.com</option>
																		<option>@gmail.com</option>
																	</select>
																</div>
																<div class="col-4">
																	<button type="button" class="btn btn-primary" id="emailBtn">인증코드 전송</button>
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<th scope="col">인증번호</th>
														<td>
															<div class="row">
																<div class="col-8">
																	<input type="text" id="codenum" name="codenum"
																	class="form-control input-full">                                      
																</div>
																<div class="col-4 mt-1" id="codeTarget">
																	<button type="button" class="btn btn-primary" id="codeCheck">확인</button>
																	
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<th scope="col">주민등록번호</th>
														<td>
															<div class="row">
																<div class="col-6">
																	<input type="text" id="cnn" name="cnn" re
																	class="form-control input-full" placeholder="(앞 6자리)" maxlength="6">
																</div>
															</div>
														</td>
													</tr>
												</tbody>
												<tfoot>
													<tr>
														<th colspan="2">
															<div class="row">
																<div class="col-md-6 ml-auto mr-auto">
																	<button class="btn btn-danger" id="cancel">취소</button>
																	<input type="submit" class="btn btn-success" value="확인">
																</div>
															</div>
														</th>
													</tr>
												</tfoot>
											</table>
										</form>
										<!-- 보안카드 신청 form 끝 -->
										
										
										
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
		$(function() {
			var email = null;
			var emailCode = null;
			$("#cancel").click(function() {
				location = "security";
			});
			
			$("#sessionBtn").click(function() {
			})
			
			$("#codeCheck").click(function() {
				console.log("emailCode : "+emailCode);
				console.log("codenum : "+$("#codenum").val());
				if ($("#codenum").val() == emailCode) {
					$("#codeTarget").html('<button class="btn btn-success btn-sm" disabled="disabled">Success</button>');
					$("#codeTarget").append('<input type="hidden" value="success" name="successData" />')
				}
				
			})
			
			$('#emailBtn').click(function(e) {
				email = $("#emailId").val()+ $("#emailBack").val();
				swal({
					title: '이메일을 전송 하시겠습니까?',
					text: "이메일을 확인해주세요. \n"+email,
					type: 'warning',
					buttons:{
						confirm: {
							text : '전송',
							className : 'btn btn-success'
						},
						cancel: {
							text : '취소',
							visible: true,
							className: 'btn btn-danger'
						}
					}
				}).then((Delete) => {
					if (Delete) {
						$.ajax({
							url:"emailsend?email="+email,
							success:function(data){
								emailCode = data;
							}
						})
						swal({
							title: '전송되었습니다.',
							text: '전송된 코드를 입력해주세요.',
							type: 'success',
							buttons : {
								confirm: {
									text : '확인',
									className : 'btn btn-success'
								}
							},
							
						});
					} else {
						swal.close();
					}
				});
			});
		})
			
	</script>
