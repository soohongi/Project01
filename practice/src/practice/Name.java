package practice;

import java.util.Scanner;
import java.util.regex.Pattern;

////È¸¿ø °¡ÀÔ À¯È¿¼º °Ë»ç¸¦ ½Ç½ÃÇÏ¼¼¿ä
/*
1. ¾ÆÀÌµğ : ¿µ¹® ¼ıÀÚ Á¶ÇÕ
2. ºñ¹ø , ºñ¹øÈ®ÀÎ 
3. ÀÌ¸ŞÀÏ  -  ¾ÆÀÌµğ:¿µ¹®,¼ıÀÚ   @  µµ¸ŞÀÎ : ¿µ¹® Á¡
4. ÀüÈ­¹øÈ£ - ¼ıÀÚ :  ###-####-####,   ##(#)-###-####
5. ÀÌ¸§ (ÇÑ±Û¸¸ °¡´É)
6. ÁÖ¹Î¹øÈ£ 
7. »çÁø Ã·ºÎ-->¿µ¹®,¼ıÀÚ.ÀÌ¹ÌÁö È®ÀåÀÚ
ÀÌ¹ÌÁö(jpg, jpeg, bmp, png, gif)  --  ´ë¼Ò¹®ÀÚ ±¸ºĞ¾øÀ½
8. ¿ìÆí¹øÈ£ °Ë»ö - ±¸´ÜÀ§ (ÃÊ¼º°Ë»ö)
¿¹¿ÜÃ³¸®·Î Ã³¸®ÇÒ °Í
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
			/*	System.out.print("¾ÆÀÌµğ ÀÔ·Â :");
				input = sc.nextLine();
				if(!Pattern.matches("[0-9a-zA-Z]*", input))
			        throw new Exception("¾ÆÀÌµğ Çü½Ä¿¡·¯");
			    
			    System.out.print("ºñ¹Ğ¹øÈ£ ÀÔ·Â :");
			    input = sc.nextLine();
				if(!Pattern.matches(".*", input))
			        throw new Exception("ºñ¹Ğ¹øÈ£");
			    
			    System.out.print("ºñ¹Ğ¹øÈ£ È®ÀÎ :");
			    input2 = sc.nextLine();
			    if(!input2.equals(input))
			    	throw new Exception("ºñ¹Ğ¹øÈ£°¡ ´Ù¸¨´Ï´Ù.");
			    
			    System.out.print("ÀÌ¸ŞÀÏ ÀÔ·Â :");
			    input = sc.nextLine();
			    if(!Pattern.matches("[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}[.][0-9a-zA-Z]{1,}", input))
			        throw new Exception("ÀÌ¸ŞÀÏ Çü½Ä¿¡·¯");
			    
			    
			    
			    System.out.print("ÀüÈ­¹øÈ£ ÀÔ·Â :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}", input))
			        throw new Exception("ÀüÈ­¹øÈ£ Çü½Ä¿¡·¯");
			    
			    
			    System.out.print("ÀÌ¸§ ÀÔ·Â : ");
			    input = sc.nextLine();
				if(!Pattern.matches("[°¡-ÆR]{2,4}", input))
			        throw new Exception("ÀÌ¸§ Çü½Ä¿¡·¯");
			    
			    System.out.print("ÁÖ¹Î¹øÈ£ ÀÔ·Â :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9]{6}-[0-9]{7}", input))
			        throw new Exception("ÁÖ¹Î¹øÈ£ Çü½Ä¿¡·¯");
			    
			      */  
		        
			    System.out.print("ÆÄÀÏ Ã·ºÎ :");
			    input = sc.nextLine();
				if(!Pattern.matches("[0-9a-zA-Z]*[.](jpg|jpeg|bmp|png|gif|JPG|JPEG|BMP|PNG|GIF)", input))
			        throw new Exception("ÆÄÀÏ Çü½Ä¿¡·¯");
			        
			    break;
	
			}
			catch (Exception e) 
			{
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		System.out.println("·Î±×ÀÎ!");
		
	}

}
