package ��ǰ�����;

public class ���� {

	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.company = "apple";
		p1.shape = "�׸���";
		p1.size = 11;
		
		System.out.println(p1.company);
		System.out.println(p1.shape);
		System.out.println(p1.size);
		p1.call();
		p1.text();
		p1.alarm();
		
		Phone p2 = new Phone();
		p2.company = "Galxey";
		p2.shape = "�׸���";
		p2.size = 10;
		
		System.out.println(p2.company);
		System.out.println(p2.shape);
		System.out.println(p2.size);
		p2.call();
		p2.text();
		p2.alarm();
		
				
		
		System.out.println("----------------");
		
		TV tv1 = new TV();
		tv1.color = "������"; //����
		tv1.power = true;
		tv1.size = 50;
		//System.out.println(tv1.color);
		//System.out.println(tv1.power);
		//System.out.println(tv1.size);
		System.out.println(tv1);
		tv1.changeCh(); //�޼ҵ�
		tv1.connect();
		tv1.sound();
		System.out.println();
		
		//class�� �����ؼ� ���� tv2�� ��ü(���, object)
		//new�� ���� : ��ü ����
		
		TV tv2 = new TV();
		tv2.color = "������";
		tv2.power = false;
		tv2.size = 30;
		//System.out.println(tv2.color);
		//System.out.println(tv2.power);
		//System.out.println(tv2.size);
		tv1.changeCh();
		tv1.connect();
		tv1.sound();
		
		System.out.println(tv2);
		
		}

}
