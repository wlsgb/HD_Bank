<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>


<div class="content">
    <!-- 상단의 푸른색 공간 시작 -->
    <div class="panel-header bg-primary-gradient">
        <div class="page-inner py-5">
            <div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
                <div>
                    <h2 class="text-white pb-2 fw-bold">HD Bank</h2>
                    <h5 class="text-white op-7 mb-2">어서오세요. HD Bank 메인 페이지입니다.</h5>
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
            <!-- 좌측 버튼 시작 -->
            <div class="col-md-2">
                <!-- 계좌 조회 -->
                <div class="card" id="checkBalance">
                    <div class="card-body pb-0">
                        <h2 class="mb-2">계좌 조회</h2>
                        <p class="text-muted">Check balance</p>
                    </div>
                </div>
                <!-- 계좌 조회 -->
                <!-- 계좌 이체 -->
                <div class="card" id="transfer">
                    <div class="card-body pb-0">
                        <h2 class="mb-2">계좌 이체</h2>
                        <p class="text-muted">Wire money</p>
                    </div>
                </div>
                <!-- 계좌 이체 -->
                <!-- 분석 -->
                <!-- <div class="card" id="analysis">
                    <div class="card-body pb-0">
                        <h2 class="mb-2">분석</h2>
                        <p class="text-muted">Analysis</p>
                    </div>
                </div> -->
                <!-- 분석 -->
                <!-- 환율 조회 -->
                <div class="card card-primary bg-primary-gradient">
                    <div class="card-body">
                        <h2 class="mb-2">환율 조회</h2>
                        <p class="d-flex justify-content-between pb-1 pt-1">Exchange rate</p>
                    </div>
                </div>
                <!-- 환율 조회 -->
            </div>
            <!-- 좌측 버튼 끝 -->
            <div class="col-md-10">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">환율 조회</h4>
                        <h4 class="card-title" id="erdatetarget">환율 조회</h4>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="multi-filter-select" class="display table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>통화명</th>
                                    <th>현찰사실때</th>
                                    <th>현찰파실때</th>
                                    <th>송금_전신환<br/>보내실때</th>
                                    <th>송금_전신환<br/>받으실때</th>
                                    <th>매매기준율</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>통화명</th>
                                    <th>현찰사실때</th>
                                    <th>현찰파실때</th>
                                    <th>송금_전신환<br/>보내실때</th>
                                    <th>송금_전신환<br/>받으실때</th>
                                    <th>매매기준율</th>
                                </tr>
                                </tfoot>
                                <tbody id="ex_datatable">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 우측 컨텐츠 끝 -->
        <!-- 페이지 레이아웃 끝 -->
    </div>
</div>

<script id="scriptTarget"></script>
<script>

    /* 페이지 이동 자바스크립트 시작 */
    $("#checkBalance").click(function () {
        location = "checkbalance";
    });
    $("#transfer").click(function () {
        location = "transfer";
    });
    $("#analysis").click(function () {
        location = "analysis";
    });
    $("#exchangeRate").click(function () {
        location = "exchangerate";
    });
    /* 페이지 이동 자바스크립트 끝 */

    $(function () {
        $.ajax({
            url: "exchangeRateJson",
            success: function (data) {
                var erj = decodeURIComponent(data);
                $("#scriptTarget").html(erj);
                for (var ele in exView) {
                    if (typeof (exView[ele]) === "string") {
                        $("#erdatetarget").html('<span class="h2">조회 기준일 : ' + '<span class="text-primary">' + exView[ele] + '</span></span>')
                    } else {
                        var html = "";
                        for (var ele2 in exView[ele]) {
                            html += "<tr>";
                            for (var e in exView[ele][ele2]) {
                                if (exView[ele][ele2][e] == "0.00") {
                                    html += "<td>" + "-" + "</td>";
                                } else {
                                    html += "<td>" + exView[ele][ele2][e] + "</td>";
                                }
                            }
                            html += "</tr>";
                        }
                        $("#ex_datatable").html(html)
                    }
                }
            }
        })
        setTimeout(function () {
            $('#basic-datatables').DataTable({});

            $('#multi-filter-select').DataTable({
                "pageLength": 5,
                initComplete: function () {
                    this.api().columns().every(function () {
                        var column = this;
                        var select = $('<select class="form-control"><option value=""></option></select>')
                            .appendTo($(column.footer()).empty())
                            .on('change', function () {
                                var val = $.fn.dataTable.util.escapeRegex(
                                    $(this).val()
                                );

                                column
                                    .search(val ? '^' + val + '$' : '', true, false)
                                    .draw();
                            });

                        column.data().unique().sort().each(function (d, j) {
                            select.append('<option value="' + d + '">' + d + '</option>')
                        });
                    });
                }
            });
        }, 500)

    })


</script>

