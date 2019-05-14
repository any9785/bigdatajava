package 배열;


public class 데이터입력받아배열에넣기6 {

	public static void main(String[] args) {
		int[] num = new int[5];
		
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}
		for (int i : num) {
			System.out.print(i + " ");
		}

	}

}
