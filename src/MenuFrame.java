import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MenuFrame extends JFrame{
	JButton viewAllContact,AddContact,Search,DeleteContact,signOut;
	JLabel Welcome,username;
	ImagePanel panel = new ImagePanel();
	
	MenuFrame(){
		System.out.println("USer : " + LoginInfo.usrName);
		panel.setLayout(null);
		panel.setBounds(520,250,100, 45);
		
		
		viewAllContact = new JButton("View All Contacts");
		viewAllContact.setBounds(530,160,160,40);
		AddContact = new JButton("Add New Contact");
		AddContact.setBounds(530,220,160,40);
		Search = new JButton("Search");
		Search.setBounds(530,280,160,40);
		DeleteContact = new JButton("Delete Contact");
		DeleteContact.setBounds(530,340,160,40);
		
		
		signOut = new JButton("Sign Out");
		signOut.setBounds(630,30,100,40);
		
		Font labelFont = new Font("Arial",Font.PLAIN, 20);
		Welcome = new JLabel("Welcome To Your Contact Book !!");
		Welcome.setBounds(60,10,450,80);
		Welcome.setFont(labelFont);
		
		username=new JLabel("User: " + LoginInfo.usrName);
		username.setBounds(100,500,500,30);
		username.setFont(labelFont);

		
		panel.add(viewAllContact);
		panel.add(AddContact);
		panel.add(Search);
		panel.add(DeleteContact);
		panel.add(signOut);
		panel.add(Welcome);
		panel.add(username);
		this.add(panel);
		addMenuActionListener();
	}
	
	
	public class ImagePanel extends JPanel{
		private ImageIcon imageIcon = new ImageIcon("images/logo.png");
		private Image image = imageIcon.getImage();
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
		    g.drawImage(image, 20,110, getWidth()-420, getHeight()-220, this);
		        
		    }
	 }
	
	public void addMenuActionListener(){
		signOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 JFrame frame = new UserLogin();
				    frame.setTitle("Login");
				    frame.setSize(800,600);
				    frame.setLocationRelativeTo(null);
				    frame.setLayout(null);
				    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    frame.setVisible(true);	
				    frame.setResizable(false);
			        setVisible(false);
			        LoginInfo.usrName=null;
				
			}
		});
		viewAllContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewAll all= new ViewAll(); 
				all.setTitle("Contact Book");
				all.setBounds(100, 100, 1260, 650);
			    all.setLocationRelativeTo(null);
			    all.setLayout(null);
			    all.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    all.setVisible(true);	
			    all.setResizable(false);
		        setVisible(false);
			}
		});
		
		AddContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddNewContact all= new AddNewContact(); 
				all.setTitle("Contact Book");
			    all.setSize(800,600);
			    all.setLocationRelativeTo(null);
			    all.setLayout(null);
			    all.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    all.setVisible(true);	
			    all.setResizable(false);
		        setVisible(false);
			}
		});
		Search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Search all= new Search(); 
				all.setTitle("Contact Book");
				all.setBounds(100, 100, 1260, 650);
			    all.setLocationRelativeTo(null);
			    all.setLayout(null);
			    all.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    all.setVisible(true);	
			    all.setResizable(false);
		        setVisible(false);
			}
		});
		
		DeleteContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteContact all= new DeleteContact(); 
				all.setTitle("Contact Book");
			    all.setSize(800,600);
			    all.setLocationRelativeTo(null);
			    all.setLayout(null);
			    all.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    all.setVisible(true);	
			    all.setResizable(false);
		        setVisible(false);
			}
		});
	}
}

	
