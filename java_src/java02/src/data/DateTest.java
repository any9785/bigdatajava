package data;

public class DateTest {

	public static void main(String[] args) {
		// comment, 주석, 설명
		// 컨트롤+/ (한줄주석)
//		sysout, syso + (컨트롤+스페이스바) : 자동완성
		System.out.println("나의 데이터 프린트..");
		//컨트롤+s(저장)
		//컨트롤+F11(실행)
		
		int spaceY = 300; // 4byte : -21~21억
		//byte(1byte(8bit) : -128~127
		//short(2byte)
		//int(4byte)
		//long(8byte)
		
		int startX = 0;
		int startY = 0;
		
		int result = startX + startY;
		String result2 = "그래픽의 시작점 Y축은" + startY;
		System.out.println("그래픽의 시작점은 x축은" + startX);
		System.out.println(result2);
		
		System.out.println();
		
		float x = 5.5f;
		double y = 5.5;
		
		char gender = '남';
		boolean brakeTime = true; //false(거짓)
	}
}
