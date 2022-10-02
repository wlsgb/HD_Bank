<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                        <a href="transfer_auto" class="btn btn-white btn-sm btn-border mr-1">자동이체신청내역</a>
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
                        <div class="card-title">자동이체 신청내역</div>
                    </div>
                    <div class="card-body" style="margin-bottom: 20px; margin-top: 0">
                        <div class="row">
                            <div class="col-md-1 col-lg-1"></div>
                            <div class="col-md-10 col-lg-10">

                                <div class="card">
                                    <form action="transfer_auto_apply" method="post">
                                        <div class="card-header">
                                            <!-- 									<div class="card-title">Hoverable Table</div> -->
                                            <table style="margin: auto; width: 400px; height: 30px;">
                                                <tr>
                                                    <td>계좌번호</td>
                                                    <td>
                                                        <!-- 									<input type="text" placeholder="110-111-12345 : 보통예금" style="width: 300px; margin-left: 20%;"/> -->
                                                        <select name="ac_num" id="ac_num" class="form-control">
                                                            <c:forEach var="e" items="${aclist }" varStatus="i">
                                                                <c:if test="${e.saving.sav_name != '0'}">
                                                                    <c:if test="${i.index eq 0 }">
                                                                        <option value="" selected="selected">선택</option>
                                                                    </c:if>
                                                                    <option>${e.ac_num }</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="card-body">
                                            <table class="table table-bordered">


                                                <tbody style="border: 2px solid black;" id="ajaxtarget">


                                                </tbody>


                                            </table>
                                            <!-- 										<div style="margin-left: 40%; margin-bottom: 20px;"> -->
                                            <!-- 											<button class="btn btn-default btn-xs" type="submit">1</button> -->
                                            <!-- 											<button class="btn btn-default btn-xs" type="submit">2</button> -->
                                            <!-- 											<button class="btn btn-default btn-xs" type="submit">3</button> -->
                                            <!-- 											<button class="btn btn-default btn-xs" type="submit">4</button> -->
                                            <!-- 										</div> -->


                                            <div style="margin-left: 35%;">
                                                <!-- 								<button type="button" class="btn btn-info ">확인</button> -->

                                                <button type="submit" class="btn btn-info ">자동이체 신청</button>

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

</div>


<script>

    $(document).ready(function () {


        $('#ac_num').change(function () {

            $('#ajaxtarget').html("");
            $.ajax({
                url: 'deposit_transfer_auto_server?ac_num=' + $('#ac_num').val(),
                success: function (data) {
                    $('#ajaxtarget').html(data);
                }
            })
        })
    })


</script>
	
	
	
	
