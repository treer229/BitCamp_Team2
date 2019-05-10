package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Notice_Comments;

public class NoticeCommentsDao {
	/*
	작업일자 : 2019-05-08
	작업자 :    권순조
	작업내용 : notice DTO 작성
	*/
	DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public NoticeCommentsDao() {
		try {
			Context context = new InitialContext(); // 이름기반 검색
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			System.out.println("NoticeComments" + e.getMessage());
		}
	}

	public int insertComment(Notice_Comments Notice_comments) {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into NOTICE_COMMENTS ( NOTICE_NUM, ID, CONTENT,CREATED_DATE, COMMENT_NUM) values (?,?,?,sysdate,NOTICE_COMMENTS_SEQ.NEXTVAL)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Notice_comments.getNotice_num());
			pstmt.setString(2, Notice_comments.getId());
			pstmt.setString(3, Notice_comments.getComments_content());

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertComment Exception" + e.getMessage());
			row = -1;
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {} // 반환
		}
		return row;
	}

	public int deleteComment(String id, int comment_num) {
		int row = 0;
		try{
			//String sql = "delete from reply where no=? and pwd =?"
			//String replyselect ="select pwd from reply where no=?";
			//가지고 온 pwd 값 parameter 받은 pwd 일치하면 삭제 처리
			String sql = "delete from NOTICE_COMMENTS where COMMENT_NUM=?";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment_num);
			rs =pstmt.executeQuery();
			if(rs.next()){
					//실제 삭제 처리
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, comment_num);
					row = pstmt.executeUpdate();
			}else{
				row = -1;
				System.out.println("존재하는 댓글이 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {}
		}
		return row;
	}

	public int updateComment(int comment_num, String content) {
		int row = 0;

		try{
			String sql = "UPDATE NOTICE_COMMENTS SET CONTENT=? WHERE COMMENT_NUM=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, comment_num);

			row = pstmt.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
				row = -1;
			} finally{
				if (rs != null) try {rs.close();} catch (Exception e) {}
				if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
				if (conn != null) try {conn.close();} catch (Exception e) {}
			}
		return row;
}

	public List<Notice_Comments> noticeCommentList(int Notice_Num) {
		List<Notice_Comments> noticommentlist = new ArrayList<Notice_Comments>();

		try {

			String sql = "select * from NOTICE_COMMENTS where NOTICE_NUM=?";

			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Notice_Num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String content = rs.getString("CONTENT");
				String create_date = rs.getString("CREATED_DATE");

				Notice_Comments noticomments = new Notice_Comments();
				noticomments.setId(id);
				noticomments.setComments_content(content);
				noticomments.setcomments_date(create_date);

				noticommentlist.add(noticomments);
			}

		} catch (Exception e) {
			System.out.println("noticeCommentList :" + e.getMessage());
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {}
		}
		return noticommentlist;
	}
}
