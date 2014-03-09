package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {
	private String driverClass="com.mysql.jdbc.Driver";
	private String jdbcURL="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	private String user="root";
	private String pwd="";
	//private java.sql.PreparedStatement pstmt = null ;
	private Connection conn=null;
	public void getConnection()throws Exception {
			Class.forName(driverClass);
			conn=DriverManager.getConnection(jdbcURL, user, pwd);	
			//System.out.println("yes");
	}
	public boolean checkUser(String username,String userpassword){
		    boolean Value=false;
		    try {
		    	Statement stmt=conn.createStatement();
		    	String sql =" select*from userinfo " ;
				//pstmt = (PreparedStatement)conn.prepareStatement(sql);		
				//pstmt.setString(1, username);
				//pstmt.setString(2, userpassword);
				ResultSet rs = stmt.executeQuery(sql);
				while(true){
				  if(rs.next()){
					  if(rs.getString(1).equals(username)&&rs.getString(2).equals(userpassword))
					  {
					  Value=true;
					  break;
					  }
				  }
				  else {
					break;
				}
				  
				
			}
		    } catch (SQLException e) {
				e.printStackTrace();
			}
		    return Value;
			
	}
		       
	
}
