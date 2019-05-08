<%@page import="java.sql.ResultSet"%>
<%@page import="kr.or.bit.utils.SingletonHelper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
/* 
1. 한글처리
2. 데이터받기 (ID,PWD)
3. DB연동 (sql)
4. 업무(로직)처리

	ID,PWD 를 parameter 로 받아서 회원인지 아닌지 판단
	
	--판단조건
	1. id 존재 , pwd ( 0 ) == 회원 >> main 페이지 이동 >> session.setAttribute("userid",id);
	2. ID 존재 , PWD ( X ) >> 다시 한번 로그인 처리 ( 로그인 페이지 이동 )
	3. ID 존재(X) >  회원가입 페이지 이동처리

	1.Ex02_JDBC_Main.jsp
	2.Ex02_JDBC_Login.jsp
	3.Ex02_JDBC_JoinForm.jsp
	
	
	sql : select id , pwd form koreamember where id = ?
			
	>>select ...
			1. 결과 없는경우
			
			2. single row
			
			3. multi row ( 회원 데이터 확인할경우에만 사용)
	
	if(rs.next()) {
		do{
			System.out.println(rs.getint(1));
		}while(rs.next());
	}else {
		회원이 아닌경우
	}
	
	기능적 요구사항
	
	
	비기능적 요구사항
	SingletonHelper 톤을 사용해서 코드 중복성을 줄인다.
	
			*/
	String id = request.getParameter("login");
	String pwd = request.getParameter("password");
	
	
	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	
	   try{
		  	
		   	//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");;
		   	conn = SingletonHelper.Conection("oracle");
		   	String sql = "select id,pwd from koreamember where id=?";
		   	pstmt = conn.prepareStatement(sql);
		   	pstmt.setString(1,id);
		   	rs = pstmt.executeQuery();
		   	
		   	while(rs.next()){
		   		
		   		//ID존재
		   		if(pwd.equals(rs.getString("pwd"))){
		   			//ID(0) , PWD(0)
		   			//정상회원
		   			
		   			//Top.jsp 활용
		   			session.setAttribute("userid", rs.getString("id"));
		   			
		   			out.print("<script>");
		   				out.print("location.href='Ex02_JDBC_Main.jsp'");
		   			out.print("</script>");
		   		}else{
		   			//ID(0) , PWD(x)
		   				out.print("<script>");
		  					out.print("location.href='Ex02_JDBC_Login.jsp'");
		  				out.print("</script>");
		   		}
		   	}
		   		//ID(x)
		   		out.print("<script>");
		  			out.print("location.href='Ex02_JDBC_JoinForm.jsp'");
		  		out.print("</script>");
		   	
		   }catch(Exception e){
		   	e.printStackTrace();
		   }finally{
		   	System.out.println("Finally");
		   	SingletonHelper.Close(rs);
		  	SingletonHelper.Close(pstmt);
		  		//연결은 해제 하지 않아요 ....
		   }
		   %>