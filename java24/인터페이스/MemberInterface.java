package �������̽�;

public interface MemberInterface {
		//�������ִ� ����� ����
		//�Ϲݺ������Ұ�, �Ϲݸ޼ҵ� ���Ұ�
		//�����밡��
		//�߻� <-> ��ü�� , �߻� : �ҿ���
		//�������̽��� ��ü�� �����Ͽ� �� �� ����.
	
	public abstract void insert(MemberDTO dto);
	void delete(String id);
	void update(MemberDTO dto);
	MemberDTO select(String id);
}
