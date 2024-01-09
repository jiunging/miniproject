package projectJorder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());
		System.out.println(path);
		
		// 서비스 선언
		UserService service = new UserServiceImpl();
		
		if(path.equals("/projectJorder/user_join.user")) {
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
		} else if(path.equals("/projectJorder/user_login.user")) { // 로그인화면
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		} else if(path.equals("/projectJorder/joinForm.user")) { // 회원가입
			
			int result = service.join(request, response);
			
			if(result == 1) { // 아이디 중복
				request.setAttribute("msg", "아이디가 중복되었습니다");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);
			} else { // 회원가입 성공
				response.sendRedirect("user_login.user");
			}
			
		} else if(path.equals("/projectJorder/loginForm.user")) { // 로그인
			USERVO vo = service.login(request, response);
			
			if(vo != null) { // 로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_name", vo.getName());
				
				response.sendRedirect(request.getContextPath()); // 홈화면

			} else { // 로그인 실패
				request.setAttribute("msg", "아이디, 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
				
			}
		} else if(path.equals("/projectJorder/user_mypage.user")) { // 마이페이지
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);
		} else if(path.equals("/projectJorder/logout.user")) { // 로그아웃
			
		} else if(path.equals("/projectJorder/user_update.user")) {
			
			USERVO vo = service.getUserInfo(request, response);
			
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("user_update.jsp").forward(request, response);
			
		}
				
				
		
		
		
		
		
		
		
	}

}
