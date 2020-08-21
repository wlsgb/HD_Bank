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
			<div class="col-md-9 ml-auto mr-auto">
				<div class="card">
					<div class="card-header">
						<div class="card-head-row">
							<div class="card-title col-3">자주 찾는 질문</div>
						</div>
					</div>
					<div class="form-group">
						<!-- <div class="input-icon"> -->
						<div class="col-md-6 row">
							<select name="searchType" id="searchType" class="form-control col-3">
								<option value="2">제목</option>
									
								<option value="3">내용</option>
								<option value="4">날짜</option>
							</select>
							&nbsp;
							<input type="text" name="searchValue" id="searchValue" class="form-control col-5">
							&nbsp;
							<input class="btn btn-info col-2" type="button" id="search" value="검색">
						</div>

						</div>
						<div class="card-body">
							<button id="one" class="btn btn-primary">전체</button>
							<button id="two" class="btn btn-primary">예금</button>
							<button id="three" class="btn btn-primary">대출</button>
							<button id="four" class="btn btn-primary">회원정보</button>
							<button id="five" class="btn btn-primary">기타</button>
							<br />
							<br />
							<c:forEach items="${list }" var="e">
								<div class="row col-12">
									<span class="blockquote blockquote-primary text-info">
									[
									<c:if test="${e.cat_num eq 2}">예금</c:if>
									<c:if test="${e.cat_num eq 3}">대출</c:if>
									<c:if test="${e.cat_num eq 4}">회원정보</c:if>
									<c:if test="${e.cat_num eq 5}">기타</c:if>
									]
									</span>
									&nbsp;
									<span class="blockquote blockquote-primary">${e.qna_title }</span>
								</div>
								<div class="card-sub">
									<span class="lead">${e.qna_content }</span>
									<br />
									<br />
									<p style="text-align: right;">수정/게시된 날짜 : <b>${e.qna_date }</b></p>
								</div>
								<br />
								<br />
							</c:forEach>
							<div class="card-body">
									<ul class="pagination pg-primary">
											<li>
											<!-- 이전 페이지  --> 
											<input type="hidden" id="cntperpage" value="${paging.cntPerPage}">
											</li> 
											<c:if test="${paging.startPage != 1 }">
												<li class="page-item">
												<a href="qna?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&categori=${paging.categori}
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
														<a href="qna?nowPage=${p }&cntPerPage=${paging.cntPerPage}&categori=${paging.categori}
															&searchType=${paging.searchType }&searchValue=${paging.searchValue}" class="page-link">${p }</a>
													</li>
													</c:when>
												</c:choose>
											</c:forEach> 
											<!-- 다음페이지  --> 
											<c:if test="${paging.endPage != paging.lastPage}">
												<li class="page-item">
												<a href="qna?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&categori=${paging.categori}
													&searchType=${paging.searchType }&searchValue=${paging.searchValue}" class="page-link">&gt;&gt;</a>
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