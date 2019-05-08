package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Notice_Comments;

public class NoticeCommentsDao {

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
			String sql = "insert into NOTICE_COMMENTS (NOTICE_NUM, ID, CONTENT,CREATED_DATE) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Notice_comments.getNotice_num());
			pstmt.setString(2, Notice_comments.getId());
			pstmt.setString(3, Notice_comments.getComments_content());
			pstmt.setString(4, Notice_comments.getcomments_date());

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Comment ok Exception" + e.getMessage());
			row = -1;
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				} // 반환
		}
		return row;
	}

	public void deleteComment() {

	}

	public void updateComment() {

	}

	public int selectAllComment(int Notice_Num) {
		int resultrow = 0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {

			String sql = "select ID, CONTENT, CREATED_DATE from NOTICE_COMMENTS where=? ";

			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Notice_Num);

			resultrow = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Insert :" + e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultrow;
	}
}
