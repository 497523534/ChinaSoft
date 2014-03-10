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
	private Statement stmt = null ;
	private Connection conn=null;
	private ResultSet rs=null;
	public void getConnection()throws Exception {
			Class.forName(driverClass);
			conn=DriverManager.getConnection(jdbcURL, user, pwd);	
			//System.out.println("yes");
	}
	public boolean checkUser(String username,String userpassword){
		    boolean Value=false;
		    try {
		    	stmt=conn.createStatement();
		    	String sql =" select*from userinfo " ;
				//pstmt = (PreparedStatement)conn.prepareStatement(sql);		
				//pstmt.setString(1, username);
				//pstmt.setString(2, userpassword);
				rs = stmt.executeQuery(sql);
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
		    }catch (SQLException e) {
				e.printStackTrace();
			}
		    return Value;
	}
	public void registerUser(String rname,String rpassword){
		    String  sql="INSERT INTO userinfo(username,userpassword) VALUES('"+rname+"','"+rpassword+"')";
		    try {
		     stmt=conn.createStatement();
			 stmt.executeUpdate(sql);
			} catch (SQLException e) {
			 e.printStackTrace();
			}
	}
		       
	
}
