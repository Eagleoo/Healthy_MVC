package circle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import circle.model.*;
import circle.util.DBConn;
import dao.dbc.DataBaseConnection;


public class MessageDao {
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet pResultSet = null;
	DataBaseConnection dataBaseConnection=new DataBaseConnection();

	public ArrayList<Message> CheckMessage() {
		ArrayList<Message> list = new ArrayList<Message>();
		try {
			connection= dataBaseConnection.getConn();
			String sql = "select * from message";
			pStatement = connection.prepareStatement(sql);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				Message message = new Message();
				message.setId(pResultSet.getInt("id"));
				message.setTitle(pResultSet.getString("title"));
				message.setContent(pResultSet.getString("content"));
				message.setImag(pResultSet.getString("imag"));
				list.add(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public String SelectContent(int id) {
		String content = null;
		try {
			connection = DBConn.getConnection();
			String sql = "select content from message where id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				content = pResultSet.getString("content");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}

	public void Collect(String username, int consult_id) {
		try {
			connection = DBConn.getConnection();
			String sql = "insert into m_collect(username,consult_id) select ?,?\r\n" +
					"from collect where not EXISTS(select username from collect where username=? and consult_id=?)  ";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setInt(2, consult_id);
			pStatement.setString(3, username);
			pStatement.setInt(4, consult_id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteconllect(String username, int consult_id) {
		try {
			connection = DBConn.getConnection();
			String sql = "delete from m_collect where username=? and consult_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setInt(2, consult_id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean checkconllevt(String username, int consult_id) {
		int id = 0;
		boolean flag = false;
		try {
			connection = DBConn.getConnection();
			String sql = "select id from m_collect where username=? and consult_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setInt(2, consult_id);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				id = pResultSet.getInt("id");
				if (id != 0) {
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

	public ArrayList<Message> SelectConllect(String username) {
		ArrayList<Message> list = new ArrayList<Message>();
		try {
			connection = DBConn.getConnection();
			String sql = "select title,content,imag,message.id from message,m_collect\r\n"
					+ "where m_collect.consult_id=message.id\r\n" + "and username=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				Message message = new Message();
				message.setId(pResultSet.getInt("id"));
				message.setTitle(pResultSet.getString("title"));
				message.setContent(pResultSet.getString("content"));
				message.setImag(pResultSet.getString("imag"));
				list.add(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Message> Search(String title) {
		ArrayList<Message> list=new ArrayList<Message>();
		try {
			connection=DBConn.getConnection();
			String sql="select * from message\r\n" + 
					"where title like '%"+title+"%'";
			pStatement=connection.prepareStatement(sql);
			pResultSet=pStatement.executeQuery();
			while(pResultSet.next())
			{
				Message message=new Message();
				message.setId(pResultSet.getInt("id"));
				message.setImag(pResultSet.getString("imag"));
				message.setContent(pResultSet.getString("content"));
				message.setTitle(pResultSet.getString("title"));
				list.add(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public ArrayList<Message> NewConsult() {
		ArrayList<Message> list=new ArrayList<Message>();
		try {
			connection=DBConn.getConnection();
			String sql="select * from message\r\n" + 
					"where rank=1";
			pStatement=connection.prepareStatement(sql);
			pResultSet=pStatement.executeQuery();
			while(pResultSet.next())
			{
				Message message=new Message();
				message.setId(pResultSet.getInt("id"));
				message.setImag(pResultSet.getString("imag"));
				message.setContent(pResultSet.getString("content"));
				message.setTitle(pResultSet.getString("title"));
				list.add(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public ArrayList<Order> NewMall() {
		ArrayList<Order> list=new ArrayList<Order>();
		try {
			connection=DBConn.getConnection();
			String sql="select * from mall\r\n" + 
					"where rank=1";
			pStatement=connection.prepareStatement(sql);
			pResultSet=pStatement.executeQuery();
			while(pResultSet.next())
			{
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
	public ArrayList<Dynamics> ShowDynamic() {
		ArrayList<Dynamics> list=new ArrayList<Dynamics>();
		try {
			connection=DBConn.getConnection();
			String sql="select * from dynamic";
			pStatement=connection.prepareStatement(sql);
			pResultSet=pStatement.executeQuery();
			while(pResultSet.next())
			{
				Dynamics dynamic=new Dynamics();
				dynamic.setId(pResultSet.getInt("id"));
				dynamic.setDescribe(pResultSet.getString("describle"));
				dynamic.setTitle(pResultSet.getString("title"));
				dynamic.setContent(pResultSet.getString("content"));
				dynamic.setAuthor(pResultSet.getString("author"));
				list.add(dynamic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public ArrayList<Dynamics> NewDynamic() {
		ArrayList<Dynamics> list=new ArrayList<Dynamics>();
		try {
			connection=DBConn.getConnection();
			String sql="select * from dynamic\r\n" + 
					"where rank=1";
			pStatement=connection.prepareStatement(sql);
			pResultSet=pStatement.executeQuery();
			while(pResultSet.next())
			{
				Dynamics dynamic=new Dynamics();
				dynamic.setId(pResultSet.getInt("id"));
				dynamic.setDescribe(pResultSet.getString("describle"));
				dynamic.setTitle(pResultSet.getString("title"));
				dynamic.setContent(pResultSet.getString("content"));
				dynamic.setAuthor(pResultSet.getString("author"));
				list.add(dynamic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public ArrayList<Review> Review(int consult_id) {
		ArrayList<Review> list=new ArrayList<Review>();
		try {
			connection=DBConn.getConnection();
			String sql="select portrait,id,review.username,consult_id,content from `user`,review\r\n" + 
					"where review.username=`user`.user_name and consult_id=?";
			pStatement=connection.prepareStatement(sql);
			pStatement.setInt(1, consult_id);
			pResultSet=pStatement.executeQuery();
			while(pResultSet.next())
			{
				Review review=new Review();
				review.setImag(pResultSet.getString("portrait"));
				review.setId(pResultSet.getInt("id"));
				review.setUsername(pResultSet.getString("username"));
				review.setContent(pResultSet.getString("content"));
				review.setConsult_id(pResultSet.getInt("consult_id"));
				list.add(review);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public void Announce(Review review) {
		try {
			connection=DBConn.getConnection();
			String sql="insert into review(username,consult_id,content) values(?,?,?)";
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, review.getUsername());
			pStatement.setInt(2, review.getConsult_id());
			pStatement.setString(3, review.getContent());
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Responses> CheckResponse(int reviewid) {
		ArrayList<Responses> list=new ArrayList<Responses>();
		try {
			connection=DBConn.getConnection();
			String sql="select * from response where reviewid=?";
			pStatement=connection.prepareStatement(sql);
			pStatement.setInt(1, reviewid);
			pResultSet=pStatement.executeQuery();
			while(pResultSet.next())
			{
				Responses responses=new Responses();
				responses.setId(pResultSet.getInt("id"));
				responses.setUsername(pResultSet.getString("username"));
                responses.setResponsename(pResultSet.getString("responsename"));
                responses.setResponsecon(pResultSet.getString("responsecont"));
                responses.setReviewid(pResultSet.getInt("reviewid"));
                list.add(responses);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	 public void Insertreply(Responses responses) {
		  try {
			connection=DBConn.getConnection();
			String sql="insert into response(username,responsename,responsecont,reviewid) "
					+ "values(?,?,?,?)";
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, responses.getUsername());
			pStatement.setString(2, responses.getResponsename());
			pStatement.setString(3, responses.getResponsecon());
			pStatement.setInt(4,responses.getReviewid());
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 } 
	 public void Deletereply(String responsename,String content,int reviewid) {
		  try {
			connection=DBConn.getConnection();
			String sql="DELETE FROM response where responsename=? and responsecont=? and reviewid=? ";
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, responsename);
			pStatement.setString(2, content);
			pStatement.setInt(3, reviewid);
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 } 
	 public void DeleteReview(String username,String content,int consult_id) {
		  try {
			connection=DBConn.getConnection();
			String sql="DELETE FROM review where username=? and content=? and consult_id=? ";
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setString(2, content);
			pStatement.setInt(3, consult_id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 } 
	
	 public void InsertDynamic(Dynamics dynamics) {
		  try {
			connection=DBConn.getConnection();
			String sql="insert into dynamic(describle,title,content,author) "
					+ "values(?,?,?,?)";
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, dynamics.getDescribe());
			pStatement.setString(2, dynamics.getTitle());
			pStatement.setString(3, dynamics.getContent());
			pStatement.setString(4,dynamics.getAuthor());
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 } 
}
