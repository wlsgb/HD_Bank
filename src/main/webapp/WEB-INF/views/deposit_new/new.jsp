<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
				<!-- 상단의 푸른색 공간 시작 -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">예금</h2>
								<h5 class="text-white op-7 mb-2">
									<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
									<span class="h2 mr-1"> > </span>
									<a href="new" class="btn btn-white btn-sm btn-border mr-1">신규</a>
								</h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
								<a href="qna" class="btn btn-secondary btn-round">고객센터</a>
							</div>
						</div>
					</div>
				</div>
				
				<!-- 상단의 푸른색 공간 끝 -->
				<div class="page-inner mt--5">
				<!-- 페이지 레이아웃 시작 -->
				<div class="row">
						<div class="col-4" id="savinfo">
							<div class="card card-stats card-primary card-round">
								<div class="card-body">
									<div class="numbers">
										<h4 class="card-title">입출금식 예금 상품</h4>
									</div>
								</div>
							</div>
						</div>
						<div class="col-4" id="insinfo">
							<div class="card card-stats card-info card-round">
								<div class="card-body">
									<div class="numbers">
										<h4 class="card-title">저축식 예금 상품</h4>
									</div>
								</div>
							</div>
						</div>
						<div class="col-4" id="shasinfo">
							<div class="card card-stats card-success card-round">
								<div class="card-body ">
									<div class="numbers">
										<h4 class="card-title">공유 계좌</h4>
									</div>
								</div>
							</div>
						</div>
						<!-- <div class="col-sm-6 col-md-3" id="shacinfo">
							<div class="card card-stats card-secondary card-round">
								<div class="card-body ">
									<div class="numbers">
										<h4 class="card-title">도전하기</h4>
									</div>
								</div>
							</div>
						</div> -->
					</div>
					<!-- 상단 페이지 이동 4개 -->
				<div class="row">
						<div class="col-md-12" >
							<div class="card">
								<div class="card-header">
									<div class="card-head-row">
										<div class="card-title" id='depname'></div>
									</div>
								</div>
								<div class="card-body">
										<div class="row">
										<div class="col-md-12">
											<table class="table mt-1">
											<thead>
											</thead>
											<tbody id="depval">
											</tbody>
										</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 페이지 레이아웃 끝 -->
				</div>
			</div>


	<script>
	$(function() {
		$('#depval').html("");
		$.ajax({
			url:'savlist',
			dataType:'JSON',
			success:function(data){
				var savlist=data;
				$('#depname').html("예금상품");
				//console.log(savlist);
				for(var e in savlist){
					//console.log(savlist[e].sav_name);
					$('#depval').append("<tr><th scope='col'>"+savlist[e].sav_name+"</th><td><div class='row'><div class='col-md-4 ml-auto'><input type='button' class='btn btn-default' value='신청하기' onclick=\"location='new_savdetail?sav_code="+savlist[e].sav_code+"'\"></div></div></td></tr>")
				};
			}
		});
	});
	$('#savinfo').click(function() {
		$('#depname').html("예금상품");
		$('#depval').html("");
 		$.ajax({
			url:'savlist',
			dataType:'JSON',
			success:function(data){
				var savlist=data;
				//console.log(savlist);
				for(var e in savlist){
					//console.log(savlist[e].sav_name);
					$('#depval').append("<tr><th scope='col'>"+savlist[e].sav_name+"</th><td><div class='row'><div class='col-md-4 ml-auto'><input type='button' class='btn btn-default' value='신청하기' onclick=\"location='new_savdetail?sav_code="+savlist[e].sav_code+"'\"></div></div></td></tr>")
				};
			}
		});
	});
	$("#insinfo").click(function() {
		$('#depname').html("적금상품");
		$('#depval').html("");
		$.ajax({
			url:'inslist',
			dataType:'JSON',
			success:function(data){
				var inslist=data;
				//console.log(inslist);
				for(var e in inslist){
					//console.log(inslist[e].ins_name);
					$('#depval').append("<tr><th scope='col'>"+inslist[e].ins_name+"</th><td><div class='row'><div class='col-md-4 ml-auto'><input type='button' class='btn btn-default' value='신청하기' onclick=\"location='new_insdetail?ins_code="+inslist[e].ins_code+"'\"></div></div></td></tr>")
				};
			}
		});
	});
	$("#shasinfo").click(function() {
		$('#depname').html("공유예금");
		$('#depval').html("");
		$.ajax({
			url:'sharelist',
			dataType:'JSON',
			success:function(data){
				var sharelist=data;
				//console.log(inslist);
				for(var e in sharelist){
					//console.log(inslist[e].ins_name);
					$('#depval').append("<tr><th scope='col'>"+sharelist[e].savingVO.sav_name+"</th><td><div class='row'><div class='col-md-4 ml-auto'><input type='button' class='btn btn-default' value='신청하기' onclick=\"location='new_shasdetail?shas_code="+sharelist[e].shas_code+"'\"></div></div></td></tr>");
				};
			}
		});
		/* $('#depval').append("<a href='share_new_req'>share_new_req</a><br>");
		$('#depval').append("<a href='share_new_res'>share_new_res</a><br>");
		$('#depval').append("<a href='share_new_insert'>share_new_insert</a><br>");
		$('#depval').append("<a href='share_new_complete'>share_new_complete</a><br>");
		$('#depval').append("<a href='share_new_check'>share_new_check</a><br>");
		$('#depval').append("<a href='deposite_cancle_check_shareAccount'>deposite_cancle_check_shareAccount</a><br>");
		$('#depval').append("<a href='share_cancel_req'>share_cancel_req</a><br>");
		$('#depval').append("<a href='share_cancel'>share_cancel</a><br>"); */
	});
	$("#shacinfo").click(function() {
		$('#depname').html("도적하기(공유적금)");
		$('#depval').html("");
	});
	
	</script>
