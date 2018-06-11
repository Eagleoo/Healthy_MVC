package circle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import circle.model.User;
import circle.util.DBConn;
import dao.dbc.DataBaseConnection;


public class UserDao {
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet pResultSet = null;
	DataBaseConnection dataBaseConnection=new DataBaseConnection();
	public boolean ClientLogin(String user_name, String user_password) {
		boolean flag = false;
		
		try {
			connection= dataBaseConnection.getConn();
			String sql = "select * from user";
			pStatement = connection.prepareStatement(sql);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				String username = pResultSet.getString("user_name");
				String password = pResultSet.getString("user_password");
				if (username.equals(user_name)) {

					if (password.equals(user_password)) {
						flag = true;
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}
	public boolean CheckUsername(String user_name) {
		boolean check = false;
		
		try {
			connection = DBConn.getConnection();
			String sql = "select * from user where user_name=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user_name);
			pResultSet = pStatement.executeQuery();
			while (pResultSet.next()) {
				String username = pResultSet.getString("user_name");
				
				if (username.equals(user_name)) {
          check=true;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;

	}
	 public void ClientRegister(User user) {
		  try {
			connection=DBConn.getConnection();
			String sql="insert into user values(?,?,?,?,?,?,?,?);";
			pStatement=connection.prepareStatement(sql);
			pStatement.setInt(1, user.getUser_id());
			pStatement.setString(2, user.getUsername());
			pStatement.setString(3, user.getUser_password());
			pStatement.setString(4, user.getSex());
			pStatement.setDouble(5, user.getUser_tall());
			pStatement.setDouble(6, user.getUser_weight());
			pStatement.setInt(7, user.getUser_age());
            pStatement.setString(8, user.getPortrait());
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 } 
	 public void ClientRegisterByname(String user_name,String user_sex,String url) {
		  try {
			connection=DBConn.getConnection();
			String sql="insert into user(user_name,user_sex,portrait) values(?,?,?);";
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, user_name);
			pStatement.setString(2, user_sex);
			pStatement.setString(3, url);
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 }
	
	public User ClientQuery(String user_name) {
		User user = new User();	
		try {
			connection = DBConn.getConnection();
			String sql = "select * from user where user_name=?;";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user_name);
			pResultSet = pStatement.executeQuery();
			if (pResultSet.next()) {
				user.setUser_id(pResultSet.getInt("user_id"));
				user.setUsername(pResultSet.getString("user_name"));
				user.setUser_password(pResultSet.getString("user_password"));
				user.setSex(pResultSet.getString("user_sex"));
				user.setUser_tall(pResultSet.getFloat("user_tall"));
				user.setUser_weight(pResultSet.getFloat("user_weight"));
				user.setUser_age(pResultSet.getInt("user_age"));
				user.setPortrait(pResultSet.getString("portrait"));
					
			} else {
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return user;
	}
	 public void ClientUpdate(User user)
	    {
	    	try
	    	{
	    		connection=DBConn.getConnection();
	    		String sql="update user set user_name=?,"
	    				+ "user_sex=?,user_tall=?,user_weight=?,"
	    				+ "user_age=? where user_id=?";
	    		pStatement=connection.prepareStatement(sql);
	    		pStatement.setString(1, user.getUsername());
	    		pStatement.setString(2, user.getSex());
	    		pStatement.setDouble(3, user.getUser_tall());
	    		pStatement.setDouble(4, user.getUser_weight());
	    		pStatement.setInt(5, user.getUser_age());
	    		pStatement.setInt(6,user.getUser_id() );
	    		pStatement.executeUpdate();
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	 public void UpdatePwd(String password,int id)
	    {
	    	try
	    	{
	    		
	    		connection=DBConn.getConnection();
	    		String sql="update user set user_password=? where user_id=?";
	    		 pStatement=connection.prepareStatement(sql);
	    		 pStatement.setString(1,password);
	    		 pStatement.setInt(2, id);
	    		 pStatement.executeUpdate();
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	 public boolean Checkpwd(int id,String password) {
			boolean flag = false;
			try {
				connection = DBConn.getConnection();
				String sql = "select user_password from user where user_id=?";
				pStatement = connection.prepareStatement(sql);
				pStatement.setInt(1, id);
				pResultSet = pStatement.executeQuery();
				while (pResultSet.next()) {
					String passwords = pResultSet.getString("user_password");
                    if(password.equals(passwords))
                    {
                    	flag=true;
                    }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;

		}
	 public void Update(String url,String username)
	    {
	    	try
	    	{
	    		connection=DBConn.getConnection();
	    		String sql="update user set portrait=? where user_name=?";
	    		pStatement=connection.prepareStatement(sql);
	    		pStatement.setString(1, url);
	    		pStatement.setString(2, username);
	    		pStatement.executeUpdate();
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		public String QueryImage(String user_name) {
			User user=new User();
			String portraits=null;
			try {
				connection = DBConn.getConnection();
				String sql = "select portrait from user where user_name=?;";
				pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, user_name);
				pResultSet = pStatement.executeQuery();
				if (pResultSet.next()) {
				
				portraits=pResultSet.getString("portrait");
						
				} else {
					return null;
				}

			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
			return portraits;
		}
	 }


