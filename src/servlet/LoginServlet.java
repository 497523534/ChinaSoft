package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.JDBCdemo;


@WebServlet("/Loginservlet")
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
		System.out.println(username+"  "+userpassword);
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
	    JDBCdemo jdbCdemo=new JDBCdemo();
	    Boolean rSet=null;
	    try {
			jdbCdemo.getConnection();
			rSet=jdbCdemo.checkUser(username,userpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    if(rSet){
			response.sendRedirect("success.jsp");
		}
		else{
			response.sendRedirect("fail.jsp");
		}

      
		
		
	}

}
