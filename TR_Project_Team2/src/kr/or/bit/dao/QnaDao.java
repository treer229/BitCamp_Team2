package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Qna;

/*
작업일자 : 2019/05/08
작업자 : 이노진
작업내용 : 묻고답하기 게시판 dao
*/
public class QnaDao {
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public QnaDao() {
		try {
			  Context context = new InitialContext(); //이름기반 검색
			 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		}catch (Exception e) {
			System.out.println("DB연결 실패 : "+ e.getMessage());
			return;
		}
	}




//묻고답하기 글쓰기
	
public void writeok(Qna data){
	int qna_num = 0;
	String sql = "insert into Qna(qna_num, id, qna_title, qna_content, views, qna_created_date, qna_comment_count, refer)values("+ "?,?,?,?,?,0,?,0)";
	
	int result = 0;
	
	
	
    try {
    	conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
    
    }
	
	
	
	
	
	
//public List<Qna> SelectAllList() {// 전체 테이블 보기
//    
//	pstmt = null;
//    rs = null;
//    List<Qna> Qnalist = new ArrayList<>();
//    
//    try {
//  	 conn = ds.getConnection();
//       String sql = "select * from qna";
//       pstmt = conn.prepareStatement(sql);
//                
//       rs = pstmt.executeQuery();
//       
//       while(rs.next()){
//    	  Qna Qna = new Qna();
//    	  Qna.setQna_num(rs.getInt("qna_num"));
//    	  Qna.setId(rs.getString("id"));
//    	  Qna.setQna_title(rs.getString("qna_title"));
//    	  Qna.setQna_content(rs.getString("qna_content"));
//    	  Qna.setViews(rs.getInt("views"));
//    	  Qna.setQna_created_date(rs.getString("qna_created_date"));
//    	  Qna.setQna_num(rs.getInt("qna_comment_count"));
//    	  Qnalist.add(Qna);
//
//          
//       }
//       
//    } catch (Exception e) {
//       System.out.println(e.getMessage());
//    }finally{
//			if(rs!=null) try {rs.close();}catch(Exception e) {}
//  	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
//			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
//    }
//    return Qnalist;
//}
//
//
//
//public Emp SelectByEmpno(int empno) {//번호로 사원조회
//	     
//	  PreparedStatement pstmt = null;
//    ResultSet rs = null;
//    Emp Emp= new Emp();
//    
//    try {
//  	 conn = ds.getConnection();
//       String sql = "select * from emp where empno= ?";
//       pstmt = conn.prepareStatement(sql);
//       pstmt.setInt(1, empno);
//                
//       rs = pstmt.executeQuery();
//       
//       while(rs.next()){
//          Emp.setEmpno(rs.getInt("empno"));
//          Emp.setEname(rs.getString("ename"));
//          Emp.setJob(rs.getString("job"));
//          Emp.setMgr(rs.getInt("mgr"));
//          Emp.setHiredate(rs.getString("hiredate"));
//          Emp.setSal(rs.getInt("sal"));
//          Emp.setComm(rs.getInt("comm"));
//          Emp.setDeptno(rs.getInt("deptno"));
//       }
//       
//    } catch (Exception e) {
//       System.out.println(e.getMessage());
//    }finally{
//			if(rs!=null) try {rs.close();}catch(Exception e) {}
//  	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
//			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
//    }
//    return Emp;
//}
//
//
//
//public List<Emp> SelectByDeptno(int deptno) {//부서번호로 조회하기
//	
//    
//	  PreparedStatement pstmt = null;
//    ResultSet rs = null;
//    List<Emp> Emplist = new ArrayList<>();
//    
//    try {
//  	 conn = ds.getConnection();
//       String sql = "select * from emp where deptno=?";
//       pstmt = conn.prepareStatement(sql);
//       pstmt.setInt(1, deptno);
//                
//       rs = pstmt.executeQuery();
//       
//       while(rs.next()){
//          Emp Emp = new Emp();
//          Emp.setEmpno(rs.getInt("empno"));
//          Emp.setEname(rs.getString("ename"));
//          Emp.setJob(rs.getString("job"));
//          Emp.setMgr(rs.getInt("mgr"));
//          Emp.setHiredate(rs.getString("hiredate"));
//          Emp.setSal(rs.getInt("sal"));
//          Emp.setComm(rs.getInt("comm"));
//          Emp.setDeptno(rs.getInt("deptno"));
//          Emplist.add(Emp);
//       }
//       
//    } catch (Exception e) {
//       System.out.println(e.getMessage());
//    }finally{
//			if(rs!=null) try {rs.close();}catch(Exception e) {}
//  	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
//			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
//    }
//    return Emplist;
//}
//
//public int InsertEmp(Emp emp) {//사원정보 입력하기
//	int row = 0;
//	 try {
//       conn = ds.getConnection();
//       String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?)"; 
//       pstmt = conn.prepareStatement(sql);
//                
//       pstmt.setInt(1, emp.getEmpno());
//       pstmt.setString(2, emp.getEname());
//       pstmt.setString(3, emp.getJob());
//       pstmt.setInt(4, emp.getMgr());
//       pstmt.setString(5, emp.getHiredate());
//       //pstmt.setDate(5, (Date) dto.getHiredate());
//       pstmt.setInt(6, emp.getSal());
//       pstmt.setInt(7, emp.getComm());
//       pstmt.setInt(8, emp.getDeptno());
//       row = pstmt.executeUpdate();
//       
//    } catch (Exception e) {
//       System.out.println(e.getMessage());
//    }finally{
//  	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
//			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
//    }
//	return row;
//}
//
//
//public int UpdateEmp(Emp emp) {//사원정보 업데이트하기
//	int row = 0;
//	   PreparedStatement pstmt = null;
//
//	         try{
//	            conn = ds.getConnection();
//	            String sql="update emp set job=?, ename=?, mgr=?, sal=?, comm=?, deptno=?, hiredate=? where empno=?";
//	            pstmt = conn.prepareStatement(sql);
//		        pstmt.setInt(8, emp.getEmpno());
//		        pstmt.setString(1, emp.getJob());
//		        pstmt.setString(2, emp.getEname());
//		        pstmt.setInt(3, emp.getMgr());
//		        pstmt.setInt(4, emp.getSal());
//		         //pstmt.setDate(5, (Date) dto.getHiredate());
//		        pstmt.setInt(5, emp.getComm());
//		        pstmt.setInt(6, emp.getDeptno());
//		        pstmt.setString(7, emp.getHiredate());
//		        row = pstmt.executeUpdate();
//	                       
//	            row=pstmt.executeUpdate();      
//
//	         }catch(Exception e){
//	            System.out.println(e.getMessage());
//	         }finally {
//		    	 if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
//				if(conn!=null) try{conn.close();}catch (Exception e){} //반환
//	         }
//	         return row;
// }
//
//public int DeleteEmp(int empno) {//번호로 정보삭제
//	  int row = 0;
//    PreparedStatement pstmt = null;
//
//    try{
//       conn = ds.getConnection();
//       String sql = "delete from emp where empno=?";
//       pstmt = conn.prepareStatement(sql);
//       pstmt.setInt(1, empno);
//       row = pstmt.executeUpdate();
//
//    }catch(Exception e){
//       System.out.println(e.getMessage());
//    }finally {
//	    if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
//		if(conn!=null) try{conn.close();}catch (Exception e){} //반환
//    }
//	return row;
//}
}