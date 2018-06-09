package dao.impl;

import dao.Dao.IBannerDAO;
import dao.vo.Banner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BannerDAOImpl implements IBannerDAO {
    private Connection conn;
    private Banner banner;
    public BannerDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Banner> selectbanner() throws Exception {
        List<Banner> list=new ArrayList<Banner>();
        String sql ="SELECT *  FROM  banner";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                banner=new Banner();
                banner.setBanner_img1(rs.getString("banner_img1"));
                banner.setBanner_img2(rs.getString("banner_img2"));
                banner.setBanner_img3(rs.getString("banner_img3"));
                banner.setBanner_img4(rs.getString("banner_img4"));
                banner.setBanner_img5(rs.getString("banner_img5"));
                list.add(banner);
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
        System.out.println(list);
        return list;
    }
}
