package in.ashok.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionClass {
	private static HikariDataSource ds=null;
public static Connection getConnection() throws IOException, SQLException {
	if(ds==null) {
		InputStream fr = ConnectionClass.class.getClassLoader().getResourceAsStream("db.properties");
		
		Properties p = new Properties();
		p.load(fr);

		String user = p.getProperty("db.username");
		String url = p.getProperty("db.url");
		String password = p.getProperty("db.password");
		String Driver = p.getProperty("db.driver");
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(password);
		config.setDriverClassName(Driver);
		
		ds = new HikariDataSource(config);
		}
	
	return ds.getConnection();
}
}
