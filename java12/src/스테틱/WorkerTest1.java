package 스테틱;

public class WorkerTest1 {

	public static void main(String[] args) {
		WorkerTest wk1 = new WorkerTest("임아무개", "남", 24);
		WorkerTest wk2 = new WorkerTest("김아무개", "여", 23);
		WorkerTest wk3 = new WorkerTest("박아무개", "남", 25);
		
		System.out.println("전체 직원수는: " + WorkerTest.count);
		System.out.println("직원들의 평균나이는: " + wk1.aver());
		System.out.println("전체 직원");
		System.out.println(wk1);
		System.out.println(wk2);
		System.out.println(wk3);
		
		
	}

}
