package task9;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowBook")
public class ShowBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();

			String folderName = "E:\\Book list";

			File f = new File(folderName);

			if (f.isDirectory()) {
				File files[] = f.listFiles();
				Arrays.sort(files);
				out.println("<html>");
				out.println("<body>");
				out.println("<br>");
				out.println("<h2>List of Books</h2><hr>");
				for (File file : files) {
					
					String name=file.getName();
					
					

					out.println("<a href='BookRead?name="+name+"'>"+name+"</a>");
					out.println("<br>");

				}
				out.println("</body>");
				out.println("</html>");
				
				out.println("<br><br>");
				out.println("<a href=\"index.jsp\">Go back</a>");
				out.println("<a href='BookEntry.jsp'>Add Book</a>");
				out.println("<br>");
				out.println("<a href='SearchBook.jsp'>Search Book</a>");
			}
	}

}
