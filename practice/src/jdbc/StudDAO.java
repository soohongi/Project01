package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudDAO {

	Connection con = null;
	Statement stmt =null;
	ResultSet rs = null;
	
	String url ="localhost:1521:orcl";
	String id = "hr";
	String pw = "hr";
	String sql = null;
	
	public StudDAO() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+url, "hr", "hr");
			stmt = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	List<StudDTO> getList()
	{
		List<StudDTO> res = new ArrayList<>();
		try {
			sql = "select * from exam";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				StudDTO dto = new StudDTO();
				
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setSid(rs.getString("sid"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setRegdate(rs.getDate("regdate"));

				res.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return res;
	}

	
	StudDTO getOne(String title)
	{
		StudDTO res = null;
		try {
			sql = "select * from exam where title='"+title+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				res = new StudDTO();
				
				res.setNo(rs.getInt("no"));
				res.setTitle(rs.getString("title"));
				res.setSid(rs.getString("sid"));
				res.setKor(rs.getInt("kor"));
				res.setEng(rs.getInt("eng"));
				res.setMat(rs.getInt("mat"));
				res.setRegdate(rs.getDate("regdate"));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return res;
	}
	
	
	int insert(StudDTO dto) {
		int res = 0;

		sql = "insert into exam " + "(no, title, sid, kor, eng, mat, regdate) " + "values (" + dto.getNo() + ",'"
				+ dto.getTitle() + "','" + dto.getSid() + "'," + dto.getKor() + ","+ dto.getEng() + ","+ dto.getMat() + ",'"
				+ new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dto.getRegdate())  + ")";

		System.out.println(sql);
		try {
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	void close() {

		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}

	}
}
