package kr.or.bit.dto;

public class Comments {
	
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : 댓글 dto 작성
    */
	
	private int Comment_Num;
	private int Tr_Reply_Num;
	private int Qna_Reply_Num;
	private String Id;
	private int Qna_Num;
	private int Tr_Num;
	private int Notice_Num;
	private String Comments_Content;
	private String Date;
	public int getComment_Num() {
		return Comment_Num;
	}
	public void setComment_Num(int comment_Num) {
		Comment_Num = comment_Num;
	}
	public int getTr_Reply_Num() {
		return Tr_Reply_Num;
	}
	public void setTr_Reply_Num(int tr_Reply_Num) {
		Tr_Reply_Num = tr_Reply_Num;
	}
	public int getQna_Reply_Num() {
		return Qna_Reply_Num;
	}
	public void setQna_Reply_Num(int qna_Reply_Num) {
		Qna_Reply_Num = qna_Reply_Num;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getQna_Num() {
		return Qna_Num;
	}
	public void setQna_Num(int qna_Num) {
		Qna_Num = qna_Num;
	}
	public int getTr_Num() {
		return Tr_Num;
	}
	public void setTr_Num(int tr_Num) {
		Tr_Num = tr_Num;
	}
	public int getNotice_Num() {
		return Notice_Num;
	}
	public void setNotice_Num(int notice_Num) {
		Notice_Num = notice_Num;
	}
	public String getComments_Content() {
		return Comments_Content;
	}
	public void setComments_Content(String comments_Content) {
		Comments_Content = comments_Content;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@Override
	public String toString() {
		return "Comments [Comment_Num=" + Comment_Num + ", Tr_Reply_Num=" + Tr_Reply_Num + ", Qna_Reply_Num="
				+ Qna_Reply_Num + ", Id=" + Id + ", Qna_Num=" + Qna_Num + ", Tr_Num=" + Tr_Num + ", Notice_Num="
				+ Notice_Num + ", Comments_Content=" + Comments_Content + ", Date=" + Date + "]";
	}
	
}
