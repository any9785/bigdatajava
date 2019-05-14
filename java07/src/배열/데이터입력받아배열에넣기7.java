package 배열;


public class 데이터입력받아배열에넣기7 {

	public static void main(String[] args) {
		
		int num[] = {66, 77, 88, 99};
		
		int max = num[0];
		int min = num[0];
		for (int i = 0; i < num.length; i++) {
			if(max < num[i]) {
				max = num[i];
			}
			if (min > num[i]) {
				min = num[i];
				
			}
		}
		System.out.println("최대값은 " + max + "입니다.");
		System.out.println("최소값은 " + min + "입니다.");
		
	}

}
