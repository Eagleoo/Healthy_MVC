package dao.proxy;

import dao.Dao.IBannerDAO;
import dao.dbc.DataBaseConnection;
import dao.impl.BannerDAOImpl;
import dao.vo.Banner;

import java.util.List;

public class BannerDAOImpllProxy implements IBannerDAO {
    private DataBaseConnection dbc;
    private BannerDAOImpl bannerDAOImpl;
    public BannerDAOImpllProxy(){
        dbc = new DataBaseConnection();
        bannerDAOImpl = new BannerDAOImpl(dbc.getConn());
    }
    @Override
    public List<Banner> selectbanner() throws Exception {
        List<Banner> list= bannerDAOImpl.selectbanner();
        dbc.close();
        return list;
    }
}
