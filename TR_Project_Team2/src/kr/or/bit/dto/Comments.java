package kr.or.bit.dto;

public class Comments {
	
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : 댓글 dto 작성
    */
	
	private int comment_num;
	private int tr_reply_num;
	private int qna_reply_num;
	private String id;
	private int qna_num;
	private int tr_num;
	private int notice_num;
	private String comments_content;
	private String comment_date;
	public int getcomment_num() {
		return comment_num;
	}
	public void setcomment_num(int comment_num) {
		comment_num = comment_num;
	}
	public int gettr_reply_num() {
		return tr_reply_num;
	}
	public void settr_reply_num(int tr_reply_num) {
		tr_reply_num = tr_reply_num;
	}
	public int getqna_reply_num() {
		return qna_reply_num;
	}
	public void setqna_reply_num(int qna_reply_num) {
		qna_reply_num = qna_reply_num;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		id = id;
	}
	public int getqna_num() {
		return qna_num;
	}
	public void setqna_num(int qna_num) {
		qna_num = qna_num;
	}
	public int gettr_num() {
		return tr_num;
	}
	public void settr_num(int tr_num) {
		tr_num = tr_num;
	}
	public int getnotice_num() {
		return notice_num;
	}
	public void setnotice_num(int notice_num) {
		notice_num = notice_num;
	}
	public String getcomments_content() {
		return comments_content;
	}
	public void setcomments_content(String comments_content) {
		comments_content = comments_content;
	}
	public String getcomment_date() {
		return comment_date;
	}
	public void setcomment_date(String comment_date) {
		comment_date = comment_date;
	}
	@Override
	public String toString() {
		return "Comments [comment_num=" + comment_num + ", tr_reply_num=" + tr_reply_num + ", qna_reply_num="
				+ qna_reply_num + ", id=" + id + ", qna_num=" + qna_num + ", tr_num=" + tr_num + ", notice_num="
				+ notice_num + ", comments_content=" + comments_content + ", comment_date=" + comment_date + "]";
	}
	
}
