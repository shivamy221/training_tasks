package mybookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject=request.getParameter("subject");
		PrintWriter out=response.getWriter();
		try{
			ServletContext contex = this.getServletContext();
			String driver = contex.getInitParameter("driver");
			String url = contex.getInitParameter("url");
			String dbUsername = contex.getInitParameter("dbusername");
			String dbPassword = contex.getInitParameter("dbpassword");
			
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,dbUsername,dbPassword);
		String sql="SELECT bcode,btitle from books where subject=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, subject);
		ResultSet rs=ps.executeQuery();
		out.println("<html>");
		out.println("<html><body>");
		out.println("<h3>Select The Desired Title</h3>");
		out.println("<hr>");
		while(rs.next()){
			String code=rs.getString(1);
			String title=rs.getString(2);		
			out.println("<a href=BookDetailsServlet?code="+code+">");
			out.println(title);
			out.println("</a><br>");
		}
		out.println("<hr>");
		out.println("<a href=SubjectPageServlet>Subject-Page</a>");
		out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
		out.println("</body></html>");
		
		Cookie c1=new Cookie("subjectchoice",subject);
		c1.setMaxAge(60*60*24*7);
		response.addCookie(c1);
		
		
		}catch(Exception e){
			out.println(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String subject=request.getParameter("subject");
				
				String sub[]=request.getParameterValues("subjects");
				PrintWriter out=response.getWriter();
				if(sub.length<=0)
				{
					out.println("No Subjects Selected");
					response.sendRedirect("buyerpage.jsp");
				}
				String subjects="";
				for(int i=0;i<sub.length-1;i++)
				{
					subjects+="'"+sub[i]+"',";
				}
				subjects+="'"+sub[sub.length-1]+"'";
						
				
				
				ServletContext context=getServletContext();
				String driver=context.getInitParameter("driver");
				String url=context.getInitParameter("url");
				String dbusername=context.getInitParameter("dbusername");
				String dbpassword=context.getInitParameter("dbpassword");
				try{
					Class.forName(driver);
					Connection con=DriverManager.getConnection(url,dbusername,dbpassword);
				String sql="SELECT bcode,btitle from books where subject in ("+subjects+");";
				PreparedStatement ps=con.prepareStatement(sql);
				//ps.setString(1, subject);
				
				ResultSet rs=ps.executeQuery();
				out.println("<html>");
				out.println("<html><body>");
				out.println("<h3>Select The Desired Title</h3>");
				out.println("<hr>");
				while(rs.next()){
					String code=rs.getString(1);
					String title=rs.getString(2);
					
					out.println("<a href=BookDetailsServlet?code="+code+">");
					out.println(title);
					out.println("</a><br>");
				}
				out.println("<hr>");
				out.println("<a href=SubjectPageServlet>Subject-Page</a>");
				out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
				out.println("</body></html>");
				
				Cookie c1=new Cookie("subjectchoice",subject);
				c1.setMaxAge(60*60*24*7);
				response.addCookie(c1);
					
				
				}catch(Exception e){
					out.println(e);
				}
	}

}
