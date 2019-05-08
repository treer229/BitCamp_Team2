package kr.or.bit.dto;

public class Tr_Reply_Comments {
	
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : 여행리뷰 답글 dto 작성
    */
	
	private int comment_num;
	private int tr_reply_num;
	private String id;
	private String comments_content;
	private String comment_date;
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getTr_reply_num() {
		return tr_reply_num;
	}
	public void setTr_reply_num(int tr_reply_num) {
		this.tr_reply_num = tr_reply_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	@Override
	public String toString() {
		return "Tr_Reply_Comments [comment_num=" + comment_num + ", tr_reply_num=" + tr_reply_num + ", id=" + id
				+ ", comments_content=" + comments_content + ", comment_date=" + comment_date + "]";
	}

	
}
