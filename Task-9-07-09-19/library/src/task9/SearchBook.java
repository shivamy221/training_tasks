package task9;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String subject=request.getParameter("subject");
		
		try {
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
    		String sql="select  bname,bauthor,bno,bsub from books where bsub=?";
    		PreparedStatement ps=con.prepareStatement(sql);
    		ps.setString(1,subject);
    		
    		ResultSet rs= ps.executeQuery();
    		while(rs.next())
    		{
    			out.println("<html>");
    			out.println("<body>");
    			out.println("<h3>\nBook Title :"+rs.getString(1)+"</h3>");
    			out.println("<h3>\nBook author:"+rs.getString(2)+"</h3>");
    			out.println("<h3>\nBook code :"+rs.getString(3)+"<h3>");
    			out.println("<h3>\nBook subject :"+rs.getString(3)+"<h3>");
    			out.println("<hr>");
    			out.println("</body>");
    			out.println("</html>");
    			
    		}
    			
	    	
    		
		}
		catch(Exception e)
		{
				out.println(e.getMessage());
		}
	}

}
