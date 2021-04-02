package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookModel;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bcode = request.getParameter("bcode");
		String btitle = request.getParameter("btitle");
		String author = request.getParameter("author");
		String subject = request.getParameter("subject");
		String price = request.getParameter("price");

		Book book = new Book(Integer.parseInt(bcode), btitle, author, subject, Integer.parseInt(price));

		BookModel DAO = new BookModel();
		DAO.bookEntry(book);

		request.setAttribute("newbook", book);

		RequestDispatcher rd = request.getRequestDispatcher("ViewBookEntry.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
