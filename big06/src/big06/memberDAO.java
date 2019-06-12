package big06;

public class memberDAO {
	//dao의 단계를 조금 효율적으로 변경
	public void insert(MemberDTO dto) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/member";
	}
}

