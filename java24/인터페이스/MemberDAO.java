package 인터페이스;

public class MemberDAO implements MemberInterface {

	@Override
	public void insert(MemberDTO dto) {
		System.out.println("회원가입");
	}

	@Override
	public void delete(String id) {
		System.out.println("회원탈퇴");
	}

	@Override
	public void update(MemberDTO dto) {
		System.out.println("회원수정");
	}

	@Override
	public MemberDTO select(String id) {
		MemberDTO dto;
		//MemberDTO dto = new MemberDTO("park", "park", "park", "park");
		return dto;
	}

	
}
