package main.java.com.rj.connectionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConn {
	private static DataSource dataSource;
	private static Connection conn = null;

	static {
		try {
			File f = new File("J:/DB.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);

			String url = p.getProperty("url");
			String uname = p.getProperty("uname");
			String pwd = p.getProperty("pwd");
			String size = p.getProperty("size");

			HikariConfig config = new HikariConfig();

			config.setJdbcUrl(url);
			config.setUsername(uname);
			config.setPassword(pwd);
			config.setMaximumPoolSize(Integer.parseInt(size));

			dataSource = new HikariDataSource(config);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConn() throws SQLException {
		
		conn= dataSource.getConnection();
			return conn;
		
	}	
}
