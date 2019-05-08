package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentDao {

	DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public CommentDao() {
		try {
			  Context context = new InitialContext(); //이름기반 검색
			  ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		}catch (Exception e) {
			System.out.println("look yp Fail"+ e.getMessage());
		}
	}
	
	public void insertComment() {
		try {
			conn = ds.getConnection();
			String sql = "insert into Comment(TR_REPLY_NUM,CONTENT,email) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, dto.getId());
//			pstmt.setString(2, dto.getPwd());
//			pstmt.setString(3, dto.getEmail());
//			

		}catch (Exception e) {
			System.out.println("write ok Exception"+ e.getMessage());

		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
		}
	}
	
	public void deleteComment() {
		
	}
	
	public void updateComment() {
		
	}
	
	public void selectAllComment() {
		
	}
}
