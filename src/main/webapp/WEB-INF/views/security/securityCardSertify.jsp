<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
    <!-- 상단의 푸른색 공간 시작 -->
    <div class="panel-header bg-primary-gradient">
        <div class="page-inner py-5">
            <div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
                <div>
                    <h2 class="text-white pb-2 fw-bold"><!--  -->보안카드 인증</h2>
                    <h5 class="text-white op-7 mb-2">
                        <a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
                        <span class="h2 mr-1"> > </span>
                        <a href="securitycard" class="btn btn-white btn-sm btn-border mr-1">보안카드</a>
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
        <div class="row row-card-no-pd">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <div class="card-head-row card-tools-still-right">
                            <h4 class="card-title">보안카드</h4>
                        </div>
                        <p class="card-category">인증</p>
                    </div>

                    <div class="card-body">
                        <div class="row">

                            <div class="col-md-3">
                                <span class="blockquote blockquote-primary">보안카드 비밀번호 입력</span>
                                <!-- 보안카드 form 시작 -->
                                <form action="ssc" method="post">
                                    <input type="hidden" value="${nextPage }"/>
                                    <div class="form-group">
                                        <label for="">
														<span class="h4 text-danger">
															[${scd[0][0]}]
														</span>
                                            <span class="h5" style="font-style: italic;">
                                                ${scd[0][1]}
                                            </span>에서 두자리 </label>
                                        <input type="password" class="form-control" id="main_left" maxlength="2"
                                               name="main_code"
                                               placeholder="[일련번호] - ${scd[0][1] }에서 두자리">
                                    </div>
                                    <div class="form-group">
                                        <label for="email2">
														<span class="h4 text-danger">
															[${scd[1][0] }]
														</span>
                                            <span class="h5" style="font-style: italic;">
                                                ${scd[1][1] }
                                            </span>에서 두자리 </label>
                                        <input type="password" class="form-control" id="fir_left" maxlength="2"
                                               name="fir_code"
                                               placeholder="[${scd[1][0] }] - ${scd[1][1] }에서 두자리">
                                    </div>
                                    <div class="form-group">
                                        <label for="email2">
														<span class="h4 text-danger">
															[${scd[2][0] }]
														</span>
                                            <span class="h5" style="font-style: italic;">
                                                ${scd[2][1] }
                                            </span>에서 두자리 </label>
                                        <input type="password" class="form-control" id="sec_left" maxlength="2"
                                               name="sec_code"
                                               placeholder="[${scd[2][0] }] - ${scd[2][1] }에서 두자리">
                                    </div>
                                    <div class="card-action">
                                        <button type="button" class="btn btn-danger">취소</button>
                                        <input type="submit" class="btn btn-success" value="확인"/>
                                    </div>
                                </form>
                                <!-- 보안카드 form 끝 -->
                            </div>

                            <div class="col-md-9" style="text-align: center;">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th colspan="5" style="text-align: left;">
                                            <span class="h1">보안카드</span>
                                            <span class="h6" style="font-style: italic;">${name}님</span>
                                        </th>
                                        <th colspan="5" style="text-align: right;">
                                            <div class="form-group">
                                                <div class="input-group mb-3">
                                                    <div class="input-group-prepend">
																			<span class="input-group-text"
                                                                                  style="background-color: #2E9AFE; color: #ffffff;">일련번호</span>
                                                    </div>
                                                    <c:choose>
                                                        <c:when test="${scd[0][1]=='앞'}">
                                                            <input type="password" class="form-control" maxlength="2"
                                                                   name="main_code" id="main_right" placeholder="**">
                                                            <div class="input-group-append">
																					<span class="input-group-text"
                                                                                          style="font-size: 20px;">******</span>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="input-group-append">
																					<span class="input-group-text"
                                                                                          style="font-size: 20px;">******</span>
                                                            </div>
                                                            <input type="password" class="form-control" maxlength="2"
                                                                   name="main_code" id="main_right" placeholder="**">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <c:set var="code1" value="${scd[1][0] }"/>
                                        <c:set var="code2" value="${scd[2][0] }"/>

                                        <c:forEach begin="0" end="29" step="1" varStatus="i">
                                        <c:choose>
                                            <c:when test="${(i.index+1)==code1}">
                                                <td style="text-align: center; font-style: italic;
																background-color: #2E9AFE; color: #ffffff; font-size: 16px;">${i.index+1 }</td>
                                                <td style="text-align: center; font-size: 20px;
																color: #ffffff;">
                                                    <div class="form-group">
                                                        <div class="input-group">
                                                            <c:choose>
                                                                <c:when test="${scd[1][1]=='앞'}">
                                                                    <input type="password" class="form-control"
                                                                           maxlength="2"
                                                                           id="fir_right" name="fir_code">
                                                                    <div class="input-group-append">
                                                                        <span class="input-group-text">**</span>
                                                                    </div>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div class="input-group-prepend">
                                                                        <span class="input-group-text">**</span>
                                                                    </div>
                                                                    <input type="password" class="form-control"
                                                                           maxlength="2"
                                                                           id="fir_right" name="fir_code">
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </td>
                                            </c:when>
                                            <c:when test="${(i.index+1)==code2}">
                                                <td style="text-align: center; font-style: italic;
																background-color: #2E9AFE; color: #ffffff; font-size: 16px;">${i.index+1 }</td>
                                                <td style="text-align: center; font-size: 20px;
																color: #ffffff;">
                                                    <div class="form-group">
                                                        <div class="input-group">
                                                            <c:choose>
                                                                <c:when test="${scd[2][1]=='앞'}">
                                                                    <input type="password" class="form-control"
                                                                           maxlength="2"
                                                                           id="sec_right" name="sec_code">
                                                                    <div class="input-group-append">
                                                                        <span class="input-group-text">**</span>
                                                                    </div>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div class="input-group-prepend">
                                                                        <span class="input-group-text">**</span>
                                                                    </div>
                                                                    <input type="password" class="form-control"
                                                                           maxlength="2"
                                                                           id="sec_right" name="sec_code">
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td style="text-align: center; font-style: italic; background-color: #F2F2F2;">${i.index+1 }</td>
                                                <td style="text-align: center;">-</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:if test="${(i.index+1)%5==0 }">
                                    </tr>
                                    <tr>
                                        </c:if>
                                        </c:forEach>
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
    $(function () {
        var oldVal = null;
        /* 왼쪽 입력했을때 */
        $("#main_left").on("propertychange change keyup paste input", function () {
            var currentVal = $(this).val();
            if (currentVal == oldVal) {
                return;
            }
            oldVal = currentVal;
            $("#main_right").val($("#main_left").val());
        });

        $("#fir_left").on("propertychange change keyup paste input", function () {
            console.log("입력됨")
            var currentVal = $(this).val();
            if (currentVal == oldVal) {
                return;
            }
            oldVal = currentVal;
            $("#fir_right").val($("#fir_left").val());
        });
        $("#sec_left").on("propertychange change keyup paste input", function () {
            console.log("입력됨")
            var currentVal = $(this).val();
            if (currentVal == oldVal) {
                return;
            }
            oldVal = currentVal;
            $("#sec_right").val($("#sec_left").val());
        });
        /* 오른쪽 입력했을때 */
        $("#main_right").on("propertychange change keyup paste input", function () {
            var currentVal = $(this).val();
            if (currentVal == oldVal) {
                return;
            }
            oldVal = currentVal;
            $("#main_left").val($("#main_right").val());
        });
        $("#fir_right").on("propertychange change keyup paste input", function () {
            console.log("입력됨")
            var currentVal = $(this).val();
            if (currentVal == oldVal) {
                return;
            }
            oldVal = currentVal;
            $("#fir_left").val($("#fir_right").val());
        });
        $("#sec_right").on("propertychange change keyup paste input", function () {
            console.log("입력됨")
            var currentVal = $(this).val();
            if (currentVal == oldVal) {
                return;
            }
            oldVal = currentVal;
            $("#sec_left").val($("#sec_right").val());
        });

    })
</script>

