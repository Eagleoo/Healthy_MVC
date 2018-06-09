package dao.impl;

import dao.Dao.IUserInfoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInfoDAOImpl implements IUserInfoDAO {
    private Connection conn;
    public UserInfoDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public boolean checkLogin(String username, String password) throws Exception {
        boolean flag = false;
        String sql ="SELECT * FROM user" +
                " WHERE username=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            flag = true;
        }
        ps.close();
        return flag;
    }
}
