package string테스트;

public class StringTest1 {

		public static void main(String[] args) {
			//String - 한번 할당되면 값 변경X, 값이변경되면 새로운주소값을 만들어 할당
			//읽기(조회)가 많은경우 성능우수, 값의변경이 많은경우 성능저하
			//문자열과 관련된 연산이 적은 경우 사용하면 좋다. 연산이 많으면 많을수록 성능차이가 현격하게 차이가남
			//실시간 문자열 연산에 부적합 ex)입력값에 특정한값을 붙여 새로운 문자열 생성 후, db에 저장하는 경우 부적합
			
			//StringBuffer - 한번 할당되면 값을 변경하여 사용가능
			//값의 변경이 많은 경우 성능 우수
			String s1 = "winner";
			String s2 = "success";
			String s3 = "winner1";
			String s4 = new String();
			
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s1.hashCode()); //주소값
			System.out.println(s2.hashCode());
			System.out.println(s3.hashCode());
			System.out.println(s4.hashCode());
			
		}
}
