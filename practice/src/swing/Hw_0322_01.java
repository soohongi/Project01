package swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

class Mine25_HW extends JFrame implements ActionListener{

    List<JButton> btn=new ArrayList<>();
    Set<Integer> mine=new HashSet<>();
    int clear, m, n;

    public Mine25_HW(int n, int m) {
        this.clear=n*n;
        this.n=n;
        this.m=m;

        setBounds(300, 200, n*20, n*20);
        setLayout(new GridLayout(n,n));
        
        while(btn.size()!=(n*n)){
            JButton bt=new JButton();
            bt.addActionListener(this);
            bt.setSize(20,20);
            btn.add(bt);
            add(bt);
        }

        while(mine.size()!=m){
            mine.add((int)(Math.random()*n*m));

        }

        for(int num:mine){
            System.out.print(num+", ");
        }

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton bt:btn){
            if(e.getSource()==bt){
                if(mine.contains(btn.indexOf(bt))){
                    bt.setBackground(Color.black);
                    JOptionPane.showMessageDialog(this, "지뢰를 밟으셨습니다. 꽝!!!");
                }else{
                    clear--;
                    int cnt=0;
                    if(mine.contains(btn.indexOf(bt)-1)) cnt++;
                    if(mine.contains(btn.indexOf(bt)+1)) cnt++;
                    if(mine.contains(btn.indexOf(bt)-n-1)) cnt++;
                    if(mine.contains(btn.indexOf(bt)-n)) cnt++;
                    if(mine.contains(btn.indexOf(bt)-n+1)) cnt++;
                    if(mine.contains(btn.indexOf(bt)+n-1)) cnt++;
                    if(mine.contains(btn.indexOf(bt)+n)) cnt++;
                    if(mine.contains(btn.indexOf(bt)+n+1)) cnt++;

                    

                    if(cnt==0){
                        bt.setBackground(Color.green);
                    }else if(cnt==1){
                        bt.setBackground(Color.yellow);
                    }else if(cnt==2){
                        bt.setBackground(Color.orange);
                    }else{
                        bt.setBackground(Color.red);
                    }

                    

                    if(clear==m){
                        JOptionPane.showMessageDialog(this, "게임 클리어!!! 축하드립니다!!!");
                    }
                }
            }
        }
    }
}

public class Hw_0322_01 {
    public static void main(String[] args) {
        new Mine25_HW(25, 10);

    }

}