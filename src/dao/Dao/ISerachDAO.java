package dao.Dao;

import dao.vo.Mall_Name;

import java.util.List;

public interface ISerachDAO {
    public List<Mall_Name> selectmallformallname(String mall_name) throws Exception;
}
