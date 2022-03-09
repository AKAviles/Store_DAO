package com.perscholas.store;

import java.sql.SQLException;

public class CreateTables extends AbstractDAO {

	public void createTable(String sql) throws SQLException {
		try {
			this.connect();
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
			System.out.println("Table created");
		}
	}


}
