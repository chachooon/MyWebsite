import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User;
import dao.UserDao;

@WebServlet("/LoginActions")
public class LoginActions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginActions() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = request.getParameter("target");
		UserDao uDao = UserDao.getInstance();

		if (request.getParameter("email") != null && request.getParameter("pwd") != null) {
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			
			User user = uDao.selectUser(email);
			if (user != null) {
				if (user != null && user.getPassword().equals(pwd)) {
					// 로그인 성공하면 세션에 회원정보 저장
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					session.setAttribute("name", user.getName());

					if (request.getParameter("keepID") != null) {
						// 아이디 저장 체크시 쿠키에 아이디 저장
						Cookie cookie = new Cookie("email", email);
						response.addCookie(cookie);
					} else { // 아이디 저장 체크 해제시 쿠키 삭제
						Cookie cookie = new Cookie("email", "");
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
					if (target == null)
						target = (String) session.getAttribute("target");
					if (target == null) { // target 값이 없을 경우 홈으로 리다이렉트
						response.sendRedirect("http://localhost:8080/index.jsp");
					} else { // target 값이 있을 경우 해당경로로 리다이렉트
						response.sendRedirect("http://localhost:8080/index.jsp");
					}
				} else {// 로그인 실패하면 error메세지 출력
					System.out.println("아이디, 비밀번호 틀림");
					response.sendRedirect("http://localhost:8080/login.jsp");
				}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
