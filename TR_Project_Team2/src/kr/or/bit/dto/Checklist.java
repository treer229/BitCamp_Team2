package kr.or.bit.dto;

public class Checklist {
	/*
    작업일자 : 2019-05-08
    작업자 :    정진호
    작업내용 : 체크리스트 dto 작성
    */
	
	private int CL_NUM;
	private String ID;
	private String CL_TITLE;
	private String COLOR;
	
	
	public int getCL_NUM() {
		return CL_NUM;
	}
	public void setCL_NUM(int cL_NUM) {
		CL_NUM = cL_NUM;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCL_TITLE() {
		return CL_TITLE;
	}
	public void setCL_TITLE(String cL_TITLE) {
		CL_TITLE = cL_TITLE;
	}
	public String getCOLOR() {
		return COLOR;
	}
	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}
	@Override
	public String toString() {
		return "Checklist [CL_NUM=" + CL_NUM + ", ID=" + ID + ", CL_TITLE=" + CL_TITLE + ", COLOR=" + COLOR + "]";
	}
	
	
	
}
