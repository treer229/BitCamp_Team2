package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoticeCommentsDao;
import kr.or.bit.dto.Notice_Comments;

public class InsertCommentsService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("comments 서비스 시작");
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String date = request.getParameter("date");
		
		System.out.println(id);
		System.out.println(content);
		System.out.println(date);

		Notice_Comments noticomments = new Notice_Comments();
		
		noticomments.setComments_num(1);
		noticomments.setNotice_num(1);
		noticomments.setId(id);
		noticomments.setComments_content(content);
		
		System.out.println(noticomments.toString());
		
		NoticeCommentsDao noticommentsdao = new NoticeCommentsDao();
		noticommentsdao.insertComment(noticomments);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/Page/test.jsp");
		System.out.println("서비스 끝");
		return forward;
	}
	
}
