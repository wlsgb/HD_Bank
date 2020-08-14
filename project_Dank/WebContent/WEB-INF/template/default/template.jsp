<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
      <%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!-- ------------------------------------------ -->
<tiles:insertAttribute name="beforeBody"/>
<!-- ------------------------------------------ -->
<div class="wrapper">
<!-- ------------------------------------------ -->
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="sidebar"/>
<!-- ------------------------------------------ -->
<div class="main-panel">
<!-- ------------------------------------------ -->
<!-- ------------------------------------------ -->
<!-- ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼ -->

<tiles:insertAttribute name="body"/>


			<!-- ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲ -->
			<!-- ------------------------------------------ -->
			<!-- ------------------------------------------ -->
			<tiles:insertAttribute name="footer"/>
			<!-- ------------------------------------------ -->
			</div>   <!-- 메인패널닫기 -->
			<!-- ------------------------------------------ -->
			</div> <!--바깥래퍼닫기-->
			<!-- ------------------------------------------ -->
			<!-- <script>
			window.onload = function() {
				<tiles:insertAttribute name="addjs"/>
			}
			</script> -->
			<!-- ------------------------------------------ -->
			<!-- ------------------------------------------ -->
			<!-- ▽▽▽▽▽▽▽ 해당되는 script 밑으로복사▽▽▽▽▽▽▽▽▽▽ -->
			<script src="resources/js/core/jquery.3.2.1.min.js"></script> 
	
	<script src="resources/js/core/popper.min.js"></script>
	<script src="resources/js/core/bootstrap.min.js"></script>

	<!-- jQuery UI -->
	<script src="resources/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="resources/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

	<!-- jQuery Scrollbar -->
	<script src="resources/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>


	<!-- Chart JS -->
	<script src="resources/js/plugin/chart.js/chart.min.js"></script>

	<!-- jQuery Sparkline -->
	<script src="resources/js/plugin/jquery.sparkline/jquery.sparkline.min.js"></script>

	<!-- Chart Circle -->
	<script src="resources/js/plugin/chart-circle/circles.min.js"></script>

	<!-- Datatables -->
	<script src="resources/js/plugin/datatables/datatables.min.js"></script>

	<!-- Bootstrap Notify -->
	<script src="resources/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>

	<!-- jQuery Vector Maps -->
	<script src="resources/js/plugin/jqvmap/jquery.vmap.min.js"></script>
	<script src="resources/js/plugin/jqvmap/maps/jquery.vmap.world.js"></script>

	<!-- Sweet Alert -->
	<script src="resources/js/plugin/sweetalert/sweetalert.min.js"></script>

	<!-- Atlantis JS -->
	<script src="resources/js/atlantis.min.js"></script>
			

			
</body>
<script>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
// 				setInterval(function() {
=======
/* setInterval(function() {
	
	$.ajax({
		url:"atloadval",
		success:function(data1){
			
			$.each(data1, function(index, item) {
				
				var nowtimehour =String(new Date().getHours());
				var nowtimeminute = String(new Date().getMinutes());
				
				if (nowtimehour.length < 2) nowtimehour = '0' + nowtimehour;
				if (nowtimeminute.length < 2) nowtimeminute = '0' + nowtimeminute;
				
				var nowtimeyear = String(new Date().getFullYear());
				var nowtimemonth = String(new Date().getMonth()+1);
				var nowtimedate = String(new Date().getDate());
				
				if (nowtimemonth.length < 2) nowtimemonth = '0' + nowtimemonth;
				if (nowtimedate.length < 2) nowtimedate = '0' + nowtimedate;
														
				let myac = item.ac_num;
				let yourac = item.ata_yourac;
				let youracmem = item.ata_yourmemcode;
				let trmoney = item.ata_setmoney;
				let youracwrite =encodeURI(item.ata_youracmemo,"UTF-8");
				let myacwrite = encodeURI(item.ata_myacmemo,"UTF-8");
				let memcode = item.ata_mymemcode;
				let atacode = item.ata_code;
				
				var ajax2param = new Object();
				ajax2param.myac = myac;
				ajax2param.yourac = yourac;
				ajax2param.youracmem = youracmem;
				ajax2param.trmoney = trmoney;
				ajax2param.youracwrite = youracwrite;
				ajax2param.myacwrite = myacwrite;
				ajax2param.memcode = memcode;
				ajax2param.atacode = atacode;
>>>>>>> refs/remotes/origin/master
					
<<<<<<< HEAD
// 					$.ajax({
// 						url:"atloadval",
// 						success:function(data1){
							
// 							$.each(data1, function(index, item) {
								
// 								var nowtimehour =String(new Date().getHours());
// 								var nowtimeminute = String(new Date().getMinutes());
								
// 								if (nowtimehour.length < 2) nowtimehour = '0' + nowtimehour;
// 								if (nowtimeminute.length < 2) nowtimeminute = '0' + nowtimeminute;
								
// 								var nowtimeyear = String(new Date().getFullYear());
// 								var nowtimemonth = String(new Date().getMonth()+1);
// 								var nowtimedate = String(new Date().getDate());
								
// 								if (nowtimemonth.length < 2) nowtimemonth = '0' + nowtimemonth;
// 								if (nowtimedate.length < 2) nowtimedate = '0' + nowtimedate;
																		
// 								let myac = item.ac_num;
// 								let yourac = item.ata_yourac;
// 								let youracmem = item.ata_yourmemcode;
// 								let trmoney = item.ata_setmoney;
// 								let youracwrite =encodeURI(item.ata_youracmemo,"UTF-8");
// 								let myacwrite = encodeURI(item.ata_myacmemo,"UTF-8");
// 								let memcode = item.ata_mymemcode;
// 								let atacode = item.ata_code;
								
// 								var ajax2param = new Object();
// 								ajax2param.myac = myac;
// 								ajax2param.yourac = yourac;
// 								ajax2param.youracmem = youracmem;
// 								ajax2param.trmoney = trmoney;
// 								ajax2param.youracwrite = youracwrite;
// 								ajax2param.myacwrite = myacwrite;
// 								ajax2param.memcode = memcode;
// 								ajax2param.atacode = atacode;
									
// 								let ajaxtimearr = String(item.ata_time).split(":");
// 								let ajaxdatearr = String(item.ata_startdate).split("-");
									
// 								if(parseInt(ajaxdatearr[0]) <= parseInt(nowtimeyear)){
// 									if(parseInt(ajaxdatearr[1]) <= parseInt(nowtimemonth)){	
// 										if(parseInt(ajaxdatearr[2]) < parseInt(nowtimedate)){
// 										}else if(parseInt(ajaxdatearr[2]) === parseInt(nowtimedate)){
// 											if(parseInt(ajaxtimearr[0]) < parseInt(nowtimehour)){
// 											}else if(parseInt(ajaxtimearr[0]) === parseInt(nowtimehour)){
// 												if(parseInt(ajaxtimearr[1]) < parseInt(nowtimeminute)){									
// 												}else if(parseInt(ajaxtimearr[1]) === parseInt(nowtimeminute)){
// 													console.log('time is 자동이체')
// 													///////////////////////
// 													$.ajax({
// 														type:"POST",
// 														url:"atprocess",
// 														dataType:"json",
// 														data:JSON.parse(JSON.stringify(ajax2param)),
// 														success: function(){
// 															console.log("서블릿으로 보냄 ^^")
// 														}
// 													})
// 													/////////////////////
// 												}
// 											}
// 										}else if(parseInt(ajaxdatearr[2]) >= parseInt(nowtimedate)){	
// 										}
// 									}else {						
// 									}
// 								}else {			
// 								}
// 							})
// 						}
// 					})	
// 				}, 5000)
=======
				let ajaxtimearr = String(item.ata_time).split(":");
				let ajaxdatearr = String(item.ata_startdate).split("-");
					
				if(parseInt(ajaxdatearr[0]) <= parseInt(nowtimeyear)){
					if(parseInt(ajaxdatearr[1]) <= parseInt(nowtimemonth)){	
						if(parseInt(ajaxdatearr[2]) < parseInt(nowtimedate)){
						}else if(parseInt(ajaxdatearr[2]) === parseInt(nowtimedate)){
							if(parseInt(ajaxtimearr[0]) < parseInt(nowtimehour)){
							}else if(parseInt(ajaxtimearr[0]) === parseInt(nowtimehour)){
								if(parseInt(ajaxtimearr[1]) < parseInt(nowtimeminute)){									
								}else if(parseInt(ajaxtimearr[1]) === parseInt(nowtimeminute)){
									console.log('time is 자동이체')
									///////////////////////
									$.ajax({
										type:"POST",
										url:"atprocess",
										dataType:"json",
										data:JSON.parse(JSON.stringify(ajax2param)),
										success: function(){
											console.log("서블릿으로 보냄 ^^")
										}
									})
									/////////////////////
								}
							}
						}else if(parseInt(ajaxdatearr[2]) >= parseInt(nowtimedate)){	
						}
					}else {						
					}
				}else {			
				}
			})
		}
	})	
}, 5000) */
>>>>>>> refs/remotes/origin/master

// ///////////////////////////////////////////////////
=======
setInterval(function() {
=======
// 				setInterval(function() {
=======
/* setInterval(function() {
>>>>>>> refs/remotes/origin/backupmaster
	
	$.ajax({
		url:"atloadval",
		success:function(data1){
			
			$.each(data1, function(index, item) {
				
				var nowtimehour =String(new Date().getHours());
				var nowtimeminute = String(new Date().getMinutes());
				
				if (nowtimehour.length < 2) nowtimehour = '0' + nowtimehour;
				if (nowtimeminute.length < 2) nowtimeminute = '0' + nowtimeminute;
				
				var nowtimeyear = String(new Date().getFullYear());
				var nowtimemonth = String(new Date().getMonth()+1);
				var nowtimedate = String(new Date().getDate());
				
				if (nowtimemonth.length < 2) nowtimemonth = '0' + nowtimemonth;
				if (nowtimedate.length < 2) nowtimedate = '0' + nowtimedate;
														
				let myac = item.ac_num;
				let yourac = item.ata_yourac;
				let youracmem = item.ata_yourmemcode;
				let trmoney = item.ata_setmoney;
				let youracwrite =encodeURI(item.ata_youracmemo,"UTF-8");
				let myacwrite = encodeURI(item.ata_myacmemo,"UTF-8");
				let memcode = item.ata_mymemcode;
				let atacode = item.ata_code;
				
				var ajax2param = new Object();
				ajax2param.myac = myac;
				ajax2param.yourac = yourac;
				ajax2param.youracmem = youracmem;
				ajax2param.trmoney = trmoney;
				ajax2param.youracwrite = youracwrite;
				ajax2param.myacwrite = myacwrite;
				ajax2param.memcode = memcode;
				ajax2param.atacode = atacode;
>>>>>>> refs/remotes/origin/master
					
<<<<<<< HEAD
// 					$.ajax({
// 						url:"atloadval",
// 						success:function(data1){
							
// 							$.each(data1, function(index, item) {
								
// 								var nowtimehour =String(new Date().getHours());
// 								var nowtimeminute = String(new Date().getMinutes());
								
// 								if (nowtimehour.length < 2) nowtimehour = '0' + nowtimehour;
// 								if (nowtimeminute.length < 2) nowtimeminute = '0' + nowtimeminute;
								
// 								var nowtimeyear = String(new Date().getFullYear());
// 								var nowtimemonth = String(new Date().getMonth()+1);
// 								var nowtimedate = String(new Date().getDate());
								
// 								if (nowtimemonth.length < 2) nowtimemonth = '0' + nowtimemonth;
// 								if (nowtimedate.length < 2) nowtimedate = '0' + nowtimedate;
																		
// 								let myac = item.ac_num;
// 								let yourac = item.ata_yourac;
// 								let youracmem = item.ata_yourmemcode;
// 								let trmoney = item.ata_setmoney;
// 								let youracwrite =encodeURI(item.ata_youracmemo,"UTF-8");
// 								let myacwrite = encodeURI(item.ata_myacmemo,"UTF-8");
// 								let memcode = item.ata_mymemcode;
// 								let atacode = item.ata_code;
								
// 								var ajax2param = new Object();
// 								ajax2param.myac = myac;
// 								ajax2param.yourac = yourac;
// 								ajax2param.youracmem = youracmem;
// 								ajax2param.trmoney = trmoney;
// 								ajax2param.youracwrite = youracwrite;
// 								ajax2param.myacwrite = myacwrite;
// 								ajax2param.memcode = memcode;
// 								ajax2param.atacode = atacode;
									
// 								let ajaxtimearr = String(item.ata_time).split(":");
// 								let ajaxdatearr = String(item.ata_startdate).split("-");
									
// 								if(parseInt(ajaxdatearr[0]) <= parseInt(nowtimeyear)){
// 									if(parseInt(ajaxdatearr[1]) <= parseInt(nowtimemonth)){	
// 										if(parseInt(ajaxdatearr[2]) < parseInt(nowtimedate)){
// 										}else if(parseInt(ajaxdatearr[2]) === parseInt(nowtimedate)){
// 											if(parseInt(ajaxtimearr[0]) < parseInt(nowtimehour)){
// 											}else if(parseInt(ajaxtimearr[0]) === parseInt(nowtimehour)){
// 												if(parseInt(ajaxtimearr[1]) < parseInt(nowtimeminute)){									
// 												}else if(parseInt(ajaxtimearr[1]) === parseInt(nowtimeminute)){
// 													console.log('time is 자동이체')
// 													///////////////////////
// 													$.ajax({
// 														type:"POST",
// 														url:"atprocess",
// 														dataType:"json",
// 														data:JSON.parse(JSON.stringify(ajax2param)),
// 														success: function(){
// 															console.log("서블릿으로 보냄 ^^")
// 														}
// 													})
// 													/////////////////////
// 												}
// 											}
// 										}else if(parseInt(ajaxdatearr[2]) >= parseInt(nowtimedate)){	
// 										}
// 									}else {						
// 									}
// 								}else {			
// 								}
// 							})
// 						}
// 					})	
// 				}, 5000)
=======
				let ajaxtimearr = String(item.ata_time).split(":");
				let ajaxdatearr = String(item.ata_startdate).split("-");
					
				if(parseInt(ajaxdatearr[0]) <= parseInt(nowtimeyear)){
					if(parseInt(ajaxdatearr[1]) <= parseInt(nowtimemonth)){	
						if(parseInt(ajaxdatearr[2]) < parseInt(nowtimedate)){
						}else if(parseInt(ajaxdatearr[2]) === parseInt(nowtimedate)){
							if(parseInt(ajaxtimearr[0]) < parseInt(nowtimehour)){
							}else if(parseInt(ajaxtimearr[0]) === parseInt(nowtimehour)){
								if(parseInt(ajaxtimearr[1]) < parseInt(nowtimeminute)){									
								}else if(parseInt(ajaxtimearr[1]) === parseInt(nowtimeminute)){
									console.log('time is 자동이체')
									///////////////////////
									$.ajax({
										type:"POST",
										url:"atprocess",
										dataType:"json",
										data:JSON.parse(JSON.stringify(ajax2param)),
										success: function(){
											console.log("서블릿으로 보냄 ^^")
										}
									})
									/////////////////////
								}
							}
						}else if(parseInt(ajaxdatearr[2]) >= parseInt(nowtimedate)){	
						}
					}else {						
					}
				}else {			
				}
			})
		}
	})	
}, 5000) */
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
///////////////////////////////////////////////////
>>>>>>> branch 'hov2' of https://github.com/wlsgb/HD_Bank.git
=======
// ///////////////////////////////////////////////////
>>>>>>> refs/remotes/origin/backupmaster
</script>
</html>
