<%@page import="kr.or.bit.utils.SingletonHelper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
    1.권한검사
    2.id값 parameter 받기
    3.삭제 : delete from koreamember where id=?
    4.정상 삭제 >> 회원목록 이동
 -->
 <jsp:include page="/common/sessionCheck.jsp"></jsp:include>
<%
 
 
 
 String id = request.getParameter("id");
 
    Connection   conn = null;
    PreparedStatement pstmt = null;
    
    
    try{
        conn = SingletonHelper.Conection("oracle");
        String sql = "delete from koreamember where id=?";
        pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1,id);
        
        int row = pstmt.executeUpdate();
        if(row>0){
            out.print("<script>location.href='Ex03_Memberlist.jsp'</script>");
        }else{
            //필요에 따라 구
        }
        
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        SingletonHelper.Close(pstmt);
    }
        
        
 %>
 
 
 