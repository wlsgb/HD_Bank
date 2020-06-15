<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


		<div class="content">
			<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">예금</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="transfer" class="btn btn-white btn-sm btn-border mr-1">이체</a> 
								 <span class="h2 mr-1"> > </span>
								 <a href="transfer_auto_apply" class="btn btn-white btn-sm btn-border mr-1">자동이체신청</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
			<div class="page-inner mt--5">







				<div class="row">

					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<div class="card-title">자동이체신청</div>
							</div>
							<div class="card-body" style="margin-bottom: 20px;">
								<div class="row">
									<div class="col-md-2 col-lg-2"></div>
									<div class="col-md-8 col-lg-8">
									<form action="transfer_auto_apply_process" method="post">
										<div class="form-group">
											<label for="email2">계좌번호</label> 
											<input type="text" name="ac_num"
												class="form-control" id="email2"
												style="width: 400px; margin-left: 10%;"
												placeholder="110-111-12345 : 보통예금">
										</div>
										<hr class="my-0">

										<div class="form-group ">
											<label for="email2">입금계좌번호</label>

											<div class="form-inline" style="margin-left: 10%;">
												<input type="text" placeholder="HD" class="form-control"
													style="text-align: center; width: 60px;" />
												 <input name="ata_yourac"
													type="text" placeholder="입금 계좌 번호" class="form-control"
													style="text-align: center; width: 300px;" />
											</div>
										</div>
										<hr class="my-0">
										<div class="form-group ">
											<label for="email2">자동이체금액설정</label> <br />
						
											<div class="form-inline" style="margin-left: 10%;">

												<input type="text" name="ata_setmoney" placeholder="이체 금액" class="form-control"
													style="text-align: center; width: 360px;" />
											</div>
										</div>
										<hr class="my-0">
										
										
										<div class="form-group ">
											<label for="email2">시작일/이체시간 설정</label> <br />
												
											<div class="form-inline" style="margin-left: 10%;">
														<input type="date" class="form-control" name="ata_startdate" />
														<input type="time" name="ata_time"  class="form-control">
											</div>
										</div>
										<div class="form-group ">
											
											<div class="form-inline" >
													<label for="email2">받는분통장에 쓸 내용</label> <br />
													<input type="text" name="atayouracmemo" class="form-control"  placeholder="받는분통장에 쓸 내용" style="text-align: center; width: 300px;"/>
											</div>
											<div class="form-inline">
													<label for="email2">보내는분통장에 쓸 내용</label> <br />
													<input type="text" name="atamyacmemo" class="form-control" placeholder="보내는분통장에 쓸 내용" style="text-align: center; width: 300px;" />
											</div>
										</div>
										<input type="hidden" name="atacheck" value="0" />
										<input type="hidden" name="ataing" value="0" />
										
													  
													  <input type="button" data-toggle="collapse" data-target="#demo" value="매달"/>
			
			
			
														<!--// 숨겨지는 영역 -->
														
														<div id="demo" class="collapse">
															<div class="form-group ">
															<label for="email2">이체주기</label> <br />
				
															<div class="form-inline" style="margin-left: 10%;">
				
																<input type="text" placeholder="매월 19일" class="form-control"
																	style="text-align: center; width: 360px;" name="atadterm" />
															</div>
															</div>
															<div class="form-group ">
															<label for="email2">종료일</label> <br />
				
															<div class="form-inline" style="margin-left: 10%;">
																<input type="date" class="form-control"  name="atastopdate"/>
															</div>
															</div>
																		    
														
														  </div>
														<!-- 숨겨지는 영역 //-->
										
										
										

										

										<div class="form-group ">
											<div class="form-inline">
											
										
												<a href="transfer_auto"><button type="button" class="btn btn-danger "
													style="margin-left: 10%; width: 200px;">취소</button></a>
											
													<input type="submit" class="btn btn-success " value="신청" style="margin-left: 10%; width: 200px;" />
											</div>
										</div>





										</form>
									</div>






								</div>
							</div>

						</div>
					</div>
				</div>




			
		</div>

	</div>





<script>

</script>

