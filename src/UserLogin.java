import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SignedObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class UserLogin extends JFrame{
	JLabel username,password,userLogin;
	JTextField userTxt,passTxt;
	JButton signIn,ForgotPassword,signUp;
	dbMan d;

	public UserLogin() {
		initComponents();
		d=new dbMan();
		addAcctionListener();
	}
	public void initComponents(){
		username = new JLabel("Username");
		userLogin = new JLabel("Contact Book Login");
		password = new JLabel("Password");
		
		userTxt = new JTextField();
		passTxt = new JPasswordField(15);
		
		signIn = new JButton("Sign In");
		ForgotPassword = new JButton("Forgot PassWord");
		signUp = new JButton("Sign Up");
		
		Font labelFont = new Font("Arial",Font.PLAIN, 20);
		username.setBounds(350,80,100,80);
		username.setFont(labelFont);
		password.setBounds(350,220,100,80);
		password.setFont(labelFont);
		
		userTxt.setBounds(230,150,350,50);
		passTxt.setBounds(230, 290, 350, 50);
		
		signIn.setBounds(250,380,310,50);
		signUp.setBounds(250,460,150,50);
		ForgotPassword.setBounds(410,460,150,50);
		
		userTxt.setFont(LoginInfo.textareaFont);
		passTxt.setFont(LoginInfo.textareaFont);
		
		userLogin.setBounds(250,20,500,50);
		userLogin.setFont(LoginInfo.lvlfont);
	
		this.add(signIn);
		this.add(signUp);
		this.add(ForgotPassword);
		
		this.add(userTxt);
		this.add(passTxt);
	
		this.add(username);
		this.add(password);
		this.add(userLogin);
	}
	
	public void addAcctionListener(){
		signIn.addActionListener(new startPageAction());
		signIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		signUp.addActionListener(new signUpAction());
		ForgotPassword.addActionListener(new ForgotAction());
	}
	
	public class startPageAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String username = userTxt.getText();
			String password = passTxt.getText();
			int i=d.check(username,password);
			if(i==1){
				LoginInfo.usrName=username;
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
			else{
				userTxt.setText("");
				passTxt.setText("");
				Wrong newError = new Wrong();
				newError.setTitle("Error");
				newError.setSize(400,200);
				newError.setLayout(null);
				newError.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				newError.setVisible(true);
				newError.setResizable(false);
				newError.setLocationRelativeTo(null);
			}
		}
	}
	
	
	public class signUpAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SignUp newFrame = new SignUp(); 
			newFrame.setTitle("Sign Up");
			newFrame.setSize(800,600);
			newFrame.setLocationRelativeTo(null);
			newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newFrame.setVisible(true);	
			newFrame.setResizable(false);
			newFrame.setLayout(null);
			setVisible(false);
		}
		
	}
	
	public class ForgotAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Forgot newFrame = new Forgot(); 
			newFrame.setTitle("Forgot password");
			newFrame.setSize(800,600);
			newFrame.setLocationRelativeTo(null);
			newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			newFrame.setVisible(true);	
			newFrame.setResizable(false);
			newFrame.setLayout(null);
			setVisible(false);
		}
		
	}
	

}



