package projectJorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	

	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	private String url = JdbcUtil.url;
	private String uid = JdbcUtil.uid;
	private String upw = JdbcUtil.upw;
	
	
	public int idCheck(String id) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from members where id = ?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if(rs.next()) { // 동작을 하는 순간? 이미 중복이 있다는 소리임
				result = 1;
			} else {
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public void insertUser(USERVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "insert into members values(?,?,?,?)";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}
	
	public USERVO login(String id, String pw) {
		
		USERVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from members where id = ? and pw = ?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 있으면 데이터가 있다는 뜻, 로그인 가능
				vo = new USERVO();
				vo.setId(id);
				vo.setName(rs.getString("name"));
			}
			
			
			
		} catch (Exception e) {
			
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	public USERVO getUserInfo(String id) {
		
		USERVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from members where id = ?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				vo = new USERVO(id, pw, name, email);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		
		return vo;
		
	}
	
	
	
	
	
	
	
	

}
