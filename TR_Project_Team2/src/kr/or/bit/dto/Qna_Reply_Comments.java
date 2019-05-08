package kr.or.bit.dto;

public class Qna_Reply_Comments {
	
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : 댓글 dto 작성
    */
	
	private int comments_num;
	private int qna_reply_num;
	private String id;
	private String comments_content;
	private String comments_date;
	public int getcomments_num() {
		return comments_num;
	}
	public void setcomments_num(int comments_num) {
		this.comments_num = comments_num;
	}
	public int getQna_reply_num() {
		return qna_reply_num;
	}
	public void setQna_reply_num(int qna_reply_num) {
		this.qna_reply_num = qna_reply_num;
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
	public String getcomments_date() {
		return comments_date;
	}
	public void setcomments_date(String comments_date) {
		this.comments_date = comments_date;
	}
	@Override
	public String toString() {
		return "Qna_Reply_Comments [comments_num=" + comments_num + ", qna_reply_num=" + qna_reply_num + ", id=" + id
				+ ", comments_content=" + comments_content + ", comments_date=" + comments_date + "]";
	}

	
}
