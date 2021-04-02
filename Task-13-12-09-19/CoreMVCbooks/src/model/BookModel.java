package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BookModel {

	private Connection con;
	
	public BookModel() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybookstore", "root", "root");

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void bookEntry(Book book) {
		try {
			String sql = "insert into books values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, book.getBcode());
			ps.setString(2, book.getBtitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getSubject());
			ps.setInt(5, book.getPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public Book deleteBook(String bcode){
		Book book = null;
		int code = Integer.parseInt(bcode);
		try {
			
			String sql = "select bcode,btitle,author,subject,price from books where bcode=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			String pcode = rs.getString(1);
			String ptitle = rs.getString(2);
			String pauthor = rs.getString(3);
			String psubject = rs.getString(4);
			String pprice = rs.getString(5);
			
			book = new Book(Integer.parseInt(pcode),ptitle,pauthor,psubject,Integer.parseInt(pprice));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String delete = "delete from books where bcode=?";
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, code);
		    ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}


	
}
