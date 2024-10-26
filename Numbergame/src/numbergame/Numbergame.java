package numbergame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Numbergame extends JFrame implements ActionListener {
    
    JTextField userinput;
    JButton Submit,answer;
    JLabel ans,thumbsup,ans2,thumbsdown;
    int result,move=0;
    
    Numbergame()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/background.jpg"));
        Image i2= i1.getImage().getScaledInstance(700, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        setLayout(null);
        JLabel image=new JLabel(i3);
        add(image);
        image.setBounds(0,0,700,800);
        
        JLabel text=new JLabel("Guess the Number");
        image.add(text);
        text.setForeground(Color.black);
        text.setFont(new Font("System",Font.BOLD,60));
        text.setBounds(80,40,600,100);
        
        JLabel text2=new JLabel("Between 1 to 100");
        image.add(text2);
        text2.setForeground(Color.black);
        text2.setFont(new Font("System",Font.BOLD,50));
        text2.setBounds(140,90,600,100);
        
        JLabel moveinfo=new JLabel("<html>you have only<br>5 moves</br></html>");
        image.add(moveinfo);
        moveinfo.setForeground(Color.black);
        moveinfo.setFont(new Font("System",Font.BOLD,14));
        moveinfo.setBounds(400,200,600,100);
        
        userinput=new JTextField();
        image.add(userinput);
        userinput.setFont(new Font("Ralway",Font.BOLD,50));
        userinput.setBounds(280,200,100,100);
                
        ans2=new JLabel();
        image.add(ans2);
        ans2.setForeground(Color.black);
        ans2.setFont(new Font("System",Font.BOLD,30));
        ans2.setBounds(200,330,400,100);
        
        Submit=new JButton("Submit");
        image.add(Submit);
        Submit.addActionListener(this);
        Submit.setBackground(Color.white);
        Submit.setFont(new Font("System",Font.BOLD,20));
        Submit.setBounds(180, 450, 150, 80);
        
        answer=new JButton("Anwer");
        image.add(answer);
        answer.addActionListener(this);
        answer.setBackground(Color.white);
        answer.setFont(new Font("System",Font.BOLD,20));
        answer.setBounds(350, 450, 150, 80);
                  
        Random r=new Random();
        result=(int)(r.nextInt(100)+1);
        System.out.println(result);
        
        setVisible(true);
        setBounds(350,10,700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()== Submit)
        {
            move=move+1;
            try{
                int guess=Integer.parseInt(userinput.getText());
                if(guess > 100)
                {
                    ans2.setText("");
                    ans2.setText("Pleas guess 1 T0 100"); 
                }else if(guess < 1){
                    ans2.setText("");
                    ans2.setText("Pleas guess 1 T0 100");
                }else if(result == guess){
                    if(move == 1)
                    {
                        setVisible(false);
                        Result r=new Result();
                        r.ans.setText("Correct Guess");
                        r.text.setText("Score: 1000");
                        r.thumbsup.setVisible(true);
                        r.thumbsdown.setVisible(false);
                    }else if(move == 2)
                    {
                        setVisible(false);
                        Result r=new Result();
                        r.ans.setText("Correct Guess");
                        r.text.setText("Score: 600");
                        r.thumbsup.setVisible(true);
                        r.thumbsdown.setVisible(false);
                    }
                    else if(move == 3)
                    {
                        setVisible(false);
                        Result r=new Result();
                        r.ans.setText("Correct Guess");
                        r.text.setText("Score: 300");
                        r.thumbsup.setVisible(true);
                        r.thumbsdown.setVisible(false);
                    }
                    else if(move == 4)
                    {
                        setVisible(false);
                        Result r=new Result();
                        r.ans.setText("Correct Guess");
                        r.text.setText("Score: 100");
                        r.thumbsup.setVisible(true);
                        r.thumbsdown.setVisible(false);
                    }
                    
                }else if(result < guess){
                    ans2.setText("");
                    ans2.setText("Guess lower value");
                }else if(result > guess){
                    ans2.setText("");
                    ans2.setText("Guess higher value");
                }
                if(move == 5)
                    {
                        setVisible(false);
                        Result r=new Result();
                        r.ans.setText("you out of move");
                        r.text.setText("Score: 0");
                        r.thumbsup.setVisible(false);
                        r.thumbsdown.setVisible(true);
                    }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }       
                
        }
        else if(e1.getSource()== answer)
        {  
            setVisible(false);
            Result r=new Result();
            r.ans.setText("Anwer is: "+result);
            r.text.setText("Score: 0");
            r.thumbsup.setVisible(false);
            r.thumbsdown.setVisible(true);
        }
        
    }
    
    
    public static void main(String[] args) {
        
        new Numbergame();
    }

    
}
