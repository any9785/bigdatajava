package »ý¼ºÀÚ;

public class Member {

	String name;
	int age;
	String tel;
	String addr;
	
	public Member() {
	}
	public Member(String name, int age, String tel, String addr) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.addr = addr;
	}
	public String toString() {
		return name + "   " + age + "    " + tel + "    " + addr + "   ";
	}
	
	
	

}
