<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<style>
    label {
        padding-top: 10px;
    }

    input[type="number"]::-webkit-outer-spin-button,
    input[type="number"]::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

</style>
<div class="content">
    <div class="panel-header bg-primary-gradient">
        <div class="page-inner py-5">
            <div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
                <div>
                    <h2 class="text-white pb-2 fw-bold">대출</h2>
                    <h5 class="text-white op-7 mb-2">
                        <a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
                        <span class="h2 mr-1"> > </span>
                        <a href="application" class="btn btn-white btn-sm btn-border mr-1">대출신청</a>
                    </h5>
                </div>
                <div class="ml-md-auto py-2 py-md-0">
                    <a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">빠른 페이지</a>
                    <a href="qna" class="btn btn-secondary btn-round">고객센터</a>
                </div>
            </div>
        </div>
    </div>
    <!--대출 신청   -->
    <form name="form1" method="post" class="form-horizontal">
        <div class="row mt--4">
            <div class="col-sm-6 col-md-2"></div>
            <div class="col-sm-6 col-md-8">
                <div class="card card-stats card-round">

                    <div class="card-body ">
                        <h1>대출 신청</h1>
                        <hr>
                        <h3>신청자 정보</h3>
                        <div class="form-group row">
                            <label for="name" class="col-2 control-label">이름</label>
                            <div class="col-10">
                                <input type="text" class="form-control" id="name" readonly="readonly"
                                       value="${member.mem_name }">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="name" class="col-2 control-label">이메일</label>
                            <div class="col-10">
                                <input type="text" class="form-control" id="name" readonly="readonly"
                                       value="${member.mem_email }">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="name" class="col-2 control-label">생년월일</label>
                            <div class="col-10">
                                <input type="text" class="form-control" id="name" readonly="readonly"
                                       value="${member.mem_birth }">
                            </div>
                        </div>

                        <input type="hidden" class="form-control" id="mem_code" name="mem_code"
                               value="${member.mem_code }">

                        <hr>
                        <h3>대출 정보</h3>
                        <div class="form-group row">
                            <label for="loanname" class="col-2 control-label">대출명</label>
                            <div class="col-10">
                                <input type="text" class="form-control" name="lp_name" id="lp_name" readonly="readonly"
                                       value="${vo.lp_name }">
                                <input type="hidden" name="lp_num" id="lp_num" value="${vo.lp_num }">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="interestrate" class="col-2">대출이율</label>
                            <div class="col-10">
                                <input type="text" class="form-control" id="interestrate" readonly="readonly"
                                       value="${vo.lp_interestrate }%">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="name" class="col-2 control-label">최대 대출 가능 금액</label>
                            <div class="col-10">
                                <input type="text" class="form-control" readonly="readonly" value="${vo.lp_maximum }원">
                            </div>

                        </div>

                        <div class="form-group row">
                            <label for="amount" class="col-2">대출 희망 금액</label>
                            <div class="col-6">
                                <input type="hidden" id="maximum" value="${vo.lp_maximum }">
                                <input type="text" class="form-control" name="la_hamount" id="la_hamount"
                                       placeholder="희망금액">
                            </div>
                            <div class="col-4">
                                <p id="target"></p>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="interestrate" class="col-2">희망대출일</label>
                            <div class="col-10">
                                <input type="date" name="la_startdate" id="la_startdate" class="form-control">
                            </div>
                        </div>


                        <div class="form-group row">
                            <label for="period" class="col-2">거치기간</label>
                            <div class="col-4">
                                <select class="form-control" id="la_livingterm" name="la_livingterm">
                                    <option value="0">없음</option>
                                    <option>1년</option>
                                    <option>2년</option>
                                    <option>3년</option>
                                </select>
                            </div>
                            <label for="period" class="col-2">상환기간</label>
                            <div class="col-4">
                                <select class="form-control" id="la_repayterm" name="la_repayterm">
                                    <option>1년</option>
                                    <option>2년</option>
                                    <option>3년</option>
                                    <option>5년</option>
                                    <option>10년</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="period" class="col-2">상환방법</label>
                            <div class="col-10">
                                <select class="form-control" id="lr_type" name="lr_type">
                                    <option>원리금균등상환</option>
                                    <option>원금균등상환</option>
                                    <option>만기일시상환</option>
                                </select>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-2"></div>

        </div>


        <p class="text-center">
            <button type="button" class="btn btn-info" onclick="application()">대출 신청</button>
        </p>
    </form>
</div>


<script>


    function application() {
        document.form1.action = "applicationsuccess"
        la_hampunt = $('#la_hamount').val().replace(/,/g, '')
        $('#la_hamount').val(la_hampunt)
        document.form1.submit()
    }


    $("#la_hamount").keyup(function () {
        x = $(this).val()
        x = x.replace(/[^0-9]/g, '');
        x = x.replace(/,/g, '');
        if (parseInt(x) > parseInt($('#maximum').val())) {
            alert('대출 가능 최대 금액을 초과해서 입력하셨습니다.')
            $(this).val($('#maximum').val().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
        } else {
            $(this).val(x.replace(/\B(?=(\d{3})+(?!\d))/g, ","));
        }


        var amount = parseInt($('#la_hamount').val().replace(/,/g, ''));
        var result = '';
        if (Math.floor(amount / 100000000) > 0) {
            result += (Math.floor(amount / 100000000) + '억')
        }
        if (Math.floor(amount / 10000) > 0 && amount < 100000000) {
            result += (Math.floor(amount / 10000) + '만')
        }
        if (amount > 0 && amount < 10000) {
            result += (amount + '원')
        }
        $('#target').html(result);


    });


    var date = new Date().toISOString().slice(0, 10);
    var dateSplit = date.split("-");
    var sysdate = new Date(dateSplit[0] + '/' + dateSplit[1] + '/' + dateSplit[2]);
    var startdate = new Date(dateSplit[0] + '/' + dateSplit[1] + '/' + dateSplit[2]);
    startdate.setDate(sysdate.getDate() + 8);
    var defaultdate = startdate.toISOString().slice(0, 10);
    $('#la_startdate').attr("value", defaultdate);

    $('#la_startdate').change(function () {
        var startdate = $('#la_startdate').val();
        var startdateSplit = startdate.split("-");
        var startDate = new Date(startdateSplit[0] + '/' + startdateSplit[1] + '/' + startdateSplit[2]);
        if (startDate < sysdate) {
            alert("희망대출일은 오늘 이전일 수 없습니다.")
            $(this).val(date);
            $(this).attr('value', date)
        }
    })

    $('form').on('focus', 'input[type=number]', function (e) {
        $(this).on('wheel.disableScroll', function (e) {
            e.preventDefault()
        })
    })
    $('form').on('blur', 'input[type=number]', function (e) {
        $(this).off('wheel.disableScroll')
    })
</script>


