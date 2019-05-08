<%@page import="java.io.Console"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="kr.or.bit.utils.SingletonHelper"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   <%
   /* Ex02_JDBC_JoinForm.jsp 에서 >> action
   	
   1. 한글처리
   2. parameter 받기 ( 확인하기 )
   3. 로직처리 : 회원가입  처리 >> 데이터 받고 >> DB연결  >> insert > 유무 > client에게 전달
   4. 회원가입에 성공 or 실패
   	성공 : 페이지 이동 > 로그인페이지 (Ex02_JDBC_Login.jsp)> 
   			이동 : response.sendRedirect("주소") 또는   (클라이언트가 페이지를 서버에 재요청)
   				Javascript >>  location.href = "주소"
   	
   	회원가입 실패 > 경고창(가입실패 원인) > 회원가입 페이지 이동
   	서버코드작성 : <script>alert('....'); location.href = "주소"</script>
   	
   	클라이언트가 정보(request) 객체 ( request.getRemoteAddr())
   	id , pwd , name , age , gender, email , ip
   */
    request.setCharacterEncoding("UTF-8");
   String id = request.getParameter("id");
   String pwd = request.getParameter("inputPassword");
   String name = request.getParameter("inputName");
   int birth = Integer.parseInt(request.getParameter("birthday"));
   String gender = request.getParameter("gender");
   String email = request.getParameter("InputEmail");
   

   Class.forName("oracle.jdbc.OracleDriver");
   Connection conn =null;
   PreparedStatement pstmt = null;
   
   try{
	   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
		String sql="insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
   		
   		pstmt.setString(1, id);
   		pstmt.setString(2, pwd);
   		pstmt.setString(3, name);
   		pstmt.setInt(4, birth);
   		pstmt.setString(5, gender);
   		pstmt.setString(6, email);
   		pstmt.setString(7, request.getRemoteAddr());
   		
   		int result = pstmt.executeUpdate();
   		
   		if(result != 0) {
   			out.print("<script>location.href = 'Ex02_JDBC_Login.jsp'</script>");
   		}
   }catch(Exception e){
	   String msg = e.getMessage();
  		out.print("<script>alert('회원가입 양식이 맞지 않습니다.')</script>");
  		out.print("<script>location.href = 'Ex02_JDBC_JoinForm.jsp'</script>");
   }finally{
	   System.out.println("Finally");
	   if(pstmt !=null)try{pstmt.close();}catch(Exception e){}
       if(conn !=null)try{conn.close();}catch(Exception e){}
   }
   	 
   	
    %>
