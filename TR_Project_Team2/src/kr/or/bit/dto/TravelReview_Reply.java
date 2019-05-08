/*
     작업일자 : 2019/05/08
     작업자 : 이노진
     작업내용 : 여행후기 답글 게시판 dto
*/
package kr.or.bit.dto;

public class TravelReview_Reply {
private int tr_reply_num;			//여행후기답글 번호
private String id;					//아이디
private int tr_num;					//여행후기 원글번호
private String tr_reply_title;		//여행후기답글 제목
private String tr_reply_content;	//여행후기답글 내용
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
public int getTr_num() {
	return tr_num;
}
public void setTr_num(int tr_num) {
	this.tr_num = tr_num;
}
public String getTr_reply_title() {
	return tr_reply_title;
}
public void setTr_reply_title(String tr_reply_title) {
	this.tr_reply_title = tr_reply_title;
}
public String getTr_reply_content() {
	return tr_reply_content;
}
public void setTr_reply_content(String tr_reply_content) {
	this.tr_reply_content = tr_reply_content;
}
@Override
public String toString() {
	return "TravelReview_Reply [tr_reply_num=" + tr_reply_num + ", id=" + id + ", tr_num=" + tr_num
			+ ", tr_reply_title=" + tr_reply_title + ", tr_reply_content=" + tr_reply_content + "]";
}



}
