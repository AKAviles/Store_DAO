package com.perscholas.store;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends AbstractDAO implements ICustomerDao {
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		try {
			this.connect();
			ps = conn.prepareStatement(ICustomerDao.SQL.GET_ALL_CUSTOMERS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt(1));
				customer.setEmail(rs.getString(2));
				customer.setfName(rs.getString(3));
				customer.setlName(rs.getString(4));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
			return customers;
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.GET_CUSTOMER_BY_ID.getQuery());
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				customer.setId(rs.getInt(1));
				customer.setEmail(rs.getString(2));
				customer.setfName(rs.getString(3));
				customer.setlName(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
			return customer;
		}
	}

	@Override
	public Customer addCustomer(Customer c) {
		int id = 0;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.ADD_CUSTOMER.getQuery(), Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getfName());
			ps.setString(3, c.getlName());

			int affectedRows = ps.executeUpdate();
			if (affectedRows > 0) {
				try {
					rs = ps.getGeneratedKeys();
					if (rs.next()) {
						id = rs.getInt(1);
						c.setId(id);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
			return c;
		}
	}

	@Override
	public boolean removeCustomerById(int id) throws SQLException {
		boolean deleted = false;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.DELETE_CUSTOMER_BY_ID.getQuery());
			ps.setInt(1, id);
			int affectedRows = ps.executeUpdate();
			if (affectedRows > 0) {
				deleted = true;
				System.out.println("Row successfully deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
			return deleted;
		}
	}
}
