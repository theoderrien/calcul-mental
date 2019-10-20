package dal;

import bo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DataAccessObjectJDBC<User> {
	
	private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
	private static final String LEADERBOARD_QUERY = "SELECT login,bestScore FROM user ORDER BY bestScore DESC LIMIT 10";

	public UserDAO( String dbUrl, String dbLogin, String dbPwd ) {
		super( dbUrl, dbLogin, dbPwd );
	}

	@Override
	public void create(User objet) {

	}

	@Override
	public List<User> findAll() {
		return null;
	}
	
	public User authenticate(String login, String password ) throws SQLException {
		
		User user = null;
		try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
			  PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY) ) {
			ps.setString( 1, login );
			ps.setString( 2, password );
			try ( ResultSet rs = ps.executeQuery() ) {
				if ( rs.next() ) {
					user = new User();
					user.setLogin( rs.getString( "login" ) );
					user.setPassword( rs.getString( "password" ) );
				}
			}
		}
		return user;
	}

	public List<User> leaderboard() throws SQLException {
		List<User> leaderboard = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
			 PreparedStatement ps = connection.prepareStatement(LEADERBOARD_QUERY)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					User user = new User();
					user.setLogin(rs.getString("login"));
					user.setBestScore(rs.getInt("bestScore"));
					leaderboard.add(user);
				}
			}
		}
		return leaderboard;
	}
}
