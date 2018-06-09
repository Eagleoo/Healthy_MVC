package dao.impl;

import dao.Dao.EatDao;
import dao.vo.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EatDAOImpl implements EatDao {
    private Connection conn;
    public EatDAOImpl(Connection conn){
        this.conn = conn;
    }


    @Override
    public List<Food> list_food() throws Exception {
        List<Food> list=new ArrayList<Food>();
        String sql ="SELECT f_name,f_ka,f_type  FROM  food";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        try {
            while (rs.next()) {
                Food food=new Food();
                food.setF_name(rs.getString(1));
                food.setF_ka(rs.getString(2));
                food.setF_type(rs.getString(3));
                list.add(food);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        ps.close();

        return list;
    }

    @Override
    public void add_food(Food food) throws Exception {
        String sql_add="insert into food(f_name,f_ka,f_type) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql_add);
        ps.setString(1,food.getF_name());
        ps.setString(2,food.getF_ka());
        ps.setString(3,food.getF_type());

        ps.execute();

        ps.close();
    }
}