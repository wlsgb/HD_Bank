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
					<h2 class="text-white pb-2 fw-bold">뉴스페이지</h2>
					<h5 class="text-white op-7 mb-2">
						<a href="index" class="btn btn-white btn-sm btn-border mr-1">
							<span class="flaticon-home" />
						</a> <span class="h2 mr-1"> > </span> <a href="search"
							class="btn btn-white btn-sm btn-border mr-1">금융뉴스페이지</a>
					</h5>
				</div>
				<div class="ml-md-auto py-2 py-md-0">
					<a href="checkbalance"
						class="btn btn-white btn-border btn-round mr-2">빠른페이지</a> <a
						href="qna" class="btn btn-secondary btn-round">고객센터</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 상단의 푸른색 공간 끝 -->

	<div class="page-inner mt--5">
		<div class="row">
			<div class="col-md-9 ml-auto mr-auto">
				<div class="card">
					<div class="card-header">
						<div class="card-head-row">
							<div class="card-title col-12">금융기사 게시판</div>
						</div>
					</div>
					<div class="form-group">
						<!-- <div class="input-icon"> -->
						<div class="col-md-6 row" style="max-width: 100%;display: flex;justify-content: center;">
							<select name="searchType" id="searchType" class="form-control col-3">
								<option value="1">제목</option>									
								<option value="2">내용</option>
							</select>
							&nbsp;
							<input type="text" name="searchValue" id="searchValue" class="form-control col-5">
							&nbsp;
							<input class="btn btn-info col-2" type="button" id="search" value="검색">
						</div>

						</div>
						<div class="card-body">
			
							<c:forEach items="${list}" var="e">
								<div class="row col-12">
									&nbsp;
									<span class="blockquote blockquote-primary">${e.title }</span>
								</div>
								<div class="card-sub">
									<span class="lead">${e.content }</span>
									<br />
									<br />
									<p style="text-align: right;">관련링크 : <a href="${e.link }"><b>${e.link }</b></a></p>
								</div>
								<br />
								<br />
							</c:forEach>
							<div class="card-body" style="justify-content: center;display: flex;">
									<ul class="pagination pg-primary">
											<li>
											<!-- 이전 페이지  --> 
											<input type="hidden" id="cntperpage" value="${paging.cntPerPage}">
											</li> 
											<c:if test="${paging.startPage != 1 }">
												<li class="page-item">
												<a href="goNews?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}
													&searchType=${paging.searchType }&searchValue=${paging.searchValue}" class="page-link">&lt;&lt;</a>
												</li>
											</c:if> 
												<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
												<c:choose>
													<c:when test="${p == paging.nowPage }">
														<li class="page-item active">
														<a class="page-link">${p }</a>
														<input type="hidden" value="${p }" id="p">
														<!--현재 페이지 일경우 링크 해제 -->
														</li>
													</c:when>
													<c:when test="${p != paging.nowPage }">
													<li class="page-item">
														<!--다른페이지 링크   -->
														<a href="goNews?nowPage=${p }&cntPerPage=${paging.cntPerPage}
															&searchType=${paging.searchType }&searchValue=${paging.searchValue}" class="page-link">${p }</a>
													</li>
													</c:when>
												</c:choose>
											</c:forEach> 
											<!-- 다음페이지  --> 
											<c:if test="${paging.endPage != paging.lastPage}">
												<li class="page-item">
												<a href="goNews?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&searchType=${paging.searchType }&searchValue=${paging.searchValue}" class="page-link">&gt;&gt;</a>
												</li>
											</c:if>
									</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$('#search').click(function() {
			location = 'goNews?searchType='+$('#searchType').val()+'&searchValue='+$('#searchValue').val()
		})
	</script>