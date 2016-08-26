import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {
	JLabel username,password,userLogin,pin,acc;
	JTextField userTxt;
	JPasswordField pinTxt,passTxt;
	JButton signIn,signUp;
	dbMan d;

	public SignUp() {
		initComponents();
		d=new dbMan();
		addSignUpActionListener();
	}
	public void initComponents(){
		this.setLayout(null);
		username = new JLabel("Username");
		userLogin = new JLabel("Sign Up Here");
		password = new JLabel("Password");
		pin = new JLabel("Pin");
		acc = new JLabel("Already Have Account?");
		
		userTxt = new JTextField();
		passTxt = new JPasswordField();
		pinTxt = new JPasswordField();
		
		signIn = new JButton("Sign In");
		signUp = new JButton("Sign Up");
		
		
		Font labelFont = new Font("Arial",Font.PLAIN, 20);
		username.setBounds(350,60,100,80);
		username.setFont(labelFont);
		password.setBounds(350,180,100,80);
		password.setFont(labelFont);
		pin.setBounds(380,300,100,80);
		pin.setFont(labelFont);
		acc.setFont(labelFont);
	
		
		userTxt.setBounds(230,120,350,50);
		userTxt.setFont(LoginInfo.textareaFont);
		passTxt.setBounds(230, 240, 350, 50);
		passTxt.setFont(LoginInfo.textareaFont);
		pinTxt.setBounds(230,360, 350, 50);
		acc.setBounds(200,500,350,50);
		pinTxt.setFont(LoginInfo.textareaFont);
		
		signUp.setBounds(245,430,320,50);
		signIn.setBounds(430,500,150,50);
		
		userLogin.setBounds(300,20,500,50);
		userLogin.setFont(LoginInfo.lvlfont);
		
		this.add(signIn);
		this.add(signUp);

		this.add(userTxt);
		this.add(passTxt);
		this.add(userLogin);
		
		this.add(username);
		this.add(password);
		this.add(pin);
		this.add(pinTxt);
		this.add(acc);

	}
	
	public void addSignUpActionListener(){
		signUp.addActionListener(new signUpAction());
		signIn.addActionListener(new signInAction());
	}
	
	
	public class signUpAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = userTxt.getText();
			String password = passTxt.getText();
			String pin = pinTxt.getText();
			int n=d.reg(username,password,pin);
			if(n==1){
				JFrame frame = new UserLogin();
			    frame.setTitle("Login");
			    frame.setSize(800,600);
			    frame.setLocationRelativeTo(null);
			    frame.setLayout(null);
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.setVisible(true);	
			    frame.setResizable(false);
			    setVisible(false);
			}
		}
		
	}
	
	
	public class signInAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				JFrame frame = new UserLogin();
			    frame.setTitle("Login");
			    frame.setSize(800,600);
			    frame.setLocationRelativeTo(null);
			    frame.setLayout(null);
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.setVisible(true);	
			    frame.setResizable(false);
			    setVisible(false);
			}
		}
		
}
