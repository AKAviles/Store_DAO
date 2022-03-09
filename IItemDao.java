package com.perscholas.store;

import java.sql.SQLException;
import java.util.List;

public interface IItemDao {
	enum SQL {
		GET_ALL_ITEMS("SELECT * FROM items"),
		GET_ITEM_BY_ID("SELECT * FROM items WHERE id=?"),
		DELETE_ITEM_BY_ID("DELETE FROM items WHERE id=?"),
		ADD_ITEM("INSERT INTO items(name, price) "
				+ "VALUES(?,?)");
		private final String query;

		private SQL(String s) {
			this.query = s;
		}

		public String getQuery() {
			return query;
		}
	}

	List<Item> getAllItems();
	Item getItemById(int id);
	Item addItem(Item i);
	boolean removeItemById(int id) throws SQLException;

}
