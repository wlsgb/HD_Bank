<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
/*  폰트 적용 */
@import url('https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500&display=swap');

html {
    font-family: "Noto Sans KR", sans-serif;
}

/* 노말라이즈 */
body, ul, li, h1, h2, h3, h4, h5, p, figure {
    margin:0;
    padding:0;
    list-style:none;
}

a {
    color:inherit;
    text-decoration:none;
}

/* 라이브러리 */
.con {
    margin:0 auto;
}

.img-box > img {
    width:100%;
    display:block;
}

.row::after {
    content:"";
    display:block;
    clear:both;
}

.cell {
    float:left;
    box-sizing:border-box;
}

.cell-right {
    float:right;
    box-sizing:border-box;
}

.margin-0-auto {
    margin:0 auto;
}

.block {
    display:block;
}

.inline-block {
    display:inline-block;
}

.text-align-center {
    text-align:center;
}

.line-height-0-ch-only {
    line-height:0;
}

.line-height-0-ch-only > * {
    line-height:normal;
}

.relative {
    position:relative;
}

.absolute-left {
    position:absolute;
    left:0;
}

.absolute-right {
    position:absolute;
    right:0;
}

.absolute-middle {
    position:absolute;
    top:50%;
    transform:translateY(-50%);
}

.table {
    display:table;
}

.table-cell {
    display:table-cell;
}

input, button, select, fieldset {
    -webkit-border-radius: 0;
    border-radius: 0;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    border:0;
    background-color:transparent;
}

fieldset {
    padding:0;
    margin:0;
}

.blind, legend {
    overflow: hidden;
    position: absolute;
    width: 1px;
    height: 1px;
    font-size: 12px;
    clip: rect(1px, 1px, 1px, 1px);
}

button {
    cursor:pointer;
    padding:0;
    font-size:inherit;
}

/* 커스텀 */
.con {
    max-width:1440px;
}

.con-min-width {
    min-width:320px;
}

html {
    overflow-x:hidden;
}

body {
    height:5000px;
}

/* 메인 배너 슬라이더 */
.slider-wrap {
    position:relative;
}

.main-slider {
    position:relative;
    margin-bottom:0 !important;
}

.main-slider .slide-item .slide-con {
    position:relative;
}

.main-slider .slide-item > .slide-con > .slide-txt {
    position:absolute;
    top:50%;
    transform:translatey(-50%);
    padding-left:10%;
    z-index:50;
}

.main-slider .slide-item-1 > .slide-con > .slide-txt {
    left:50%;
    transform:translatex(-50%);
    padding:0;
    text-align:center;
}

.main-slider .slide-item > .slide-con > .slide-txt > h2.txt-tt {
    font-size:48px;
}

.main-slider .slide-item > .slide-con > .slide-txt > p.txt-desc {
    font-size:18px;
    font-weight:300;
    margin-top:16px;
}

.main-slider .slide-item > .slide-con > .slide-txt > .txt-btn {
    margin-top:46px;
}

.main-slider .slide-item > .slide-con > .slide-txt > .txt-btn > a {
    font-size:14px;
    display:inline-block;
}

.main-slider .slide-item > .slide-con > .slide-txt > .txt-btn > a.txt-btn-1 {
    position:relative;
    margin-right:31px;
}

.main-slider .slide-item > .slide-con > .slide-txt > .txt-btn > a.txt-btn-1::after {
    content:"";
    width:0;
    height:1px;
    position:absolute;
    left:50%;
    bottom:0;
    transform:translatex(-50%);
    background-color:#555;
}

.main-slider .slick-active .slide-item .slide-txt > .txt-btn > a.txt-btn-1::after {
    animation:more-btm-line 1s 1 .2s;
    animation-fill-mode: forwards;
}

.main-slider .slick-active .slide-item .slide-txt > .txt-btn > a.txt-btn-1:hover::after {
    animation:more-btm-line-hover 1s 1;
    animation-fill-mode: forwards;
}

@keyframes more-btm-line {
    0%{
        width:0;
    }
    100%{
        width:100%;
    }
}

@keyframes more-btm-line-hover {
    0%{
        width:0;
    }
    100%{
        width:100%;
    }
}


.main-slider .slide-item > .slide-con > .slide-txt > .txt-btn > a.txt-btn-2 {
    padding:12px 38px;
    border:1px solid #555;
    border-radius:45px;
    line-height:1;
    letter-spacing:.05rem;
    color:#555;
    transition:all .5s;
}

.main-slider .slide-item > .slide-con > .slide-txt > .txt-btn > a.txt-btn-2:hover {
    background-color:#555;
    color:#fff;
}

/* 사이드 버튼 */
.main-slider .slick-arrow {
    position:absolute;
    top:50%;
    left:24px;
    transform:translatey(-50%);
    display:block;
    z-index:50;
}

.main-slider .slick-arrow::before {
    content:"";
    display:block;
    width:35px;
    height:55px;
    opacity:1;
}

.main-slider .slick-next {
    left:auto;
    right:24px;
}

.main-slider .slick-prev::before {
    background:url('https://kimyang-sun.github.io/pf-img/samsung-img/arrow_icon_kv_l_b.svg') no-repeat center;
}

.main-slider .slick-next::before {
    background:url('https://kimyang-sun.github.io/pf-img/samsung-img/arrow_icon_kv_r_b.svg') no-repeat center;
}

/* 페이지 버튼 */
.main-slider .slick-dots {
    font-size:0;
    position:absolute;
    left:50%;
    bottom:20px;
    transform:translatex(-50%);
    width:54%;
    z-index:50;
}

.main-slider .slick-dots::after {
    content:"";
    display:block;
    clear:both;
}

.main-slider .slick-dots > li {
    width:20%;
    height:auto;
    padding-left:16px;
    margin:0;
    box-sizing:border-box;
    float:left;
}

.main-slider .slick-dots > li > button {
    width:100%;
    height:2px;
    background-color:rgba(0,0,0,.3);
    outline:none;
    position:relative;
    padding:0;
    color:inherit;
    line-height:normal;
}

.main-slider .slick-dots > li > button::before {
    display:none;
}

.main-slider .slick-dots > li > button > .s-line-fill {
    content:"";
    width:0;
    height:2px;
    background-color:#000;
    position:absolute;
    top:0;
    left:0;
    opacity:1;
}

.slider-wrap .slick-dots .slick-active > button > .s-line-fill {
    animation:slick-progressbar 4s 1;
    animation-fill-mode: forwards;
}

.slider-wrap[data-slick-autoplay-status="N"] .slick-dots .slick-active > button > .s-line-fill {
    animation-play-state:paused;
}

@keyframes slick-progressbar {
    0% {
        width:0%;
    }
    100% {
        width:100%;
    }
}

/* 페이지 버튼 인디케이터 */
.main-slider .slick-dots > li > button > .s-indicator {
    position:absolute;
    left:50%;
    bottom:0;
    transform:translatex(-50%);
    width:110%;
    overflow:hidden;
}

.main-slider .slick-dots > li > button > .s-indicator > .inner-txt {
    font-size:15px;
    font-weight:bold;
    white-space:nowrap;
    display:block;
    width:100%;
    transform:translatey(100%);
    opacity:0;
    transition:all .8s;
}

.main-slider .slick-dots > li > button:hover > .s-indicator > .inner-txt {
    transform:translatey(0);
    opacity:1;
    padding-bottom:5px;
}

/* 오토플레이 버튼 */
.slider-wrap .s-autoplay-btn {
    width:12px;
    height:12px;
    position:absolute;
    left:79%;
    bottom:15px;
    z-index:50;
}

.slider-wrap[data-slick-autoplay-status="Y"] .s-autoplay-btn {
    background:url('https://kimyang-sun.github.io/pf-img/samsung-img/new-home-ico-pause-black.svg') no-repeat;
    background-size:contain;
}

.slider-wrap[data-slick-autoplay-status="N"] .s-autoplay-btn {
    background:url('https://kimyang-sun.github.io/pf-img/samsung-img/new-home-ico-play-black.svg') no-repeat;
    background-size:contain;
}

.slider-wrap .slide-dummy {
    position:absolute;
    top:0;
    left:0;
    width:100%;
    height:90%;
}

/* 메인 슬라이더 반응형 */
@media (max-width:1440px){
    .main-slider .slide-item > .slide-con > .slide-txt > h2.txt-tt {
        font-size:3.33vw;
    }

    .main-slider .slide-item > .slide-con > .slide-txt > p.txt-desc {
        font-size:1.25vw;
        margin-top:1vw;
    }
    
    .main-slider .slide-item > .slide-con > .slide-txt > .txt-btn {
        margin-top:3vw
    }
    
    .main-slider .slide-item > .slide-con > .slide-txt > .txt-btn > a.txt-btn-1 {
        font-size:1vw;
        margin-right:2vw;
    }
    
    .main-slider .slide-item > .slide-con > .slide-txt > .txt-btn > a.txt-btn-2 {
        font-size:0.95vw;
        padding:0.8vw 2.5vw;
    }
    
</style>
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
				<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
							<div class="card-body" style="overflow: hidden;">
				<div class="slider-wrap con" data-slick-autoplay-status="Y">
    <div class="slider main-slider con">
        <div class="slide-item slide-item-1" data-dot-title="HDBANK">
            <div class="slide-con">
                <div class="slide-dummy"></div>
                <div class="slide-txt">
                    <h2 class="txt-tt">소상공인 지원</h2>
                    <p class="txt-desc">코로나 19 소상공인 지원.</p>
                    <div class="txt-btn">
                        <a href="#" class="txt-btn-2">소상공인 지원 더보기</a>
                    </div>
                </div>
                <picture class="img-box">
                    <source srcset="resources/img/mainIMG/test8.jpg" media="(max-width: 770px)">
                    <img src="resources/img/mainIMG/test8.jpg" alt="">
                </picture>
            </div>
        </div>
        <div class="slide-item slide-item-2" data-dot-title="HDBANK">
            <div class="slide-con">
                <div class="slide-dummy"></div>
                <div class="slide-txt">
                    <h2 class="txt-tt" style="color:black;">HDBANK</h2>
                    <p class="txt-desc" style="color:black;">언제나 함께하는 동반자. HDbank</p>
                    <div class="txt-btn">
                        <a href="#" class="txt-btn-1" style="color:black;">고객 서비스</a>
                        <a href="#" class="txt-btn-2" style="color:black;">은행 정보</a>
                    </div>
                </div>
                <picture class="img-box">
                    <source srcset="resources/img/mainIMG/test5.jpg" media="(max-width: 770px)">
                    <img src="resources/img/mainIMG/test5.jpg" alt="">
                </picture>
            </div>
        </div>
        <div class="slide-item slide-item-3" data-dot-title="금융서비스">
            <div class="slide-con">
                <div class="slide-dummy"></div>
                <div class="slide-txt">
                    <h2 class="txt-tt txt-tt-book"style="color:black;">비대면 계좌서비스</h2>
                    <p class="txt-desc"style="color:black;">컴퓨터만 있다면 언제 어디서든!</p>
                    <div class="txt-btn">
                        <a href="#" class="txt-btn-1"style="color:black;">더 알아보기</a>
                        <a href="#" class="txt-btn-2"style="color:black;">계좌 확인하기</a>
                    </div>
                </div>
                <picture class="img-box">
                    <source srcset="resources/img/mainIMG/test4.jpg" media="(max-width: 770px)">
                    <img src="resources/img/mainIMG/test4.jpg" alt="">
                </picture>
            </div>
        </div>
        <div class="slide-item slide-item-4" data-dot-title="대출서비스">
            <div class="slide-con">
                <div class="slide-dummy"></div>
                <div class="slide-txt">
                    <h2 class="txt-tt"style="color:black;">든든한 대출 서비스</h2>
                    <p class="txt-desc"style="color:black;">빠른 대출 신청으로 쉽고 빠르게</p>
                    <div class="txt-btn">
                        <a href="#" class="txt-btn-1"style="color:black;">더 알아보기</a>
                        <a href="#" class="txt-btn-2"style="color:black;">대출 바로가기</a>
                    </div>
                </div>
                <picture class="img-box">
                    <source srcset="resources/img/mainIMG/test6.jpg" media="(max-width: 770px)">
                    <img src="resources/img/mainIMG/test6.jpg" alt="">
                </picture>
            </div>
        </div>
        <div class="slide-item slide-item-5" data-dot-title="주식서비스">
            <div class="slide-con">
                <div class="slide-dummy"></div>
                <div class="slide-txt">
                    <h2 class="txt-tt"style="color:black;">전문적인 주식 분석</h2>
                    <p class="txt-desc"style="color:black;">핸드폰에 주식을 담다. HDSTOCK</p>
                    <div class="txt-btn">
                        <a href="#" class="txt-btn-1"style="color:black;">더 알아보기</a>
                        <a href="#" class="txt-btn-2"style="color:black;">모바일 웹 이동</a>
                    </div>
                </div>
                <picture class="img-box">
                    <source srcset="resources/img/mainIMG/test7.jpg" media="(max-width: 770px)">
                    <img src="resources/img/mainIMG/test7.jpg" alt="">
                </picture>
            </div>
        </div>
    </div>
    <button class="s-autoplay-btn"></button>
</div>
						</div>
									</div>
								</div>
							</div>
				<div class="page-inner mt--5">
				<!-- 페이지 레이아웃 시작 -->
				<div class="row">
						<div class="col-4" id="checkBalance">
							<div class="card card-stats card-primary card-round">
								<div class="card-body">
									<div class="row">
										<div class="col-5">
											<div class="icon-big text-center">
												<i class="fas fa-dollar-sign"></i>
											</div>
										</div>
										<div class="col-7 col-stats">
											<div class="numbers">
												<p class="card-category">Check balance</p>
												<h4 class="card-title">계좌 조회</h4>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-4" id="transfer">
							<div class="card card-stats card-info card-round">
								<div class="card-body">
									<div class="row">
										<div class="col-5">
											<div class="icon-big text-center">
												<i class="fas fa-file-invoice-dollar"></i>
											</div>
										</div>
										<div class="col-7 col-stats">
											<div class="numbers">
												<p class="card-category">Wire money</p>
												<h4 class="card-title">계좌 이체</h4>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- <div class="col-sm-6 col-md-3" id="analysis">
							<div class="card card-stats card-success card-round">
								<div class="card-body ">
									<div class="row">
										<div class="col-5">
											<div class="icon-big text-center">
												<i class="fas fa-chart-pie"></i>
											</div>
										</div>
										<div class="col-7 col-stats">
											<div class="numbers">
												<p class="card-category">Analysis</p>
												<h4 class="card-title">분석</h4>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div> -->
						<div class="col-4" id="exchangeRate">
							<div class="card card-stats card-secondary card-round">
								<div class="card-body ">
									<div class="row">
										<div class="col-5">
											<div class="icon-big text-center">
												<i class="flaticon-success"></i>
											</div>
										</div>
										<div class="col-7 col-stats">
											<div class="numbers">
												<p class="card-category">Exchange rate</p>
												<h4 class="card-title">환율 조회</h4>
											</div>
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

		
	window.onload = function() {
		console.clear();

		// 상단 메인 배너 slick
		$('.main-slider').slick({
		    dots:true,
		    fade:true,
		    customPaging: function(slider, i) { 
		        //console.log($(slider.$slides[i]).html());
		        return '<button class="tab"><div class="s-indicator only-pc"><span class="inner-txt">' + $(slider.$slides[i]).find('.slide-item').attr('data-dot-title') + '</span></div><span class="s-line-fill"></span></button>';
		    },
		});

		// 마우스 더미에 올렸을 때 멈추도록
		$('.slide-dummy, .slide-txt').mouseenter(function() {
		    $(this).closest('.slider-wrap').attr('data-slick-autoplay-status', 'N');
		});

		$('.slide-dummy').mouseleave(function() {
		    $(this).closest('.slider-wrap').attr('data-slick-autoplay-status', 'Y');
		});

		// 재생 및 정지 버튼 클릭
		$('.s-autoplay-btn').click(function(){
		    var $sliderWrap = $(this).parent();
		    
		    if ( $sliderWrap.attr('data-slick-autoplay-status') == 'Y' ){
		        $sliderWrap.attr('data-slick-autoplay-status', 'N');
		    }
		    else if ( $sliderWrap.attr('data-slick-autoplay-status') == 'N' ){
		        $sliderWrap.attr('data-slick-autoplay-status', 'Y');
		    }
		})

		// progressbar 다 차면 슬라이드 시키기
		setInterval(function() {
		    $('.slider-wrap > .main-slider').each(function(index, node) {
		        var $slider = $(node);
		        
		        if ( $slider.parent().attr('data-slick-autoplay-status') !== 'N' ) {
		            var width = $slider.find('.slick-dots .slick-active > button > .s-line-fill').css('width');
		            var buttonWidth = $slider.find('.slick-dots .slick-active > button').css('width');
		            
		            //console.log(width);
		            if ( width == buttonWidth ) {
		                $slider.slick('slickNext');
		            }
		        }
		    });
		}, 500);
	}
		
	
		/* 페이지 이동 자바스크립트 시작 */
		$("#checkBalance").click(function() {
			location = "checkbalance";
		});
		$("#transfer").click(function() {
			location = "transfer";
		});
		$("#analysis").click(function() {
			location = "analysis";
		});
		$("#exchangeRate").click(function() {
			location = "exchangerate";
		});
		/* 페이지 이동 자바스크립트 끝 */
	
	</script>
