package main.java.com.rj.bookdao;

import com.rj.bookdtomodel.BookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	private static final String ADD_BOOK = "INSERT INTO BOOK VALUES(?,?,?)";

	private static final String SEARCH_BOOK = "SELECT * FROM BOOK WHERE AUTHOR=?";

	private static final String ALL_BOOK = "SELECT * FROM BOOK";

	private int status = 0;
	private boolean isAvail = false;

	// save book detail
	public int saveBook(BookDTO book) {
		
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "rahul", "123")) {
			String title = book.getTitle();
			String author = book.getAuthor();
			int isbn = book.getIsbn();

			PreparedStatement psmt = con.prepareStatement(ADD_BOOK);

			psmt.setString(1, title);
			psmt.setString(2, author);
			psmt.setInt(3, isbn);

			status = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return status;

	}

// search by author name
	public boolean searchBook(BookDTO book) {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "rahul", "123")) {
		//String title = book.getTitle();
			String author = book.getAuthor();
		//int isbn = book.getIsbn();

			PreparedStatement psmt = con.prepareStatement(SEARCH_BOOK);
			psmt.setString(1, author);
			// psmt.setString(1, title);
			// psmt.setString(2, author);
			// psmt.setInt(3, isbn);
			ResultSet rs = psmt.executeQuery();
			isAvail = rs.next();
		} catch (SQLException e) { 
			e.printStackTrace();
		}

		return isAvail;
	}

	// all book record retrive
	public List<BookDTO> getAllBook() {
		List<BookDTO> bookList = new ArrayList();
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "rahul", "123")) {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(ALL_BOOK);
				BookDTO book = new BookDTO();

				while (rs.next()) {
					book.setTitle(rs.getString(1));
					book.setAuthor(rs.getString(2));
					book.setIsbn(rs.getInt(3));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return bookList;

	}

}
