package college_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lecture_details
 */
@WebServlet("/Lecture_details")
public class Lecture_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lecture_details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang='en'>");
		out.print("<head>");
		   out.print(" <meta charset='UTF-8'>");
		   out.print(" <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		    out.print("<link rel='stylesheet' href='students_details.css'>");
		    out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
		    out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css'>");
		    out.print("<title>Lecture_Details</title>");
		out.print("</head>");
		out.print("<body>");
		    out.print("<div class='main'>");
		        out.print("<nav class='navbar'>");
		            out.print("<img src='img/logo-final.png' alt=''>");
		            out.print("<h6 style='padding:30px; color:#3034a8; text-align:left;'>KOZHUVALLOOR POST - CHENGANNUR, ALAPPUZHA DIST<br>Tel: 0479-2369993, 2369994 | Email: info@stcet.net </h6>");
		        out.print("</nav>");

		        out.print("<div class='tablediv'>");
		            out.print("<table class='table table-striped'>");
		                out.print("<thead>");
		                    out.print("<tr>");
		                      out.print("<th scope='col'>SL.No</th>");
		                      out.print("<th scope='col'>Name</th>");
		                      out.print("<th scope='col'>Phone</th>");
		                      out.print("<th scope='col'>Email</th>");
		                      out.print("<th scope='col'>DOB</th>");
		                      out.print("<th scope='col'>Gender</th>");
		                      out.print("<th scope='col'>Department</th>");
		                      out.print("<th scope='col'>Password</th>");
		                    out.print("</tr>");
		                  out.print("</thead>");
		                  out.print("<tbody>");
		                  try 
		                  {
		                	  Class.forName("com.mysql.jdbc.Driver");
		         			 Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/collegemang","root","reebu312");
		         			Statement stm=con.createStatement();
		         			ResultSet rs=stm.executeQuery("select * from lecture");
		         			while(rs.next())
		         			{
		         				 out.print("<tr>");
			                        out.print("<th scope='row'>"+rs.getInt("slno")+"</th>");
			                        out.print("  <td>"+rs.getString("name")+"</td>");
			                        out.print("  <td>"+rs.getString("phone")+"</td>");
			                        out.print("  <td>"+rs.getString("email")+"</td>");
			                        out.print("  <td>"+rs.getString("dob")+"</td>");
			                        out.print("  <td>"+rs.getString("gender")+"</td>");
			                        out.print("  <td>"+rs.getString("department")+"</td>");
			                        out.print("  <td>"+rs.getString("password")+"</td>");
			                    out.print("</tr>");
		         				
		         			}
							
						  } 
		                  catch (Exception e)
		                  {
							System.out.println(e);
						}
		                   
		                out.print("</tbody>");
		                  
		              out.print("</table>");
		        out.print("</div>");


		    out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
