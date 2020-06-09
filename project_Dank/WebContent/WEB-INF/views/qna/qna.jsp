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
					<h2 class="text-white pb-2 fw-bold">고객센터</h2>
					<h5 class="text-white op-7 mb-2">
						<a href="index" class="btn btn-white btn-sm btn-border mr-1">
						<span class="flaticon-home" /></a> <span class="h2 mr-1"> > </span> 
						<a href="search" class="btn btn-white btn-sm btn-border mr-1">자주
							찾는 실문</a>
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
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<div class="card-head-row">
							<div class="card-title col-3">자주 찾는 질문</div>


						</div>
					</div>


					<div class="form-group" id="">

						<div class="input-icon" style="display: inline-block;">

							<span class="input-icon-addon"> <i class="fa fa-search"></i>
							</span> <input type="text" class="form-control"
								placeholder="Search for..."">


						</div>
						<button class="btn btn-info" style="display: inline-block;">검색</button>

					</div>


					<div class="card-body">
						<ul class="nav nav-pills nav-secondary" id="pills-tab"
							role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="pills-home-tab" data-toggle="pill" href="#pills-home"
								role="tab" aria-controls="pills-home" aria-selected="true">전체</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								id="pills-profile-tab" data-toggle="pill" href="#1" role="tab"
								aria-controls="pills-profile" aria-selected="false">예금</a></li>
							<li class="nav-item"><a class="nav-link"
								id="pills-contact-tab" data-toggle="pill" href="#2" role="tab"
								aria-controls="pills-contact" aria-selected="false">대출</a></li>
							<li class="nav-item"><a class="nav-link"
								id="pills-contact-tab" data-toggle="pill" href="#3" role="tab"
								aria-controls="pills-contact" aria-selected="false">회원정보</a></li>
							<li class="nav-item"><a class="nav-link"
								id="pills-contact-tab" data-toggle="pill" href="#4" role="tab"
								aria-controls="pills-contact" aria-selected="false">기타</a></li>
						</ul>
						<div class="tab-content mt-2 mb-3" id="pills-tabContent">
							<div class="tab-pane fade show active" id="pills-home"
								role="tabpanel" aria-labelledby="pills-home-tab">
								<c:forEach items="${list }" var="e">
									<div>${e.qna_num }번
										)
										<c:if test="${e.cat_num eq 2}">예금</c:if>
										<c:if test="${e.cat_num eq 3}">대출</c:if>
										<c:if test="${e.cat_num eq 4}">회원정보</c:if>
										<c:if test="${e.cat_num eq 5}">기타</c:if>
									</div>
									<div>${e.qna_title }</div>
									<div>${e.qna_content }</div>
									<div>${e.qna_date }</div>
								</c:forEach>
							</div>
							<div class="tab-pane fade" id="1" role="tabpanel"
								aria-labelledby="pills-profile-tab">

								<c:forEach items="${list }" var="e">
									<c:if test="${e.cat_num eq 2}">
										<div>${e.qna_num }번)예금</div>
										<div>${e.qna_title }</div>
										<div>${e.qna_content }</div>
										<div>${e.qna_date }</div>
									</c:if>
								</c:forEach>

							</div>
							<div class="tab-pane fade" id="2" role="tabpanel"
								aria-labelledby="pills-contact-tab">
								<c:forEach items="${list }" var="e">
									<c:if test="${e.cat_num eq 3}">
										<div>${e.qna_num }번)대출</div>
										<div>${e.qna_title }</div>
										<div>${e.qna_content }</div>
										<div>${e.qna_date }</div>
									</c:if>
								</c:forEach>
								<!-- <div style="border: 1px solid gray; background-color: #E2E2E2;">
											</div> -->
							</div>
							<div class="tab-pane fade" id="3" role="tabpanel"
								aria-labelledby="pills-contact-tab">
								<c:forEach items="${list }" var="e">
									<c:if test="${e.cat_num eq 4}">
										<div>${e.qna_num }번)회원정보</div>
										<div>${e.qna_title }</div>
										<div>${e.qna_content }</div>
										<div>${e.qna_date }</div>
									</c:if>
								</c:forEach>

							</div>
							<div class="tab-pane fade" id="4" role="tabpanel"
								aria-labelledby="pills-contact-tab">
								<c:forEach items="${list }" var="e">
									<c:if test="${e.cat_num eq 5}">
										<div>${e.qna_num }번)기타</div>
										<div>${e.qna_title }</div>
										<div>${e.qna_content }</div>
										<div>${e.qna_date }</div>
									</c:if>
								</c:forEach>

							</div>
						</div>
					</div>

					<div class="card-body">
						<div class="demo">
							<ul class="pagination pg-primary">
								<li class="page-item">
									<!-- 이전 페이지  --> <c:if test="${paging.startPage != 1 }">
										<a
											href="qna?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"></a>
									</c:if> <c:forEach begin="${paging.startPage }"
										end="${paging.endPage }" var="p">
										<c:choose>
											<c:when test="${p == paging.nowPage }">
												<b>${p }</b>
												<!--현재 페이지 일경우 링크 해제 -->
											</c:when>
											<c:when test="${p != paging.nowPage }">
												<!--다른페이지 링크   -->
												<a href="qna?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
											</c:when>
										</c:choose>
									</c:forEach> <!-- 다음페이지  --> <c:if
										test="${paging.endPage != paging.lastPage}">
										<a
											href="qna?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}"></a>
									</c:if> <!-- <a class="page-link" href="#" aria-label="Previous">
													<span aria-hidden="true"> < </span>
													<span class="sr-only"></span>
												</a>
											</li>
											<li class="page-item active"><a class="page-link" href="#">1</a></li>
											<li class="page-item"><a class="page-link" href="#">2</a></li>
											<li class="page-item"><a class="page-link" href="#">3</a></li>
											<li class="page-item">
												<a class="page-link" href="#" aria-label="Next">
													<span aria-hidden="true">></span>
													<span class="sr-only"></span>
												</a> -->
								</li>
							</ul>


						</div>

					</div>
				</div>


			</div>
		</div>
	</div>

</div>
<script>
	
</script>
