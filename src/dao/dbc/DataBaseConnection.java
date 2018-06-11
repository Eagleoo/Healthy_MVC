package dao.dbc;

import java.sql.*;

public class DataBaseConnection {
    private static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&autoReconnect=true";
    private static final String DBUSER="root";
    private static final String DBPASSWORD = "123456";

//    //刘泽宇数据库
//    private static final String DBDRIVER="com.mysql.jdbc.Driver";
//    private static final String DBURL="jdbc:mysql://localhost:3306/health?useUnicode=true&characterEncoding=utf-8&useSSL=false";
//    private static final String DBUSER="root";
//    private static final String DBPASSWORD = "123456";
   private static Connection conn;

    public DataBaseConnection(){
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
