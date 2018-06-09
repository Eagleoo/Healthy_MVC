package dao.proxy;

import dao.Dao.EatDao;
import dao.dbc.DataBaseConnection;
import dao.impl.EatDAOImpl;
import dao.vo.Food;

import java.util.List;

public class EatDAOImpllProxy implements EatDao {
    private DataBaseConnection dbc;
    private EatDAOImpl foodDAOImpl;

    public EatDAOImpllProxy(){
        dbc = new DataBaseConnection();
        foodDAOImpl = new EatDAOImpl(dbc.getConn());
    }

    @Override
    public List<Food> list_food() throws Exception {
        List<Food> list= foodDAOImpl.list_food();
        dbc.close();
        return list;
    }

    @Override
    public void add_food(Food food) throws Exception {
        foodDAOImpl.add_food(food);
    }
}
