package kr.or.bit.dto;
/*
작업일자 : 2019-05-08
작업자 :   이힘찬
작업내용 : 회원 dto 작성
*/
public class Member { 			//회원table
	private String Id;			//아이디
	private String Password;	//비밀번호
	private String Name;		//이름
	private int Gender;			//성별		
	private String Email;		//이메일
	private String Travel;		//관심여행지역
	private int Admin;			//관리여부
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTravel() {
		return Travel;
	}
	public void setTravel(String travel) {
		Travel = travel;
	}
	public int getAdmin() {
		return Admin;
	}
	public void setAdmin(int admin) {
		Admin = admin;
	}
	
	@Override
	public String toString() {
		return "Member [Id=" + Id + ", Password=" + Password + ", Name=" + Name + ", Gender=" + Gender + ", Email="
				+ Email + ", Travel=" + Travel + ", Admin=" + Admin + "]";
	}
	
	
	
	
}
