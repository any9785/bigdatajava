package jdbc;

public class MemberDTO { 
	private String id; //private ��������X
	private String pw;
	private String name;
	private String tel;
	
	//alt+shift+s+r : setters/getters : ���� �־��ٻ���
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
