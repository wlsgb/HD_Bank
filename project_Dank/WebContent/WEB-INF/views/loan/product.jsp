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
								 <a href="product" class="btn btn-white btn-sm btn-border mr-1">대출상품</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				<!--대출 목록   -->
				
				<div class="row mt--4">
				<div class="col-1"></div>
				<div class="row row-card-no-pd col-10">
					<c:forEach items="${list }" var="e">
						<div class="col-sm-6 col-md-3">
								<div class="card card-stats card-round">
									<!-- <a href="index.jsp"> -->
									<div class="card-body ajax">
										<div class="row">
											<div class="col-3">
												<div class="icon-big text-center">
													<i class="flaticon-coins text-success"></i>
												</div>
											</div>
											<div class="col-9 col-stats">
												<div class="numbers">
												<input type="hidden" id="lp_num" value="${e.lp_num }">
													<p class="card-category">무담보 대출</p>
													<h4 class="card-title">${e.lp_name }</h4>
												</div>
											</div>
										</div>
									</div>
											<!-- </a> -->
								</div>
							</div>
			</c:forEach>
				
						</div>
				</div>
				<!--대출 정보 나오는 곳  -->
				<div class="row">
				<div class="col-1"></div>
					<div class="row row-card-no-pd col-10" id="target">
					<input type="hidden" id="lp" value="0">
						<div class="col-md-12">
						<h1 class="text-center">대출 정보가 나올 곳입니다.</h1><br>
						</div>
						<div class="col-md-12">
						<p class="text-center">알고 싶은 대출을 클릭해 보세요!</p>
						</div>
						</div>
						</div>
			<div>
			
			<p class="text-center"><button type="button" id="btn" class="btn btn-info">대출 신청</button></p>
		
			</div>
			</div>


		
			
			<script>
				$('.ajax').click(function() {
					
						
					
					$.ajax({
						url:'productinfo?lp_num='+$(this).find('input').val(),
						success: function(data) {
							$('#target').html(data)
						}
					})
					
					
				})
				
				$('#btn').click(function() {
					if($('#lp').val()==0){
						alert('상품을 선택해 주세요.')
					}else{
						
					location='applicationform?lp_num='+$('#target').children('input').val();
					}
				})
	</script>
