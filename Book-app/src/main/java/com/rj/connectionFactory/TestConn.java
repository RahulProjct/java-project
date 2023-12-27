package main.java.com.rj.connectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConn {

	public static void main(String[] args) throws SQLException {

		System.out.println("load TestConn");
		Connection con = DBConn.getConn();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM BOOK");

		while (rs.next()) {
			
			System.out.println(rs.getString(1) + ", " + 
			rs.getString(2) + ", " + rs.getString(3));
		}
		rs.close();
		st.close();
		con.close();

	}

}
