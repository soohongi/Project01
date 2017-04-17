package swing;

 

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.GridLayout;

import java.awt.Insets;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;

 

import javax.swing.JButton;

import javax.swing.JCheckBox;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;

import javax.swing.JPanel;

 

public class Calcul_01 extends JFrame implements ActionListener{

 

    JLabel res;

    JLabel res2;

    JButton btn;

    String str = "";

    String str2 = "";

    String str3 = "";

    ArrayList<JButton> btnArr = new ArrayList<>();

    String[] arr = {"MC", "MR", "MS", "M+", "M-", "←", "CE", "C", "±", "√",

            "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2", "3",

            "-", "=", "0", ".", "+"};

    

    public Calcul_01() {

        // TODO Auto-generated constructor stub

        

        super("계산기");

        setBounds(0, 0, 350, 400);

//        setLayout(new BorderLayout());

        

        JPanel p0 = new JPanel(); 

        JPanel p1 = new JPanel(); 

        JPanel p3 = new JPanel();

        

        JPanel p2 = new JPanel();

        p2.setBackground(Color.DARK_GRAY);

    

        p0.setLayout(new BorderLayout());

        res = new JLabel( str, JLabel.RIGHT);

        res2 = new JLabel( str2, JLabel.RIGHT);

        p1.add(res);

        p3.add(res2);

        p0.add(p1, "North");

        p0.add(p3);

        add(p0, "North");

        add(p2);

//----------------------------------------------------------

 

        JMenuBar mb = new JMenuBar();

        setJMenuBar(mb);

        JMenu m1 = new JMenu("보기(V)"); 

        JMenu m2 = new JMenu("편집(E)"); 

        JMenu m3 = new JMenu("도움말(H)"); 

        

        JMenuItem m3_1 = new JMenuItem("도움말 보기(V)");

        m3.addSeparator();

        JMenuItem m3_2 = new JMenuItem("계산기 정보(A)");

        m3.add(m3_1);

        m3.add(m3_2);

        

        mb.add(m1);

        mb.add(m2);

        mb.add(m3);    

    //-----------------------------------------------------------------------

        

        GridLayout gr = new GridLayout(6, 5);

        p2.setLayout(gr);

        add(p2);

        gr.setHgap(10);

        gr.setVgap(10);

                

        for (int i = 0; i < arr.length; i++) {

            btn = new JButton(arr[i]);

            p2.add(btn);

            btnArr.add(btn);

            btn.addActionListener(this);

        }    

    

        setVisible(true);

        //addWindowListener(new WinClose());

 

    }

//----------------------------------------------------------------        

    @Override

    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub

 

        String[] oper = new String[3];

        for (int i = 0; i < arr.length; i++) {

            if(e.getActionCommand().equals(arr[i]))

            {

                str2 += e.getActionCommand();

                res2.setText(str2);

                break;

            }            

        }

        if(e.getActionCommand().matches("[0-9]")) // 숫자 들어올 때

        {

            

        }

        else // 연산자 들어올 때 

        {

            res.setText(str2);

            str = str2.substring(0, str2.length()-1); // 연산자 앞 숫자

            res2.setText("");

                    

            if(oper[0] == null) oper[0] = str;

            else oper[2] = str;    

            

            oper[1] = e.getActionCommand();

 

            for (int i = 0; i < oper.length; i++) {

                System.out.println(i + "/// " + oper[i]);

            }

            

        }

            

    

    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        new Calcul_01();

 

    }

 

 

}