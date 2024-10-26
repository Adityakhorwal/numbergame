package numbergame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Result extends JFrame implements ActionListener{
    
    JLabel text,thumbsup,thumbsdown,ans;
    JButton restart,quit;
    
    Result()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/background.jpg"));
        Image i2= i1.getImage().getScaledInstance(700, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        setLayout(null);
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(0,0,700,800);
        
        text=new JLabel();
        image.add(text);
        text.setForeground(Color.black);
        text.setBounds(300,300,600,100);
        text.setFont(new Font("System",Font.BOLD,40));
           
        ans=new JLabel();
        image.add(ans);
        ans.setForeground(Color.black);
        ans.setFont(new Font("System",Font.BOLD,40));
        ans.setBounds(280,240,500,100);

        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/thumbsup.png"));
        Image i5=i4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        
        thumbsup=new JLabel(i6);
        image.add(thumbsup);
        thumbsup.setBounds(160, 220, 100, 100);
        thumbsup.setVisible(false);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("images/thumbsdown.png"));
        Image i8=i7.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        
        thumbsdown=new JLabel(i9);
        image.add(thumbsdown);
        thumbsdown.setBounds(160, 260, 100, 100);
        thumbsdown.setVisible(false);
        
        restart=new JButton("Restart");
        image.add(restart);
        restart.addActionListener(this);
        restart.setBackground(Color.white);
        restart.setFont(new Font("System",Font.BOLD,20));
        restart.setBounds(350, 500, 150, 80);
        
        quit=new JButton("Quit");
        image.add(quit);
        quit.addActionListener(this);
        quit.setBackground(Color.white);
        quit.setFont(new Font("System",Font.BOLD,20));
        quit.setBounds(180, 500, 150, 80);
        
        setVisible(true);
        setBounds(350,10,700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== quit)
        {
            System.exit(0);
        }else if(e.getSource() == restart)
        {
            new Numbergame().setVisible(true);
            setVisible(false);
        }
    }
    
    public static void main(String []args)
    {
        new Result();
    }
}
