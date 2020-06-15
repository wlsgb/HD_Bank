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
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
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
											<table class="table mt-1">
											<tbody>
												<tr>
													<th scope="col">전화번호</th>
													<td>
														<div class="row">
															<div class="col-2">
																<select class="form-control" id="exampleFormControlSelect1">
																	<option>SKT</option>
																	<option>KT</option>
																	<option>LGU</option>
																</select>
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">이메일</th>
													<td>
														<div class="row">
															<div class="col-8">
																<input type="text" class="form-control input-full">                                      
															</div>
															<div class="col-4">
																<button class="btn btn-primary" id="emailsend">전송</button>
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">인증번호</th>
													<td>
														<div class="row">
															<div class="col-8">
																<input type="text" class="form-control input-full">                                      
															</div>
															<div class="col-4 mt-1">
																<button class="btn btn-success btn-sm" disabled="disabled">Success</button>
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">주민등록번호</th>
													<td>
														<div class="row">
															<div class="col-7">
																<input type="text" class="form-control input-full">
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
																<button class="btn btn-success" id="send">확인</button>
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
			$("#cancel").click(function() {
				location = "security";
			});
			$("#send").click(function() {
				location = "securityotpsuccess";
			});
			$('#emailsend').click(function(e) {
				swal({
					title: '이메일을 전송 하시겠습니까?',
					text: "이메일을 확인해주세요. \n hani@naver.com",
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
						swal({
							title: '전송되었습니다.',
							text: '전송된 코드를 입력해주세요.',
							type: 'success',
							buttons : {
								confirm: {
									text : '확인',
									className : 'btn btn-success'
								}
							}
						});
					} else {
						swal.close();
					}
				});
			});
			/*  */
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
			  text: '하니야 우리 저녁 뭐 먹어?', // 문자 내용
			  type: 'SMS', // 발송할 메시지 타입 (SMS, LMS, MMS, ATA, CTA)
			  to: '01072588357', // 수신번호 (받는이)
			  from: '01039475130' // 발신번호 (보내는이)
			}
			send(params)
	</script>

