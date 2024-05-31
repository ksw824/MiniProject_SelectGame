



//package miniProject;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import org.apache.commons.beanutils.BeanUtils;
//
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import miniProject.GameModel.Move;
//import miniProject.GameModel.Result;
//
///**
// * Servlet implementation class UserController
// */
//public class UserController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	UserDAO dao =  null;
//    public UserController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//    public void init(ServletConfig config) throws ServletException{
//		super.init(config);
//		dao = new UserDAO();
//	}
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//    	request.setCharacterEncoding("utf-8");
//    	if(request.getParameter("move")==null) {
//    		String action = request.getParameter("action");
//			String view = "";
//			
//			if(action == null) {
//				getServletContext().getRequestDispatcher("/userControl?action=list")
//				.forward(request, response);
//			}else {
//				switch(action) {
//				case "login" : try {
//						view = login(request, response);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} break;
//				case "list" : view = list(request, response);break;
//				case "join" : view = join(request, response);break;
//				//case "delete" : view = delete(request, response);break;
//				}
//				getServletContext().getRequestDispatcher("/miniProject/" + view).forward(request, response);
//			}
//    	}else {
//    		String playerMoveParam = request.getParameter("move");
//            Move playerMove = Move.valueOf(playerMoveParam);
//
//            GameModel gameModel = new GameModel();
//            gameModel.setPlayerMove(playerMove);
//            Move computerMove = gameModel.getComputerMove();
//            Result result = gameModel.getResult();
//
//            request.setAttribute("playerMove", playerMove);
//            request.setAttribute("computerMove", computerMove);
//            request.setAttribute("result", result);
//
//            request.getRequestDispatcher("/miniProject/ResultView.jsp").forward(request, response);
//    	}
//	}
//    public String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//    	String id = request.getParameter("id");
//    	String password = request.getParameter("password");
//    	if(dao.checkID(id)&&dao.checkPW(password))
//    		return "GameView.jsp";
//    	else
//    		return "startPage.jsp";
//    }
//	public String list(HttpServletRequest request, HttpServletResponse response) {
//		request.setAttribute("users", dao.getAll());
//		return "startPage.jsp";
//	}
//	
//	public String join(HttpServletRequest request, HttpServletResponse response) {
//		User s = new User();
//		try {
//			BeanUtils.populate(s,request.getParameterMap());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		dao.join(s);
//		return list(request,response);
//	}
//
//	
//
//}
//
//UserController.java
package miniProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserController
 */

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO dao = null;

    public UserController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new UserDAO();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = dao.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/miniProject/userList.jsp").forward(request, response);
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            doGet(request, response); // list 액션이나 액션이 지정되지 않은 경우 doGet 호출
            return;
        }

        // 나머지 액션에 대한 처리
        switch (action) {
            case "login":
                try {
                    String view = login(request, response);
                    getServletContext().getRequestDispatcher("/miniProject/" + view).forward(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "join":
                String view = join(request, response);
                getServletContext().getRequestDispatcher("/miniProject/" + view).forward(request, response);
                break;
            case "play":
                playGame(request, response);
                break;
        }
    }
    
    // Add this method to get the logged-in user
    private User getLoggedInUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("loggedInUser");
    }

    // Modify the login method to store the user in the session
    public String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if (dao.validateUser(id, password)) {
            User user = dao.getUserById(id); // Assume this method is implemented to fetch user details
            request.getSession().setAttribute("loggedInUser", user);
            request.setAttribute("message", "로그인 성공!");
            return "index.jsp";
        } else {
            request.setAttribute("message", "로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
            return "startPage.jsp";
        }
    }


    public String list(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", dao.getAll());
        return "userList.jsp"; // User 목록을 표시할 JSP 페이지
    }

    public String join(HttpServletRequest request, HttpServletResponse response) {
        User s = new User();
        try {
            BeanUtils.populate(s, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        dao.join(s);
        // Redirect to userList.jsp after successful registration
        return "userControl?action=list"; 
    }

    // Modify the playGame method to update the game1hp
    private void playGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String moveParam = request.getParameter("move");
        if (moveParam == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        GameModel gameModel = new GameModel();
        GameModel.Move playerMove = GameModel.Move.valueOf(moveParam);
        GameModel.Move computerMove = gameModel.getComputerMove();

        gameModel.setPlayerMove(playerMove);
        GameModel.Result result = gameModel.getResult();

        User loggedInUser = getLoggedInUser(request);
        if (loggedInUser != null) {
            int currentHp = loggedInUser.getGame1hp();
            if (result == GameModel.Result.WIN) {
                loggedInUser.setGame1hp(currentHp + 100);
            } else if (result == GameModel.Result.LOSE) {
                loggedInUser.setGame1hp(currentHp - 100);
            }
            dao.updateUser(loggedInUser); // Assume this method updates the user in the database
        }

        request.setAttribute("playerMove", playerMove);
        request.setAttribute("computerMove", computerMove);
        request.setAttribute("result", result);
        request.setAttribute("game1hp", loggedInUser != null ? loggedInUser.getGame1hp() : "N/A");

        request.getRequestDispatcher("/miniProject/ResultView.jsp").forward(request, response);
    }
}
