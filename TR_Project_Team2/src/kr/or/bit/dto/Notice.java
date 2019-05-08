package kr.or.bit.dto;

public class Notice {
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : 공지 dto 작성
    */
	private int Notice_Num;
	private int Notice_Title;
	private String Notice_Content;
	private String Date;
	private int Comment_Count;
	public int getNotice_Num() {
		return Notice_Num;
	}
	public void setNotice_Num(int notice_Num) {
		Notice_Num = notice_Num;
	}
	public int getNotice_Title() {
		return Notice_Title;
	}
	public void setNotice_Title(int notice_Title) {
		Notice_Title = notice_Title;
	}
	public String getNotice_Content() {
		return Notice_Content;
	}
	public void setNotice_Content(String notice_Content) {
		Notice_Content = notice_Content;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getComment_Count() {
		return Comment_Count;
	}
	public void setComment_Count(int comment_Count) {
		Comment_Count = comment_Count;
	}
	@Override
	public String toString() {
		return "Notice [Notice_Num=" + Notice_Num + ", Notice_Title=" + Notice_Title + ", Notice_Content="
				+ Notice_Content + ", Date=" + Date + ", Comment_Count=" + Comment_Count + "]";
	}
	
}
