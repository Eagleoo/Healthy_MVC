package dao.impl;

import dao.Dao.PlanDao;
import dao.vo.Plan;
import dao.vo.StepPlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanDAOImpl implements PlanDao {
    private Connection conn;
    public PlanDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public List<Plan> list_plan() throws Exception {
        List<Plan> list=new ArrayList<Plan>();
        String sql ="SELECT p_name,p_select,p_type  FROM  plan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        try {
            while (rs.next()) {
                Plan plan=new Plan();
                plan.setP_name(rs.getString(1));
                plan.setP_select(rs.getInt(2));
                plan.setP_type(rs.getString(3));
                list.add(plan);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public void add_plan(Plan plan) throws Exception {
        //String sql ="SELECT *  FROM  step";
        String sql_add="insert into plan(p_name,p_type,p_select) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql_add);
        ps.setString(1,plan.getP_name());
        ps.setString(2,plan.getP_type());
        ps.setInt(3,plan.getP_select());

        ps.execute();

        ps.close();
    }

    @Override
    public void update_plan(Plan plan) throws Exception {
        String sql_update="update plan set p_select=? where p_name=?";
        PreparedStatement ps = conn.prepareStatement(sql_update);
        ps.setString(1,Integer.valueOf(plan.getP_select()).toString());
        ps.setString(2,plan.getP_name());
        ps.execute();

    }

    @Override
    public int count_plan() throws Exception {
        String sql_count="select count(*) from plan WHERE p_select=1";
        PreparedStatement ps = conn.prepareStatement(sql_count);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        int count=0;
        try {
            while (rs.next()) {
                count=rs.getInt(1);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void add_step_plan(StepPlan stepPlan) throws Exception {

        Boolean flag=true;
        String sql_add="insert into step_plan(p_step,p_km,p_ka,u_id) values(?,?,?,?)";
        String sql_select="select u_id from step_plan";

        PreparedStatement ps1 = conn.prepareStatement(sql_select);
        ps1.execute();
        ResultSet rs = ps1.getResultSet();
        while (rs.next()){
            int temp=rs.getInt("u_id");
            if(temp==stepPlan.getU_id()){
                flag=false;
                String sql_update="update step_plan set p_step=?,p_km=?,p_ka=? where u_id=?";
                PreparedStatement ps2 = conn.prepareStatement(sql_update);
                ps2.setString(1,stepPlan.getP_steps());
                ps2.setString(2,stepPlan.getP_km());
                ps2.setString(3,stepPlan.getP_ka());
                ps2.setInt(4,stepPlan.getU_id());
                ps2.execute();
            }
        }
        if(flag){
            PreparedStatement ps = conn.prepareStatement(sql_add);
            ps.setString(1,stepPlan.getP_steps());
            ps.setString(2,stepPlan.getP_km());
            ps.setString(3,stepPlan.getP_ka());
            ps.setInt(4,stepPlan.getU_id());
            ps.execute();

            ps.close();
        }

    }



    @Override
    public StepPlan select_step_plan(int u_id) throws Exception {
        StepPlan stepPlan=new StepPlan();
        String sql ="SELECT p_step,p_km,p_ka,u_id FROM step_plan where u_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,u_id);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()){
            try {
                stepPlan.setP_steps(rs.getString(1));
                stepPlan.setP_km(rs.getString(2));
                stepPlan.setP_ka(rs.getString(3));
                stepPlan.setU_id(rs.getInt(4));
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return stepPlan;
    }
}
