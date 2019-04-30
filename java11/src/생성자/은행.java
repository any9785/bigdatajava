package 생성자;

public class 은행 {

	public static void main(String[] args) {
		money money1 = new money();
		money1.product = "청약저축";
		money1.name = "김아무개";
		money1.money = "500만원";
		System.out.println("상품명          예금주         예금액");
		System.out.println(money1);

	}

}
