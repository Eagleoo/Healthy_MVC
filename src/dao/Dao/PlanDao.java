package dao.Dao;

import dao.vo.Plan;
import dao.vo.StepPlan;

import java.util.List;

public interface PlanDao {
    List<Plan> list_plan() throws Exception;
    void add_plan(Plan plan) throws Exception;
    void update_plan(Plan plan) throws Exception;
    int count_plan() throws Exception;
    void add_step_plan(StepPlan stepPlan) throws Exception;
    StepPlan select_step_plan(int u_id) throws Exception;
}
