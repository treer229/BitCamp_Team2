package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.ChecklistDAO;
import kr.or.bit.dto.Checklist;

public class ChecklistRead implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		ChecklistDAO listdao = new ChecklistDAO();
		
		List<Checklist> list = listdao.getCheckListAll("admin");
		request.setAttribute("list", list);
		
		forward.setPath("/WEB-INF/Page/test.jsp");
		
		return forward;
	}

}
