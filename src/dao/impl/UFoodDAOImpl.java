package dao.impl;

import dao.Dao.UFoodDao;
import dao.vo.U_Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UFoodDAOImpl implements UFoodDao {
    private Connection conn;
    public UFoodDAOImpl(Connection conn){
        this.conn = conn;
    }


    @Override
    public List<U_Food> list_u_food() throws Exception {
        List<U_Food> list=new ArrayList<U_Food>();
        String sql ="SELECT u_id,f_name,f_ka,f_time,f_date,f_ke FROM user_food";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        try {
            while (rs.next()) {
                U_Food u_food=new U_Food();
                u_food.setU_id(rs.getInt(1));
                u_food.setF_name(rs.getString(2));
                u_food.setF_ka(rs.getString(3));
                u_food.setF_time(rs.getString(4));
                u_food.setF_date(rs.getString(5));
                u_food.setF_ke(rs.getString(6));
                list.add(u_food);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        ps.close();

        return list;
    }

    @Override
    public void add_u_food(U_Food u_food) throws Exception {
        String sql_add="insert into user_food(u_id,f_name,f_ka,f_time,f_date,f_ke) values(?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql_add);
        ps.setInt(1,u_food.getU_id());
        ps.setString(2,u_food.getF_name());
        ps.setString(3,u_food.getF_ka());
        ps.setString(4,u_food.getF_time());
        ps.setString(5,u_food.getF_date());
        ps.setString(6,u_food.getF_ke());

        ps.execute();

        ps.close();
    }

    @Override
    public void delete_u_food(U_Food u_food) throws Exception {
        String sql_del="delete from user_food where u_id=? and f_name=? and f_time=? and f_date=?";
        PreparedStatement ps = conn.prepareStatement(sql_del);
        ps.setInt(1,u_food.getU_id());
        ps.setString(2,u_food.getF_name());
        ps.setString(3,u_food.getF_time());
        ps.setString(4,u_food.getF_date());
        ps.execute();

        ps.close();
    }
}