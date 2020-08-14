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
							<span class="flaticon-home" />
						</a> <span class="h2 mr-1"> > </span> <a href="search"
							class="btn btn-white btn-sm btn-border mr-1">자주 찾는 실문</a>
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
							<div class="card-title col-3">나의 문의 글</div>
						</div>
					</div>
					<div class="form-group" id="">
						
						<div class="card-body">
						
							<c:forEach items="${list }" var="e">
							
								<div>${e.inq_num }번)
									<c:if test="${e.cat_num eq 2}">예금</c:if>
									<c:if test="${e.cat_num eq 3}">대출</c:if>
									<c:if test="${e.cat_num eq 4}">회원정보</c:if>
									<c:if test="${e.cat_num eq 5}">기타</c:if>
								</div>
								
								<div>제목 : ${e.inq_title }</div><div>문의 시간 : ${e.inq_date }</div>
								<div style="border: 1px solid gray; background-color: #E2E2E2;">내용 : ${e.inq_content }
									
								</div>
							</c:forEach>
							<div class="card-body">
								<div class="demo">
									<ul class="pagination pg-primary">
										<li class="page-item">
											<!-- 이전 페이지  --> <input type="hidden" id="cntperpage"
											value="${paging.cntPerPage}"> <c:if
												test="${paging.startPage != 1 }">
												<a
													href="qna?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&categori=${paging.categori}
													&searchType=${paging.searchType }&searchValue=${paging.searchValue}"></a>
											</c:if> <c:forEach begin="${paging.startPage }"
												end="${paging.endPage }" var="p">
												<c:choose>
													<c:when test="${p == paging.nowPage }">
														<b>${p }</b>
														<input type="hidden" value="${p }" id="p">
														<!--현재 페이지 일경우 링크 해제 -->
													</c:when>
													<c:when test="${p != paging.nowPage }">
														<!--다른페이지 링크   -->
														<a
															href="qna?nowPage=${p }&cntPerPage=${paging.cntPerPage}&categori=${paging.categori}
															&searchType=${paging.searchType }&searchValue=${paging.searchValue}">${p }</a>
													</c:when>
												</c:choose>
											</c:forEach> <!-- 다음페이지  --> <c:if
												test="${paging.endPage != paging.lastPage}">
												<a
													href="qna?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&categori=${paging.categori}
													&searchType=${paging.searchType }&searchValue=${paging.searchValue}"></a>
											</c:if>
											
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$('#one').click(function() {                                                                                                                                                                                                                                                                                                         
			location = 'qna?categori=0'
		})
		$('#two').click(function() {
			location = 'qna?categori=2'
		})
		$('#three').click(function() {
			location = 'qna?categori=3'
		})
		$('#four').click(function() {
			location = 'qna?categori=4'
		})
		$('#five').click(function() {
			location = 'qna?categori=5'
		})
		
		$('#search').click(function() {
			location = 'qna?categori=0&searchType='+$('#searchType').val()+'&searchValue='+$('#searchValue').val()
		})
	</script>