package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.TravelReviewContentService;
import kr.or.bit.service.TravelReviewEditService;
import kr.or.bit.service.TravelReviewListService;
import kr.or.bit.service.TravelReviewWriteService;

/*
작업일자 : 2019-05-10
작업자 :   이힘찬
작업내용 : TravelreviewController 작성
*/

@WebServlet("*.TravelReview")
public class TravelreviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TravelreviewController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//request.setCharacterEncoding("UTF-8");
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String cmdURI = requestURI.substring(contextPath.length());
        
        
        //http://localhost:8090/WebServlet_94_Board_Model2_Mvc/boardwrite.bbs
        
        //BoardCmd cmd = null;
        //String viewPage = null;
        ActionForward forward = new ActionForward();
        Action action = null;

        // 글 작성 화면 요청이 들어왔을때, ok  (화면처리)
        if(cmdURI.equals("/boardwrite.TravelReview")){
        	forward.setRedirect(false);
        	forward.setPath("/board/board_write.jsp");
        }
        
        // 글 리스트 보여주기, ok
        else if(cmdURI.equals("/travelreviewlist.TravelReview")){
        	
        	action = new TravelReviewListService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 글 상세보기, ok
        else if(cmdURI.equals("/travelreviewread.TravelReview")){
        	action = new TravelReviewContentService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 글 작성 요청, ok
        else if(cmdURI.equals("/travelreviewwriteok.TravelReview")){
        	action = new TravelReviewWriteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 글 수정 화면 제공, ok
        else if(cmdURI.equals("/travelrevieweditform.TravelReview")){
        	action = new TravelReviewEditService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 수정 처리, ok
        else  if(cmdURI.equals("/boardEdit.TravelReview")){
        	action = new BoardEditOkAction();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 글 삭제 비밀번호 확인 화면 제공, ok
        else if(cmdURI.equals("/boardDeletePassword.TravelReview")){
        	forward.setRedirect(false);
        	forward.setPath("/board/board_delete.jsp");
        }
        
        
        // 글 삭제 비밀번호 확인 처리, ok
        else if(cmdURI.equals("/boardDeleteCheck.TravelReview")){
        	action = new BoardDeleteAction();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 답글작성 화면제공
        else if(cmdURI.equals("/boardRewrite.TravelReview")) {
        	forward.setRedirect(false);
        	forward.setPath("/board/board_rewrite.jsp");
        }
        
        // 답글 작성
        else if(cmdURI.equals("/boardRewriteok.TravelReview")) {
        	action = new BoardRewriteOkAction();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 작성
        else if(cmdURI.equals("/boardReplyok.TravelReview")) {
        	action = new BoardReplyAction();
        	System.out.println("boardReplyok................");
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 삭제
        else if(cmdURI.equals("/boardreplyDeleteOk.TravelReview")) {
        	action = new BoardReplyDeleteAction();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        else if(cmdURI.equals("/boardreplylist.TravelReview")) {
        	System.out.println("boardreplylist들어옴");
        	action = new BoardReplyListAction();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
        
        
        
        /*
        /*
        // 글 작세 비밀번호 오류 화면 제공
        if(cmdURI.equals("/boardDeleteError.bbs")){
           viewPage = "boardDeleteError.jsp";
        }
        
        // 글 삭제 처리
        if(cmdURI.equals("/boardDelete.bbs")){
           cmd = new BoardDeleteCmd();
           cmd.execute(request, response);
           viewPage = "boardList.bbs";
        }
        
        // 글 검색 처리
        if(cmdURI.equals("/boardSearch.bbs")){
           cmd = new BoardSearchCmd();
           cmd.execute(request, response);
           viewPage = "boardSearchList.jsp";
        }
        
        // 답글 작성 화면 제공
        if(cmdURI.equals("/boardReplyForm.bbs")){
           cmd = new BoardReplyFormCmd();
           cmd.execute(request, response);
           viewPage = "boardReply.jsp";
        }
        
        // 답글 작성 처리
        if(cmdURI.equals("/boardReply.bbs")){
           cmd = new BoardReplyCmd();
           cmd.execute(request, response);
           viewPage = "boardList.bbs";
        }*/
        
     
        /*RequestDispatcher dis = request.getRequestDispatcher(viewPage);
        dis.forward(request, response);*/
        if(forward != null){
        	if(forward.isRedirect()) {
        		response.sendRedirect(forward.getPath());
        	}
        	else {
        		RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
        		dis.forward(request, response);
        	}
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
