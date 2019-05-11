package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Member;

/*
작업일자 : 2019-05-08
작업자 :   이힘찬
작업내용 : MemberDao 작성
편집자 : 이노진
*/

public class MemberDao {
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDao() { //constructer 사용 커넥션
		try {
			  Context context = new InitialContext(); //이름기반 검색
			 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		}catch (Exception e) {
			System.out.println("look up Fail"+ e.getMessage());
		}
	}
	
	public List<Member> MemberAllList() {	//회원전체조회
	      
		  PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<Member> memberlist = new ArrayList<>();
	      
	      try {
	    	 conn = ds.getConnection();
	         String sql = "select * from Member";
	         pstmt = conn.prepareStatement(sql);
	                  
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()){
	            Member member = new Member();
	            member.setId(rs.getString("id"));
	            member.setPassword(rs.getString("password"));
	            member.setName(rs.getString("name"));
	            member.setGender(rs.getInt("gender"));
	            member.setEmail(rs.getString("email"));
	            member.setTravel(rs.getString("travel"));
	            member.setAdmin(rs.getInt("admin"));
	          
	            memberlist.add(member);
	         }
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally{
				if(rs!=null) try {rs.close();}catch(Exception e) {}
	    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
	      return memberlist;
	}
	
	
//	회원가입안되면 이걸로....
//	public int MemberInsert(Member member) {	//회원가입
//		int row = 0;
//		 try {
//	         conn = ds.getConnection();
//	         String sql = "insert into member(id, password, name, gender, email, travel, admin) values(?,?,?,?,?,?,?)"; 
//	         pstmt = conn.prepareStatement(sql);
//	                  
//	         pstmt.setString(1, member.getId());
//	         pstmt.setString(2, member.getPassword());
//	         pstmt.setString(3, member.getName());
//	         pstmt.setInt(4, member.getGender());
//	         pstmt.setString(5, member.getEmail());
//	         pstmt.setString(6, member.getTravel());
//	         pstmt.setInt(7, member.getAdmin());
//	         
//	         row = pstmt.executeUpdate();
//	         
//	      } catch (Exception e) {
//	         System.out.println(e.getMessage());
//	      }finally{
//	    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
//				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
//	      }
//		return row;
//	}
//	
	
	
	public boolean MemberInsert(Member member) {	//회원가입
		int result = 0;
<<<<<<< HEAD
=======
		boolean ok = false;
>>>>>>> 1차 커밋
		 try {
	         conn = ds.getConnection();
	         String sql = "insert into member(id, password, name, gender, email, travel, admin) values(?,?,?,?,?,?,0)"; 
	         pstmt = conn.prepareStatement(sql);
	                  
	         pstmt.setString(1, member.getId());
	         pstmt.setString(2, member.getPassword());
	         pstmt.setString(3, member.getName());
	         pstmt.setInt(4, member.getGender());
	         pstmt.setString(5, member.getEmail());
	         pstmt.setString(6, member.getTravel());
	         
	         result = pstmt.executeUpdate();
<<<<<<< HEAD
=======
	         if(result > 0 ) {
	        	 ok = true;
	         }else {
	        	 ok = false;
	         }
>>>>>>> 1차 커밋
	         
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally{
	    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
<<<<<<< HEAD
		return false;
=======
		return ok;
>>>>>>> 1차 커밋
	}
	
	
	
	
	
	public int MemberEdit(Member member) {	//회원정보 수정하기
		int row = 0;
		   PreparedStatement pstmt = null;
    
		         try{
		            conn = ds.getConnection();
		            String sql="update member set password=?, name=?, gender=?, email=?, travel=? where id=?";
		            pstmt = conn.prepareStatement(sql);
			        pstmt.setString(1, member.getPassword());
			        pstmt.setString(2, member.getName());
			        pstmt.setInt(3, member.getGender());
			        pstmt.setString(4, member.getEmail());
			        pstmt.setString(5, member.getTravel());
			        pstmt.setString(6, member.getId());
			        
			        row = pstmt.executeUpdate();
		                             
		         }catch(Exception e){
		            System.out.println(e.getMessage());
		         }finally {
			    	 if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
					if(conn!=null) try{conn.close();}catch (Exception e){} //반환
		         }
		         return row;
	   }

	public int MemberDelete(String id) {	//ID로 삭제
		  int row = 0;
	      PreparedStatement pstmt = null;

	      try{
	         conn = ds.getConnection();
	         String sql = "delete from member where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         row = pstmt.executeUpdate();

	      }catch(Exception e){
	         System.out.println(e.getMessage());
	        // row = -1;
	      }finally {
		    if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
		return row;
	}
	
	public Member MemberSearch(String id) {	//ID로 회원조회
		PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      Member member= new Member();
	      
	      try {
	    	 conn = ds.getConnection();
	         String sql = "select * from MEMBER where ID= ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	                  
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()){
	        	member.setId(rs.getString("id"));
	        	member.setPassword(rs.getString("password"));
	        	member.setName(rs.getString("name"));
	        	member.setGender(rs.getInt("gender"));
	        	member.setEmail(rs.getString("email"));
	        	member.setTravel(rs.getString("travel"));
	        	member.setAdmin(rs.getInt("admin"));
	           
	         }
	         
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally{
				if(rs!=null) try {rs.close();}catch(Exception e) {}
	    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
	      return member;
<<<<<<< HEAD
	}
	
	public String PasswordSearch (String password) {	//비밀번호 조회
		  PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      Member member = new Member();
	     try {
	    	 conn = ds.getConnection();
	         String sql = "select * from MEMBER where ID= ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	                  
	         rs = pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(rs!=null) try {rs.close();}catch(Exception e) {}
    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
      }
		return null;
	}
	
	
}
=======
	}
}
>>>>>>> 1차 커밋
