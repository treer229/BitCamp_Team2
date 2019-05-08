<%@page import="kr.or.bit.utils.SingletonHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 권한처리 -->
<jsp:include page="/common/sessionCheck.jsp"></jsp:include>
<%
	/* 회원 상세 페이지
	1. 권한검사
	2. ID값 받기 (where id ='hong') (id 컬럽 PK) >> request.getParameter("id");
	3. select id , pwd , name , age ,gender ,email from koreamember where id = ?
	4. id primary key 데이터 한것 : 하나의 row
	5. 화면 구성 ()
	*/
%>

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
				 <%
				 	String id = request.getParameter("id");
					Connection conn =null;
					PreparedStatement pstmt = null;
					ResultSet rs = null; 
					
					try{
						conn = SingletonHelper.Conection("oracle"); 
						String sql = "select id, pwd, name, age, gender, email from koreamember where id=?";
				 	 	pstmt = conn.prepareStatement(sql);
				 	 	
				 	 	pstmt.setString(1,id);
				 	 	
				 	 	rs = pstmt.executeQuery();
				 	 	//rs.next();
				 	 	while(rs.next()){
				 %>
				 		<table style="width:400px; height:100px; margin-left:auto; margin-right:auto;">
							<tr>
								<td style="width:100px">아이디</td>
								<td style="width:100px"><%=rs.getString("id") %></td>
							</tr>
							<tr>
								<td style="width:100px">비번</td>
								<td style="width:100px"><%=rs.getString("pwd") %></td>
							</tr>
							<tr>
								<td style="width:100px">이름</td>
								<td style="width:100px"><%=rs.getString("name") %></td>
							</tr>
							<tr>
								<td style="width:100px">나이</td>
								<td style="width:100px"><%=rs.getString("age") %></td>
							</tr>
							<tr>
								<td style="width:100px">성별</td>
								<td style="width:100px"><%=rs.getString("gender") %></td>
							</tr>
							<tr>
								<td style="width:100px">이메일</td>
								<td style="width:100px"><%=rs.getString("email") %></td>
							</tr>
							<tr style = "text-align: right">
								<td colspan="2">
									<a href="Ex03_Memberlist.jsp">뒤로가기</a>
								</td>
							</tr>
						</table>
				 <%}
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						SingletonHelper.Close(rs);
						SingletonHelper.Close(pstmt);
					}%>
				
				
			
			</div>
		</div>

	</div>
			<div>
			<jsp:include page="/common/Bottom.jsp"></jsp:include>
</body>
</html>