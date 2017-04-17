package practice;

//mp3 �뷡��⸦ �����ϼ���
//1. �뷡 ���� :  Ʈ����ȣ, �뷡����, ����
//2. �뷡 ����Ʈ -->next �� �ֱ�
//3. �������� ������, ������, Ʈ����ȣ
//////////////////////////////////////////////////////////////////////
//�˻������ �����ϼ���
//1. �������� �˻�
//2. ���� Ʈ�� ���ĺ��� �˻�
//3. ����, ������ �����Ͽ� �˻� 
import java.util.Stack;

class Music_01{																// class Music_01 ����
	String title, singer;													// String title, singer ����
	int tr;																	// int tr ����
	public Music_01(int tr, String title, String singer) {					// Music_01 ������ ����ؼ� ������ �Է� (�ʱ�ȭ)
		super();															
		this.tr = tr;														
		this.title = title;
		this.singer = singer;
	}
	@Override
	public String toString() {												//toString�� �̿��Ͽ� ����Ѵ�.
		return tr + ". " + title + " (" + singer + ")";
	}	
}

class MP3_01	
{
	Music_01 now=null;														// Music_01 class�� ��ü�� null���� �־� �ʱ�ȭ �Ѵ�.
	
	Stack back = new Stack();												// Stack back ����, ����
	Stack next = new Stack();												// Stack next ����, ����
	int tot = 0;															// tot �ʱ�ȭ ==>
	
	void input(String title, String singer)
	{
		/*for (int i = 0; i<next.size() ; i++) {
			((Music_01)next.get(i)).tr=next.size()-i;
		}*/
		
		
		next.add(0,new Music_01(next.size()+1,title, singer));				// Vector�� add�� �̿��Ͽ� ���� 0��°�� ���� ����ֱ� ������ �� ������ ���� 0��°��
																			// �� ������ ���� 0��°�� �ִ� ���� �о�� ���� �ȴ�.
		tot = next.size();													// ��ü ���� ������ next.size()�����Ͽ� ���Ѵ�.
	}
	
	boolean nextModule()													// boolean�� nextModule()�޼ҵ�
	{
		boolean res = false;												// boolean�� res�� ���� flase�� �ʱ�ȭ
		
		if(!next.isEmpty())													// if�� ==> next���ÿ��� ��������� Ȯ��(.isEmpty)
		{
			if(now!=null)													// if�� ==> now�� ��������� Ȯ��
				back.push(now);												// back���ÿ�  now�� �ִ� ���� push�ؼ� �ִ´�.
																	////////// now�� ���� ���� back�� �ִ� ���� Ȯ��!!                 ///////////////
			now = (Music_01)next.pop();										// now�� next�� ���� pop(������)�Ͽ� �����Ѵ�.
				
			res = true;														// res���� true�� �ʱ�ȭ
		}
		
		return res;															// res�� return�Ѵ�.
	}
	
	boolean backModule()													// boolean�� backModule �޼ҵ�
	{
		boolean res = false;												// boolean�� res�� ����  flase �ʱ�ȭ
		
		if(!back.isEmpty())													// if�� ==> back ���ÿ��� ��������� Ȯ��(.isEmpty)
		{																	
			if(now!=null)													// if�� ==> now�� ��������� Ȯ��
				next.push(now);												// next���ÿ� now�� �ִ� ����  push�ؼ� �ִ´�.
																	////////// now�� ���� ���� back�� �ִ� ���� Ȯ��!!                 ///////////////
			now = (Music_01)back.pop();										// now�� next�� ���� pop(������)�Ͽ� �����Ѵ�.
			
			res = true;														// res���� true�� �ʱ�ȭ
		}
		
		return res;															// res�� return�Ѵ�.
	}
	
	void goNext()															//goNext�޼ҵ�
	{
		System.out.println("goNext()>>>>>>>");								//���
		if(nextModule())													//if�� ==> nextModule�� ���϶�
			print();														//���
		else																//if���� flase�϶�
			System.out.println("����� ���� �����ϴ�.");							//���
		
		
	}
	
	void goBack()															//goNext�޼ҵ�
	{
		System.out.println("goBack()>>>>>>>");								//���
		if(backModule())													//if�� ==> nextModule�� ���϶�
			print();														//���
		else																//if���� flase�϶�
			System.out.println("�ڷΰ� ���� �����ϴ�.");							//���
		
	}
	

	void searchT(String str)
	{
		System.out.println("������� �˻��մϴ�~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!");
		
		if(now == null)
		{
			now=(Music_01)next.peek();
		}

		for (int i = 0; i < back.size() ; i++) {
			if(((Music_01)(back.get(i))).title == str)
			{
				goTr(((Music_01)(back.get(i))).tr);
			}
		}
		
		for (int i = 0; i < next.size() ; i++) {
			if(((Music_01)(next.get(i))).title == str)
			{
				goTr(((Music_01)(next.get(i))).tr);
			}
		}
	}
	
	void singersearchT(String str)
	{
		System.out.println("���������� �˻��մϴ�~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!");
		
		if(now == null)
		{
			now=(Music_01)next.peek();
		}

		for (int i = 0; i < back.size() ; i++) {
			if(((Music_01)(back.get(i))).singer == str)
			{
				goTr(((Music_01)(back.get(i))).tr);
			}
		}
		
		for (int i = 0; i < next.size() ; i++) {
			if(((Music_01)(next.get(i))).singer == str)
			{
				goTr(((Music_01)(next.get(i))).tr);
			}
		}
	}
	
	
	
	
	void nextsearchT(String str)
	{
		System.out.println("�������� Ʈ���� �˻��մϴ�~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!");
		
		boolean chk=false;
		if(now == null)
		{
			now=(Music_01)next.peek();
		}

		for (int i = 0; i < next.size() ; i++) {
			if(((Music_01)(next.get(i))).title == str)
			{
				chk = true;
				goTr(((Music_01)(next.get(i))).tr);
			}
		}
		
		if(!chk)
		{
			System.out.println("�ش� �˻����� ���Ŀ���  �����ϴ�.");
			System.out.println();
		}
	}
	
	void goTr(int tr)														// go tr�޼ҵ� (tr���� �޴´�.)
	{
		//System.out.println("goTr("+tr+")>>>>>>>");						// ���
		
		if(tr>tot || tr<0)													// if�� ==> tr�� ���� üũ
		{
			System.out.println("Ʈ����ȣ Ȯ!");								// ���
			return;															// ���
		}
		
		while(true)															// whle��
		{
			if(now.tr>tr)		backModule();								// now�� ��ȣ�� �˻��ҷ��� ��ȣ���� Ŭ��  �ڿ���(back) ã�´�.
			else if(now.tr<tr)	nextModule();								// now�� ��ȣ�� �˻��ҷ��� ��ȣ���� ������  �տ���(next) ã�´�.
				
			if(now.tr==tr)	break;											// now�� ��ȣ�� ã�� ��ȣ�� ������ break;
		}
		
		print();															// ���
	}
	
	
	void print()															//��¹�
	{
		
		System.out.println("�����:"+ now);
		System.out.println("�ڷ�:"+ back);
		System.out.println("������:"+next);
		System.out.println();
	}
}

public class Mp3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MP3_01 yoyo = new MP3_01();
		yoyo.input("�ð��� �޷���", "����ģ��");
		yoyo.input("����� �޷���", "����ģ��");
		yoyo.input("�������� �޷���", "����ģ��");
		yoyo.input("�������� �޷���", "�׸�ģ��");
		yoyo.input("�Ű����� �޷���", "����ģ��");
		yoyo.input("���ڸ��� �޷���", "��������");
		yoyo.input("���繫�Ҹ� �޷���", "�Ѻ��ȥ");
		yoyo.input("���ʸ� �޷���", "��������");
		yoyo.input("���̽��� �޷���", "������");
		yoyo.input("�ָ��� �޷���", "�����ؿ�");
	
		//yoyo.searchT("�������� �޷���");
		yoyo.print();
		
		//yoyo.goNext();
		/*yoyo.goNext();
		yoyo.goNext();
		yoyo.goBack();
		yoyo.goBack();
		yoyo.goBack();*/
		
		
		yoyo.searchT("�������� �޷���");
		yoyo.nextsearchT("���繫�Ҹ� �޷���");
		yoyo.nextsearchT("�������� �޷���");
		yoyo.singersearchT("����ģ��");
		
		
		
		/*yoyo.goTr(5);
		yoyo.goTr(2);
		yoyo.goTr(11);
		yoyo.goTr(-1);
		yoyo.goTr(2);*/
	}

}
