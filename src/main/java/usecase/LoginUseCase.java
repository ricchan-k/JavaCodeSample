package usecase;

import domain.User;
import repository.UserRepository;

public class LoginUseCase {

	private UserRepository userRepository;

	// NOTE
	// 具体的なデータベース実装(MySqlUserRepository)から独立させるため、UserRepositoryインターフェースに依存している。
	// UserRepositoryインターフェースを通じて実装することで、データベースアクセスの実装が変更されても、
	// このクラスには影響がない。将来的に異なるデータベースに変更があった場合でも、LoginUseCaseクラスは変更不要で再利用可能となる。

	/**
	 * コンストラクタ
	 * @param userRepository
	 */
	public LoginUseCase(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * 入力値をもとに認証する
	 * @param userId
	 * @param password
	 * @return true:認証OK / false:認証失敗
	 */
	public boolean authenticate(String userId, String password) {
		User user = userRepository.findUserById(userId);

		if (user != null && user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}
}
