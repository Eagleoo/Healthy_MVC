package dao.proxy;

import dao.Dao.TextDao;
import dao.dbc.DataBaseConnection;
import dao.impl.TextDAOImpl;
import dao.vo.Text;
import dao.vo.TextResult;

import java.util.List;

public class TextDAOImpllProxy implements TextDao {
    private DataBaseConnection dbc;
    private TextDAOImpl textDAOImpl;

    public TextDAOImpllProxy(){
        dbc = new DataBaseConnection();
        textDAOImpl = new TextDAOImpl(dbc.getConn());
    }

    @Override
    public List<Text> list_text() throws Exception {
        List<Text> list= textDAOImpl.list_text();
        dbc.close();
        return list;
    }

    @Override
    public List<TextResult> text_result() throws Exception {
        List<TextResult> list=textDAOImpl.text_result();
        return list;
    }
}
