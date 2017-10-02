package dao;
import java.sql.SQLException;
import java.util.*;



public class UserDao extends Dao {
	private static UserDao instance = new UserDao();
//	User user = new User();
	
	private UserDao() {
		super("user_info");
	}

	public static UserDao getInstance() {
		if (instance == null)
			instance = new UserDao();
		return instance;
	}

	public int checkID(String email) {
		String query = "SELECT email, password FROM "+tableName+" WHERE email = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			pstmt.setString(1,email);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1; // 아이디, 비밀번호 일치할 경우
			} else {
				result = 0; // 조회결과 없을경우
			}
		} catch (Exception e) {
			System.out.println("CheckID:" + e.getMessage());
			result = 0;
		} finally {
			close(rs, pstmt);
		}
		return result;
	} // CheckID()의 끝

	public User selectUser(String email) {
		String query = "SELECT * FROM "+tableName+" WHERE EMAIL = ?";
		//"SELECT * FROM user_info WHERE EMAIL = 'admin@email.com'";
		User user = new User();
		try {
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
			} else {
				System.out.println("조회결과없음");
			}
		} catch (Exception e) {
			System.out.println("selectUser:" + e.getMessage());

		} finally {
			close(rs, pstmt);
		}
		return user;
	} // SelectUser()의 끝

	public List<User> selectAllUsers() {
		String query = "SELECT * FROM "+tableName;
		List<User> users = new ArrayList<User>();
		User user = null;
		try {
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new User(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"));
				users.add(user);
			}
			System.out.println("조회결과 :" + users.size() + "건");

		} catch (Exception e) {
			System.out.println("selectAllUsers:" + e.getMessage());
		} finally {
			close(rs, pstmt);
		}
		return users;
	} // selectAllUsers()의 끝

	public int insertUser(User user) {
		int result =0;
//		User user = new User();
		if (user.getEmail().equals("") || user.getPassword().equals("") || user.getName().equals("")) {
			System.out.println("아이디, 비밀번호, 이름을 입력해주세요.");
		} else if (checkID(user.getEmail()) != 0) {
			System.out.println("이미 가입된 아이디 입니다.");
		} else {
			String query = "INSERT INTO "+tableName+"(EMAIL, NAME , PASSWORD) value(?,?,?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,user.getEmail());
				pstmt.setString(2,user.getName());
				pstmt.setString(3,user.getPassword());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("insertUser:" + e.getMessage());
			} finally {
				close(rs, pstmt);
			} 
		}
		return result;
	} // insertUser()의 끝
	
//	public int updateUser(User user) {
//		int result = 0;
//		if (user.getPassword().equals("") || user.getNewPWD().equals("") || user.getName().equals("") || user.getEmail().equals("")) {
//			System.out.println("현재/새 비밀번호, 이름, 이메일을 입력해주세요.");
//		} else if (checkID(user.getId()) != 1) {
//			System.out.println("비밀번호가 일치하지 않습니다.");
//		} else {
//			String query = "UPDATE "+tableName+" SET PASSWORD= ?, NAME=?, EMAIL=?";
//			try {
//				pstmt = conn.prepareStatement(query);
//				pstmt.setString(1,user.getNewPWD());
//				pstmt.setString(2,user.getName());
//				pstmt.setString(3,user.getEmail());
//				result = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				System.out.println("insertUser:" + e.getMessage());
//			}finally {
//				close(rs, pstmt);
//			}
//		}
//		return result;
//	} // updateUser()의 끝

	public int deleteUser(String userID) {
		int result = 0;
		String query = "DELETE FROM"+tableName+" WHERE USER_ID = ?";
		if (checkID(userID) != 1) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		} else {
			try {
				pstmt = conn.prepareStatement(query); // Statement를 가져온다.
				pstmt.setString(1,userID);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("deleteUser:" + e.getMessage());
			} finally {
				close(rs, pstmt);
			}
		}
		return result;
	} // deleteUser()의 끝


}
