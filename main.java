package password_generator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class main{
 public static void main(String[] args)
 {
 password_generator_logic pass=new password_generator_logic();

//frame
JFrame frame=new JFrame("PASSWORD GENERATOR");
frame.setLayout(null);
frame.setSize(540,600);
frame.setResizable(false);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);
//frame.setVisible(true);

//title
JLabel title=new JLabel("PASSWORD GENERATOR");
title.setFont(new Font("DIALOG",Font.BOLD,27));
title.setBounds(100,30,540,39);
frame.add(title);

//textarea for output
JTextArea output=new JTextArea();
output.setFont(new Font("DIALOG",Font.BOLD,23));
output.setEditable(false);
output.setBorder(BorderFactory.createLineBorder(Color.BLACK));

JScrollPane scroll=new JScrollPane(output);
scroll.setBounds(75,97,379,70);
frame.add(scroll);

//password length
JLabel passwordlength=new JLabel("Password Length :");
passwordlength.setFont(new Font("DIALOG",Font.PLAIN,20));
passwordlength.setBounds(25,215,272,39);
frame.add(passwordlength);

//password length text
JTextArea passwordinput=new JTextArea();
passwordinput.setFont(new Font("DIALOG",Font.PLAIN,18));
passwordinput.setBounds(230,215,192,39);
passwordinput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
frame.add(passwordinput);

//toggle buttons
JToggleButton upper=new JToggleButton("Uppercase");
upper.setFont(new Font("DIALOG",Font.PLAIN,20));
upper.setBounds(25,302,225,56);
frame.add(upper);

JToggleButton lower=new JToggleButton("Lowercase");
lower.setFont(new Font("DIALOG",Font.PLAIN,20));
lower.setBounds(282,302,225,56);
frame.add(lower);

JToggleButton number=new JToggleButton("Number");
number.setFont(new Font("DIALOG",Font.PLAIN,20));
number.setBounds(25,373,225,56);
frame.add(number);

JToggleButton symbol=new JToggleButton("Symbol");
symbol.setFont(new Font("DIALOG",Font.PLAIN,20));
symbol.setBounds(282,373,225,56);
frame.add(symbol);

//generate button
JButton generate=new JButton("GENERATE");
generate.setFont(new Font("DIALOG",Font.BOLD,20));
generate.setBounds(155,477,222,41);


//actions of generate button
generate.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  

  //converts string of text into integer to get password length
       int password_length=Integer.parseInt(passwordinput.getText());
       
       //if password length is 0 then return
       if(password_length==0)
       {
        return;
       }
       
       //if password length is not 0 the do the following
       else
       {
        boolean istoggleselected=upper.isSelected()||lower.isSelected()||number.isSelected()||symbol.isSelected();
        if(istoggleselected)
        {
        String password=pass.generate_password(password_length,upper.isSelected(),lower.isSelected(),number.isSelected(),symbol.isSelected());
        output.setText(password);
        }
       }
}  
});  


frame.add(generate);

frame.setVisible(true);

 }
}
