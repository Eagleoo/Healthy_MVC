package circle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import circle.model.Order;
import circle.util.DBConn;
import dao.dbc.DataBaseConnection;


public class RecieveDao {
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet pResultSet = null;
	DataBaseConnection dataBaseConnection=new DataBaseConnection();
	public ArrayList<Order> SelectOrder(String username) {
		ArrayList<Order> list = new ArrayList<Order>();
		try {

			connection= dataBaseConnection.getConn();
			String sql = "select mall.mall_id, mall_name, " + "mall_describe,mall_price," + "mall_img,mall_detail_img,"
					+ "mall_type,order_id from mall,mall_order " + "where mall.mall_id=mall_order.mall_id and username=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				Order order = new Order();
				order.setOrder_id(pResultSet.getInt("order_id"));
				order.setMall_id(pResultSet.getInt("mall_id"));
				order.setMall_name(pResultSet.getString("mall_name"));
				order.setMall_describe(pResultSet.getString("mall_describe"));
				order.setMall_price(pResultSet.getString("mall_price"));
				order.setMall_img(pResultSet.getString("mall_img"));
				order.setMall_detail_img(pResultSet.getString("mall_detail_img"));
				order.setMall_type(pResultSet.getString("mall_type"));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<Order> isreceive(String username) {
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			connection = DBConn.getConnection();
			String sql = "select mall.mall_id,mall_name,mall_describe,mall_price,mall_img from mall_order,mall where mall.mall_id=mall_order.mall_id and username=? and isreceive='F'";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				Order order = new Order();
				order.setMall_id(pResultSet.getInt("mall_id"));
				order.setMall_name(pResultSet.getString("mall_name"));
				order.setMall_describe(pResultSet.getString("mall_describe"));
				order.setMall_price(pResultSet.getString("mall_price"));
				order.setMall_img(pResultSet.getString("mall_img"));
				list.add(order);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public void ensurereceive(String mall_name) {

		try {
			connection = DBConn.getConnection();
			String sql = "update mall_order set isreceive='T' where mall_id=(select mall_id from mall where mall_name=?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, mall_name);
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Order> checkpayment(String username) {
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			connection = DBConn.getConnection();
			String sql = "select mall_img,mall_name,mall_describe,mall_price from mall,mall_order\r\n"
					+ "where mall.mall_id=mall_order.mall_id and\r\n" + "username=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				Order order = new Order();
				order.setMall_img(pResultSet.getString("mall_img"));
				order.setMall_name(pResultSet.getString("mall_name"));
				order.setMall_describe(pResultSet.getString("mall_describe"));
				order.setMall_price(pResultSet.getString("mall_price"));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Order> issend(String username) {
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			connection = DBConn.getConnection();
			String sql = "select order_id,mall_name,mall_describe,mall_img,mall_price from mall,mall_order\r\n"
					+ "where mall.mall_id=mall_order.mall_id\r\n" + "and issend='F' and username=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				Order order = new Order();
				order.setOrder_id(pResultSet.getInt("order_id"));
				order.setMall_img(pResultSet.getString("mall_img"));
				order.setMall_name(pResultSet.getString("mall_name"));
				order.setMall_describe(pResultSet.getString("mall_describe"));
				order.setMall_price(pResultSet.getString("mall_price"));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Order> ShowOrder(int order_id) {
		ArrayList<Order> list = new ArrayList<Order>();
		try {

			connection = DBConn.getConnection();
			String sql ="select consignee,cellnumber,address from mall_order where order_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, order_id);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				Order order = new Order();
				order.setConsigee(pResultSet.getString("consignee"));
				order.setCellnumber(pResultSet.getString("cellnumber"));
				order.setAddress(pResultSet.getString("address"));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	public boolean checkSend(int order_id) {
		String issend=null;
		boolean flag = false;
		try {
			connection = DBConn.getConnection();
			String sql = "select issend from mall_order where order_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, order_id);
			
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				
				issend=pResultSet.getString("issend");
				if (issend.equals("T")) {
					flag = true;
				} else {
					flag = false;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public void DeleteGoods(int order_id) {
		try {
			connection = DBConn.getConnection();
			String sql = "delete from mall_order where issend='F' and order_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, order_id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
