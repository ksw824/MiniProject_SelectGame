package ch05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HelloWorld() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
			out.append("<html><head><title>Hello World Servlet</title></head><body>")
			.append("<h2>Hello World!!</h2><hr><p><img alt='img' src='ch03/gawi.jpg'></p>")
			.append("현재 날짜와 시간은: "+java.time.LocalDateTime.now())
			.append("</body></html>"); 
	}


	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
