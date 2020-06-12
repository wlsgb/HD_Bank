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
								 <a href="caculator" class="btn btn-white btn-sm btn-border mr-1">이자계산기</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
		
		<!--상환해야하는 대출  -->
				<div class="row mt--4">
				<div class="col-sm-6 col-md-3"></div>
						<div class="col-sm-6 col-md-6">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
											<div class="col-2"></div>
											
											<div class="form-group col-8">
												<label class="form-label">상환방법</label>
												<div class="selectgroup w-100">
													<label class="selectgroup-item">
														<input type="radio" name="type" value="1" class="selectgroup-input" checked="checked">
														<span class="selectgroup-button">원리금균등</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="type" value="2" class="selectgroup-input">
														<span class="selectgroup-button">원금균등</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="type" value="3" class="selectgroup-input">
														<span class="selectgroup-button">만기일시</span>
													</label>
												</div>
											</div>
											<div class="col-2"></div>
											</div>
										
										<div class="row">
										<div class="col-2"></div>
												<div class="form-group col-8">
												<label class="form-label">상환기간</label>
												<div class="selectgroup w-100">
													<label class="selectgroup-item">
														<input type="radio" name="term" value="1" class="selectgroup-input" checked="checked">
														<span class="selectgroup-button">년</span>
													</label>
													<label class="selectgroup-item">
														<input type="radio" name="term" value="2" class="selectgroup-input">
														<span class="selectgroup-button">월</span>
													</label>
													<label>
														<input type="number" class="form-control input-lg">
													</label>
												</div>
											</div>
											<div class="col-2"></div>
										</div>	
										
										<div class="row">
										<div class="col-2"></div>
										<div class="col-5">
												<div class="form-group">
												<label class="form-label">대출 금액</label>
												<div class="selectgroup w-100">
													<label>
														<input type="number" class="form-control input-lg">
													</label>
												</div>
											</div>
										</div>
										
										<div class="col-3">
												<div class="form-group">
												<label class="form-label">이자율</label>
												<div class="selectgroup w-100">
													<label>
														<input type="number" class="form-control input-lg" step="0.1">
													</label>
												</div>
											</div>
										</div>
										</div>
										<div class="row">
											<div class="col-2"></div>
											<div class="col-4">
											<button type="button" class="btn btn-primary"> 초기화 </button>
											</div>
											<div class="col-4">
											<button type="button" class="btn btn-primary">계산하기</button>
											</div>
										</div>
										
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-3"></div>
			
						</div>
			</div>
		
			


			
			
			<script>
			
	</script>

