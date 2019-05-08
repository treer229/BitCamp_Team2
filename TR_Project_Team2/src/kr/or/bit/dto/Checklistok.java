package kr.or.bit.dto;

public class Checklistok {
	/*
    작업일자 : 2019-05-08
    작업자 :    정진호
    작업내용 : 체크리스트OK dto 작성
    */
	
	private int CLC_NUM;
	private int CLCC_CHECKED;
	
	public int getCLC_NUM() {
		return CLC_NUM;
	}
	public void setCLC_NUM(int cLC_NUM) {
		CLC_NUM = cLC_NUM;
	}
	public int getCLCC_CHECKED() {
		return CLCC_CHECKED;
	}
	public void setCLCC_CHECKED(int cLCC_CHECKED) {
		CLCC_CHECKED = cLCC_CHECKED;
	}
	@Override
	public String toString() {
		return "Checklistok [CLC_NUM=" + CLC_NUM + ", CLCC_CHECKED=" + CLCC_CHECKED + "]";
	}

	
}
