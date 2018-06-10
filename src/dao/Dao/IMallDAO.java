package dao.Dao;
import dao.vo.*;
import java.util.List;

public interface IMallDAO {

    public List<Mall> selectmallall()throws Exception;
    public List<Mall> selectmallallpage(int mallstart, int mallcount)throws Exception;
    public List<Mall> selectmallbyid(String id)throws Exception;
    public List<Mall> selectmall_name()throws Exception;
    public void insertmall(String mall_name, String mall_describe, String mall_price, String mall_img, String mall_type)throws Exception;
    public List<Detail_img> selectdetailimgbyid(String mall_id)throws Exception;
    public void insertmall_collect(String mall_id, String username)throws Exception;
    public void deletemall_collect(String mall_id, String username)throws Exception;
    public String selectmall_collect_iscollect(String mall_id, String username)throws Exception;
    public void insertorder(String username, String mall_id, String address, String order_count, String allprice, String consignee, String cellnumber, String ispay, String issend, String isreceive)throws Exception;
    public List<Address> selectaddr(String username)throws Exception;
    public void insertdetailimg(String img1, String img2, String img3, String img4, String img5, String img6)throws Exception;
    public boolean deletemall(String id)throws Exception;
    public List<Mall> selectmallforcollect(String username)throws Exception;
    public List<Order> selectallorder()throws Exception;
    public void inserlogistics(String order_id,String l_time,String l_add)throws Exception;
    public boolean deleteorder(String order_id)throws Exception;
    public boolean updateorder(String order_id, String username, String mall_id, String address, String order_count, String allprice, String consignee, String cellnumber, String ispay, String issend, String isreceive)throws Exception;
}
