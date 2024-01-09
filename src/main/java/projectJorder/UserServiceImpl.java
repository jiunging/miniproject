package projectJorder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService{
	
	UserDAO dao = UserDAO.getInstance();

	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println("넘어온값: " +  id);
		
		int result = dao.idCheck(id);
		
		if(result == 1) {
			return result;
		} else {
			USERVO vo = new USERVO(id, pw, name, email);
			// 이제 입력 메서드 만들기
			dao.insertUser(vo);
			return 0;
		}
		
	}

	@Override
	public USERVO login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		USERVO vo = dao.login(id, pw);
		
		
		return vo;
	}

	@Override
	public USERVO getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		USERVO vo = dao.getUserInfo(id);
		return vo;
	}
	
	

	
	
}
