package main.java.com.rj.addbook;




@WebServlet("/save")
public class SaveBookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3612705779258527596L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title= req.getParameter("title");
		String author= req.getParameter("author");
		int isbn= Integer.parseInt(req.getParameter("isbn"));
	
		
		BookDTO book= new BookDTO();
		book.setTitle(title);
		book.setAuthor(author);
		book.setIsbn(isbn);
		System.out.println(title+" ,"+author+" ,"+isbn);
		
		
		
		BookDAO bookDao=new BookDAO();
		int status=bookDao.saveBook(book);
		
		
			if(status>0){
				PrintWriter out=res.getWriter();
				out.write("<font color='green'; text-align='center'>Book Record Successful Added</font>");
			   //RequestDispatcher  rd=req.getRequestDispatcher("dashboard.html");
				//rd.forward(req, res);
			}
			else {
				PrintWriter out=res.getWriter();
				out.write("<font color='red'; text-align='center'>Book Record  Not Added</font>");
				//RequestDispatcher  rd=req.getRequestDispatcher("login.html");
				//rd.include(req, res);	
		   }
		
	}

}
