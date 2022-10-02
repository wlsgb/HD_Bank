<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                            <span class="flaticon-home"/>
                        </a> <span class="h2 mr-1"> > </span> <a href="search"
                                                                 class="btn btn-white btn-sm btn-border mr-1">나의 1:1
                        문의하기</a>
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
    <form action="addquestion" accept-charset="euc-kr" method="post">
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
                                <table class="table mt-3">
                                    <thead>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>작성자</td>
                                        <td>
                                            <div class="col-xs-6"><input type="text" class="form-control"
                                                                         id="inlineinput" placeholder="이름"></div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>분류</td>
                                        <td>
                                            <div class="col-xs-6"><select class="form-control"
                                                                          id="inlineinput" name="cat_num"></div>
                                            <option>-분류선택-</option>
                                            <option value="1">예금</option>
                                            <option value="2">대출</option>
                                            <option value="3">회원정보</option>
                                            <option value="4">기타</option>
                                            </select>
                            </div>
                            </td>
                            </tr>

                            <tr>
                                <td>제목</td>
                                <td>
                                    <div class="col-xs-8"><input type="text" name="inq_title" class="form-control"
                                                                 id="inq_title" placeholder="입력 하시오.">
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
                                                   style="height: 200px;">
                                                <tbody>
                                                <tr valign="top">
                                                    <td><textarea class="form-control" name="inq_content"
                                                                  style="width: 700px; height: 1000px;"></textarea>
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
                                        <td><input type="submit" value="확인" class="btn btn-primary btn-round">
                                            <button class="btn btn-danger btn-round">취소</button>
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
</form>
</div>
<script>

</script>