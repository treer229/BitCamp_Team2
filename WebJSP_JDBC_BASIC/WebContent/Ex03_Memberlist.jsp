<%@page import="kr.or.bit.utils.SingletonHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	/* 이 페이지는 admin만 접근가능 
	
	이 페이지는 회원 목록을 출력하는곳이다.
	- 관리자만 접근이 가능해야한다[userid == admin]
	- 로그인한 일반 사용자가 주소값을 외워서 접근 불가하게 해야한다. >> 로그인하도록
	
	
	고려사항 ( 권한 처리 코드가 여러 페이지에 사용 된다면 유지보수 )
		별도의 page 구성 ( include ...)
		
	*/
	%>
	<jsp:include page="/common/sessionCheck.jsp"></jsp:include>
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
				<!-- 회원 목록 출력하기
					관리자인경우 데이터를 볼수있다.
					목록 출력 >> 상세정보 별도 구성
					목록 : select id , ip from koreamember
					
					회원 데이터 (HTML과 결합) 출력 생성
					 -->
					 <%
					Connection conn =null;
					PreparedStatement pstmt = null;
					ResultSet rs = null; 
					
					try{
					   	conn = SingletonHelper.Conection("oracle");
					   	String sql = "select id,ip from koreamember";
					   	pstmt = conn.prepareStatement(sql);
					   	rs = pstmt.executeQuery();
					   	%>
					   	<table style = "width : 60%; height : 10%; margin-left: auto; margin-right: auto;
					   						text-align: center">
					   	<tr>
					   		<th colspan="4">회원 리스트</th>
					   	</tr>
					   	<% while(rs.next()){
					  %><tr>
					   		<td width = 30%>
					   			<a href ='Ex03_MemberDetail.jsp?id=<%= rs.getString("id")%>'>
					   			<%= rs.getString("id")%></a>
					   		</td>
					   		<td width = 30%><%=rs.getString("ip") %></td>
					   		<td width = 20%>
					   		<!-- 삭제 구현 -->
					   			<a href ='Ex03_MemberDelete.jsp?id=<%= rs.getString("id")%>'>[삭제]</a>
					   		</td>
					   		<td width = 25%>
					   		<a href ='Ex03_MemberEdit.jsp?id=<%= rs.getString("id")%>'>[수정]</a>
					   		</td>
					   	</tr>
					   	<%} 
					   	%>
					   	
					   	
					   	</table> 
					   	<hr>
					   		<div style = "text-align: center">
					   		<form action = "Ex03_MemberSearch.jsp" method = "post" >
					   			회원명 : <input type = "text" name = "search" placeholder="이름을 입력해주세요">
					   				   <input type = "submit" value = "검색" class = "btn btn-outline-secondary">
					   		</form>
					   		</div>
					   	<hr>
					   	
					   	
					   	<% 
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						SingletonHelper.Close(rs);
						SingletonHelper.Close(pstmt);
					}
					
					 %>
			
			</div>
		</div>

	</div>
			<div>
			<jsp:include page="/common/Bottom.jsp"></jsp:include>
</body>
</html>