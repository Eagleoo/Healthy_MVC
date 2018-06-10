package dao.proxy;

import dao.Dao.IMallDAO;
import dao.dbc.DataBaseConnection;
import dao.impl.MallDAOImpl;
import dao.vo.Address;
import dao.vo.Detail_img;
import dao.vo.Mall;
import dao.vo.Order;

import java.util.List;

public class MallDAOImplProxy implements IMallDAO {
    private DataBaseConnection dbc;
    private MallDAOImpl mallDAOImpl;
    public MallDAOImplProxy(){
        dbc = new DataBaseConnection();
        mallDAOImpl = new MallDAOImpl(dbc.getConn());
    }
    @Override
    public List<Mall> selectmallfortype(String type) throws Exception {
        List<Mall> list=mallDAOImpl.selectmallfortype(type);
        dbc.close();
        return list;
    }

    @Override
    public List<Mall> selectmallall() throws Exception {
        List<Mall> list=mallDAOImpl.selectmallall();
        dbc.close();
        return list;

    }

    @Override
    public List<Mall> selectmallallpage(int mallstart, int mallcount) throws Exception {
        List<Mall> list=mallDAOImpl.selectmallallpage(mallstart,mallcount);
        dbc.close();
        return list;
    }

    @Override
    public List<Mall> selectmallbyid(String id) throws Exception {
        List<Mall> list=mallDAOImpl.selectmallbyid(id);
        dbc.close();
        return list;
    }

    @Override
    public List<Mall> selectmall_name() throws Exception {
        List<Mall> list=mallDAOImpl.selectmall_name();
        dbc.close();
        return list;
    }

    @Override
    public void insertmall(String mall_name, String mall_describe, String mall_price, String mall_img,  String mall_type) throws Exception {
        mallDAOImpl.insertmall(mall_name,mall_describe,mall_price,mall_img,mall_type);
        dbc.close();
    }
    @Override
    public void insertdetailimg( String img1, String img2, String img3, String img4, String img5, String img6) throws Exception {
        mallDAOImpl.insertdetailimg(img1,img2,img3,img4,img5,img6);
        dbc.close();
    }

    @Override
    public boolean deletemall(String id) throws Exception {
        mallDAOImpl.deletemall(id);
        dbc.close();
        return true;
    }

    @Override
    public List<Mall> selectmallforcollect(String username) throws Exception {
        List<Mall>list=mallDAOImpl.selectmallforcollect(username);
        dbc.close();
        return list;
    }

    @Override
    public List<Order> selectallorder() throws Exception {
        List<Order>list=mallDAOImpl.selectallorder();
        dbc.close();
        return list;
    }

    @Override
    public boolean deleteorder(String order_id) throws Exception {
        mallDAOImpl.deleteorder(order_id);
        dbc.close();
        return true;
    }

    @Override
    public boolean updateorder(String order_id, String username, String mall_id, String address, String order_count, String allprice, String consignee, String cellnumber, String ispay, String issend, String isreceive) throws Exception {
        mallDAOImpl.updateorder(order_id,username,mall_id,address,order_count,allprice,consignee,cellnumber,ispay,issend,isreceive);
        dbc.close();
        return true;
    }


    @Override
    public  List<Detail_img> selectdetailimgbyid(String mall_id) throws Exception {
        List<Detail_img> list=mallDAOImpl.selectdetailimgbyid(mall_id);
        dbc.close();
        return list;
    }

    @Override
    public void insertmall_collect(String mall_id, String username) throws Exception {
        mallDAOImpl.insertmall_collect(mall_id,username);
        dbc.close();
    }

    @Override
    public void deletemall_collect(String mall_id, String username) throws Exception {
        mallDAOImpl.deletemall_collect(mall_id,username);
        dbc.close();
    }

    @Override
    public String selectmall_collect_iscollect(String mall_id, String username) throws Exception {
        String Tag=mallDAOImpl.selectmall_collect_iscollect(mall_id,username);
        dbc.close();
        return Tag;
    }

    @Override
    public void insertorder( String username, String mall_id, String address, String order_count, String allprice, String consignee,String cellnubmer,String ispay, String issend, String isreceive) throws Exception {
        mallDAOImpl.insertorder(username,mall_id,address,order_count,allprice,consignee,cellnubmer,ispay,issend,isreceive);
        dbc.close();
    }

    @Override
    public List<Address> selectaddr(String username) throws Exception {
        List<Address> list=mallDAOImpl.selectaddr(username);
        dbc.close();
        return list;
    }



}
