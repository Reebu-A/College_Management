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
 * Servlet implementation class Admin_login
 */
@WebServlet("/Admin_login")
public class Admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_login() {
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
		
		DBoperations db=new DBoperations();
		 
	    int idn=(Integer)session.getAttribute("aid");
		
		
		List al=new ArrayList();
		al=db.admininfo(idn);
		int i=(int) al.get(0);
		
		if(i==1)
		{
		PrintWriter out=response.getWriter();
	       out.print("<!DOCTYPE html>\r\n"
	       		+ "<html>\r\n"
	       		+ "<head>\r\n"
	       		+ "<meta charset=\"ISO-8859-1\">\r\n"
	       		+ "<title>Admin_Profile</title>\r\n"
	       		+ "<link rel=\"stylesheet\" href=\"admin_profile.css\">\r\n"
	       		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
	       		+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css\">\r\n"
	       		+ "</head>\r\n"
	       		+ "<body>\r\n"
	       		+ "\r\n"
	       		+ "	<div class=\"main\">\r\n"
	       		+ "        <nav class=\"navbar\">\r\n"
	       		+ "            <img src=\"img/logo-final.png\" alt=\"\">\r\n"
	       		+ "            <h6 style=\"padding:30px; color:#3034a8; text-align:left;\">KOZHUVALLOOR POST - CHENGANNUR, ALAPPUZHA DIST<br>Tel: 0479-2369993, 2369994 | Email: info@stcet.net </h6>\r\n"
	       		+ "            <i class=\"bi bi-person-circle\"></i>\r\n"
	       		+ "            <b>"+al.get(3)+"</b><br>\r\n"
	       		+ "            <a href=\"Logout?="+idn+"\"><h5><u>Logout</u></h5></a>\r\n"
	       		+ "        </nav>\r\n"
	       		+ "        <div class=\"leftdiv\">\r\n"
	       		+ "            <div class=\"heading\">\r\n"
	       		+ "                <h4><b><u>Admin Profile</u></b></h4>\r\n"
	       		+ "            </div>\r\n"
	       		+ "            <div class=\"ldetails\">\r\n"
	       		+ "                <p><b>Name :</b>"+al.get(3)+"</p>\r\n"
	       		+ "                <p><b>Phone No :</b>"+al.get(4)+"</p>\r\n"
	       		+ "                <p><b>Email Id :</b>"+al.get(5)+"</p>\r\n"
	       		+ "                <p><b>D.O.B :</b>"+al.get(6)+"</p>\r\n"
	       		+ "                <p><b>Gender :</b>"+al.get(7)+"</p>\r\n"
	       		+ "                <p><b>Designation :</b>"+al.get(8)+"</p>\r\n"
	       		+ "            </div>\r\n"
	       		+ "        </div>\r\n"
	       		+ "\r\n"
	       		+ "        <div class=\"bottomdiv\">\r\n"
	       		+ "           <a href=\"student_registration.html\"><button type=\"button\" class=\"btn btn-danger btn-lg\">Register Student</button></a>\r\n"
	       		+ "           <a href=\"lecture_registration.html\"><button type=\"button\" class=\"btn btn-success btn-lg\">Register Lecture</button></a>\r\n"
	       		+ "           <a href=\"Students_details?"+idn+"\"><button type=\"button\" class=\"btn btn-danger btn-lg\">Students Details</button></a>\r\n"
	       		+ "           <a href=\"Lecture_details\"><button type=\"button\" class=\"btn btn-success btn-lg\">Lecture Details</button></a>\r\n"
	       		+ "           <a href=\"Registration_log\"><button type=\"button\" class=\"btn btn-primary btn-lg\">Registration</button></a>\r\n\" "
	       		+ "\r\n"
	       		+ "\r\n"
	       		+ "        </div>\r\n"
	       		+ "\r\n"
	       		+ "\r\n"
	       		+ "     </div>\r\n"
	       		+ "\r\n"
	       		+ "</body>\r\n"
	       		+ "</html>");
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
