package ����ƽ;

public class Day {
	
	static int total; // �ѽð�
	static int aver;
	String doing;     
	int time;
	String location;
	static int count;
	
	public Day() {
	}
	public Day(String doing, int time, String location) {
		this.doing = doing;
		this.time = time;
		this.location = location;
		count++;
		total += time;
		aver = total/3;
	}
	public static int getTotal() {
		return total; 
		//static�޼ҵ峻�� ���Ǵ� ��������� �ݵ�� static������!!
		//��ü������ ������� Ŭ�����̸����� ���ٰ����� ����
	}
	@Override
	public String toString() {
		return "Day [doing=" + doing + ", time=" + time + ", location=" + location + "]";
	}
}