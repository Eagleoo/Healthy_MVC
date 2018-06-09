package dao.proxy;

import dao.Dao.UFoodDao;
import dao.dbc.DataBaseConnection;
import dao.impl.UFoodDAOImpl;
import dao.vo.U_Food;

import java.util.List;

public class UFoodDAOImpllProxy implements UFoodDao {
    private DataBaseConnection dbc;
    private UFoodDAOImpl ufoodDAOImpl;

    public UFoodDAOImpllProxy(){
        dbc = new DataBaseConnection();
        ufoodDAOImpl = new UFoodDAOImpl(dbc.getConn());
    }

    @Override
    public List<U_Food> list_u_food() throws Exception {
        return ufoodDAOImpl.list_u_food();
    }

    @Override
    public void add_u_food(U_Food u_food) throws Exception {
        ufoodDAOImpl.add_u_food(u_food);
    }

    @Override
    public void delete_u_food(U_Food u_food) throws Exception {
        ufoodDAOImpl.delete_u_food(u_food);
    }
}
