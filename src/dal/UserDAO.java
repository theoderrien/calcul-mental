package dal;

import bo.User;

import java.sql.*;
import java.util.List;

public class UserDAO extends DataAccessObjectJDBC<User> {
	
	private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
	private static final String CREATE_QUERY = "INSERT INTO user (login, password) VALUES (?,?)";

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

	public User createUser(String login, String password ) throws SQLException {

		User user = null;
		try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
			  PreparedStatement ps = connection.prepareStatement(CREATE_QUERY) ) {
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
}
