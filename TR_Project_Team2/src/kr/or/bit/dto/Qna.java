/*
     작업일자 : 2019/05/08
     작업자 : 이노진
     작업내용 : 묻고답하기 게시판 dto
*/
package kr.or.bit.dto;

public class Qna {

	private int qna_num;				//묻고답하기_글번호
	private String id;					//아이디
	private String qna_title;			//묻고답하기_제목
	private String qna_content;			//내용
	private int views;					//조회수
	private String qna_created_date;	//작성일
	private int qna_comment_count;		//댓글수
	
	//계층형
	private int refer;	//참조
	private int depth;	//들여쓰기
	private int step;	//글의 순서
	
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getQna_created_date() {
		return qna_created_date;
	}
	public void setQna_created_date(String qna_created_date) {
		this.qna_created_date = qna_created_date;
	}
	public int getQna_comment_count() {
		return qna_comment_count;
	}
	public void setQna_comment_count(int qna_comment_count) {
		this.qna_comment_count = qna_comment_count;
	}
	@Override
	public String toString() {
		return "Qna [qna_num=" + qna_num + ", id=" + id + ", qna_title=" + qna_title + ", qna_content=" + qna_content
				+ ", views=" + views + ", qna_created_date=" + qna_created_date + ", qna_comment_count="
				+ qna_comment_count + "]";
	}
	

	
	
}
