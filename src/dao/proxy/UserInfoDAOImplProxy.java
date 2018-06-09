package dao.proxy;

import dao.Dao.IUserInfoDAO;
import dao.dbc.DataBaseConnection;
import dao.impl.UserInfoDAOImpl;

public class UserInfoDAOImplProxy implements IUserInfoDAO {
    private DataBaseConnection dbc;
    private UserInfoDAOImpl userInfoDAOImpl;
    public UserInfoDAOImplProxy(){
        dbc = new DataBaseConnection();
        userInfoDAOImpl = new UserInfoDAOImpl(dbc.getConn());
    }
    @Override
    public boolean checkLogin(String username, String password) throws Exception {
        boolean flag = userInfoDAOImpl.checkLogin(username,password);
        dbc.close();
        return flag;
    }
}
