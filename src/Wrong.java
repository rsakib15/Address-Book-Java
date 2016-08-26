import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Wrong extends JFrame{
	JLabel wr =new JLabel("Wrong Username or Password");
	JLabel wr1 =new JLabel();
	
	JButton lb=new JButton("OK");
	Wrong(){
		
		Font wrongFont = new Font("Arial",Font.PLAIN, 15);
		
		wr.setBounds(105,30, 300,50);
		lb.setBounds(170,90,60,40);
		wr.setFont(wrongFont);
		this.add(wr);
		this.add(lb);
		wrongActionListener();
		
	}
	public void wrongActionListener(){
		lb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				
			}
		});
	}
	
	Wrong(String str){
		Font wrongFont = new Font("Arial",Font.PLAIN, 15);
		if(str!=null)
			wr1.setText("Password is : " +str);
		else
			wr1.setText("Wrong Username or Pin");
		
		wr1.setBounds(115,30, 300,50);
		lb.setBounds(170,90,60,40);
		wr1.setFont(wrongFont);
		this.add(wr1);
		this.add(lb);
		wrongActionListener();
		
	}

}
