package college_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Student_login_mark
 */
@WebServlet("/Student_login_mark")
public class Student_login_mark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_login_mark() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession(false); 
		System.out.println("Hello");
		if(session!=null)
		{
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		
	      int sid=(Integer)session.getAttribute("id");
	      System.out.println("stu "+sid);
	      DBoperations db=new DBoperations();
	      List n=new ArrayList();   
	      n=db.studentinfo(sid);
	      List  m=new ArrayList(); 
	      m=db.marklistprint(sid);
		System.out.println(n.get(2));
		int i=(int) n.get(0);
		System.out.println(i);
		
		int a=3,b=4,j=0,g=0;
		String k="",h="";
		String grade[]=new String[10];
		System.out.println( m.get(a));
		while(a<18)
		{
		 k= (String) m.get(a);
		 h= (String) m.get(b);
			System.out.println("k="+k);
			System.out.println("h="+h);
			int r=Integer.parseInt(k);
			int s=Integer.parseInt(h); 
		 g=r+s;
		  
		a=a+2;
		b=b+2;
		System.out.println("gra "+g);
		if(g<32 && g>40)
		{
			grade[j]="D";
		}
		else if(g>39 && g<50)
		{
			grade[j]="C";
		}
		else if(g>49 && g<60)
		{
			grade[j]="C+";
		}
		else if(g>59 && g<70)
		{
			grade[j]="B";
		}
		else if(g>69 && g<80)
		{
			grade[j]="B+";
		}
		else if(g>79 && g<90)
		{
			grade[j]="A";
		}
		else if(g>89 && g<101)
		{
			grade[j]="A+";
		}
		else
		{
			grade[j]="E";
		}
		j++;
		} 
		
		
		if(i==1)
		{
	
		 PrintWriter out=response.getWriter();
	       out.print("<!DOCTYPE html>\r\n"
	       		+ "<html>\r\n"
	       		+ "<head>\r\n"
	       		+ "<meta charset=\"ISO-8859-1\">\r\n"
	       		+ "<title>Student_Profile</title>\r\n"
	       		+ "<link rel=\"stylesheet\" href=\"student_loginpage.css\">\r\n"
	       		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
	       		+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css\">\r\n"
	       		+ "</head>\r\n"
	       		+ "<body>\r\n"
	       		+ " <div class=\"main\">\r\n"
	       		+ "        <nav class=\"navbar\">\r\n"
	       		+ "            <img src=\"img/logo-final.png\" alt=\"\">\r\n"
	       		+ "            <h6 style=\"padding:30px; color:#3034a8; text-align:left;\">KOZHUVALLOOR POST - CHENGANNUR, ALAPPUZHA DIST<br>Tel: 0479-2369993, 2369994 | Email: info@stcet.net </h6>\r\n"
	       		+ "            <i class=\"bi bi-person-circle\"></i>\r\n"
	       		+ "            <b>"+n.get(3)+"</b><br>\r\n"
	       		+ "            <a href=\"Logout?="+sid+"\"><h5><u>Logout</u></h5></a>\r\n"
	       		+ "        </nav>\r\n"
	       		+ "        <div class=\"contdiv\">\r\n"
	       		+ "            <div class=\"leftdiv\">\r\n"
	       		+ "\r\n"
	       		+ "                <div class=\"upper-container\">\r\n"
	       		+ "                    <div class=\"image-container\">\r\n"
	       		+ "                        <img src=\"img/3135715.png\" />\r\n"
	       		+ "                    </div>\r\n"
	       		+ "                </div>\r\n"
	       		+ "                <div class=\"lower-container\">\r\n"
	       		+ "                    <table class=\"table table-borderless table-sm\">\r\n"
	       		+ "                        <tbody>\r\n"
	       		+ "                            <tr>\r\n"
	       		+ "                                <th ></th>\r\n"
	       		+ "                                <th ></th>\r\n"
	       		+ "                                \r\n"
	       		+ "                              </tr>\r\n"
	       		+ "                            <tr>\r\n"
	       		+ "                             \r\n"
	       		+ "                              <th>Name :</th>\r\n"
	       		+ "                              <td>"+n.get(3)+"</td>\r\n"
	       		+ "                            </tr>\r\n"
	       		+ "                            <tr>  \r\n"
	       		+ "                             \r\n"
	       		+ "                              <td>Department :</td>\r\n"
	       		+ "                              <td>"+n.get(8)+"</td>\r\n"
	       		+ "                            </tr>\r\n"
	       		+ "                            <tr>\r\n"
	       		+ "                              \r\n"
	       		+ "                              <td>Phone :</td>\r\n"
	       		+ "                              <td>"+n.get(4)+"</td>\r\n"
	       		+ "                            </tr>\r\n"
	       		+ "                            <tr>\r\n"
	       		+ "                             \r\n"
	       		+ "                              <td>Email :</td>\r\n"
	       		+ "                              <td>"+n.get(5)+"</td>\r\n"
	       		+ "                            </tr>\r\n"
	       		+ "                            <tr>\r\n"
	       		+ "                              \r\n"
	       		+ "                              <td>DOB :</td>\r\n"
	       		+ "                              <td>"+n.get(6)+"</td>\r\n"
	       		+ "                            </tr>\r\n"
	       		+ "                            <tr>\r\n"
	       		+ "                              \r\n"
	       		+ "                              <td>Gender :</td>\r\n"
	       		+ "                              <td>"+n.get(7)+"</td>\r\n"
	       		+ "                            </tr>\r\n"
	       		+ "                            \r\n"
	       		+ "                        </tbody>\r\n"
	       		+ "                      </table>\r\n"
	       		+ "                </div>\r\n"
	       		+ "            </div>\r\n"
	       		+ "    \r\n"
	       		+ "            <div class=\"rightdiv\">\r\n"
	       	  + "               <div class=\"heading\"> \r\n"
	      	+ "                 <h3>Report card</h3>\r\n"
	      	+ "               </div>  \r\n"
	      	+ "               <table class=\"table table-bordered border-primary\" id=\"tab\"> \r\n"
	      	+ "                 <tbody>\r\n"
	      	+ "                <tr >\r\n"
	      	+ "                 <th scope=\"col\" id=\"colhead\">Subjects</th> \r\n"
	      	+ "               <th scope=\"col\" id=\"colhead\">Mark T.E</th>  \r\n"
	      	+ "               <th scope=\"col\" id=\"colhead\">Mark C.E</th>  \r\n"
	      	+ "               <th scope=\"col\" id=\"colhead\">Grade</th>  \r\n"
	      	+ "               </tr> \r\n"
	      	+ "                <tr> \r\n"
	      	+ "                <th scope=\"row\">Malayalam</th> \r\n"
	      	+ "                          <td>"+m.get(3)+"</td>\r\n"                       
	      	+ "                          <td>"+m.get(4)+"</td>\r\n"      
	      	+ "                <td id=\""+grade[0]+"\">"+grade[0]+"</td>\r\n"
	      	+ "                </tr>\r\n"
	      	+ "                 <tr>\r\n"
	      	+ "                 <th scope=\"row\">English</th>\r\n"
	      	+ "                          <td>"+m.get(5)+"</td>\r\n"                        
	      	+ "                          <td>"+m.get(6)+"</td>\r\n"
	      	+ "               <td id=\""+grade[1]+"\">"+grade[1]+"</td> \r\n"
	      	+ "                </tr> \r\n"
	      	+ "               <tr> \r\n"
	      	+ "                <th scope=\"row\">Maths</th> \r\n"
	      	+ "                          <td>"+m.get(7)+"</td>\r\n"      
	      	+ "                          <td>"+m.get(8)+"</td>\r\n"      
	      	+ "                <td id=\""+grade[2]+"\">"+grade[2]+"</td> \r\n"
	      	+ "               </tr>  \r\n"
	      	+ "               <tr> \r\n"
	      	+ "               <th scope=\"row\">Physics</th> \r\n"
	      	+ "                          <td>"+m.get(9)+"</td>\r\n"      
	      	+ "                          <td>"+m.get(10)+"</td>\r\n"   
	      	+ "                <td id=\""+grade[3]+"\">"+grade[3]+"</td> \r\n"
	      	+ "                </tr>  \r\n"
	      	+ "                <tr>  \r\n"
	      	+ "               <th scope=\"row\">Chemistry</th> \r\n"
	      	+ "                          <td>"+m.get(11)+"</td>\r\n"      
	      	+ "                          <td>"+m.get(12)+"</td>\r\n"      
	      	+ "                <td id=\""+grade[4]+"\">"+grade[4]+"</td> \r\n"
	      	+ "                </tr>  \r\n"
	      	+ "                <tr>  \r\n"
	      	+ "                <th scope=\"row\">Biology</th> \r\n"
	      	+ "                          <td>"+m.get(13)+"</td>\r\n"      
	      	+ "                          <td>"+m.get(14)+"</td>\r\n"      
	      	+ "                 <td id=\""+grade[5]+"\">"+grade[5]+"</td> \r\n"
	      	+ "                </tr>   \r\n"
	      	+ "               <tr> \r\n"
	      	+ "                <th scope=\"row\">I.T</th> \r\n"
	      	+ "                          <td>"+m.get(15)+"</td>\r\n"   
	      	+ "                          <td>"+m.get(16)+"</td>\r\n"   
	      	+ "               <td id=\""+grade[6]+"\">"+grade[6]+"</td> \r\n"
	      	+ "               </tr>  \r\n"
	      	+ "               <tr> \r\n"
	      	+ "                <th scope=\"row\">Social Studies</th> \r\n"
	      	+ "                          <td>"+m.get(17)+"</td>\r\n"   
	      	+ "                          <td>"+m.get(18)+"</td>\r\n"   
	      	+ "               <td id=\""+grade[7]+"\">"+grade[7]+"</td> \r\n"
	      	+ "              </tr>  \r\n"                           
	      	+ "                    </tbody>\r\n"
	      	+ "                  </table>\r\n"
	       		+ "                 </div>\r\n"
	       		+ "            </div>\r\n"
	       		+ "        </div>\r\n"
	       		+ "       \r\n"
	       		+ "\r\n"
	       		+ "\r\n"
	       		+ "    </div>\r\n"
	       		+ "</body>\r\n"
	       		+ "</html>");
		
	}
		else {
			
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
