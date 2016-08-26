import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import java.awt.SystemColor;

import java.awt.Font;

public class Search extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField searchbox;
	public Search() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		JButton back = new JButton("Back");
		back.setFont(new Font("Arial", Font.PLAIN, 13));
		searchbox=new JTextField();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String host = "jdbc:mysql://localhost:3306/oop1";
				    String uName = "root";
				    String uPass = "";
				    String text= searchbox.getText();
				    String uSer= LoginInfo.usrName;
				    Connection con = DriverManager.getConnection(host, uName, uPass);
				    
					Statement stmt = con.createStatement( );
					String SQL = "SELECT concat(firstname,' ',lastname) as Name,country as Country,"
							+ "city as City,zip as ZIP,dob as DateOfBirth,address as Address FROM contact "
							+ "where user=? AND (firstname LIKE '%"+text+"%' or lastname LIKE '%"+text+"%')";
					PreparedStatement st = con.prepareStatement(SQL);
				    st.setString(1, uSer);
					ResultSet rs = st.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(SQLException err ){
					
				}
				
				
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
		btnNewButton.setBounds(700, 20, 148, 40);
		contentPane.add(btnNewButton);
		back.setBounds(15, 20, 148, 40);
		contentPane.add(back);
		
		searchbox.setBounds(400, 20, 280, 40);
		contentPane.add(searchbox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(13,70, 1227,530);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}