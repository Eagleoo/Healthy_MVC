package dao.impl;

import dao.Dao.IMallDAO;
import dao.vo.Address;
import dao.vo.Detail_img;
import dao.vo.Mall;
import dao.vo.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallDAOImpl implements IMallDAO {
    private Connection conn;
    private Mall mall;
    public MallDAOImpl(Connection conn){
        this.conn = conn;
    }
    //按照类型查询商品
    @Override
    public List<Mall> selectmallfortype(String type) throws Exception {
        List<Mall> list=new LinkedList<Mall>();
        String sql ="SELECT *  FROM mall WHERE mall_type= ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,type);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                mall=new Mall();
                mall.setMall_id(rs.getString("mall_id"));
                mall.setMall_name(rs.getString("mall_name"));
                mall.setMall_describe(rs.getString("mall_describe"));
                mall.setMall_price(rs.getString("mall_price"));
                mall.setMall_img(rs.getString("mall_img"));
                mall.setMall_type(rs.getString("mall_type"));
                list.add(mall);
                System.out.println("Mall"+list.get(0).getMall_name());
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
   //查询所有商品
    @Override
    public List<Mall> selectmallall() throws Exception {
        List<Mall> list=new LinkedList<Mall>();
        String sql ="SELECT *  FROM mall";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                mall=new Mall();
                mall.setMall_id(rs.getString("mall_id"));
                mall.setMall_name(rs.getString("mall_name"));
                mall.setMall_describe(rs.getString("mall_describe"));
                mall.setMall_price(rs.getString("mall_price"));
                mall.setMall_img(rs.getString("mall_img"));
                list.add(mall);
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

    @Override
    public List<Mall> selectmallallpage(int mallstart, int mallcount) throws Exception {
        List<Mall> list=new LinkedList<Mall>();
        String sql ="SELECT *  FROM mall limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,mallstart);
        ps.setInt(2,mallcount);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                mall=new Mall();
                mall.setMall_id(rs.getString("mall_id"));
                mall.setMall_name(rs.getString("mall_name"));
                mall.setMall_describe(rs.getString("mall_describe"));
                mall.setMall_price(rs.getString("mall_price"));
                mall.setMall_img(rs.getString("mall_img"));
                list.add(mall);
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
    //    根据商品id查询商品部分信息
    @Override
    public List<Mall> selectmallbyid(String id) throws Exception {
        List<Mall> list=new LinkedList<Mall>();
        String sql ="SELECT *  FROM mall where mall_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                mall=new Mall();
                mall.setMall_name(rs.getString("mall_name"));
                mall.setMall_describe(rs.getString("mall_describe"));
                mall.setMall_price(rs.getString("mall_price"));
                mall.setMall_img(rs.getString("mall_img"));
                list.add(mall);
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
    //查询所有商品名，搜索框
    @Override
    public List<Mall> selectmall_name() throws Exception {
        List<Mall> list=new LinkedList<Mall>();
        String sql ="SELECT mall_name  FROM mall";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                mall=new Mall();
                mall.setMall_name(rs.getString("mall_name"));
                list.add(mall);
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
    //前台添加商品
    @Override
    public void insertmall(String mall_name, String mall_describe, String mall_price, String mall_img, String mall_type) throws Exception {
        String sql ="INSERT INTO mall (mall_name,mall_describe,mall_price,mall_img,mall_type)VALUE (?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,mall_name);
        ps.setString(2,mall_describe);
        ps.setString(3,mall_price);
        ps.setString(4,mall_img);
        ps.setString(5,mall_type);
        ps.executeUpdate();
    }
    //添加商品详情图片
    @Override
    public void insertdetailimg(String img1, String img2, String img3, String img4, String img5, String img6) throws Exception {
        String sql ="INSERT INTO detail_img (img_1,img_2,img_3,img_4,img_5,img_6)VALUE (?,?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,img1);
        ps.setString(2,img2);
        ps.setString(3,img3);
        ps.setString(4,img4);
        ps.setString(5,img5);
        ps.setString(6,img6);
        ps.executeUpdate();
    }
//删除商品
    @Override
    public boolean deletemall(String id) throws Exception {
        String sql="delete from mall where mall_id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,id);
        ps.executeUpdate();
        return true;
    }
//查询收藏的商品
    @Override
    public List<Mall> selectmallforcollect(String username) throws Exception {
        List<Mall> list=new LinkedList<Mall>();
        String sql ="SELECT * FROM mall,mall_collect where username=? and mall.mall_id=mall_collect.mall_id ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            mall=new Mall();
            mall.setMall_id(rs.getString("mall_id"));
            mall.setMall_name(rs.getString("mall_name"));
            mall.setMall_price(rs.getString("mall_price"));
            mall.setMall_img(rs.getString("mall_img"));
            list.add(mall);
        }
        return list;
    }
//查询所有订单
    @Override
    public List<Order> selectallorder() throws Exception {
        List<Order> list=new LinkedList<>();
        String sql="SELECT * FROM mall_order";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Order order=new Order();
            order.setOrder_id(rs.getString("order_id"));
            order.setUsername(rs.getString("username"));
            order.setMall_id(rs.getString("mall_id"));
            order.setOrder_count(rs.getString("order_count"));
            order.setOrder_allprice(rs.getString("order_allprice"));
            order.setConsignee(rs.getString("consignee"));
            order.setCellnumber(rs.getString("cellnumber"));
            order.setAddress(rs.getString("address"));
            order.setIspay(rs.getString("ispay"));
            order.setIssend(rs.getString("issend"));
            order.setIsreceive(rs.getString("isreceive"));
            list.add(order);
        }
        return  list;
    }
//删除订单
    @Override
    public boolean deleteorder(String order_id) throws Exception {
        String sql="delete from mall_order where order_id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,order_id);
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean updateorder(String order_id, String username, String mall_id, String address, String order_count, String allprice, String consignee, String cellnumber, String ispay, String issend, String isreceive) throws Exception {
        String sql="UPDATE mall_order SET username=?,mall_id=?,order_count=?,order_allprice=?,consignee=?,cellnumber=?,address=?,ispay=?,issend=?,isreceive=? WHERE order_id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,mall_id);
        ps.setString(3,order_count);
        ps.setString(4,allprice);
        ps.setString(5,consignee);
        ps.setString(6,cellnumber);
        ps.setString(7,address);
        ps.setString(8,ispay);
        ps.setString(9,issend);
        ps.setString(10,isreceive);
        ps.setString(11,order_id);
        ps.executeUpdate();
        return true;
    }

    //根据id查询详情页面图片
    @Override
    public  List<Detail_img> selectdetailimgbyid(String mall_id) throws Exception {
        List<Detail_img> list=new LinkedList<Detail_img>();
        String sql ="SELECT * FROM detail_img WHERE mall_id= ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,mall_id);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Detail_img detail_img1=new Detail_img();
            detail_img1.setImg_1(rs.getString("img_1"));
            list.add(detail_img1);
            Detail_img detail_img2=new Detail_img();
            detail_img2.setImg_1(rs.getString("img_2"));
            list.add(detail_img2);
            Detail_img detail_img3=new Detail_img();
            detail_img3.setImg_1(rs.getString("img_3"));
            list.add(detail_img3);
            Detail_img detail_img4=new Detail_img();
            detail_img4.setImg_1(rs.getString("img_4"));
            list.add(detail_img4);
            Detail_img detail_img5=new Detail_img();
            detail_img5.setImg_1(rs.getString("img_5"));
            list.add(detail_img5);
            Detail_img detail_img6=new Detail_img();
            detail_img6.setImg_1(rs.getString("img_6"));
            list.add(detail_img6);
            System.out.println();
        }
        return list;
    }
    //添加收藏
    @Override
    public void insertmall_collect(String mall_id, String username) throws Exception {
        String sql ="INSERT INTO mall_collect VALUE (?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,mall_id);
        ps.setString(2,username);
        ps.executeUpdate();
    }
    //取消收藏
    @Override
    public void deletemall_collect(String mall_id, String username) throws Exception {
        String sql ="DELETE FROM mall_collect WHERE mall_id=? AND username=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,mall_id);
        ps.setString(2,username);
        ps.executeUpdate();
    }
    //查询是否收藏
    @Override
    public String selectmall_collect_iscollect(String mall_id, String username) throws Exception {
        String Tag="no";
        String sql ="SELECT * FROM mall_collect WHERE mall_id = ? AND username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,mall_id);
        ps.setString(2,username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs != null) {
                Tag ="yes";
            }
        }
        return Tag;
    }
    //添加订单
    @Override
    public void insertorder(String username, String mall_id, String address, String order_count, String allprice, String consignee,String cellnubmer,String ispay, String issend, String isreceive) throws Exception {
        String sql ="INSERT INTO mall_order(username,mall_id,address,order_count,order_allprice,consignee,cellnumber,ispay,issend,isreceive) VALUE (?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,mall_id);
        ps.setString(3,address);
        ps.setString(4,order_count);
        ps.setString(5,allprice);
        ps.setString(6,consignee);
        ps.setString(7,cellnubmer);
        ps.setString(8,ispay);
        ps.setString(9,issend);
        ps.setString(10,isreceive);
        ps.executeUpdate();
    }
    //查询收货地址
    @Override
    public List<Address> selectaddr(String username) throws Exception {
        List<Address> list=new ArrayList<Address>();
        String sql ="SELECT * FROM user_addr WHERE username=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Address address=new Address();
            address.setConsigneer(rs.getString("consignee"));
            address.setCellnumber(rs.getString("cellnumber"));
            address.setAddress(rs.getString("address"));
            list.add(address);
        }
        return list;
    }

}
