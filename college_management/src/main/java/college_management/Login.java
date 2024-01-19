package college_management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String phone=request.getParameter("phn");
		String pass=request.getParameter("psw");
	
		try {
	 		Class.forName("com.mysql.jdbc.Driver");
	 		Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/collegemang","root","reebu312"); 
			Statement stm=con.createStatement();
			
			ResultSet rs=stm.executeQuery("select * from login where phone='"+phone+"' and password='"+pass+"' and status='"+1+"'");
			while(rs.next())
			{
				switch (rs.getString("role")) {
				case "TEACHER": 
				{
					int tid=rs.getInt("teacherid");
					System.out.println("t"+tid);
					HttpSession session=request.getSession();
					session.setAttribute("id",tid );
				
					response.sendRedirect("Lecture_login");
					break;
				}
				case "STUDENT":
				{
					int sid=rs.getInt("studentid");
					System.out.println("s"+sid);
					HttpSession session=request.getSession();
					session.setAttribute("id",sid );
					response.sendRedirect("Student_loginpage");
					break;
				}
				case "ADMIN":
				{
					int aid=rs.getInt("adminid");
					System.out.println("a"+aid);
					HttpSession session=request.getSession();
					session.setAttribute("aid",aid );
					response.sendRedirect("Admin_login");
					break;
				}
				default:
					System.out.println("Password incorrect");
				}
				
			}
			
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}

}
