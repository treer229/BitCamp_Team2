/*
     작업일자 : 2019/05/08
     작업자 : 이노진
     작업내용 : 묻고답하기 답글 게시판 dto
*/

package kr.or.bit.dto;

public class Qna_Reply {
	private int qna_reply_num;			//묻고답하기답글 번호
	private String id;					//아이디
	private int qna_num;				//묻고답하기 원글번호
	private String qna_reply_title;		//묻고답하기답글 제목
	private String qna_reply_content;	//묻고답하기답글 내용
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
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getQna_reply_title() {
		return qna_reply_title;
	}
	public void setQna_reply_title(String qna_reply_title) {
		this.qna_reply_title = qna_reply_title;
	}
	public String getQna_reply_content() {
		return qna_reply_content;
	}
	public void setQna_reply_content(String qna_reply_content) {
		this.qna_reply_content = qna_reply_content;
	}
	@Override
	public String toString() {
		return "Qna_Reply [qna_reply_num=" + qna_reply_num + ", id=" + id + ", qna_num=" + qna_num
				+ ", qna_reply_title=" + qna_reply_title + ", qna_reply_content=" + qna_reply_content + "]";
	}
	
	
	
}
