package ff;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class win extends JFrame implements ActionListener{

    boolean a=false;
    int x=0;
    int flags=0; int cm=0;//電腦答案
    JLabel jtitle = new JLabel("終極密碼 0 ~ 100");
    JLabel flag = new JLabel("我現在隨機隨機出題 :");
    JLabel ans= new JLabel("電腦猜的數 :");
    JLabel ans2= new JLabel("00");
    JLabel flag2= new JLabel("00");
    boolean v=true;
    JButton touch = new JButton("Start!!");
    JButton upper = new JButton("往上猜");
    JButton lower = new JButton("往下猜");
    JLabel note = new JLabel("還沒猜中，繼續猜");
    Font f = new Font("標楷體", Font.PLAIN, 20);//建一個字型
    int max=100,min=0,cg=0;
    public win() {
        this.setSize(400, 600);//設定視窗大小
        this.setLocation(600, 150);//設定視窗在螢幕上的顯示位置
        this.setLayout(null);//設定布局
        this.setVisible(true);//設定視窗是否顯示
        this.setResizable(false);//設定設窗是否能改變大小
        this.setTitle("電腦猜數字 終極密碼");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//設定右上角的x功能(應該
        this.getContentPane();
        this.setLayout(null);
        addobj();
    }

    public void addobj() {
        jtitle.setBounds(50, 50, 200, 50);//設定位置與大小
        jtitle.setFont(f);//設定字形

        add(jtitle);//加入容器

        touch.setBounds(250, 50, 130, 50);
        touch.setFont(f);
        touch.addActionListener(this);//加入監聽器，this是因為有implements ActionListener
        touch.setActionCommand("touch");//設定按鈕的標籤?
        add(touch);

        flag.setBounds(50, 150, 200, 50);//設定位置與大小
        flag.setFont(f);//設定字形
        add(flag);//加入容器


//        flag2.setBounds(250, 150, 100, 50);//設定位置與大小
//        flag2.setFont(f);//設定字形
//        add(flag2);//加入容器*/

        ans.setBounds(50, 250, 200, 50);//設定位置與大小
        ans.setFont(f);//設定字形
        add(ans);//加入容器


        ans2.setBounds(250, 250, 100, 50);//設定位置與大小
        ans2.setFont(f);//設定字形
        add(ans2);//加入容器

        upper.setBounds(50, 350, 130, 50);
        upper.setFont(f);
        upper.addActionListener(this);//加入監聽器，this是因為有implements ActionListener
        upper.setActionCommand("upper");//設定按鈕的標籤?
        add(upper);

        lower.setBounds(200, 350, 130, 50);
        lower.setFont(f);
        lower.addActionListener(this);//加入監聽器，this是因為有implements ActionListener
        lower.setActionCommand("lower");//設定按鈕的標籤?
        add(lower);

        note.setBounds(70, 450, 350, 50);//設定位置與大小
        note.setFont(f);//設定字形
        add(note);//加入容器
    }
    public int guess(int x)
    {
        if(x==1)
        {
            min=cm;
            cm=(int)(Math.random()*(max-min)+min);
            return cm;
        }
        else
        {
            max=cm;
            cm=(int)(Math.random()*(max-min)+min);
            return cm;
        }
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton b = (JButton) e.getSource();

        if(b==touch) {

            if(x==0)
            {
                a=true;
//                flags = (int)(Math.random()*100)+1;
//                System.out.println(flags);
                max=100;min=0;
                
                flag2.setText(String.valueOf(flags));
                cm=(int)(Math.random()*(max-min)+min);
                ans2.setText(String.valueOf(cm));
                touch.setText("中獎");
                note.setText("還沒猜中，繼續猜");
                x=1;
            }else if (x==1){
                note.setText("恭喜猜中，點擊restart開啟下一輪");
                JOptionPane.showMessageDialog(this,"恭喜!","視窗", JOptionPane.PLAIN_MESSAGE,null);
                touch.setText("restart!");
                x=0;
            }


        }else if(b==upper&&a==true) {
            ans2.setText(String.valueOf(guess(1)));

        }else if(b==lower&&a==true) {
            ans2.setText(String.valueOf(guess(0)));
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//  GuessNumber g = new GuessNumber();
        win jfr = new win();
        jfr.setVisible(true);
    }

}
//
//}