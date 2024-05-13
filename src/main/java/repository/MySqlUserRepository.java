package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnect;
import domain.User;

public class MySqlUserRepository implements UserRepository {

	@Override
	public User findUserById(String userId) {
		User user = null;

		try {
			DatabaseConnect dbConnect = new DatabaseConnect();
			Connection conn = dbConnect.getDatabaseConnection();

			// ユーザー取得SQL
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = ?");
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();

			// 1件しか取得できない想定
			if (rs.next()) {
				String foundUserId = rs.getString("user_id");
				String password = rs.getString("password");
				user = new User(foundUserId, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
