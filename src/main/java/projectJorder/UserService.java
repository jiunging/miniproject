package projectJorder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
	
	public int join(HttpServletRequest request, HttpServletResponse response);
	
	public USERVO login(HttpServletRequest request, HttpServletResponse response);
	
	public USERVO getUserInfo(HttpServletRequest request, HttpServletResponse response);
	
	public int update(HttpServletRequest request, HttpServletResponse response);
	
	public int delete(HttpServletRequest request, HttpServletResponse response);
	

}
