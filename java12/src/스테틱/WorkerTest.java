package 스테틱;

public class WorkerTest {
	
	String name;
	String gender;
	int age;
	static int count;
	static int sum;
	
	public WorkerTest() {
	}
	public WorkerTest(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		sum += age;
		count++;
	}
	public void work() {
		System.out.println("일하다");
	}
	public void friendly() {
		System.out.println("친화력있다");
	}
	public int aver() {
		return sum/count;
		
	}
	@Override
	public String toString() {
		return "WorkerTest [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
}


