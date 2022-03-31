package dto;

public class Member {
	
	private String memberID;
	private String password;
	private String name;
	private String email;
	
	public Member() {};
	
	public Member(String memberID, String password, String name, String email) {
		super();
		this.memberID = memberID;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
