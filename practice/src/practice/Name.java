package practice;

import java.util.Scanner;
import java.util.regex.Pattern;

////회원 가입 유효성 검사를 실시하세요
/*
1. 아이디 : 영문 숫자 조합
2. 비번 , 비번확인 
3. 이메일  -  아이디:영문,숫자   @  도메인 : 영문 점
4. 전화번호 - 숫자 :  ###-####-####,   ##(#)-###-####
5. 이름 (한글만 가능)
6. 주민번호 
7. 사진 첨부-->영문,숫자.이미지 확장자
이미지(jpg, jpeg, bmp, png, gif)  --  대소문자 구분없음
8. 우편번호 검색 - 구단위 (초성검색)
예외처리로 처리할 것
*/
public class Name {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Pattern pp;
		String input;
		String input2;

		while(true)
		{
			try
			{
			/*	System.out.print("아이디 입력 :");
				input = sc.nextLine();
				if(!Pattern.matches("[0-9a-zA-Z]*", input))
			        throw new Exception("아이디 형식에러");
			    
			    System.out.print("비밀번호 입력 :");
			    input = sc.nextLine();
				if(!Pattern.matches(".*", input))
			        throw new Exception("비밀번호");
			    
			    System.out.print("비밀번호 확인 :");
			    input2 = sc.nextLine();
			    if(!input2.equals(input))
			    	throw new Exception("비밀번호가 다릅니다.");
			    
			    System.out.print("이메일 입력 :");
			    input = sc.nextLine();
			    if(!Pattern.matches("[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}[.][0-9a-zA-Z]{1,}", input))
			        throw new Exception("이메일 형식에러");
			    
			    
			    
			    System.out.print("전화번호 입력 :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}", input))
			        throw new Exception("전화번호 형식에러");
			    
			    
			    System.out.print("이름 입력 : ");
			    input = sc.nextLine();
				if(!Pattern.matches("[가-힣]{2,4}", input))
			        throw new Exception("이름 형식에러");
			    
			    System.out.print("주민번호 입력 :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9]{6}-[0-9]{7}", input))
			        throw new Exception("주민번호 형식에러");
			    
			      */  
		        
			    System.out.print("파일 첨부 :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9a-zA-Z]*[.](jpg|jpeg|bmp|png|gif|JPG|JPEG|BMP|PNG|GIF)", input))
			        throw new Exception("파일 형식에러");
			        
			    break;
	
			}
			catch (Exception e) 
			{
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		System.out.println("로그인!");
		
	}

}
