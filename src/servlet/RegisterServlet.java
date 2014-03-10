package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JDBCdemo;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    public RegisterServlet() {  
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			String rename=request.getParameter("rname");
			String repassword=request.getParameter("rpassword");
			//System.out.println(rename+"  "+repassword);
			JDBCdemo insert=new JDBCdemo();
			try {
				insert.getConnection();
				insert.registerUser(rename, repassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
}
}