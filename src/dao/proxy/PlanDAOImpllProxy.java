package dao.proxy;

import dao.Dao.PlanDao;
import dao.dbc.DataBaseConnection;
import dao.impl.PlanDAOImpl;
import dao.vo.Plan;
import dao.vo.StepPlan;

import java.util.List;

public class PlanDAOImpllProxy implements PlanDao {
    private DataBaseConnection dbc;
    private PlanDAOImpl planDAOImpl;

    public PlanDAOImpllProxy(){
        dbc = new DataBaseConnection();
        planDAOImpl = new PlanDAOImpl(dbc.getConn());
    }
    @Override
    public List<Plan> list_plan() throws Exception {
        List<Plan> list= planDAOImpl.list_plan();
        dbc.close();
        return list;
    }

    @Override
    public void add_plan(Plan plan) throws Exception {
        planDAOImpl.add_plan(plan);
        dbc.close();
    }

    @Override
    public void update_plan(Plan plan) throws Exception {
        planDAOImpl.update_plan(plan);
        dbc.close();
    }

    @Override
    public int count_plan() throws Exception {
        return planDAOImpl.count_plan();

    }

    @Override
    public void add_step_plan(StepPlan stepPlan) throws Exception {
        planDAOImpl.add_step_plan(stepPlan);
        dbc.close();
    }

    @Override
    public StepPlan select_step_plan(int u_id) throws Exception {
        return planDAOImpl.select_step_plan(u_id);
    }
}
