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
 * Servlet implementation class Student_registration
 */
@WebServlet("/Student_registration")
public class Student_registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_registration() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DBoperations db=new DBoperations();
		Student_encap student=new Student_encap();
		student.setPhno(request.getParameter("phn"));
		student.setPassword(request.getParameter("psw"));
		student.setName(request.getParameter("name"));
		student.setEmail(request.getParameter("email"));
		student.setDob(request.getParameter("dob"));
		student.setGender(request.getParameter("gender"));
		student.setDeparment(request.getParameter("dep"));
		System.out.println(student.getName());
		System.out.println(student.getDob());
		System.out.println(student.getDeparment());
		int j=db.addstudent(student);
	
			if(j==1)
			{
				response.sendRedirect("Lecture_login");
			}

	
	}

}
