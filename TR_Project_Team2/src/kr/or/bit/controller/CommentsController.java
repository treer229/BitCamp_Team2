package kr.or.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.CommentsListService;
import kr.or.bit.service.InsertCommentsService;

/**
 * Servlet implementation class CommentsController
 */
@WebServlet("*.Comments")
public class CommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CommentsController() {
        super();
        // TODO Auto-generated constructor stub
    }


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
    	
    	
    	if(url_Command.equals("/InsertNotice.Comments")) {// 공지사항 댓글 보기
    		System.out.println("InsertNotice.Comments");
    		action = new InsertCommentsService();
      	  	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("컨트롤러 막힘");
				e.printStackTrace();
			}
    		
    	}  else if(url_Command.equals("/noticomlist.Comments")) {

    		System.out.println("noticomlist.Comments");
    		action = new CommentsListService();
      	  	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("컨트롤러 막힘");
				e.printStackTrace();
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
