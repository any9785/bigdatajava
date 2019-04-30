package 배열;

public class 다이나믹배열 {

	public static void main(String[] args) { //각반의 평균구하기
		int num[][] = {
				{44, 55, 66}, //1반
				{77, 88, 99, 100} //2반
		};
		
		int avg = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				avg += num[i][j];
		
			}
			System.out.println(i+1 + "반의 평균은: " + avg/num[i].length);
			avg = 0;
		}
		

	}

}
