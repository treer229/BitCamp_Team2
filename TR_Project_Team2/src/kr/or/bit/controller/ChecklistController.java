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
import kr.or.bit.service.DeleteChecklist;
import kr.or.bit.service.InsertChecklist;
import kr.or.bit.service.ReadChecklist;
import kr.or.bit.service.UpdateChecklist;
import kr.or.bit.service.UpdateOkChecklist;


@WebServlet("*.Checklist")
public class ChecklistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChecklistController() {
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
    	
    	
    	if(url_Command.equals("/write.Checklist")) {// 업무처리
      	  	action = new InsertChecklist();
      	  	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("Checkwrite업무 에러");
				e.printStackTrace();
			}
    	}else if(url_Command.equals("/read.Checklist")) {
    		action = new ReadChecklist();
      	  	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("Checkread업무 에러");
				e.printStackTrace();
			}
    	}else if(url_Command.equals("/del.Checklist")) {
    		action = new DeleteChecklist();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("Checkdelete업무 에러");
				e.printStackTrace();
			}
    	}else if(url_Command.equals("/edit.Checklist")) {
    		action = new UpdateChecklist();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("Checkedit업무 에러");
				e.printStackTrace();
			}
    	}else if(url_Command.equals("/updateok.Checklist")) {
    		action = new UpdateOkChecklist();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("updateok업무 에러");
				e.printStackTrace();
			}
    	}
    	
    	
    	if(forward != null) {
            RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
                rd.forward(request, response);
            }
    }
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
