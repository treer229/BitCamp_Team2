<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.bit.utils.SingletonHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <jsp:include page="/common/sessionCheck.jsp"></jsp:include>
	<%
	/* Ex03_MemberEdit.jsp>id=hong 
	sql > select * from koreamember where id=?
	결과를 화면에 출력 : <td>rs.getString("name")</td>
					<td><input type = "text" value = "rs.getString('name')"</td>
	Ex03_MemberEditok.jsp?
	sql > update emp set ename= ? , job = ? , sal = ? where empno = ?
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
#hoguma {
color : black;
text-decoration: none;
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
				<div>
				<%
					String id = request.getParameter("id");
					Connection conn =null;
					PreparedStatement pstmt = null;
					ResultSet rs = null; 
					
					try{
					   	conn = SingletonHelper.Conection("oracle");
					   	String sql = "select id,pwd,name,age,trim(gender),email from koreamember where id = ? ";
					   	pstmt = conn.prepareStatement(sql);
					   	
						pstmt.setString(1,id);
				 	 	
				 	 	rs = pstmt.executeQuery();
					   	
					   	rs.next();
					   	%>
					   	
			<form action="Ex03_MemberEditok.jsp" method="post">
					
					<div style="margin-top: 300px">
						<div class = "list-group"
							style="width: 320px; height: auto; margin-left: auto; margin-right: auto;
							">
							<h3 style="text-align: center;">정보 수정</h3>
							<div class = "list-group-item">ID&nbsp;&nbsp;&nbsp;&nbsp;
								<input type ="text" name = "id" value = "<%=rs.getString(1) %>" readonly>
							</div>
							<div class = "list-group-item">비번: <%=rs.getString(2) %>
							</div>
							<div class = "list-group-item">이름
								<input type = "text" name = "name" value = "<%=rs.getString(3) %>"> 
							</div>
							<div class = "list-group-item">생일
								<input type = "text" name = "age" value = "<%=rs.getString(4) %>"> 
							</div>
							<div class = "list-group-item">성별
							  	<div class="btn-group btn-group-toggle" data-toggle="buttons" style = "width : auto ; height: auto;">
                  
									<label class="btn btn-primary">
										<input type="radio" name="gender" id="gender" value = "남"
										<%if(rs.getString(5).equals("남")){%>checked<%}%>>남자
									</label>
									<label class="btn btn-danger">
										<input type="radio" name="gender" id="gender" value = "여"
										<%if(rs.getString(5).equals("여")) {%> checked<%}%>> 여자
									</label>
								</div>
							</div>
							
							<div class = "list-group-item">이메일
								<input type = "text" name = "email" value = "<%=rs.getString(6) %>"> </div>
							</div>
							
							<div style = "text-align: center ;">
							<div style = "column-count: 2 ; margin-top: 10px; position: relative; left: 150px" id = "hoguma">
								<a href='Ex03_Memberlist.jsp'>리스트이동</a><br>
								<input type="submit" value="수정하기" class = "btn btn-outline-secondary">
								</div>
						</div>
					</div>
					</div>
			
				</form>
						</div>
			</div>
		</div>
	</div>
			<div>
			<jsp:include page="/common/Bottom.jsp"></jsp:include>
</body>
</html>
					   	
					<%}catch(Exception e){
						e.printStackTrace();
					}finally{
						SingletonHelper.Close(rs);
						SingletonHelper.Close(pstmt);
					}
					
					 %>
				


