/*
     작업일자 : 2019/05/08
     작업자 : 이노진
     작업내용 : 여행후기 답글 게시판 dto
*/
package kr.or.bit.dto;

public class TravelReview_Reply {
private int Tr_Reply_Num;			//여행후기답글 번호
private String Id;					//아이디
private int Tr_Num;					//여행후기 원글번호
private String Tr_Reply_Title;		//여행후기답글 제목
private String Tr_Reply_Content;	//여행후기답글 내용
public int getTr_Reply_Num() {
	return Tr_Reply_Num;
}
public void setTr_Reply_Num(int tr_Reply_Num) {
	Tr_Reply_Num = tr_Reply_Num;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public int getTr_Num() {
	return Tr_Num;
}
public void setTr_Num(int tr_Num) {
	Tr_Num = tr_Num;
}
public String getTr_Reply_Title() {
	return Tr_Reply_Title;
}
public void setTr_Reply_Title(String tr_Reply_Title) {
	Tr_Reply_Title = tr_Reply_Title;
}
public String getTr_Reply_Content() {
	return Tr_Reply_Content;
}
public void setTr_Reply_Content(String tr_Reply_Content) {
	Tr_Reply_Content = tr_Reply_Content;
}
@Override
public String toString() {
	return "TravelReview_Reply [Tr_Reply_Num=" + Tr_Reply_Num + ", Id=" + Id + ", Tr_Num=" + Tr_Num
			+ ", Tr_Reply_Title=" + Tr_Reply_Title + ", Tr_Reply_Content=" + Tr_Reply_Content + "]";
}

}
