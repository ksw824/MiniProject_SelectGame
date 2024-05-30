package ch09;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		
		long result = 0;
		switch(request.getParameter("op")){
	 	case "+" : result = n1+n2;break;
	 	case "-" : result = n1 -n2; break;
	  	case "*" : result = n1 * n2; break;
	 	case "/" :result = n1/n2;break;
	 	}
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ch09/calcResult.jsp");
		dispatcher.forward(request, response);
		//getServletContext().getRequestDispatcher("/ch09/calcResult.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
