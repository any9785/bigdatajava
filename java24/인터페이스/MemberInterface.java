package 인터페이스;

public interface MemberInterface {
		//강제성있는 기능을 정의
		//일반변수사용불가, 일반메소드 사용불가
		//상수사용가능
		//추상 <-> 구체적 , 추상 : 불완전
		//인터페이스는 객체를 생성하여 쓸 수 없다.
	
	public abstract void insert(MemberDTO dto);
	void delete(String id);
	void update(MemberDTO dto);
	MemberDTO select(String id);
}
