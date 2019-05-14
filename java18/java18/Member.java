package java18;

public class Member {
	private String name;
	private String content;
	private String reader;
	private String pw;
	
	public Member(String name, String content, String reader, String pw) {
		super();
		this.name = name;
		this.content = content;
		this.reader = reader;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", content=" + content + ", reader=" + reader + ", pw=" + pw + "]";
	}


	
	
	
}
