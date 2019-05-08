package kr.or.bit.dto;

public class Schedule {
	/*
    작업일자 : 2019-05-08
    작업자 :    정진호
    작업내용 : 스케줄 dto 작성
    */
	
	private int Schedule_NUM;
	private int DELETEOK;
	private int COMPLETEOK;
	private String ID;
	private String Schedule_TITLE;
	private String Content;
	private String Color;
	private String Schedule_START;
	private String Schedule_END;
	
	public int getSchedule_NUM() {
		return Schedule_NUM;
	}
	public void setSchedule_NUM(int schedule_NUM) {
		Schedule_NUM = schedule_NUM;
	}
	public int getDELETEOK() {
		return DELETEOK;
	}
	public void setDELETEOK(int dELETEOK) {
		DELETEOK = dELETEOK;
	}
	public int getCOMPLETEOK() {
		return COMPLETEOK;
	}
	public void setCOMPLETEOK(int cOMPLETEOK) {
		COMPLETEOK = cOMPLETEOK;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSchedule_TITLE() {
		return Schedule_TITLE;
	}
	public void setSchedule_TITLE(String schedule_TITLE) {
		Schedule_TITLE = schedule_TITLE;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getSchedule_START() {
		return Schedule_START;
	}
	public void setSchedule_START(String schedule_START) {
		Schedule_START = schedule_START;
	}
	public String getSchedule_END() {
		return Schedule_END;
	}
	public void setSchedule_END(String schedule_END) {
		Schedule_END = schedule_END;
	}
	
	@Override
	public String toString() {
		return "Schedule [Schedule_NUM=" + Schedule_NUM + ", DELETEOK=" + DELETEOK + ", COMPLETEOK=" + COMPLETEOK
				+ ", ID=" + ID + ", Schedule_TITLE=" + Schedule_TITLE + ", Content=" + Content + ", Color=" + Color
				+ ", Schedule_START=" + Schedule_START + ", Schedule_END=" + Schedule_END + "]";
	}
	
	
	
}
