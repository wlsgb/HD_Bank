<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

			<div class="content">
					<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">대출</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="check" class="btn btn-white btn-sm btn-border mr-1">대출현황조회</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<!--대출 신청   -->
		<form action="fileupload" method="post" class="form-horizontal" enctype="multipart/form-data">
				<div class="row mt--4">
				<div class="col-sm-6 col-md-2"></div>
						<div class="col-sm-6 col-md-8">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
											<div class="col-1"></div>
											<div class="col-10">
												
												<h1>서류제출</h1>
												<hr>
												
												<h3>첨부 파일</h3>
												
												<input type="hidden" value="${lc_num }" name="lc_num" id="lc_num"> 
												<div class="form-group row">
													<label for="file1" class="col-4" >주민등록등본</label>
													<div class="col-8">
														<input type="file" id="mfile1" name="mfile1" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file2" class="col-4">주민등록초본</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile2" name="mfile2" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file3" class="col-4" >소득금액증명원</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile3" name="mfile3" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file4" class="col-4">사실확인증명원</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile4" name="mfile4" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file5" class="col-4">건강보험납부료확인서</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile5" name="mfile5" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file6" class="col-4">건강보험자격득실확인서</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile6" name="mfile6" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file7" class="col-4">근로소득원천징수영수증</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile7" name="mfile7" >
													</div>
												</div>
												<div class="form-group row">
													<label for="file8" class="col-4">사업자등록증</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile8" name="mfile8" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file9" class="col-4">배우자주민등록등본</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile9" name="mfile9" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file10" class="col-4">배우자주민등록초본</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile10" name="mfile10" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file11" class="col-4">배우자소득금액증명원</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile11" name="mfile11" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file12" class="col-4">배우자사실확인증명원</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile12" name="mfile12" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file13" class="col-4">배우자건강보험납부료확인서</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile13" name="mfile13" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file14" class="col-4">배우자건강보험자격득실확인서</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile14" name="mfile14" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file15" class="col-4">배우자근로소득원천징수영수증</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile15" name="mfile15" >
													</div>
												</div>
												<div class="form-group row">
													<label for="file16" class="col-4">배우자사업자등록증</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile16" name="mfile16" >
													</div>
												</div>
											
												<div class="form-group row">
													<label for="file17" class="col-4">기타1</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile17" name="mfile17" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file18" class="col-4">기타2</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile18" name="mfile18" >
													</div>
												</div>
												
												<div class="form-group row">
													<label for="file19" class="col-4">기타3</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile19" name="mfile19" >
													</div>
												</div>
											
												<div class="form-group row">
													<label for="file20" class="col-4">기타4</label>
													<div class="col-8">
														<input type="file" class="form-control-file" id="mfile20" name="mfile20" >
													</div>
												</div>
												
												
												
											</div>
											<div class="col-1"></div>
										</div>
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-2"></div>
			
						</div>
					
			<p class="text-center"><input type="submit" class="btn btn-info" value="제출하기"></p>
		</form>
			</div>
		
			


			
			<script>
		
	</script>

