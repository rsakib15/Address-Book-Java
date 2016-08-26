import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddNewContact extends JFrame{
	JLabel FirstName,lastName,email,country,city,zip,dob,phone,address;
	JTextField fnTxt,lnTxt,emailTxt,countryTxt,cityTxt,dobTxt,phoneTxt,zipTxt;
	JButton save,cancel;
	JTextArea addressTxt;
	
	public AddNewContact() {
		this.setLayout(null);
		FirstName = new JLabel("First Name");
		lastName = new JLabel ("Last Name");
		email = new JLabel ("Email");
		country = new JLabel ("Country");
		city = new JLabel ("City");
		zip = new JLabel ("ZIP");
		dob = new JLabel ("Date Of Birth");
		phone = new JLabel ("Phone");
		address = new JLabel ("Address");
		
		fnTxt= new JTextField();
		lnTxt=new JTextField();
		emailTxt=new JTextField();
		countryTxt=new JTextField();
		cityTxt=new JTextField();
		dobTxt=new JTextField();
		phoneTxt=new JTextField();
		addressTxt=new JTextArea();
		zipTxt=new JTextField();
		
		
		fnTxt.setFont(LoginInfo.textareaFont);
		lnTxt.setFont(LoginInfo.textareaFont);
		emailTxt.setFont(LoginInfo.textareaFont);
		countryTxt.setFont(LoginInfo.textareaFont);
		cityTxt.setFont(LoginInfo.textareaFont);
		zipTxt.setFont(LoginInfo.textareaFont);
		dobTxt.setFont(LoginInfo.textareaFont);
		phoneTxt.setFont(LoginInfo.textareaFont);
		addressTxt.setFont(LoginInfo.textareaFont);
		
		save= new JButton("Save");
		cancel = new JButton ("Cancel");
		
		init();
		addRegActionListener();
	}
	
	public void init(){
		FirstName.setBounds(50, 20, 100, 30);
		lastName.setBounds(400,20,100,30);
		email.setBounds(50, 110, 100, 30);
		country.setBounds(50,200, 100, 30);
		city.setBounds(300, 200, 100, 30);
		zip.setBounds(550, 200, 100, 30);
		dob.setBounds(50, 290, 100, 30);
		address.setBounds(50,380,700,30);
		
		fnTxt.setBounds(50, 50,300, 40);
		lnTxt.setBounds(400,50,300,40);
		emailTxt.setBounds(50, 140,500,40);
		countryTxt.setBounds(50,230,200,40);
		cityTxt.setBounds(300,230, 200, 40);
		zipTxt.setBounds(550, 230, 200, 40);
		dobTxt.setBounds(50, 320, 300, 40);
		addressTxt.setBounds(50,410,700,80);
		
		save.setBounds(320, 510,80, 40);
		cancel.setBounds(420,510,80,40);
		
		this.add(FirstName);
		this.add(lastName);
		this.add(email);
		this.add(country);
		this.add(city);
		this.add(zip);
		this.add(dob);
		this.add(address);
		this.add(fnTxt);
		this.add(lnTxt);
		this.add(emailTxt);
		this.add(countryTxt);
		this.add(cityTxt);
		this.add(zipTxt);
		this.add(dobTxt);
		this.add(addressTxt);
		this.add(save);
		this.add(cancel);
	}
	
	public void addRegActionListener(){
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dbMan d= new dbMan();
				d.add(fnTxt.getText(), lnTxt.getText(), emailTxt.getText(), countryTxt.getText(), 
						cityTxt.getText(), zipTxt.getText(), dobTxt.getText(), addressTxt.getText(),LoginInfo.usrName);
			
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
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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

