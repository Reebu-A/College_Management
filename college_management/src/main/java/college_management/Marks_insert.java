package college_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Marks_insert
 */
@WebServlet("/Marks_insert")
public class Marks_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Marks_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBoperations db=new DBoperations();
		Marklist_encap mark=new Marklist_encap();
		
		mark.setSid(request.getParameter("id"));
		
		mark.setTmark1(request.getParameter("tmark1"));
		mark.setCemark1(request.getParameter("cemark1"));
		
		mark.setTmark2(request.getParameter("tmark2"));
		mark.setCemark2(request.getParameter("cemark2"));
		
		mark.setTmark3(request.getParameter("tmark3"));
		mark.setCemark3(request.getParameter("cemark3"));
		
		mark.setTmark4(request.getParameter("tmark4"));
		mark.setCemark4(request.getParameter("cemark4"));
		
		mark.setTmark5(request.getParameter("tmark5"));
		mark.setCemark5(request.getParameter("cemark5"));
		
		mark.setTmark6(request.getParameter("tmark6"));
		mark.setCemark6(request.getParameter("cemark6"));
		
		mark.setTmark7(request.getParameter("tmark7"));
		mark.setCemark7(request.getParameter("cemark7"));
		
		mark.setTmark8(request.getParameter("tmark8"));
		mark.setCemark8(request.getParameter("cemark8"));
		int i=db.marklistenter(mark);
		if(i==1)
		{
			response.sendRedirect("Students_details");
		}
		
	}

}
