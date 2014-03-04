package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {
	private String driverClass="com.mysql.jdbc.Driver   ";
	private String jdbcURL="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	private String user="root";
	private String pwd="root";
	private Statement stmt = null ;
	private ResultSet rs = null ;
	private Connection conn = null ;
	public void getConnection()throws Exception {
			Class.forName(driverClass);
			DriverManager.getConnection(jdbcURL, user, pwd);	
	}
	public boolean checkUser(String username,String userpassword){
		    boolean Value=false;
		    try {
		    	
				stmt = conn.createStatement() ;
				String sql ="select * from test" ;
		        rs = stmt.executeQuery(sql) ;//返回查询结果
		        while(rs.next()){
		        	String userNameInDB = rs.getString("username");
		        	String passwordInDB = rs.getString("userpassword");
		        	if(userNameInDB.equals(username) &&
		        	passwordInDB.equals(userpassword)){
		        	Value = true;
		        	break;
		        	}        	
		       }
		    } catch (SQLException e) {
				e.printStackTrace();
			}
		    return Value;
			
	}
		       
	
}
