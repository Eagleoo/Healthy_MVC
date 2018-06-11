package circle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import circle.model.Adress;
import circle.util.DBConn;
import dao.dbc.DataBaseConnection;


public class AdressDao {
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet pResultSet = null;
	DataBaseConnection dataBaseConnection=new DataBaseConnection();
	 public void Insertad(Adress adress) {
		  try {
			connection= dataBaseConnection.getConn();
			String sql="insert into address(clientname,sender,clienttel,clientadress) values(?,?,?,?);";
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1,adress.getClientname());
			pStatement.setString(2, adress.getSender());
			pStatement.setString(3, adress.getClienttel());
			pStatement.setString(4, adress.getClientaddress());
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 }
		public ArrayList<Adress> AddressQuery(String clientname) {
			
			ArrayList<Adress> list=new ArrayList<Adress>();
			try {
				
				connection = DBConn.getConnection();
				String sql = "select * from address where clientname=?;";
				pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, clientname);
				pResultSet=pStatement.executeQuery();
				while(pResultSet.next()) {
					Adress adress=new Adress();
					adress.setId(pResultSet.getInt("id"));
					adress.setSender(pResultSet.getString("sender"));
					adress.setClienttel(pResultSet.getString("clienttel"));
					adress.setClientaddress(pResultSet.getString("clientadress"));
					list.add(adress);
				} 
				
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
			return list;
		}
		 public void AddressUpdate(Adress adress)
		    {
		    	try
		    	{
		    	connection=DBConn.getConnection();
		    	String sql="update address set sender=?,clienttel=?,clientadress=? where id=?";
		    	pStatement=connection.prepareStatement(sql);
		    	pStatement.setString(1, adress.getSender());
		    	pStatement.setString(2, adress.getClienttel());
		    	pStatement.setString(3, adress.getClientaddress());
		    	pStatement.setInt(4, adress.getId());
		    	pStatement.executeUpdate();
		    	}catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
		 public int SelectId(Adress adress) {
			 int id=0;
			 try
			 {
				
				 connection=DBConn.getConnection();
				 String sql="select id from address where sender=? and clienttel=? and clientadress=?";
				 pStatement=connection.prepareStatement(sql);
				 pStatement.setString(1, adress.getSender());
				 pStatement.setString(2, adress.getClienttel());
				 pStatement.setString(3, adress.getClientaddress());
				 pResultSet=pStatement.executeQuery();
				while(pResultSet.next())
				{
				 id=pResultSet.getInt("id");
				}
			 }catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			 }
			
			return id;
			
		}
//		 public ArrayList<Adress> SlelectIdByname(String clientname) {
//			 ArrayList<Adress> list=new ArrayList<Adress>();
//			 try {
//				connection=DBConn.getConnection();
//				String sql="select id from address where clientname=?";
//				pStatement=connection.prepareStatement(sql);
//				pStatement.setString(1, clientname);
//				pResultSet=pStatement.executeQuery();
//				while(pResultSet.next())
//				{
//					Adress adress=new Adress();
//					adress.setId(pResultSet.getInt("id"));
//					list.add(adress);
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 
//             return list;			
//		}
public void AddressDelete(int array) {
	try {
		connection=DBConn.getConnection();
		String sql="delete from address where id in(?)";
		pStatement=connection.prepareStatement(sql);
		pStatement.setInt(1, array);
		pStatement.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}
