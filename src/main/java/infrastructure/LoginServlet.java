package infrastructure;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MySqlUserRepository;
import repository.UserRepository;
import usecase.LoginUseCase;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private LoginUseCase loginUseCase;

	public void init() {
		// NOTE
		// 初期化時に、LoginUseCaseをインスタンス化する際にUserRepositoryの具体的な実装である
		// MySqlUserRepositoryをLoginUseCaseのコンストラクタに渡す
		// これによりLoginUseCaseはデータアクセスの詳細や取得方法に依存しない。
		// この分離によって、LoginUseCaseのテストや他のデータソースへの切り替えが容易になる
		UserRepository userRepository = new MySqlUserRepository();
		loginUseCase = new LoginUseCase(userRepository);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		boolean isAuthenticated = loginUseCase.authenticate(userId, password);

		if (isAuthenticated) {
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("login.jsp?error=true");
		}
	}

}
