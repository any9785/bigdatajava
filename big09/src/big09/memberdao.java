package big09;

public ArrayList<memberDTO> selectAll() throws Exception {
    ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 
    
    //1.2단계를 해주는 DBconnectinMgr 객체 필요
    Connection con = mgr.getConnection();
    
    
    
    //3단계 sql문 결정
    String sql = "select * from member ";
    PreparedStatement ps = con.prepareStatement(sql);
    
    
    
    //4단계 sql문 전달요청
    ResultSet rs =  ps.executeQuery();
    MemberDTO  dto2 = null;
    while(rs.next()) {
       dto2 = new MemberDTO();
       String id = rs.getString(1);
       String pw = rs.getString(2);
       String name = rs.getString(3);
       String tel = rs.getString(4);
       dto2.setId(id);
       dto2.setPw(pw);
       dto2.setName(name);
       dto2.setTel(tel);
       list.add(dto2);
       
    }
    return list;
 	}
}