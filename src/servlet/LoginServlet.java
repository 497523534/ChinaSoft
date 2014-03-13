package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.JDBCdemo;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("uname");
		String userpassword=request.getParameter("upassword");
		String identity=request.getParameter("identity");
		//System.out.println(username+"  "+userpassword+"   "+identity);
		//String result="";
		/*if((username== "")||(username==null)||(username.length()>20)){
			   try{
			    result = "请输入用户名(不能超过20个字符)!" ;
			    request.setAttribute("message" ,result) ;
			    response.sendRedirect("index.jsp");
			   }catch(Exception e){
			    e.printStackTrace() ;
			   }
			  }
	    if((userpassword=="")||(userpassword==null)||(userpassword.length()>20 )){
			   try{
			    result = "请输入密码(不能超过20个字符)!" ;
			    request.setAttribute("message" ,result) ;
			    response.sendRedirect("index.jsp") ;
			   }catch(Exception e){
			    e.printStackTrace();
			   }
			  }
		 */
		//System.out.println(identity);
	    JDBCdemo check=new JDBCdemo();
	    Boolean rSet=null;
	    try {
			check.getConnection();
			if(identity.equals("user")){
			     rSet=check.checkUser(username,userpassword);
			     if(rSet){
				   response.sendRedirect("user.jsp");
			}
			}
			else  if(identity.equals("administrator")) {
		         rSet=check.checkAdministrator(username,userpassword);	
		         if(rSet){
				   response.sendRedirect("administrator.jsp");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
