package dao.Dao;

public interface IUserInfoDAO {
   public boolean checkLogin(String username, String password)
           throws Exception;

}

