package dao.proxy;

import dao.Dao.StepDao;
import dao.dbc.DataBaseConnection;
import dao.impl.StepDAOImpl;
import dao.vo.Step;

import java.util.List;

public class StepDAOImpllProxy implements StepDao {
    private DataBaseConnection dbc;
    private StepDAOImpl stepDAOImpl;

    public StepDAOImpllProxy(){
        dbc = new DataBaseConnection();
        stepDAOImpl = new StepDAOImpl(dbc.getConn());
    }
    @Override
    public List<Step> list_step() throws Exception {
        List<Step> list= stepDAOImpl.list_step();
        dbc.close();
        return list;
    }

    @Override
    public void add_step(List<Step> list) throws Exception {
        stepDAOImpl.add_step(list);
        dbc.close();

    }

}
