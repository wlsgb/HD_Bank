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
							class="btn btn-white btn-sm btn-border mr-1">나의 1:1 문의하기</a>
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
							<div class="card-title col-3">나의 1:1 문의하기</div>
						</div>
					</div>
					<div class="form-group" id="">
						<div class="input-icon" style="display: inline-block;">
							<table class="table mt-3" style="width: 1000px;" >
								<thead>
								</thead>
								<tbody>
									<tr>
										<td>작성자</td>
										<td><input type="text" class="form-control input-full"
											id="inlineinput" placeholder="이름">
										</td>
									</tr>
									<tr>
										<td>분류</td>
										<td><select class="form-control input-full"
											id="inlineinput">
												<option>-분류선택-</option>
												<option value="1">예금</option>
												<option value="2">대출</option>
												<option value="3">회원정보</option>
												<option value="4">기타</option>
										</select></td>
									</tr>
									<tr>
										<td>답변받기</td>
										<td><span class="col-1">전화번호</span><input type="text"
											class="col-7 input-full" id="inlineinput"
											placeholder="입력하시오."> <input type="checkbox"
											name="searchopen" value="1" class="col-1 box_check"
											id=search_conform checked></td>
										<td><span class="col-1">이메일</span><input type="text"
											class="col-7 input-full" id="inlineinput"
											placeholder="입력하시오."> <input type="checkbox"
											name="searchopen" value="1" class="col-1 box_check"
											id=search_conform checked></td>
									</tr>
									<tr>
										<td>제목</td>
										<td><input type="text" class="form-control input-full"
											id="inlineinput" placeholder="입력 하시오." style="width: 1000px">
										</td>
									</tr>

								</tbody>
							</table>
						</div>
						<div class="card-body">

							<div class="card-body">
								<div class="demo">
									<ul class="pagination pg-primary">
										<li class="page-item">
											<table role="resentation" class="wrap" id="toolbox"
												style="height: 400px;">
												<tbody>
													<tr valign="top">
														<td><textarea style="width: 1000px; height: 500px;"></textarea>
														</td>
													</tr>
												</tbody>
											</table>
										</li>
									</ul>
								</div>
							</div>
							<div>
								<table class="table mt-3">
									<thead>
									</thead>
									<tbody>
										<tr>
											<td><a href="mem_pw_chk"><button
														class="btn btn-primary btn-round">확인</button></a> <a
												href="qna"><button class="btn btn-danger btn-round">취소</button></a>
											</td>
										</tr>
									</tbody>
								</table>
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

	$('#search').click(
			function() {
				location = 'qna?categori=0&searchType='
						+ $('#searchType').val() + '&searchValue='
						+ $('#searchValue').val()
			})
</script>