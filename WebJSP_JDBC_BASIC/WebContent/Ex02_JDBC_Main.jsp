<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style type="text/css">
tr {
	border: solid 1px Lightgray;
	background-color: white;
	color: black;
}

td {
	border: solid 1px Lightgray;
}
th { 
	text-align: center;
}
#hoguma {
width : 196px; 
height : 256px; 
list-style-type: none; 
padding : 0;
}
#hoguma a:link {
color: gray;
background-color: transparent;
text-decoration: none;
}

#hoguma a:visited {
color: gray;
background-color: transparent;
text-decoration: none;
}
#hoguma a:hover {
color : black;
}
</style>
</head>
<body>
			<div
		style="width: 100%; height: 100%; margin-left: auto; margin-right: auto;
			 border-collapse: collapse;">
		<div style = "height : 100px">
			
				<jsp:include page="/common/Top.jsp"></jsp:include>
			
		</div>
		<div style = "column-count: 2">
			<div style = "width : 25% ;">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</div>
			<div style = "position : relative ; right: 50%">
				<div style = "height : 280px">
				
				</div>
				<!-- MAIN PAGE CONTENT  -->
				<%
					String id = null;
					id = (String)session.getAttribute("userid");
					if(id != null){
						out.print(id + "님의 방문을 환영합니다.");
						if(id.equals("admin")){
							out.print("<br><a href = 'Ex03_Memberlist.jsp'>회원관리</a>");
						}
					}else {
						out.print("<script>location.href = 'Ex02_JDBC_Login.jsp'</script>");
					}
				%>
				
			</div>
		</div>
		
			
	</div>
	<div>
	<jsp:include page="/common/Bottom.jsp"></jsp:include>
		
</body>
</html>