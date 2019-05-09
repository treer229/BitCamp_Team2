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
import kr.or.bit.service.QnaCommentDeleteService;
import kr.or.bit.service.QnaCommentListService;
import kr.or.bit.service.QnaCommentService;
import kr.or.bit.service.QnaContentService;
import kr.or.bit.service.QnaDeleteService;
import kr.or.bit.service.QnaEditOkService;
import kr.or.bit.service.QnaListService;
import kr.or.bit.service.QnaRewriteOkService;
import kr.or.bit.service.QnaWriteService;


@WebServlet("*.Qna")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QnaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ActionForward forward = new ActionForward();
    	Action action = null;
    	
    	//요청받기 시작
    	String requestURI = request.getRequestURI();
    	String ContextPath = request.getContextPath();
    	String url_Command = requestURI.substring(ContextPath.length());

    	System.out.println("requestURI"+requestURI+"컨트롤러 check");
    	System.out.println("ContextPath"+ContextPath+"컨트롤러 check");
    	System.out.println("url_Command"+url_Command+"컨트롤러 check");
    	
    	//바로 list 페이지 이동
        // 글 작성 화면 요청이 들어왔을때, ok  (화면처리)
    	if(url_Command.equals("/QnaWrite.Qna")) {// 업무처리
    	   forward.setRedirect(false);
    	   forward.setPath("/board/board_write.jsp");
    	   System.out.println("if확인");

    	}  
    	 
    	// 글 작성 요청, ok
    	else if(url_Command.equals("/MemoList.do")) {
    		forward = new ActionForward();
    //		forward.setPath(/*여기에 주소를 넣어주세요*/);
    		action=new QnaWriteService();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	  // 글 리스트 보여주기, ok
        else if(url_Command.equals("/boardlist.bbs")){
        	
        	action = new QnaListService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
    	
    	  
        // 글 상세보기, ok
        else if(url_Command.equals("/boardRead.bbs")){
        	action = new QnaContentService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
    	
        
        // 글 수정 처리, ok
        else  if(url_Command.equals("/boardEdit.bbs")){
        	action = new QnaEditOkService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 글 삭제 비밀번호 확인 화면 제공, ok
        else if(url_Command.equals("/boardDeletePassword.bbs")){
        	forward.setRedirect(false);
        	forward.setPath("/board/board_delete.jsp");
        }
        
        
        // 글 삭제 비밀번호 확인 처리, ok
        else if(url_Command.equals("/boardDeleteCheck.bbs")){
        	action = new QnaDeleteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 답글작성 화면제공
        else if(url_Command.equals("/boardRewrite.bbs")) {
        	forward.setRedirect(false);
        	forward.setPath("/board/board_rewrite.jsp");
        }
        
        // 답글 작성
        else if(url_Command.equals("/boardRewriteok.bbs")) {
        	action = new QnaRewriteOkService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 작성
        else if(url_Command.equals("/boardReplyok.bbs")) {
        	action = new QnaCommentService();
        	System.out.println("boardReplyok................");
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 삭제
        else if(url_Command.equals("/boardreplyDeleteOk.bbs")) {
        	action = new QnaCommentDeleteService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        else if(url_Command.equals("/boardreplylist.bbs")) {
        	System.out.println("boardreplylist들어옴");
        	action = new QnaCommentListService();
        	
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
