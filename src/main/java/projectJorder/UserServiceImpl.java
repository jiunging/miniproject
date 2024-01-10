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

	@Override
	public int update(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		USERVO vo = new USERVO(id, pw, name, email);
		int result = dao.update(vo);
		
		if(result == 1) { // 성공하면 세션 값도 변경해야함!!!!!!
			HttpSession session = request.getSession();
			session.setAttribute("user_name", name);
		}
		return result;
	}

	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		// 아이디는 세션에서 받고, 비밀번호는 홈페이지에서 받음
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		
		USERVO vo = dao.login(id, pw);
		
		System.out.println("vo가 null인가?" + vo);
		
		if(vo != null) {
			dao.delete(id);
			session.invalidate();
			return 1;
		} else { // 비밀번호가 일치하지 않을 때
			return 0;
		}
	}
	
	

	
	
}
