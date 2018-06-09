package dao.Dao;

import dao.vo.Step;

import java.util.List;

public interface StepDao {
    List<Step> list_step() throws Exception;
    void add_step(List<Step> list) throws Exception;
}
