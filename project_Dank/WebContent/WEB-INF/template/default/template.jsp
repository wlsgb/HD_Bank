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
<!-- ������������������������������������������� -->

<tiles:insertAttribute name="body"/>


			<!-- ������������������������������������������� -->
			<!-- ------------------------------------------ -->
			<!-- ------------------------------------------ -->
			<tiles:insertAttribute name="footer"/>
			<!-- ------------------------------------------ -->
			</div>   <!-- �����гδݱ� -->
			<!-- ------------------------------------------ -->
			</div> <!--�ٱ����۴ݱ�-->
			<!-- ------------------------------------------ -->
			<tiles:insertAttribute name="addjs"/>
			<!-- ------------------------------------------ -->
			<!-- ------------------------------------------ -->
			<!-- �������� �ش�Ǵ� script �����κ������������� -->
			
			
			
</body>
</html>
