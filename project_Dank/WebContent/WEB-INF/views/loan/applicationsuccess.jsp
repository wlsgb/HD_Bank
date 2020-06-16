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
				<!--대출 신청   -->
				<div class="row mt--4">
				<div class="col-sm-6 col-md-2"></div>
						<div class="col-sm-6 col-md-8">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
											<div class="col-1"></div>
											<div class="col-10">
												<h1 class="text-center">신청이 완료되었습니다!</h1>
												<h3 class="text-center">완료된 신청은 담당상담사의 승인 후에 실행 할 수 있습니다.</h3>
												<h3 class="text-center">신청된 대출의 진행사항은 현황 조회를 통해 확인해 주십시오.</h3>
											</div>
											<div class="col-1"></div>
										</div>
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-2"></div>
			
						</div>
					<div class="row">
					<div class="col-4"></div>
					<div class="col-2">
			<p class="text-center"><button type="button" class="btn btn-info" onclick="location='index'">홈으로</button></p>	
					</div>
					<div class="col-2">
			<p class="text-center"><button type="button" class="btn btn-info" onclick="location='check'">대출 현황 조회</button></p>	
					</div>
		
					<div class="col-4"></div>
					</div>
			</div>
		
			


			
		
			<script>

			history.pushState(null, null, location.href);

			window.onpopstate = function(event) {	

			history.go(1);
	     
	</script>


