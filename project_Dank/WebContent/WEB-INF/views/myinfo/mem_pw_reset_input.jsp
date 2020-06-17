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
								<a href="mem_pw_reset_input" class="btn btn-white btn-sm btn-border mr-1">이메일 인증</a> 
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
								<p class="card-category">이메일 인증</p>
							</div>
							<div class="card-body">
								<%-- <c:if test="${error=='f' }">
									<div class="row">
										<div class="col-md-12">
											<div class="card">
												<div class="card-header">
													<div>
														<span class="h1 text-danger">입력한 정보가 틀렸습니다.</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:if> --%> 
								<div class="row">
									<div class="col-md-6 ml-auto mr-auto">
									<!-- 테이블 시작 -->
									<form action="mem_pw_reset" method="post">
										<table class="table mt-3">
											<tbody>
											
												<tr>
													<th scope="col">이메일</th>
													<td>
														<div class="row">
															<div class="col-8">
																<input type="email" id="mem_email" name="mem_email" readonly="readonly"
																class="form-control input-full" value="${memberVO.mem_email }">
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
																<input type="text" id="codenum" name="codenum" required="required"
																class="form-control input-full">                                      
															</div>
															<div class="col-4 mt-1" id="codeTarget">
																<button type="button" class="btn btn-primary" id="codeCheck">확인</button>
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">비밀번호</th>
													<td>
														<div class="row">
															<div class="col-6">
																<input type="password" id="pwd" name="pwd"
																class="form-control input-full" placeholder="(비밀번호)">
																
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
										<!-- 테이블 끝 -->
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
				$("#cancel").click(function() {
					location = "index";
				});
				
				$("#codeCheck").click(function() {
					console.log("emailCode : "+emailCode);
					console.log("codenum : "+$("#codenum").val());
					if ($("#codenum").val() == emailCode) {
						$("#codenum").attr("readonly", true);
						$("#codeTarget").html('<button class="btn btn-success btn-sm" disabled="disabled">Success</button>');
						$("#codeTarget").append('<input type="hidden" value="success" name="successData" />')
					}else {
						$("#codeTarget").append('<input type="hidden" value="fail" name="successData" />')
					}
					
				})
				
				$('#emailBtn').click(function(e) {
					var email = $("#mem_email").val();
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
