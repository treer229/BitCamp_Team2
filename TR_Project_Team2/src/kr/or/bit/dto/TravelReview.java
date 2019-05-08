package kr.or.bit.dto;
/*
작업일자 : 2019-05-08
작업자 :   이힘찬
작업내용 : 여행후기 dto 작성
*/
public class TravelReview {			//여행후기
	private int Tr_Num;				//여행후기_글번호
	private String Id;				//아이디
	private String Tr_Title;		//여행후기_제목
	private String Content;			//내용
	private int Views;				//조회수
	private String Created_Date;	//작성일
	private int Comment_Count;		//댓글수
	
	public int getTr_Num() {
		return Tr_Num;
	}
	public void setTr_Num(int tr_Num) {
		Tr_Num = tr_Num;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTr_Title() {
		return Tr_Title;
	}
	public void setTr_Title(String tr_Title) {
		Tr_Title = tr_Title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getViews() {
		return Views;
	}
	public void setViews(int views) {
		Views = views;
	}
	public String getCreated_Date() {
		return Created_Date;
	}
	public void setCreated_Date(String created_Date) {
		Created_Date = created_Date;
	}
	public int getComment_Count() {
		return Comment_Count;
	}
	public void setComment_Count(int comment_Count) {
		Comment_Count = comment_Count;
	}
	
	@Override
	public String toString() {
		return "TravelReview [Tr_Num=" + Tr_Num + ", Id=" + Id + ", Tr_Title=" + Tr_Title + ", Content=" + Content
				+ ", Views=" + Views + ", Created_Date=" + Created_Date + ", Comment_Count=" + Comment_Count + "]";
	}
}
