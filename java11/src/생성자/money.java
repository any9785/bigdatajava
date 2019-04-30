package »ý¼ºÀÚ;

public class money {
	String product;
	String name;
	String money;
	
	public money(){
	}
	public money(String product, String name, String money) {
		this.product = product;
		this.name = name;
		this.money = money;
	}
	@Override
	public String toString() {
		return product + "      " + name + "      " + money;
	}
	
	
	

}
