package kr.or.bit.controller;

import java.io.IOException;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

import javax.servlet.RequestDispatcher;
=======
>>>>>>> Hoguma
=======

import javax.servlet.RequestDispatcher;
>>>>>>> origin/CptNO
=======
>>>>>>> origin/Hoguma
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 받지마세염
>>>>>>> Hoguma
=======
>>>>>>> origin/CptNO
import kr.or.bit.service.CommentsListService;
import kr.or.bit.service.CommentsUpdateOkService;
import kr.or.bit.service.CommentsUpdateService;
import kr.or.bit.service.CommentsDeleteService;
import kr.or.bit.service.CommentsInsertService;
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> Revert "이것도 받지마세염"
=======

>>>>>>> 받지마세염
>>>>>>> Hoguma
=======
>>>>>>> origin/CptNO
=======
>>>>>>> origin/Hoguma

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/CptNO
    		System.out.println("InsertNotice.Comments");
    		action = new CommentsInsertService();
      	  	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("컨트롤러 막힘");
				e.printStackTrace();
			}
    		
<<<<<<< HEAD
=======
    		
<<<<<<< HEAD
<<<<<<< HEAD
=======

    		
>>>>>>> 받지마세염
>>>>>>> Hoguma
=======
>>>>>>> origin/CptNO
    	}  else if(url_Command.equals("/noticomlist.Comments")) {

    		System.out.println("noticomlist.Comments");
    		action = new CommentsListService();
      	  	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("컨트롤러 막힘");
				e.printStackTrace();
			}
    	} else if(url_Command.equals("/DeleteComNotice.comments")) {
    		System.out.println("DeleteComNotice");
    		action = new CommentsDeleteService();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("컨트롤러막힘");
				e.printStackTrace();
			}
    	} else if(url_Command.equals("/UpdateComNotice.comments")) {
    		try {
        		System.out.println("UpdateComNotice");
        		action = new CommentsUpdateService();
			} catch (Exception e) {
				System.out.println("컨트롤러 막힘");
				e.printStackTrace();
			}
    	} else if(url_Command.equals("/UpdateOkComNotice.comments")) {
    		try {
        		System.out.println("UpdateOkComNotice");
        		action = new CommentsUpdateOkService();
			} catch (Exception e) {
				System.out.println("컨트롤러 막힘");
				e.printStackTrace();
			}
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/CptNO
    	}
    	if(forward != null) {
            RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
                rd.forward(request, response);
            }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    		
    	}  else if(url_Command.equals("/MemoList.do")) {
    //		forward = new ActionForward();
    //		forward.setPath(/*여기에 주소를 넣어주세요*/);
>>>>>>> Revert "이것도 받지마세염"
=======

>>>>>>> 받지마세염
    	}
>>>>>>> Hoguma
=======
>>>>>>> origin/CptNO
=======
    		
    		
    	}  else if(url_Command.equals("/MemoList.do")) {
    //		forward = new ActionForward();
    //		forward.setPath(/*여기에 주소를 넣어주세요*/);
    	}
>>>>>>> origin/Hoguma
    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
