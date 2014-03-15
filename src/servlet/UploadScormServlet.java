package servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/UploadScormServlet" )
@MultipartConfig(location = "下载:\\", fileSizeThreshold = 1024)
public class UploadScormServlet   extends HttpServlet{
	private String fileNameExtractorRegex = "filename=\".+\"";  
	private static final long serialVersionUID = -952078951324677625L;
	public UploadScormServlet() {  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        request.setCharacterEncoding("utf-8");
		        List<String> fileNames = new LinkedList<String>(); 
		        Collection<Part>  parts = request.getParts();
		        for (Iterator<Part> iterator = parts.iterator(); iterator.hasNext();) {  
		            Part part = iterator.next();  
		            //从Part的content-disposition中提取上传文件的文件名  
		            String fileName = getFileName(part);  
		            if(fileName!=null){  
		                fileNames.add(fileName);  
		                part.write(fileName);  
		            }  
		        }  
		      }
	  private String getFileName(Part part){  
          //获取header信息中的content-disposition，如果为文件，则可以从其中提取出文件名  
            String cotentDesc = part.getHeader("content-disposition");  
            String fileName = null;  
            Pattern pattern = Pattern.compile(fileNameExtractorRegex);  
            Matcher matcher = pattern.matcher(cotentDesc);  
            if(matcher.find()){  
               fileName = matcher.group();  
               fileName = fileName.substring(10, fileName.length()-1);  
          }  
            return fileName;  
    }  
}