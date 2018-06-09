package dao.Dao;
import dao.vo.Banner;

import java.util.List;

public interface IBannerDAO {
    public List<Banner> selectbanner() throws Exception;
}
