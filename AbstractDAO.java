package com.perscholas.store;

import java.sql.*;

import static com.perscholas.store.Constants.*;

public class AbstractDAO {
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	public void connect() throws SQLTransientConnectionException {
		try {
			Class.forName(MYSQL_CJ_JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_LOCALHOST_STORE, USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new SQLTransientConnectionException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void dispose() {
		try {
			if (!rs.equals(null) && !rs.isClosed()) {
				rs.close();
			}
			if (!ps.equals(null) && !ps.isClosed()) {
				ps.close();
			}
			if (!conn.equals(null) && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}


}
