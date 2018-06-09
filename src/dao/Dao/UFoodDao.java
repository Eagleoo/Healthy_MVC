package dao.Dao;

import dao.vo.U_Food;

import java.util.List;

public interface UFoodDao {
    List<U_Food> list_u_food() throws Exception;
    void add_u_food(U_Food u_food) throws Exception;
    void delete_u_food(U_Food u_food) throws Exception;
}
