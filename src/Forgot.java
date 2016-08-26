import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Forgot extends JFrame{
	JLabel username,userLogin,pin;
	JTextField userTxt;
	JPasswordField pinTxt;
	JButton signIn,signUp;
	dbMan d;

	public Forgot() {
		initComponents();
		d=new dbMan();
		addAcctionListener();
	}
	public void initComponents(){
		this.setLayout(null);
		username = new JLabel("Username");
		userLogin = new JLabel("Forgot Passoword!! ");
		pin = new JLabel("Pin");
		
		userTxt = new JTextField();
		userTxt.setFont(LoginInfo.textareaFont);
		pinTxt = new JPasswordField();
		pinTxt.setFont(LoginInfo.textareaFont);
		signIn = new JButton("Get Password");
		signUp = new JButton("Sign In");
		
		
		Font labelFont = new Font("Arial",Font.PLAIN, 20);
		username.setBounds(350,80,100,80);
		username.setFont(labelFont);
		pin.setBounds(380,220,100,80);
		pin.setFont(labelFont);
		
		userTxt.setBounds(230,150,350,50);
		pinTxt.setBounds(230, 290, 350, 50);
		
		signIn.setBounds(245,360,320,50);
		signUp.setBounds(430,460,150,50);
		
		
		userLogin.setBounds(250,20,500,50);
		userLogin.setFont(LoginInfo.lvlfont);
		

		this.add(signIn);
		this.add(signUp);
		this.add(pin);
		
		
		
		this.add(userTxt);
		this.add(pinTxt);
		
		
		this.add(username);
		this.add(userLogin);
		this.add(pin);

	}
	
	public void addAcctionListener(){
		signIn.addActionListener(new signInAction());
		signUp.addActionListener(new signUpAction());
		
	}
	
	public class signInAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				String str=null;
			    str= d.getpass(userTxt.getText(),pinTxt.getText());
			    Wrong newError = new Wrong(str);
				newError.setTitle("Main Menu");
				newError.setSize(400,200);
				newError.setLayout(null);
				newError.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				newError.setVisible(true);
				newError.setResizable(false);
				newError.setLocationRelativeTo(null);
			    }
			}
		
		public class signUpAction implements ActionListener{
		
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
	
