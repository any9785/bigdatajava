package java16;

public class MemberDTO {
	private String id;
	private String pw;
	private String content;
	
	
	public MemberDTO(String id, String pw, String content) {
		this.id = id;
		this.pw = pw;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	//Alt + shift + s + r
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setTitle(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", content=" + content + "]";
	}

	
	}

