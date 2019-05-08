package pos;

import java.util.Scanner;

public class member입력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("METERIAL 입력 : ");
		String meterial = sc.next();
		System.out.print("WAREHOUSING 입력 : ");
		int warehousing = sc.nextInt();
		System.out.print("STOCK 입력 : ");
		int stock = sc.nextInt();
		System.out.print("WAREHOUSINGDATE 입력 : ");
		int warehousingdate = sc.nextInt();
		
		
		
		member mb1 = new member();
		
		try {
			mb1.insert(meterial, warehousing, stock, warehousingdate);
		}catch (Exception e){
			System.out.println("에러");
			e.printStackTrace();
		}
	}

}
