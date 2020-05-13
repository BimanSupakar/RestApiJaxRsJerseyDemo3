package co.biman.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {
	private static String drive, url, user, password;

	private DbUtil() {
	}

	static {
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		drive = rb.getString("jdbc.driver");
		url = rb.getString("jdbc.url");
		user = rb.getString("jdbc.user");
		password = rb.getString("jdbc.password");
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		return DriverManager.getConnection(url, user, password);
	}
}
