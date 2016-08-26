import java.sql.*;
import java.util.Scanner;

import javax.swing.table.TableModel;

public class dbMan{
  
    public int check(String name, String pass){
        String query = "SELECT `uname`, `pass` FROM `log`;";
        Connection con=null;
        Statement st = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
            st = con.createStatement();
            rs = st.executeQuery(query);
            int flag=0;
            
            while(rs.next()){
                String dbname = rs.getString("uname");
                String dbpass = rs.getString("pass");
                System.out.println(dbname+","+name+","+dbpass+","+pass);
                if(dbname.equals(name) && dbpass.equals(pass)){
                    flag=1;
                    break;
                }
                else{
                    flag=0;
                }
            }
            if(flag==1)
            	return 1;
            else
            	return 0;
        }
        catch(Exception ex){
            System.out.println("Exception : " +ex);
        }
        finally{
            try{
                if(rs!=null)
                    rs.close();

                if(st!=null)
                    st.close();

                if(con!=null)
                    con.close();
            }
            catch(Exception ex){

            }
        }
		return 0;
    }

    public void add(String f, String l,String e,String c,String ci,String z,String d,String a,String u){

	    String query="INSERT INTO `contact`(`firstname`, `lastname`, `email`, `country`, `city`, `zip`, `dob`, `address`, `user`) VALUES (?,?,?,?,?,?,?,?,?)";
	    Connection con=null;
	    ResultSet rs = null;
	    try{
	        Class.forName("com.mysql.jdbc.Driver");//load drive
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("driver loaded");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
	        System.out.println("connection done");
	        System.out.println("statement loaded");
	        
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, f);
	        st.setString(2, l);
	        st.setString(3, e);
	        st.setString(4, c);
	        st.setString(5, ci);
	        st.setString(6, z);
	        st.setString(7, d);
	        st.setString(8, a);
	        st.setString(9, u);
	        
	        st.executeUpdate();
	        System.out.println("rs loaded");
	        System.out.println("Saved");

	    }catch(Exception ex){
	        System.out.println("Exception : " +ex);
	    }
    }

    public int reg(String username,String password,String pin){
	    String query="INSERT INTO `log`(`uname`, `pass`, `pin`) VALUES (?,?,?)";
	    Connection con=null;
	    ResultSet rs = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
        System.out.println("connection done");
        System.out.println("statement loaded");
        
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, username);
        st.setString(2, password);
        st.setString(3, pin);
        
        st.executeUpdate();
        System.out.println("rs loaded");
        System.out.println("Saved");
        return 1;
    }catch(Exception ex){
        System.out.println("Exception : " +ex);
        return 0;
	    }
	}

	public int delete(String f,String l,String username){
	    String query="DELETE FROM contact WHERE firstname= ? and lastname=? and user=?";
	    Connection con=null;
	    ResultSet rs = null;
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("driver loaded");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
	        System.out.println("connection done");
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, f);
	        st.setString(2, l);
	        st.setString(3, username);
	        
	        st.executeUpdate();//getting result
	        System.out.println("rs loaded");
	        System.out.println("Saved");
	        return 1;
	
	    }catch(Exception ex){
	        System.out.println("Exception : " +ex);
	        return 0;
	    }
	}


	public String getpass(String u,String p){
	    String query="SELECT `uname`, `pass`,`pin` FROM `log`;";
	    Connection con=null;
	    ResultSet rs = null;
	    Statement st = null;//for query execution
	    String str = null;
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
	        st = con.createStatement();
	        rs = st.executeQuery(query);        
	     
	        while(rs.next()){
	            String dbname = rs.getString("uname");
	            String dbpass = rs.getString("pass");
	            String dbpin = rs.getString("pin");
	            if(dbname.equals(u) && dbpin.equals(p)){
	                str=dbpass;
	                break;
	            }
	            else{
	            	str=null;
	            } 
	        }
	    }catch(Exception ex){
	        System.out.println("Exception : " +ex);
	    }
		return str;
	}

}
