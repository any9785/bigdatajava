package 배열;

public class 배열연습2 {

	public static void main(String[] args) {
		int [] num = {44, 66, 22, 88};
        
		
		//리스트에 들어있는 값들의 개수
		System.out.println(num.length);

		//전체 출력
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println("");
		
		//첫번째 값을 55로 변경해서 출력
		num[0] = 55;
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}

}
