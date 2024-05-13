package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/please_your_database";
	private static final String DB_USER = "please_your_user";
	private static final String DB_PASSWORD = "please_your_password";

	/**
	 * データベースのコネクション情報を生成し返却する
	 * 
	 * @return コネクション情報
	 */
	public Connection getDatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
	}
}
