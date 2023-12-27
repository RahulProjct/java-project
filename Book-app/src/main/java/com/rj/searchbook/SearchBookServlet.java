package main.java.com.rj.searchbook;

import java.io.IOException;
import java.io.PrintWriter;
import com.rj.bookdao.BookDAO;
import com.rj.bookdtomodel.BookDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//  url by web.xml(/searchbook)
public class SearchBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//String title= req.getParameter("title");
		String auther= req.getParameter("auther");
		//int isbn= Integer.parseInt(req.getParameter("isbn"));
	
		System.out.println(auther);
		BookDTO book= new BookDTO();
	//	book.setTitle(title);
		book.setAuthor(auther);
	//	book.setIsbn(isbn);
		
		res.setContentType("text/html");
		
		BookDAO bookDao=new BookDAO();
		boolean isAvail=bookDao.searchBook(book);
		
		
			if(isAvail){
				PrintWriter out=res.getWriter();
				out.write("<h2 style='color: green; text-align: center;'>Book Record Available</h2>");
			   //RequestDispatcher  rd=req.getRequestDispatcher("dashboard.html");
			   //rd.forward(req, res);
			}
			else {
				PrintWriter out=res.getWriter();
				out.write("<h2 style='color: red; text-align: center;'>Book Record not Available</h2>");
				//out.write("<font color='red'>Book Record  Not Available</font>");
				//RequestDispatcher  rd=req.getRequestDispatcher("login.html");
				//rd.include(req, res);	
		   }
		
	}
}
