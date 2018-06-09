package dao.impl;

import dao.Dao.ISerachDAO;
import dao.vo.Mall_Name;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class SearchDAOImpl implements ISerachDAO {
    private Connection conn;
    private Mall_Name mallName;
    public SearchDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public List<Mall_Name> selectmallformallname(String mall_name) throws Exception {
        List<Mall_Name> list=new LinkedList<Mall_Name>();
        String sql ="SELECT mall_name FROM  mall WHERE  mall_name LIKE '%' ? '%' ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,mall_name);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                mallName=new Mall_Name();
                mallName.setMall_name(rs.getString("mall_name"));
                list.add(mallName);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return list;
    }
}
