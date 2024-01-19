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

/**
 * Servlet implementation class Enter_marks
 */
@WebServlet("/Enter_marks")
public class Enter_marks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enter_marks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stid=request.getParameter("sid");
		System.out.println("sid+"+stid);
		int sid=Integer.parseInt(stid);
		DBoperations db=new DBoperations();
		 List m=new ArrayList(); 
	      m=db.marklistprint(sid);

		PrintWriter out=response.getWriter();
	       out.print("<!DOCTYPE html>\r\n"
	       		+ "<html lang=\"en\">\r\n"
	       		+ "<head>\r\n"
	       		+ "    <meta charset=\"UTF-8\">\r\n"
	       		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	       		+ "    <title>Document</title>\r\n"
	       		+ "    <link rel=\"stylesheet\" href=\"enter_marks.css\">\r\n"
	       		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
	       		+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css\">\r\n"
	       		+ "\r\n"
	       		+ "</head>\r\n"
	       		+ "<body>\r\n"
	       		+ "    <div class=\"main\">\r\n"
	       		+ "        <nav class=\"navbar\">\r\n"
	       		+ "            <img src=\"img/logo-final.png\" alt=\"\">\r\n"
	       		+ "            <h6 style=\"padding:30px; color:#3034a8; text-align:left;\">KOZHUVALLOOR POST - CHENGANNUR, ALAPPUZHA DIST<br>Tel: 0479-2369993, 2369994 | Email: info@stcet.net </h6>\r\n"
	       		+ "          </nav>\r\n"
	       		+ "\r\n"
	       		+ "        <div class=\"formbox\">\r\n"
	       		+ "            <div class=\"login_heading\">\r\n"
	       		+ "                <h3>Enter Marks</h3>\r\n"
	       		+ "            </div>\r\n"
	       		+ "            <div class=\"logform\">\r\n"
	       		+ "\r\n"
	       		+ "                <form action=\"Marks_insert\" method=\"post\" class=\"a\">\r\n"
	       		+ "                    <table class=\"table table-borderless table-secondary\">\r\n"
	       		+ "                        <tbody>\r\n"
	       		+ "                            <tr>\r\n"
	       		+ "                                <td>\r\n"
	       		+ "                    <label for=\"sub\"><b>Subject : Malayalam</b></label>\r\n"
	       		+ "                </td>\r\n"
	       		+ "                <td>\r\n"
	       		+ "					   <input type='hidden' name='id' value="+stid+">\r\n"
	       		+ "                    <label  for=\"temark\"><b>T.E Mark</b> </label>\r\n"
	       		+ "                    <input  type=\"text\" placeholder=\" T.E:\" name=\"tmark1\" value="+m.get(3)+" id=\"tmark\">\r\n"
	       		+ "                    <label  for=\"cemark\"><b>C.E Mark</b> </label>\r\n"
	       		+ "                    <input  type=\"text\" placeholder=\" C.E:\" name=\"cemark1\" value="+m.get(4)+" id=\"pmark\" >\r\n"
	       		+ "                     <br>\r\n"
	       		+ "                    </td>\r\n"
	       		+ "                </tr>  \r\n"
	       		+ "                    <tr>\r\n"
	       		+ "                    <td>\r\n"
	       		+ "                     <label for=\"sub\"><b>Subject : English</b></label>\r\n"
	       		+ "                    </td>\r\n"
	       		+ "                <td> \r\n"
	       		+ "                    <label  for=\"temark\"><b>T.E Mark</b> </label>\r\n"
	       		+ "                    <input  type=\"text\" placeholder=\" T.E:\" name=\"tmark2\" value="+m.get(5)+" id=\"tmark\">\r\n"
	       		+ "                    <label  for=\"cemark\"><b>C.E Mark</b> </label>\r\n"
	       		+ "                    <input  type=\"text\" placeholder=\" C.E:\" name=\"cemark2\" value="+m.get(6)+" id=\"pmark\" >\r\n"
	       		+ "                </td>\r\n"
	       		+ "            </tr>\r\n"
	       		+ "        <tr>\r\n"
	       		+ "            <td>\r\n"
	       		+ "                     <label for=\"sub\"><b>Subject : Maths</b></label>\r\n"
	       		+ "                    </td>\r\n"
	       		+ "                <td>        \r\n"
	       		+ "                    <label for=\"temark\"><b>T.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" T.E:\" name=\"tmark3\" value="+m.get(7)+" id=\"tmark\">\r\n"
	       		+ "                    <label for=\"cemark\"><b>C.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" C.E:\" name=\"cemark3\" value="+m.get(8)+" id=\"pmark\" >\r\n"
	       		+ "                </td>\r\n"
	       		+ "            </tr> \r\n"
	       		+ "        <tr>    \r\n"
	       		+ "            <td>\r\n"
	       		+ "                     <label for=\"sub\"><b>Subject : Physics</b></label>\r\n"
	       		+ "                    </td>\r\n"
	       		+ "                <td> \r\n"
	       		+ "                    <label for=\"temark\"><b>T.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" T.E:\" name=\"tmark4\" value="+m.get(9)+" id=\"tmark\">\r\n"
	       		+ "                    <label for=\"cemark\"><b>C.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" C.E:\" name=\"cemark4\" value="+m.get(10)+" id=\"pmark\" >\r\n"
	       		+ "                </td>\r\n"
	       		+ "            </tr>\r\n"
	       		+ "        <tr>      \r\n"
	       		+ "            <td>\r\n"
	       		+ "                     <label for=\"sub\"><b>Subject : Chemistry</b></label>\r\n"
	       		+ "                    </td>\r\n"
	       		+ "                <td> \r\n"
	       		+ "                    <label for=\"temark\"><b>T.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" T.E:\" name=\"tmark5\" value="+m.get(11)+" id=\"tmark\">\r\n"
	       		+ "                    <label for=\"cemark\"><b>C.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" C.E:\" name=\"cemark5\" value="+m.get(12)+" id=\"pmark\" >\r\n"
	       		+ "                </td>\r\n"
	       		+ "            </tr>\r\n"
	       		+ "        <tr>      \r\n"
	       		+ "            <td>\r\n"
	       		+ "                     <label for=\"sub\"><b>Subject : Biology</b></label>\r\n"
	       		+ "                    </td>\r\n"
	       		+ "                <td>   \r\n"
	       		+ "                    <label for=\"temark\"><b>T.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" T.E:\" name=\"tmark6\" value="+m.get(13)+" id=\"tmark\">\r\n"
	       		+ "                    <label for=\"cemark\"><b>C.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" C.E:\" name=\"cemark6\" value="+m.get(14)+" id=\"pmark\" >\r\n"
	       		+ "                </td>\r\n"
	       		+ "            </tr>\r\n"
	       		+ "        <tr>\r\n"
	       		+ "                <td>\r\n"
	       		+ "                     <label for=\"sub\"><b>Subject : I.T</b></label>\r\n"
	       		+ "                    </td>\r\n"
	       		+ "                <td>    \r\n"
	       		+ "                    <label for=\"temark\"><b>T.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" T.E:\" name=\"tmark7\" value="+m.get(15)+" id=\"tmark\">\r\n"
	       		+ "                    <label for=\"cemark\"><b>C.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" C.E:\" name=\"cemark7\" value="+m.get(16)+" id=\"pmark\" >\r\n"
	       		+ "                </td>\r\n"
	       		+ "            </tr>\r\n"
	       		+ "        <tr>    \r\n"
	       		+ "        <td>\r\n"
	       		+ "                     <label for=\"sub\"><b>Subject : Social Science</b></label>\r\n"
	       		+ "                    </td>\r\n"
	       		+ "                <td>          \r\n"
	       		+ "                    <label for=\"temark\"><b>T.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" T.E:\" name=\"tmark8\" value="+m.get(17)+" id=\"tmark\">\r\n"
	       		+ "                    <label for=\"cemark\"><b>C.E Mark</b> </label>\r\n"
	       		+ "                    <input type=\"text\" placeholder=\" C.E:\" name=\"cemark8\" value="+m.get(18)+" id=\"pmark\" >\r\n"
	       		+ "                </td>\r\n"
	       		+ "                </tr>\r\n"
	       		+ "                    \r\n"
	       		+ "                    </table>\r\n"
	       		+ "                    <button type=\"submit\" class=\"registerbtn\">Submit</button>\r\n"
	       		+ "\r\n"
	       		+ "                </form>\r\n"
	       		+ "            </div>\r\n"
	       		+ "\r\n"
	       		+ "\r\n"
	       		+ "        </div>\r\n"
	       		+ "\r\n"
	       		+ "    </div>\r\n"
	       		+ "    \r\n"
	       		+ "</body>\r\n"
	       		+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
