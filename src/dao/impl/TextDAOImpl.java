package dao.impl;

import dao.Dao.TextDao;
import dao.vo.Text;
import dao.vo.TextResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TextDAOImpl implements TextDao {
    private Connection conn;

    public TextDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Text> list_text() throws Exception {
        List<Text> list=new ArrayList<Text>();
        String sql ="SELECT t_type,t_id,t_tittle,t_A,t_B,t_C  FROM  text ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        try {
            while (rs.next()) {
                Text text=new Text();
                text.setT_type(rs.getString(1));
                text.setT_id(rs.getInt(2));
                text.setT_tittle(rs.getString(3));
                text.setT_A(rs.getString(4));
                text.setT_B(rs.getString(5));
                text.setT_C(rs.getString(6));
                list.add(text);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<TextResult> text_result() throws Exception {
        List<TextResult> list=new ArrayList<>();
        String sql ="SELECT * FROM text_result ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()){
            TextResult textResult=new TextResult();
            textResult.setT_type(rs.getString(1));
            textResult.setAnswer(rs.getString(2));
            textResult.setResult(rs.getString(3));
            list.add(textResult);
        }
        return list;
    }
}
