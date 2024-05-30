package ch09_2;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StudentDAO dao = null;
	public StudentController() {
		super();
	}
	//init(): 서블릿이 컨테이너에 올라올때 호출되는 메소드
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		dao = new StudentDAO();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/studentControl?action=list")
			.forward(request, response);
		}else {
			switch(action) {
			case "list" : view = list(request, response);break;
			case "insert" : view = insert(request, response);break;
			//case "delete" : view = delete(request, response);break;
			}
			getServletContext().getRequestDispatcher("/ch09_2/" + view).forward(request, response);
		}
	}
	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("students", dao.getAll());
		return "studentInfo.jsp";
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Student s = new Student();
		try {
			BeanUtils.populate(s,request.getParameterMap());
		}catch(Exception e) {
			e.printStackTrace();
		}
		dao.insert(s);
		return list(request,response);
	}
	

}
