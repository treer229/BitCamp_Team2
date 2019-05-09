package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ChecklistDAO;
import kr.or.bit.dto.Checklistcontent;

public class ChecklistContentView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		
		ActionForward forward = new ActionForward();
		ChecklistDAO dao = new ChecklistDAO();
		Checklistcontent clc = dao.getChecklistContent(num);
		
		request.setAttribute("content", clc);
		forward.setPath("/WEB-INF/Page/content.jsp");
		
		return forward;
	}

}
