package string�׽�Ʈ;

public class StringTest1 {

		public static void main(String[] args) {
			//String - �ѹ� �Ҵ�Ǹ� �� ����X, ���̺���Ǹ� ���ο��ּҰ��� ����� �Ҵ�
			//�б�(��ȸ)�� ������� ���ɿ��, ���Ǻ����� ������� ��������
			//���ڿ��� ���õ� ������ ���� ��� ����ϸ� ����. ������ ������ �������� �������̰� �����ϰ� ���̰���
			//�ǽð� ���ڿ� ���꿡 ������ ex)�Է°��� Ư���Ѱ��� �ٿ� ���ο� ���ڿ� ���� ��, db�� �����ϴ� ��� ������
			
			//StringBuffer - �ѹ� �Ҵ�Ǹ� ���� �����Ͽ� ��밡��
			//���� ������ ���� ��� ���� ���
			String s1 = "winner";
			String s2 = "success";
			String s3 = "winner1";
			String s4 = new String();
			
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s1.hashCode()); //�ּҰ�
			System.out.println(s2.hashCode());
			System.out.println(s3.hashCode());
			System.out.println(s4.hashCode());
			
		}
}
