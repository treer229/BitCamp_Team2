package kr.or.bit.dto;

public class Checklistcontent {
	/*
    작업일자 : 2019-05-08
    작업자 :    정진호
    작업내용 : 체크리스트Content dto 작성
    */
	private int CLC_NUM;
	private int CL_NUM;
	private String CONTENT;
	
	public int getCLC_NUM() {
		return CLC_NUM;
	}
	public void setCLC_NUM(int cLC_NUM) {
		CLC_NUM = cLC_NUM;
	}
	public int getCL_NUM() {
		return CL_NUM;
	}
	public void setCL_NUM(int cL_NUM) {
		CL_NUM = cL_NUM;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	@Override
	public String toString() {
		return "Checklistcontent [CLC_NUM=" + CLC_NUM + ", CL_NUM=" + CL_NUM + ", CONTENT=" + CONTENT + "]";
	}
	
	
	
}
