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
 * Servlet implementation class Registration_log
 */
@WebServlet("/Registration_log")
public class Registration_log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration_log() {
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
		    out.print("<link rel='stylesheet' href='Registration_log.css'>");
		    out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
		    out.print("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css'>");
		    out.print("<title>Registration_log</title>");
		out.print("</head>");
		out.print("<body>");
		    out.print("<div class='main'>");
		        out.print("<nav class='navbar'>");
		            out.print("<img src='img/logo-final.png' alt=''>");
		            out.print("<h6 style='padding:30px; color:#3034a8; text-align:left;'>KOZHUVALLOOR POST - CHENGANNUR, ALAPPUZHA DIST<br>Tel: 0479-2369993, 2369994 | Email: info@stcet.net </h6>");
		        out.print("</nav>");

		        out.print("<div class='tablediv'>");
		            out.print("<table class='table table-success table-striped'>");
		                out.print("<thead>");
		                    out.print("<tr>");
		                      out.print("<th scope='col'>Lecture ID</th>");
		                      out.print("<th scope='col'>Student ID</th>");
		                      out.print("<th scope='col'>Date Of Registration</th>");
		                      out.print("<th scope='col'>Status</th>");
		                    out.print("</tr>");
		                  out.print("</thead>");
		                  out.print("<tbody>");
		                  try 
		                  {
		                	  int status=0;
		                	  Class.forName("com.mysql.jdbc.Driver");
		         			 Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/collegemang","root","reebu312");
		         			Statement stm=con.createStatement();
		         			ResultSet rs=stm.executeQuery("select * from registration_log");
		         			while(rs.next())
		         			{
		         				 out.print("<tr>");
			                        out.print("<th scope='row'>"+rs.getInt("lectureid")+"</th>");
			                        out.print("  <td>"+rs.getString("studentid")+"</td>");
			                        out.print("  <td>"+rs.getString("date")+"</td>");
			                        status=rs.getInt("status");
			                        if(status==1)
			                        {
			                        	out.print("<td><button type=\"button\" class=\"btn btn-success btn-lg\">Active</button> </td>");
			                        	
			                        }
			                        else
			                        {
			                        	out.print("<td> <a href=\"Registration_activation?sid="+rs.getString("studentid")+"\"><button type=\"button\" class=\"btn btn-danger btn-lg\">Activate</button></a> </td>");
			                        }
			                       
			                        
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
