package ch05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public QueryTestServlet() {
        super();
    }

    /*
     http://localhost:8080/queryTest?
			id=9774
			&pwd=1234
			&name=홍길동
			&hobby=news
			&hobby=dialog
			&gender=female
			&religion=무교
			&introduction=저의+이름은+홍길동입니다.
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id= request.getParameter("ID");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String [] hobbies = request.getParameterValues("hobby");		
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String intro = request.getParameter("introduction");
		
		response.setContentType("text/html;charset=UTF-8");		
		
		PrintWriter out = response.getWriter();
		out.append("<html><head><title>멤버정보</title></head><body>");
		out.append("id: " + id + "<br>");
		out.append("password: " + pwd + "<br>");
		out.append("name: " + name + "<br>");
		out.append("hobbies: ");
		for(int i=0; i < hobbies.length; i++) {
			out.append(hobbies[i] + " ");
		}
		out.append("<br> 성별: " + gender + "<br>");
		out.append("종교: " + religion + "<br>");
		out.append("소개: " + intro + "<br>");
		out.append("전체질의 문자열: " + request.getQueryString() + "<br>");
		out.append("</body></html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
