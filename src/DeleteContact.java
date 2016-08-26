import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteContact extends JFrame {
	JLabel first,last;
	JTextField firstname,lastname;
	JButton delete,back;
	public DeleteContact() {
		setLayout(null);
		first = new JLabel("Enter First Name");
		last = new JLabel("Enter Last Name");
		back = new JButton("Back");
		
		firstname = new JTextField();
		lastname = new JTextField();
		
		delete = new JButton("Delete Contact");
		
		Font labelFont = new Font("Arial",Font.PLAIN, 20);
		first.setBounds(320,80,200,80);
		first.setFont(labelFont);
		last.setBounds(320,220,200,80);
		last.setFont(labelFont);
		
		firstname.setBounds(230,150,350,50);
		lastname.setBounds(230, 290, 350, 50);
		
		delete.setBounds(245,360,320,50);
		back.setBounds(430,460,150,50);
		
		this.add(delete);
		this.add(back);

		this.add(first);
		this.add(last);
		
		
		this.add(firstname);
		this.add(lastname);
		
		addDeleteListener();

		
		
		
		
	}
	
	public void addDeleteListener(){	
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbMan d= new dbMan();
				d.delete(firstname.getText(), lastname.getText(),LoginInfo.usrName);
				MenuFrame newFrame = new MenuFrame(); 
				newFrame.setTitle("Main Menu");
				newFrame.setSize(800,600);
				newFrame.setLocationRelativeTo(null);
				newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newFrame.setVisible(true);	
				newFrame.setResizable(false);
				newFrame.setLayout(null);
				setVisible(false);
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuFrame newFrame = new MenuFrame(); 
				newFrame.setTitle("Main Menu");
				newFrame.setSize(800,600);
				newFrame.setLocationRelativeTo(null);
				newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newFrame.setVisible(true);	
				newFrame.setResizable(false);
				newFrame.setLayout(null);
				setVisible(false);
			}
		});
	}
}
