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
								 <a href="security" class="btn btn-white btn-sm btn-border mr-1">보안카드 / OTP</a>
								 <span class="h2 mr-1"> > </span>
								 <a href="securityotp" class="btn btn-white btn-sm btn-border mr-1">OTP</a>
								 <span class="h2 mr-1"> > </span>
								 <a href="securityotp" class="btn btn-white btn-sm btn-border mr-1">신청</a>
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
										<h4 class="card-title">OTP</h4>
									</div>
									<p class="card-category">
									신청</p>
								</div>
								
								<div class="card-body">
									<div class="row">
										<div class="col-11">
											<!-- 보안카드 신청 form 시작 -->
										<c:if test="${error=='f'}">
											<span class="h1 text-danger">다시입력 해주세요.</span>
										</c:if>
											<form action="otpInfoView" method="post">
												<table class="table mt-1">
												<tbody>
													<tr>
														<th scope="col">
															본인 계좌 번호
															
														</th>
														<td>
															<div class="row">
																<div class="col-8">
																	<select class="form-control" id="acNameNum" name="acNameNum">
																		<c:forEach var="e" items="${aclist}">
																		<c:choose>
																			<c:when test="${e.saving.sav_name=='0'}">
																				<option> ${e.ins.ins_name}-${e.ac_num }</option>
																			</c:when>
																			<c:otherwise>
																				<option> ${e.saving.sav_name}-${e.ac_num }</option>
																			</c:otherwise>
																		</c:choose>
																		</c:forEach>
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
												</tbody>
												<tfoot>
													<tr>
														<th colspan="2">
															<div class="row">
																<div class="col-md-6 ml-auto mr-auto">
																	<button class="btn btn-danger" id="cancel">취소</button>
																	<input type="hidden" value="security/securityOtpSuccess" id="pageName" name="pageName" />
																	<input type="submit" class="btn btn-success" value="다음">
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
					email = $("#mem_email").val();
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
				
			/* 문자 전송이 가능함 */
			const { config, Group } = require('coolsms-node-sdk')

			// 인증을 위해 발급받은 본인의 API Key를 사용합니다.
			const apiKey = 'NCSNJETH2DZH45LE'
			const apiSecret = 'HPUX3CCLXEEJSLEWMVS3JTSDNIWVHDNZ'
			config.init({ apiKey, apiSecret })
			async function send (params = {}) {
			  try {
			    const response = await Group.sendSimpleMessage(params)
			    console.log(response)
			  } catch (e) {
			    console.log(e)
			  }
			}

			const params = {
			  text: '123', // 문자 내용
			  type: 'SMS', // 발송할 메시지 타입 (SMS, LMS, MMS, ATA, CTA)
			  to: '01072588357', // 수신번호 (받는이)
			  from: '01039475130' // 발신번호 (보내는이)
			}
			send(params)
	</script>

