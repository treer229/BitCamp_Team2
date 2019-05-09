package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Notice;
import kr.or.kosta.dto.board;

public class NoticeDao {
	
	/*
	작업일자 : 2019-05-09
	작업자 :    권순조
	작업내용 : notice board 작성
	*/
	DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public NoticeDao() {//DB연결
		try {
			Context context = new InitialContext(); // 이름기반 검색
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			System.out.println("NoticeComments" + e.getMessage());
		}
	}
	
	public int noticeWriteOk(Notice notice) {//일반 게시판 글쓰기 작업
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into NOTICE(NOTICE_NUM,TITLE,CONTENT,VIEWS,CREATED_DATE,COMMENT_COUNT,id) values("
					+ " NOTICE_SEQ.nextval,?,?,?,?,?,?,sysdate,0,?,0,?)";
			pstmt = conn.prepareStatement(sql);

			// parameter 설정하기
			pstmt.setString(1, notice.getnotice_title());
			pstmt.setString(2, notice.getnotice_content());
			pstmt.setInt(3, notice.getnotice_view());
			pstmt.setString(4, notice.getnotice_date());
			pstmt.setInt(5, notice.getcomment_count());
			pstmt.setString(6, notice.getId());

			row = pstmt.executeUpdate();
		} 
		 catch (Exception e) {
		   e.printStackTrace(); 
		   } finally {
				if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
				if (conn != null) try {conn.close();} catch (Exception e) {}
		}
		return row;
	}

	public Notice getContent(int notice_num) {//공지글 상세보기 출력
		Notice notice = null;
		try{
				conn = ds.getConnection();
				String sql ="select * from jspboard where notice_num=?";
			  	pstmt = conn.prepareStatement(sql);
			  	pstmt.setInt(1, notice_num);
			  			  	
				rs =pstmt.executeQuery();
			    
				if(rs.next()){
					int num = rs.getInt("notice_num");
					String title = rs.getString("notice_title");
					String content = rs.getString("notice_content");
					String date = rs.getString("notice_date");
					String id = rs.getString("id");
					int comment_count = rs.getInt("comment_count");
					int view = rs.getInt("notirce_view");
					
					notice = new Notice(num, title, content, date, comment_count,id, view);
				} else {
					System.out.println("입력실패");
				}
		 	} catch (Exception e) {
				e.getStackTrace();
			}
		    finally{
				if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
				if (conn != null) try {conn.close();} catch (Exception e) {}
		    }
		 return notice;
	}	
	public int reWriteOk(int notice_num, Notice notice) {
		try{
			conn = ds.getConnection();
			//사용자 입력값 처리
			String sql = "update NOTICE set()  where=?";
			
			int idx = boardata.getIdx(); //추가
			String writer = boardata.getWriter();
			String email = boardata.getEmail();
			String homepage = boardata.getHomepage();
			String pwd = boardata.getPwd();
			String subject = boardata.getSubject();
			String content = boardata.getContent();
			String filename = boardata.getFilename();
			int filesize = 0;
			
			
			
			
			//refer , depth , step 값 가져오기
			pstmt = conn.prepareStatement(refer_depth_step_sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				int refer = rs.getInt("refer");
				int step = rs.getInt("step");
				int depth = rs.getInt("depth");
				
				//step () 값 업데이트
			
				pstmt = conn.prepareStatement(step_update_sql);
				pstmt.setInt(1, step);
				pstmt.setInt(2, refer);
				pstmt.executeUpdate();
				
			    //실 데이터 insert 
				//jspboard_idx.nextval,?,?,?,?,?,?,?,?,0,?,?,?
				      
				                  
				pstmt = conn.prepareStatement(rewrite_sql);
				pstmt.setString(1, writer);
				pstmt.setString(2, email);
				pstmt.setString(3, homepage);
				pstmt.setString(4, pwd);
				pstmt.setString(5, subject);
				pstmt.setString(6,content);
				pstmt.setInt(7, 0);
				//첨부파일
				pstmt.setString(8, filename);
				//답변형
				pstmt.setInt(9, refer);
				pstmt.setInt(10, depth+1);   //답글 처리
				pstmt.setInt(11, step+1); //답글처리 (현재 읽은 글보다 큰 순번은 + 1)
				
				int row = pstmt.executeUpdate();
				return row;
			}else{
				return -1;
			}
				
		}finally{
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(conn != null) conn.close();
		}
		
	}
}
