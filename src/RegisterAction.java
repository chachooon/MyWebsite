import dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String submit = request.getParameter("submit");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String pwdCheck = request.getParameter("pwdCheck");
		
		int result =0;
		UserDao uDao = UserDao.getInstance();
		User user = new User(email, name, pwd);

		
		if(submit.equals("Join")) {
			result = uDao.insertUser(user1);
			if(result==0) {
				System.out.println("빈칸을 모두 입력하세요.");
			}else {
				response.sendRedirect("http://localhost:8080/index.jsp");
			}
			
		
		}else if(submit.equals("Update")) {
			result = uDao.updateUser(user2);

			if(result==0) {
				System.out.println("빈칸을 모두 입력하세요.");
			}else {
				session.setAttribute("name", userName);
				session.setAttribute("email", email);
				response.sendRedirect("http://localhost:8080/index.jsp");
			}
			
		}else if(submit.equals("Delete")) {
			result = uDao.deleteUser(id);
			
			if(result==0) {
				System.out.println("탈퇴 실패!");
			}else {
				session.invalidate();
				response.sendRedirect("http://localhost:8080/index.jsp");
			}
			
		
			
		}

	}
}

