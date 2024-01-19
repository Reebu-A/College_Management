package college_management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lecture_registration
 */
@WebServlet("/Lecture_registration")
public class Lecture_registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lecture_registration() {
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
		Lecture_encap lecture=new Lecture_encap();
		DBoperations db=new DBoperations();
		lecture.setName(request.getParameter("name"));
		lecture.setPhone(request.getParameter("phn"));
		lecture.setEmail(request.getParameter("email"));
		lecture.setGender(request.getParameter("gender"));
		lecture.setDob(request.getParameter("dob"));
		lecture.setDepartment(request.getParameter("dep"));
		lecture.setPassword(request.getParameter("psw"));
		int i=db.addlecture(lecture);
			
			if(i==1)
			{
				response.sendRedirect("Admin_login");
			}
		
	}

}
