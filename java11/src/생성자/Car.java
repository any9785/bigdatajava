package ������;

public class Car {
 
		//�����Ӽ�
		String color;
		boolean convertible;

		public Car() {    //�Ķ���� ���� �����ڸ� �⺻������         //����Ű : Alt + Shift + s + o
		}	
		public Car(String color) {
			this.color = color;
		}
		
		public Car(String color, boolean convertible) {
			this.color = color;
			this.convertible = convertible;
		}
		//�����Ӽ�
		public void change() {
			System.out.println("�� �ٲٴ�");
		}
		public int speedUp(int nowSpeed) {
			return nowSpeed + 30;
			
		}
		@Override
		public String toString() {
			return "Car [color=" + color + ", convertible=" + convertible + "]";
		}

}
