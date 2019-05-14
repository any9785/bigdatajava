package 배열;


public class 스트링배열 {

	public static void main(String[] args) {
		int[] ages = {50, 100, 10};
		for (int i : ages) {
			System.out.print(i + " ");
		}
		System.out.println();
		String[] names = {"홍길동", "박길동", "김길동"};
		
		names[2] = "김동길";
		names[names.length-1] = "김동순";
		
		for (int i = 0; i < ages.length; i++) {
			System.out.print(ages[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}
		System.out.println();
		
		for (int i : ages) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (String imsi : names) {
			System.out.print(imsi + " ");
		}
		
		

		
		
		
		
		
		
		
		
		
		
		
	}

}
