package dao.Dao;

import dao.vo.Food;

import java.util.List;

public interface EatDao {
    List<Food> list_food() throws Exception;
    void add_food(Food food) throws Exception;
}
