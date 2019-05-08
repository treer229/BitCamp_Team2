package kr.or.bit.dto;

public class Notice {
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : 공지 dto 작성
    */
	private int notice_num;
	private int notice_title;
	private String notice_content;
	private String date;
	private int comment_count;
	public int getnotice_num() {
		return notice_num;
	}
	public void setnotice_num(int notice_num) {
		notice_num = notice_num;
	}
	public int getnotice_title() {
		return notice_title;
	}
	public void setnotice_title(int notice_title) {
		notice_title = notice_title;
	}
	public String getnotice_content() {
		return notice_content;
	}
	public void setnotice_content(String notice_content) {
		notice_content = notice_content;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		date = date;
	}
	public int getcomment_count() {
		return comment_count;
	}
	public void setcomment_count(int comment_count) {
		comment_count = comment_count;
	}
	@Override
	public String toString() {
		return "Notice [notice_num=" + notice_num + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", date=" + date + ", comment_count=" + comment_count + "]";
	}
	
}
