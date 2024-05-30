package midterm_practice;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GBBPractice
 */
public class GBBPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBBPractice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] img = {"gawi.jpg", "bawi.jpg", "bo.jpg"};
		int my = Integer.parseInt(request.getParameter("my"));
		int com = (int)(Math.random()*3);
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.append("<html><head><title>가위바위보 게임</title></head>")
		.append("<body><table><tr><td>my</td><td>com</td></tr>")
		.append("<tr><td><img src='img/"+img[my]+"' alt='img'</td>")
		.append("<td><img src='img/"+img[com]+"' alt='img'</td></tr>")
		.append("</table></body></head></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
