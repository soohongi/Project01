package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Image_01 extends JFrame implements MouseMotionListener{
   
   Image img = null;
   Graphics gimg = null;
   
   public Image_01() {
      // TODO Auto-generated constructor stub
      setBounds(600, 0, 600, 600);
      
      /*
       * ���� �߻� ---> setVisible(true); ���� ����
       * ȭ�� ���� ���� Graphics�� ���� �� ����
      img = createImage(600, 400);
      gimg = img.getGraphics();
         
      */
      
      setVisible(true);   ///------1
      setResizable(false);
      
      addWindowListener(new FrameClose2());
      
      //setVisible(true); ���� ����
      
      img = createImage(400, 400);///---2
      gimg = img.getGraphics();   ///---3
      
      //gimg�� �̿��Ͽ� img�� �׸��� (��ȭ���� �׸�)
      /*gimg.fillOval(100, 100, 200,200);   ///---4
      gimg.fillOval(100, 350, 200,200);  *//// ������ ��� image ũ�� �ȿ����� �׷����� ��
      
      addMouseMotionListener(this);
   }
   
   int x =0, y=0;
   boolean   chk = false;
   String str="*";
   
   void init(Graphics g)
   {
      if(!chk)
      {
         chk = true;
         g.setColor(Color.blue);
         g.fillRect(0, 0, 600, 600);
         g.setColor(Color.BLACK);
      }
   }
   @Override
   public void paint(Graphics g) {
      // TODO Auto-generated method stub
      //super.paint(g);
      
      /// jframe�� img �׸���
      /// ���� ��ȭ�� ���̱�
      init(g);
      g.drawImage(img, 100,100,this);
      // �̹���, x��ġ, y��ġ, (observer)������ 
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new Image_01();
   }



   @Override
   public void mouseDragged(MouseEvent e) {
      // TODO Auto-generated method stub
	   
	   x = e.getX();
	   y = e.getY();
      if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK)
      {

         str="*";
         gimg.setColor(Color.black);
         gimg.drawString(str, x-100,y-91);
      }else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK)
      {
         str="-";
         gimg.setColor(Color.YELLOW);
         gimg.fillOval(x-150, y-150, 100,100);
      }
      
      
      repaint();
   }



   @Override
   public void mouseMoved(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }

}