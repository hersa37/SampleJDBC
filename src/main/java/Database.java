import java.sql.*;
import java.util.LinkedList;

public class Database {

	public Connection getConnection() throws SQLException {
		String url = "jdbc:sqlite:src/main/resources/database.db";

		Connection conn = DriverManager.getConnection(url);
		return conn;
	}

	public LinkedList<User> getData() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedList<User> users = new LinkedList<User>();
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement("SELECT * FROM users");
			rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");

				User user = new User(id, name, email, password);
				users.add(user);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (ps != null) { ps.close(); }
				if (conn != null) { conn.close(); }
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return users;
	}

	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement("INSERT INTO users (id, name, email, password) VALUES (?, ?, ?, ?)");
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (ps != null) { ps.close(); }
				if (conn != null) { conn.close(); }
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
