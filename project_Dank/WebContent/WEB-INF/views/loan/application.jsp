<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
								<a href="#" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<!--대출 목록   -->
				<form action="applicationform" class="form-horizontal">
				<div class="radio">
				<div class="row mt--4">
				<div class="col-3"></div>
				<div class="row row-card-no-pd col-6">
						
						<c:forEach items="${list }" var="e" >
						<div class="col-sm-10 col-md-10">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
											<div class="col-1"></div>
											<div class="col-3">
												<div class="icon-big text-center">
													<i class="flaticon-coins text-success"></i>
												</div>
											</div>
											<div class="col-5 col-stats">
												<div class="numbers">
													<p class="card-category">무담보 대출</p>
													<h4 class="card-title">${e.lp_name }</h4>
												</div>
											</div>
										</div>
									</div>
											
								</div>
							</div>
		
			
			<div class="col-sm-2 col-md-2 row">
			
			<div class="col-8"></div>						
			<input type="radio" class="lp_num" name="lp_num" value="${e.lp_num }"  style="margin-top: 40px;">
			
			</div>
			</c:forEach>
			
						</div>
						</div>
				</div>	
			<p class="text-center"><button type="submit" class="btn btn-info" id="btn">대출 신청</button></p>
				</form>
		
			</div>
		
			
	

		
			
			<script>
		
			
			$('.lp_num:first').attr('checked', 'checked');
	</script>

