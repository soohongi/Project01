package jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudDTO {

	String title, sid;
	Integer no, kor, eng, mat;
	Date regdate;
	
	public StudDTO(Integer no, String title, String sid, Integer kor, Integer eng, Integer mat, String regdate) {
		this.no = no;
		this.title = title;
		this.sid = sid;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		try {
			this.regdate =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(regdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public StudDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getKor() {
		return kor;
	}

	public void setKor(Integer kor) {
		this.kor = kor;
	}

	public Integer getEng() {
		return eng;
	}

	public void setEng(Integer eng) {
		this.eng = eng;
	}

	public Integer getMat() {
		return mat;
	}

	public void setMat(Integer mat) {
		this.mat = mat;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "StudDTO [no=" + no + ", title=" + title + ", sid=" + sid + ", kor=" + kor + ", eng=" + eng + ", mat="
				+ mat + ", regdate=" + regdate + "]";
	}

}
