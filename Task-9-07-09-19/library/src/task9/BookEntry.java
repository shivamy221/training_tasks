package task9;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookEntry")
public class BookEntry extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
		
			String bookName=request.getParameter("bname");
			String subject=request.getParameter("bsub");
			String author=request.getParameter("author");
			String bcode=request.getParameter("bcode");
	    
	    
	    
	   
	    	try {
	    		
	    		Class.forName("com.mysql.jdbc.Driver");
	    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
	    		String sql="insert into books(bname,bauthor,bno,bsub) values(?,?,?,?)";
	    	
	    		PreparedStatement ps=con.prepareStatement(sql);
	    	
	    		ps.setString(1,bookName);
	    		ps.setString(2,author);
	    		ps.setString(3,bcode);
	    		ps.setString(4,subject);
	    	
	    		if(ps.executeUpdate()>0)
	    		out.println("<br><center><h3>Book Added Successfully</h3></center>");
	    		else
	    		out.println("<br><center><h3>Book Not Added</h3></center>\"");
	    		}
	    
	    		catch(Exception e)
	    		{
	    				out.println(e.getMessage());
	    		}
	       }
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

	}

}
