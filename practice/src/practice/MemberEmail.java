package practice;
///ȸ�� ������ �����ϼ���

/// ������� : jpg,bmp,png,gif �� �ø�����
/// �̸��� ��ȿ�� �˻��ϼ���

////  ���̵�@������   ������ �� : @ �Ѱ�
///  ���̵� ������
//// ������ �������� ���� ������ ������ 2,3����
         //// naver.com,   yahoo.co.kr 
/// ��ȭ��ȣ�� ���ڸ�
/// ����ó�� ����� ��
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
				throw new Exception("Ȯ���� ����");
			
			chk = false;
			for (int i = 0; i < domainchk.length; i++) {
				if(domain[i].equals(domainchk[1].toLowerCase()))
				{
					chk = true;
					break;
				}
			}
			
			if(!chk)
				throw new Exception("������ ����");
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e.getMessage());
		
			
			
		
		}
	}
}