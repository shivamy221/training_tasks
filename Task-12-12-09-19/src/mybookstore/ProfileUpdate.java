package mybookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileUpdate")
public class ProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection con;
	private PreparedStatement ps;
	
	
	public void init(){
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("driver");
		String url = context.getInitParameter("url");
		String dbusername = context.getInitParameter("dbusername");
		String dbpassword = context.getInitParameter("dbpassword");
		try{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,dbusername,dbpassword);
			
		String sql="update users set password=?,username=?,address=?,mobile=?,email=? where userid=?";
		ps=con.prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void destroy(){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//reads-request
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("user");
		String password=request.getParameter("password");
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		//process
		try{
		
			ps.setString(1, password);
			ps.setString(2, username);
			ps.setString(3, address);
			ps.setString(4, mobile);
			ps.setString(5, email);
			ps.setString(6, userid);
			ps.executeUpdate();
			out.println("Updatetion Completed");
			
		}catch(Exception e){
			out.println(e);
		}

	}
}
