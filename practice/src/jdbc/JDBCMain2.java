package jdbc;

public class JDBCMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudDAO dao = new StudDAO();

		for(StudDTO dto :dao.getList())
		{
			System.out.println(dto);
		}
		
		System.out.println(new StudDAO().getOne("semi"));
		
		/*System.out.println(new StudDAO().insert(
	new StudDTO(100,"asd","1234567",99,88,77,"2017-04-07 15:20:30")));*/
	}

}
