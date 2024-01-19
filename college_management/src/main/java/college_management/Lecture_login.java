package college_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Lecture_login
 */
@WebServlet("/Lecture_login")
public class Lecture_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lecture_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession(false); 
		System.out.println("Hello");
		if(session!=null)
		{
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			System.out.println("HAI");

			String id="",name="",NAME="",phn="",email="",dob="",gender="",dep="";
	
			int idn= (int) session.getAttribute("id");
		      System.out.println("lectu "+idn);
		      DBoperations db=new DBoperations();
			  List l=new ArrayList();
			  l=db.lectureinfo(idn);
			  int i=(int) l.get(0);
			  
			if(i==1)
			{
			PrintWriter out=response.getWriter();
		       out.print("<!DOCTYPE html>\r\n"
		       		+ "<html>\r\n"
		       		+ "<head>\r\n"
		       		+ "<meta charset=\"ISO-8859-1\">\r\n"
		       		+ "<title>Lecture_Profile</title>\r\n"
		       		+ "<link rel=\"stylesheet\" href=\"lecture_profile.css\">\r\n"
		       		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
		       		+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css\">\r\n"
		       		+ "</head>\r\n"
		       		+ "<body>\r\n"
		       		+ "\r\n"
		       		+ "<div class=\"main\">\r\n"
		       		+ "        <nav class=\"navbar\">\r\n"
		       		+ "            <img src=\"img/logo-final.png\" alt=\"\">\r\n"
		       		+ "            <h6 style=\"padding:30px; color:#3034a8; text-align:left;\">KOZHUVALLOOR POST - CHENGANNUR, ALAPPUZHA DIST<br>Tel: 0479-2369993, 2369994 | Email: info@stcet.net </h6>\r\n"
		       		+ "            <a class=\"registu\" href=\"student_registration.html\">Register Student</a>\r\n"
		       		+ "            <i class=\"bi bi-person-circle\"></i>\r\n"
		       		+ "            <b>"+l.get(3)+"</b><br>\r\n"
		       		+ "            <a href=\"Logout?="+idn+"\"><h5><u>Logout</u></h5></a>\r\n"
		       		+ "        </nav>\r\n"
		       		+ "        <div class=\"leftdiv\">\r\n"
		       		+ "            <div class=\"heading\">\r\n"
		       		+ "                <h4><b><u>Lecture Profile</u></b></h4>\r\n"
		       		+ "            </div>\r\n"
		       		+ "            <div class=\"ldetails\">\r\n"
		       		+ "                <p><b>Name : </b>"+l.get(3)+"</p>\r\n"
		       		+ "                <p><b>Phone No : </b>"+l.get(4)+"</p>\r\n"
		       		+ "                <p><b>Email Id : </b>"+l.get(5)+"</p>\r\n"
		       		+ "                <p><b>D.O.B : </b>"+l.get(6)+"</p>\r\n"
		       		+ "                <p><b>Gender : </b>"+l.get(7)+"</p>\r\n"
		       		+ "                <p><b>Department : </b>"+l.get(8)+"</p>\r\n"
		       		+ "            </div>\r\n"
		       		+ "        </div>\r\n"
		       		+ "\r\n"
		     		+ "        <div class=\"bottomdiv\">\r\n"
		       		+ "           <a href=\"student_registration.html\"><button type=\"button\" class=\"btn btn-danger btn-lg\">Register Student</button></a>\r\n"
		       		
		       		+ "           <a href=\"Students_details?"+idn+"\"><button type=\"button\" class=\"btn btn-danger btn-lg\">Students Details</button></a>\r\n"
		       		
		       		+ "\r\n"
		       		+ "\r\n"
		       		+ "        </div>\r\n"
		       		+ "      \r\n"
		       		+ "\r\n"
		       		+ "\r\n"
		       		+ "     </div>\r\n"
		       		+ "</body>\r\n"
		       		+ "</html>");
			}
			else
			{
				response.sendRedirect("login.html");
			}
		}
		else
		{
		response.sendRedirect("login.html");
		}
		
	}
	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		

}
}
