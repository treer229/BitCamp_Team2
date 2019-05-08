/*
     작업일자 : 2019/05/08
     작업자 : 이노진
     작업내용 : 묻고답하기 답글 게시판 dto
*/

package kr.or.bit.dto;

public class Qna_Reply {
	private int Qna_Reply_Num;			//묻고답하기답글 번호
	private String Id;					//아이디
	private int Qna_Num;				//묻고답하기 원글번호
	private String Qna_Reply_Title;		//묻고답하기답글 제목
	private String Qna_Reply_Content;	//묻고답하기답글 내용
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
	public String getQna_Reply_Title() {
		return Qna_Reply_Title;
	}
	public void setQna_Reply_Title(String qna_Reply_Title) {
		Qna_Reply_Title = qna_Reply_Title;
	}
	public String getQna_Reply_Content() {
		return Qna_Reply_Content;
	}
	public void setQna_Reply_Content(String qna_Reply_Content) {
		Qna_Reply_Content = qna_Reply_Content;
	}
	@Override
	public String toString() {
		return "Qna_Reply [Qna_Reply_Num=" + Qna_Reply_Num + ", Id=" + Id + ", Qna_Num=" + Qna_Num
				+ ", Qna_Reply_Title=" + Qna_Reply_Title + ", Qna_Reply_Content=" + Qna_Reply_Content + "]";
	}
	
	
}
