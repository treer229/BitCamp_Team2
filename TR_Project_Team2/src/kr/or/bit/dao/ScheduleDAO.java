package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Member;
import kr.or.bit.dto.Schedule;

/*
작업일자 : 2019-05-08
작업자 :    정진호	
작업내용 : 스케줄 DAO 작성
*/
public class ScheduleDAO {
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ScheduleDAO() { //constructer 사용 커넥션
		try {
			  Context context = new InitialContext(); //이름기반 검색
			 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		}catch (Exception e) {
			System.out.println("look yp Fail"+ e.getMessage());
		}
	}
	public Schedule getScheduleList(Member member) {
		Schedule schedule = new Schedule();
		try {
			conn = ds.getConnection();
			String sql = "select * from SCHEDULE where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			
			rs = pstmt.executeQuery();
			System.out.println("스케줄 불러오는 쿼리문 실행 완료");
			while(rs.next()) {
				schedule.setSchedule_NUM(rs.getInt(1));
				schedule.setID(rs.getString(2));
				schedule.setSchedule_TITLE(rs.getString(3));
				schedule.setContent(rs.getString(4));
				schedule.setSchedule_START(rs.getString(5));
				schedule.setSchedule_END(rs.getString(6));
				schedule.setColor(rs.getString(7));
				schedule.setDELETEOK(rs.getInt(8));
				schedule.setCOMPLETEOK(rs.getInt(9));
			}
			System.out.println("스케줄 쿼리 담기 완료");
		} catch (Exception e) {
			System.out.println("스케줄 불러오기 에러");
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {System.out.println("스케줄 rs DB서버 닫기 실패"); System.out.println(e.getMessage());}
    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("스케줄 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("스케줄 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return schedule;
	}
	public int getInsertSchedule(Schedule schedule) {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into SCHEDULE(SCHEDULE_NUM,ID,SCHEDULE_TITLE,CONTENT,SCHEDULE_START,SCHEDULE_END,COLOR,DELETEOK,COMPLETEOK) values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, schedule.getSchedule_NUM());
			pstmt.setString(2, schedule.getID());
			pstmt.setString(3, schedule.getSchedule_TITLE());
			pstmt.setString(4, schedule.getContent());
			pstmt.setString(5, schedule.getSchedule_START());
			pstmt.setString(6, schedule.getSchedule_END());
			pstmt.setString(7, schedule.getColor());
			pstmt.setInt(8, schedule.getDELETEOK());
			pstmt.setInt(9, schedule.getCOMPLETEOK());
			
			
			row = pstmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("추가 된 열의 수 : " + row);
			}else {
				System.out.println("추가 실패");
			}
		
		} catch (Exception e) {
			System.out.println("스케줄 추가오류");
			System.out.println(e.getMessage()); 
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("스케줄추가 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("스케줄추가 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		
		return row;
		
		
	}
	public int getUpdeateSchedule(Schedule schedule) {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "update SCHEDULE set SCHEDULE_TITLE=? , CONTENT=? , SCHEDULE_START=? , SCHEDULE_END=? , COLOR,DELETEOK=? ,COMPLETEOK=? where SCHEDULE_NUM = ?" ;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, schedule.getSchedule_TITLE());
			pstmt.setString(2, schedule.getContent());
			pstmt.setString(3, schedule.getSchedule_START());
			pstmt.setString(4, schedule.getSchedule_END());
			pstmt.setString(5, schedule.getColor());
			pstmt.setInt(6, schedule.getDELETEOK());
			pstmt.setInt(7, schedule.getCOMPLETEOK());
			pstmt.setInt(8, schedule.getSchedule_NUM());
			
			row = pstmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("업데이트 된 열의 수 : " + row);
			}else {
				System.out.println("업데이트 실패");
			}
		
		} catch (Exception e) {
			System.out.println("스케줄 업데이트오류");
			System.out.println(e.getMessage()); 
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("스케줄수정 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("스케줄수정 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		
		return row;
		
	}
	
	public int getDeleteSchedule(String id) {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "delete from SCHEDULE where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("삭제된 행의 수 : " + row);
				
			}else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			System.out.println("스케줄 삭제 실패");
			System.out.println(e.getMessage());
		}finally {if(rs!=null) try {rs.close();}catch(Exception e) {System.out.println("스케줄삭제 rs DB서버 닫기 실패"); System.out.println(e.getMessage());}
    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("스케줄삭제 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("스케줄삭제 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		
		return row;
	}

}
