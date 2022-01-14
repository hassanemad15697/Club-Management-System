package com.spring.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		final String host="jdbc:mysql://localhost/club";
		final String username = "DBHassan";
		final String password="ELKBEER36647126358#";
		Connection conn;
		conn = DriverManager.getConnection(host, username, password);
        System.out.println("Connected!");
        conn.close();

	}

}
