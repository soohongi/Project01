package practice;
///회원 가입을 구현하세요

/// 증명사진 : jpg,bmp,png,gif 만 올리세요
/// 이메일 유효성 검사하세요

////  아이디@도메인   형태일 것 : @ 한개
///  아이디 영문만
//// 도메인 영문으로 구성 도메인 종류는 2,3개로
         //// naver.com,   yahoo.co.kr 
/// 전화번호는 숫자만
/// 예외처리 사용할 것
public class MemberEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String res_photo = "123.png";
		String res_email = "asd@naver.com";
		
		try
		{
			String [] file_index = {"jpg", "png", "gif"};
			String [] domain ={"naver.com", "yahoo.co.kr"};
			
			String [] filechk = res_photo.split("[.]");
			String [] domainchk = res_email.split("@");
			
			boolean chk = false;
			for (int i = 0; i < file_index.length; i++) {
				if(file_index[i].equals(filechk[1].toLowerCase()))
				{
					chk = true;
					break;
				}
			}
			
			if(!chk)
				throw new Exception("확장자 에러");
			
			chk = false;
			for (int i = 0; i < domainchk.length; i++) {
				if(domain[i].equals(domainchk[1].toLowerCase()))
				{
					chk = true;
					break;
				}
			}
			
			if(!chk)
				throw new Exception("도메인 에러");
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e.getMessage());
		
			
			
		
		}
	}
}