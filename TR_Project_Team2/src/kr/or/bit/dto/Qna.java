/*
     작업일자 : 2019/05/08
     작업자 : 이노진
     작업내용 : 묻고답하기 게시판 dto
*/
package kr.or.bit.dto;

public class Qna {

	private int Qna_Num;				//묻고답하기_글번호
	private String Id;					//아이디
	private String Qna_Title;			//묻고답하기_제목
	private String Qna_Content;			//내용
	private int Views;					//조회수
	private String Qna_Created_Date;	//작성일
	private int Qna_Comment_Count;		//댓글수
	public int getQna_Num() {
		return Qna_Num;
	}
	public void setQna_Num(int qna_Num) {
		Qna_Num = qna_Num;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getQna_Title() {
		return Qna_Title;
	}
	public void setQna_Title(String qna_Title) {
		Qna_Title = qna_Title;
	}
	public String getQna_Content() {
		return Qna_Content;
	}
	public void setQna_Content(String qna_Content) {
		Qna_Content = qna_Content;
	}
	public int getViews() {
		return Views;
	}
	public void setViews(int views) {
		Views = views;
	}
	public String getQna_Created_Date() {
		return Qna_Created_Date;
	}
	public void setQna_Created_Date(String qna_Created_Date) {
		Qna_Created_Date = qna_Created_Date;
	}
	public int getQna_Comment_Count() {
		return Qna_Comment_Count;
	}
	public void setQna_Comment_Count(int qna_Comment_Count) {
		Qna_Comment_Count = qna_Comment_Count;
	}
	@Override
	public String toString() {
		return "Qna [Qna_Num=" + Qna_Num + ", Id=" + Id + ", Qna_Title=" + Qna_Title + ", Qna_Content=" + Qna_Content
				+ ", Views=" + Views + ", Qna_Created_Date=" + Qna_Created_Date + ", Qna_Comment_Count="
				+ Qna_Comment_Count + "]";
	}

	
	
}
