package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Notice;

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

	public NoticeDao() {
		try {
			Context context = new InitialContext(); // 이름기반 검색
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			System.out.println("NoticeComments" + e.getMessage());
		}
	}
	
	public int noticeWriteOk(Notice notice) throws Exception {
		try {
			conn = ds.getConnection();
			String sql = "insert into NOTICE(NOTICE_NUM,TITLE,CONTENT,VIEWS,CREATED_DATE,COMMENT_COUNT,id) values("
					+ " NOTICE_SEQ.nextval,?,?,?,?,?,?,sysdate,0,?,0,?)";
			pstmt = conn.prepareStatement(sql);

			// parameter 설정하기
			pstmt.setString(1, notice.getWriter());
			pstmt.setString(2, notice.getPwd());
			pstmt.setString(3, notice.getSubject());
			pstmt.setString(4, notice.getContent());
			pstmt.setString(5, notice.getEmail());
			pstmt.setString(6, notice.getHomepage());
			pstmt.setString(7, notice.getFilename());

			// 계층형 게시판
			// refer , depth , step
			// 1.원본글 : refer , depth(0) , step(0)
			// 2.답변글 : refer , depth(값이) , step(값이)

			// refer 설정규칙 : idx 동일 ( +1)
			int refer_max = getMaxRefer(conn);
			int refer = refer_max + 1;
			// int depth = 0;
			// int step = 0;
			pstmt.setInt(8, refer);

			int row = pstmt.executeUpdate();
			return row;

		} /*
		 * catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */finally {
			// System.out.println("close");
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close(); // pool conn 객체반환
		}

	}

}
