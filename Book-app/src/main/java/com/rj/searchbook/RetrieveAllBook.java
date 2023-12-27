package main.java.com.rj.searchbook;

import java.io.IOException;
import java.util.List;

import com.rj.bookdao.BookDAO;
import com.rj.bookdtomodel.BookDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/allbook")
public class RetrieveAllBook extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			resp.setContentType("text/html");
			BookDAO bookDao=new BookDAO();
			List<BookDTO> bookList=bookDao.getAllBook();
			 req.setAttribute("bookList",bookList);

		        // Forward the request to the JSP page  retrivebooks.jsp
		        RequestDispatcher dispatcher = req.getRequestDispatcher("retrivebooks.jsp");
		        dispatcher.forward(req,resp);
		
			
		
	}

}
