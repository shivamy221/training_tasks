package mybookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String utype=request.getParameter("utype");
		try{
			if(utype.equals("owner")){
				ServletConfig config = this.getServletConfig();
				String adminId = config.getInitParameter("adminId");
				String adminPassword = config.getInitParameter("adminPassword");
				if(userid.equals(adminId) && password.equals(adminPassword)){
					response.sendRedirect("adminpage.jsp");
				}else{
					out.println("INVALID CREDENTIALS FOR ADMIN");
				}
				
			}else{
				ServletContext contex = this.getServletContext();
				String driver = contex.getInitParameter("driver");
				String url = contex.getInitParameter("url");
				String dbUsername = contex.getInitParameter("dbusername");
				String dbPassword = contex.getInitParameter("dbpassword");
				
				Class.forName(driver);
				Connection con=DriverManager.getConnection(url,dbUsername,dbPassword);
				String sql="SELECT username FROM USERS where userid=? AND password=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,userid);
				ps.setString(2,password);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					HttpSession session=request.getSession();
                    session.setAttribute("user", userid);
					
					//whether user want to save the password
					String choice=request.getParameter("save");
					if(choice!=null){
						
						Cookie c1=new Cookie("id",userid);
						Cookie c2=new Cookie("pw", password);
						
						c1.setMaxAge(60*60*24*7);
						c2.setMaxAge(60*60*24*7);
						
						response.addCookie(c1);
						response.addCookie(c2);
						
						
					}
					
					
					
					//response.sendRedirect("buyerpage.jsp");
					RequestDispatcher rd=request.getRequestDispatcher("BuyerPage.jsp");
					rd.forward(request, response);
					
				}else{
					out.println("INVALID BUYER CREDENTIALS");
				}
				con.close();
			}
		}catch(Exception e){
			out.println(e);
		}
	}

}
