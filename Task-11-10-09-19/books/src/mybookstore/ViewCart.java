package mybookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charlist=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        
        @SuppressWarnings("unchecked")
		List<String> list=(ArrayList<String>) session.getAttribute("cart");
        
		out.println("<html>");
        out.println("<body>");
        out.println("<div style='margin:5%;'");
        if(list==null){
            out.println("<h2>Cart Is Empty</h2>");
            out.println("<a href=SubjectPageServlet><h3>Add Books</h3></a>");
                    
        }else{
        	if(list.size()<=0)
        	{
        		out.println("<h2>Cart Is Empty</h2>");
 	            out.println("<a href=SubjectPageServlet><h4>Add Books</h4></a>");
        	}
        	else
        	{
          
            String sql="select * from books where bcode in "+list;
            sql=sql.replace('[', '(');
            sql=sql.replace(']', ')');
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdata","root","root");
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                //out.println("<form action=RemoveAll>");
          
                out.println("<h2>Your Cart</h2><hr>");
                
                out.println("<table border=1 width=50%>");
          
                out.println("<tr>");
                out.println("<th>Code</th>");
                out.println("<th>Title</th>");
                out.println("<th>Author</th>");
                out.println("<th>Subject</th>");
                out.println("<th>Price</th>");
                out.println("</tr>");
                int sum=0;
                while(rs.next()){
                    String s1=rs.getString(1);
                    String s2=rs.getString(2);
                    String s3=rs.getString(3);
                    String s4=rs.getString(4);
                    int s5=rs.getInt(5);
                    sum=sum+s5;
                    out.println("<tr>");
                    out.println("<td>"+s1+"</td>");
                    out.println("<td>"+s2+"</td>");
                    out.println("<td>"+s3+"</td>");
                    out.println("<td>"+s4+"</td>");
                    out.println("<td>"+s5+"</td>");
                    out.println("<td><a href=RemoveBook?code="+s1+">[remove]</a></td>");
                    out.println("</tr>");
                    
                }
                out.println("<tr>");
                out.println("<td></td><td></td><td></td>");
                out.println("<td>Total</td>");
                out.println("<td>"+sum+"</td>");
               
                out.println("<td><a href='RemoveAll'><input type='button' value=Remove_All></a></td>");
                out.println("</tr>");
                out.println("</table>");
                //out.println("</form>");
                con.close();
                }catch(Exception e){
                    out.println(e);
                }
                
                
                
                
                out.println("<h5><a href=SubjectPageServlet>Add more books</a></h5>");
                out.println("<h5><a href=buyerpage.jsp>Buyer's Home</a></h5>");
        }
            }
        	out.println("</div>");
            out.println("</body>");
            out.println("</html>");

	
	
	}

}
