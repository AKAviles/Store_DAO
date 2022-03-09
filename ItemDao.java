package com.perscholas.store;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDao extends AbstractDAO implements IItemDao{
	@Override
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.GET_ALL_ITEMS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt(1));
				item.setName(rs.getString(2));
				item.setPrice(rs.getDouble(3));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
			return items;
		}
	}

	@Override
	public Item getItemById(int id) {
		Item item = new Item();
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.GET_ITEM_BY_ID.getQuery());
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				item.setId(rs.getInt(1));
				item.setName(rs.getString(2));
				item.setPrice(rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
			return item;
		}
	}

	@Override
	public Item addItem(Item i) {
		int id = 0;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.ADD_ITEM.getQuery(), Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, i.getName());
			ps.setDouble(2, i.getPrice());
			int affectedRows = ps.executeUpdate();
			if (affectedRows > 0) {
				try {
					rs = ps.getGeneratedKeys();
					if (rs.next()) {
						id = rs.getInt(1);
						i.setId(id);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
			return i;
		}
	}

	@Override
	public boolean removeItemById(int id) throws SQLException {
		boolean deleted = false;
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.DELETE_ITEM_BY_ID.getQuery());
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
