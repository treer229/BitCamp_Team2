package kr.or.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
<<<<<<< HEAD
=======
import kr.or.bit.service.TravelReviewCommentDeleteService;
import kr.or.bit.service.TravelReviewCommentListService;
import kr.or.bit.service.TravelReviewCommentService;
import kr.or.bit.service.TravelReviewContentService;
import kr.or.bit.service.TravelReviewDeleteService;
import kr.or.bit.service.TravelReviewEditOkService;
import kr.or.bit.service.TravelReviewEditService;
import kr.or.bit.service.TravelReviewListService;
import kr.or.bit.service.TravelReviewRewriteOkService;
import kr.or.bit.service.TravelReviewWriteService;
>>>>>>> 최종커밋


@WebServlet("*.Travelreview")
public class TravelreviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TravelreviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

<<<<<<< HEAD
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ActionForward forward = null;
    	Action action = null;
    	
    	//요청받기 시작
    	String requestURI = request.getRequestURI();
    	String ContextPath = request.getContextPath();
    	String url_Command = requestURI.substring(ContextPath.length());

    	System.out.println("requestURI"+requestURI+"컨트롤러 check");
    	System.out.println("ContextPath"+ContextPath+"컨트롤러 check");
    	System.out.println("url_Command"+url_Command+"컨트롤러 check");
    	
    	
    	if(url_Command.equals("/Register.do")) {// 업무처리
      	  
    	   System.out.println("if확인");
			
			 

    	}  else if(url_Command.equals("/MemoList.do")) {
    		forward = new ActionForward();
    //		forward.setPath(/*여기에 주소를 넣어주세요*/);
    	}
=======
        // 글 작성 화면 요청이 들어왔을때, ok  (화면처리)
        if(cmdURI.equals("/boardwrite.TravelReview")){
        	forward.setRedirect(false);
        	forward.setPath("/board/board_write.jsp");
        }
        
        // 글 리스트 보여주기, ok
        else if(cmdURI.equals("/TravelReviewList.TravelReview")){
        	
        	action = new TravelReviewListService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 글 상세보기, ok
        else if(cmdURI.equals("/TravelReviewRead.TravelReview")){
        	action = new TravelReviewContentService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 글 작성 요청, ok
        else if(cmdURI.equals("/TravelReviewWriteOk.TravelReview")){
        	action = new TravelReviewWriteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 글 수정 화면 제공, ok
        else if(cmdURI.equals("/TravelReviewEditForm.TravelReview")){
        	action = new TravelReviewEditService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 수정 처리, ok
        else  if(cmdURI.equals("/TravelReviewEdit.TravelReview")){
        	action = new TravelReviewEditOkService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 글 삭제 비밀번호 확인 화면 제공, ok
        else if(cmdURI.equals("/TravelReviewDeletePassword.TravelReview")){
        	forward.setRedirect(false);
        	forward.setPath("/travelreview/travelreviewDelete.jsp");
        }
        
        
        // 글 삭제 비밀번호 확인 처리, ok
        else if(cmdURI.equals("/TravelReviewDeleteCheck.TravelReview")){
        	action = new TravelReviewDeleteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 답글작성 화면제공
        else if(cmdURI.equals("/TravelReviewRewrite.TravelReview")) {
        	forward.setRedirect(false);
        	forward.setPath("/travelreview/travelreviewRewrite.jsp");
        }
        
        // 답글 작성
        else if(cmdURI.equals("/TravelReviewRewriteOk.TravelReview")) {
        	action = new TravelReviewRewriteOkService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 작성
        else if(cmdURI.equals("/TravelReviewCommentOk.TravelReview")) {
        	action = new TravelReviewCommentService();
        	System.out.println("boardReplyok................");
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 삭제
        else if(cmdURI.equals("/TravelReviewCommentDeleteOk.TravelReview")) {
        	action = new TravelReviewCommentDeleteService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        else if(cmdURI.equals("/TravelReviewCommentList.TravelReview")) {
        	System.out.println("boardreplylist들어옴");
        	action = new TravelReviewCommentListService();
        	
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
>>>>>>> 최종커밋
    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
