package dao.impl;

import dao.Dao.StepDao;
import dao.vo.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StepDAOImpl implements StepDao {
    private Connection conn;
    public StepDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public List<Step> list_step() throws Exception {
        List<Step> list=new ArrayList<Step>();
        String sql ="SELECT *  FROM  step";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        try {
            while (rs.next()) {
                Step step=new Step();
                step.setCurDate(rs.getString(1));
                step.setTotalSteps(rs.getString(2));
                list.add(step);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return list;

    }

    @Override
    public void add_step(List<Step> list) throws Exception {
        //String sql ="SELECT *  FROM  step";
        String sql_add="insert into step(curDate,totalSteps) values(?,?)";
        //String sql_update="update step set curDate=?,totalSteps=?";
        String sql_delete="delete from step";
        PreparedStatement ps = conn.prepareStatement(sql_add);
        PreparedStatement ps1 = conn.prepareStatement(sql_delete);
        ps1.execute();
        for(int i=0;i<list.size();i++){
            ps.setString(1,list.get(i).getCurDate());
            ps.setString(2,list.get(i).getTotalSteps());
            ps.execute();
        }
        ps.close();

    }


}