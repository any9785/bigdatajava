package pos;

import java.util.Scanner;

public class member�Է� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("METERIAL �Է� : ");
		String meterial = sc.next();
		System.out.print("WAREHOUSING �Է� : ");
		int warehousing = sc.nextInt();
		System.out.print("STOCK �Է� : ");
		int stock = sc.nextInt();
		System.out.print("WAREHOUSINGDATE �Է� : ");
		int warehousingdate = sc.nextInt();
		
		
		
		member mb1 = new member();
		
		try {
			mb1.insert(meterial, warehousing, stock, warehousingdate);
		}catch (Exception e){
			System.out.println("����");
			e.printStackTrace();
		}
	}

}
