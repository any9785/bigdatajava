package ����ƽ;

public class �����ϻ� {

	public static void main(String[] args) {
		Day day1 = new Day("�ڹٰ���", 10, "����");
		System.out.println(Day.count);
		Day day2 = new Day("����	", 15, "������");
		System.out.println(Day.count);
		Day day3 = new Day("�", 11, "��Ʈ�Ͻ�");
		System.out.println(Day.count);
		
		System.out.println(day1);
		System.out.println(day2);
		System.out.println(day3);
		
		System.out.println();
		System.out.println("��ü�ϴ����� �ð���: " + Day.total);
		System.out.println(Day.getTotal());
		System.out.println("����ϴ����� �ð���: " + Day.aver);
		System.out.println("���ϰ� �޴���?" + Day.count);
	}

}
