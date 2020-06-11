<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
label{
padding-top: 10px;
}
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

</style>
			<div class="content">
			<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">대출</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="application" class="btn btn-white btn-sm btn-border mr-1">대출신청</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				
		<form action="memberjoin" method="post" class="form-horizontal">
				<div class="row mt--4">
				<div class="col-sm-6 col-md-2"></div>
						<div class="col-sm-6 col-md-8">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
												<h1>대출 신청</h1>
												<hr>
												<h3>신청자 정보</h3>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">이메일</label>
													<div class="col-6">
   														<input type="email" class="form-control"  id="mem_email" name="mem_email">
   													<div id="target">
   													<input type='hidden' id='chk' value='0'>
   													</div>
   													</div>
   													<div class="col-2">
   													<input type="button" id="idchk" class="btn btn-info" value="중복검사">
   													</div>
												</div>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">비밀번호</label>
													<div class="col-10">
   														<input type="password" class="form-control"  id="mem_pwd" name="mem_pwd">
   													</div>
												</div>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">비밀번호확인</label>
													<div class="col-10">
   														<input type="password" class="form-control"  id="mem_pwd2" name="mem_pwd2">
   													</div>
												</div>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">이름</label>
													<div class="col-10">
   														<input type="text" class="form-control"  id="mem_name" name="mem_name">
   													</div>
												</div>
												<div class="form-group row">
													<label for="name" class="col-2 control-label">전화번호</label>
													<div class="col-10 row">
   														<input type="number" class="form-control col-3"  id="mem_phn1" name="mem_phn1">
   														<p class="col-1 text-center">ㅡ</p>
   														<input type="number" class="form-control col-3"  id="mem_phn2" name="mem_phn2">
   														<p class="col-1 text-center">ㅡ</p>
   														<input type="number" class="form-control col-3"  id="mem_phn3" name="mem_phn3">
   													</div>
												</div>
												<div class="form-group row">
													<label for="mem_birth" class="col-2 control-label">생년월일</label>
													<div class="col-10">
   														<input type="date" class="form-control"  id="mem_birth" name="mem_birth">
   													</div>
												</div>
													<div class="form-group row">
													<label for="name" class="col-2 control-label">주소</label>
													<div class="col-10">
   														<input type="text" class="form-control"  id="mem_loc" name="mem_loc">
   													</div>
												</div>
												<div class="form-group row">
													<label for="mem_birth" class="col-2 control-label">성별</label>
													<div class="col-10">
   														<input type="radio"  name="mem_gender" value="m"><span>남자</span>
   														<input type="radio"  name="mem_gender" value="f" checked="checked"><span>여자</span>
   													</div>
												</div>
												<div class="form-group row">
													<label for="mem_birth" class="col-2 control-label">이메일수신동의</label>
													<div class="col-10">
   														<input type="radio"  name="mem_email_chk" value="1"><span>동의</span>
   														<input type="radio"  name="mem_email_chk" value="0" checked="checked"><span>비동의</span>
   													</div>
												</div>
												<div class="form-group row">
													<label for="mem_birth" class="col-2 control-label">개인정보동의</label>
													<div class="col-10" id="mem_chk">
   														<input type="radio" id="check1" name="mem_pri_chk" value="1">동의
   														<input type="radio" id="check2" name="mem_pri_chk" value="0" checked="checked">비동의
   													</div>
												</div>
												
												
											
												
												
											
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-2"></div>
			
						</div>
					
			<p class="text-center"><button type="submit" class="btn btn-info" id="btn">대출 신청</button></p>
		</form>
			</div>
		
			


			
			<script>

			$('#check1').click(function() {
				$.ajax({
					url:'radio?radio='+$('#check1').val(),
					success: function(data) {
						$('#mem_chk').html(data)
					}
				})
			})
			$('#check2').click(function() {
				$.ajax({
					url:'radio?radio='+$('#check2').val(),
					success: function(data) {
						$('#mem_chk').html(data)
					}
				})
			})
			
		
			$("form").submit(function(event) {
				var id = $('#mem_email').val();
				var pw = $('#mem_pwd').val();
				var pw2 = $('#mem_pwd2').val();
				
				
				if ( $('#mem_email') == "") {
					alert("id를 입력해주세요.");
					event.preventDefault(); return; 
					} 
				if($('#chk').val() == 0 ){
					alert("email 중복확인을 해주세요.");
					event.preventDefault(); return; 
				}
				if ($('#mem_pwd').val() == "") { 
					alert("pw를 입력해주세요.");
					event.preventDefault(); return; }
				if($('#mem_pwd2').val() != pw){
					alert("pw를 확인해주세요.");
					event.preventDefault(); return; 
					
				}
				if($('#mem_name').val() == ""){
					alert("이름을 확인해주세요.");
					event.preventDefault(); return; 
					
				}
				if($('#mem_phn1').val() == ""){
					alert("전화번호 앞자리를 확인해주세요.");
					event.preventDefault(); return; 
					
				}
				if($('#mem_phn2').val() == ""){
					alert("전화번호 중간자리를 확인해주세요.");
					event.preventDefault(); return; 
					
				}
				if($('#mem_phn3').val() == ""){
					alert("전화번호 뒷자리를 확인해주세요.");
					event.preventDefault(); return; 
					
				}
				if($('#mem_birth').val() == ""){
					alert("생년월일를 확인해주세요.");
					event.preventDefault(); return; 
					
				}
				if($('#mem_loc').val() == ""){
					alert("주소를 확인해주세요.");
					event.preventDefault(); return; 
					
				}
				if($(':input[name=mem_pri_chk]:checked').val() == 0){
					alert("개인정보동의를 해주세요.");
					event.preventDefault(); return; 
					
				}
				
			}); 
			
			$('#idchk').click(function() {
				console.log('123')
				console.log($('#mem_email'))
				$.ajax({
					url:'idchk?mem_email='+$('#mem_email').val(),
					success: function(data) {
						$('#target').html(data)
					}
				})

			})
			
			$('#mem_email').keydown(function() {
				var idchk="<p style='color:red'>중복검사를 해주세요</p>";
				idchk+="<input type='hidden' id='chk' value='0'>";
				$('#target').html(idchk)
			})
	</script>


