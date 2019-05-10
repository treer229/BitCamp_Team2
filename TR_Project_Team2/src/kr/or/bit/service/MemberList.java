package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class MemberList implements Action{

	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
	ActionForward forward = new ActionForward();
	try {
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return forward;
	}
}
