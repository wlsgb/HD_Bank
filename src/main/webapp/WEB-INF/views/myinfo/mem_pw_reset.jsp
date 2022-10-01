<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content">
	<!-- 상단의 푸른색 공간 시작 -->
	<div class="panel-header bg-primary-gradient">
		<div class="page-inner py-5">
			<div
				class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
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
		<div class="row row-card-no-pd">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<p class="card-category">암호 재설정</p>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-8 ml-auto mr-auto">
								<div class="table-responsive table-hover table-sales">
									<div style="margin: auto;">
										<div style="margin: auto;">
										<!-- 테이블 시작 -->
											<form action="mem_pw_success" method="post" name="f">
											<table class="table mt-3">
												<tbody>
													<tr>
														<td>이름</td>
														<td>
															<div class="col-md-9 p-0">
																<input type="text" class="form-control input-full"
																	id="inlineinput" value="${memberVO.mem_name }"
																	readonly="readonly">
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
													<tr>
														<th scope="col">재확인</th>
														<td>
															<div class="row">
																<div class="col-6">
																	<input type="password" id="repwd" name="repwd"
																	class="form-control input-full" placeholder="(비밀번호 재확인)">
																</div>
																<div class="col-6" id="target"></div>
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
																	<input type="button" class="btn btn-success" value="확인" onclick="chk()">
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
				</div>
			</div>
		</div>

		<!-- 페이지 레이아웃 끝 -->
	</div>
</div>




<script>
	$(function() {
	/* 화면이 다 로딩이 된후 시작 */
	
	// 취소버튼
		$("#cancel").click(function() {
			location = "index";
		});
	// 패스워드가 일치하는지 확인한다.
		var oldVal = null;
		$("#repwd").on("propertychange change keyup paste input", function() {
		    var currentVal = $(this).val();
		    if(currentVal == oldVal) {
		        return;
		    }
		    oldVal = currentVal;
		   	if($('#repwd').val() !== $("#pwd").val()){
			   $('#target').html("입력하신 비밀번호와 다릅니다.").addClass('text-danger');
		   }else {
			   $('#target').removeClass('text-danger');
			   $('#target').html("입력하신 비밀번호와 일치합니다.").addClass('text-primary');;
			}
		});
		
		$("#pwd").on("propertychange change keyup paste input", function() {
		    var currentVal = $(this).val();
		    if(currentVal == oldVal) {
		        return;
		    }
		    oldVal = currentVal;
		    console.log("반응");
		   	if($('#pwd').val() !== $("#repwd").val()){
			   $('#target').html("입력하신 비밀번호와 다릅니다.").addClass('text-danger');
		   }else {
			   $('#target').removeClass('text-danger');
			   $('#target').html("입력하신 비밀번호와 일치합니다.").addClass('text-primary');;
			}
		});
	
	/* 화면이 다 로딩이 된후 끝 */
	})
	
	// 확인 버튼을 누르면 작동
		function chk() {
		console.log("chk 작동");
			if($("#pwd").val() === null){
				alert("비밀번호를 입력해주세요");
			}else if($("#repwd").val() === null){
				alert("비밀번호 재입력을 입력해주세요");
			}else if($("#pwd").val() !== $("#repwd").val()){
				alert("비밀번호를 확인해주세요.");
			}else{
				f.submit();
			}
		}
	
	
</script>
