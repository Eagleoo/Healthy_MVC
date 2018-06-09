package dao.proxy;

import dao.Dao.ISerachDAO;
import dao.dbc.DataBaseConnection;
import dao.impl.SearchDAOImpl;
import dao.vo.Mall_Name;

import java.util.List;

public class SearchDAOImplProxy implements ISerachDAO {
    private DataBaseConnection dbc;
    private SearchDAOImpl searchDAOimpl;
    public SearchDAOImplProxy()
    {
        dbc = new DataBaseConnection();
        searchDAOimpl=new SearchDAOImpl(dbc.getConn());
    }
    @Override
    public List<Mall_Name> selectmallformallname(String mall_name) throws Exception {
        List<Mall_Name> list=searchDAOimpl.selectmallformallname(mall_name);
        dbc.close();
        return list;
    }
}
