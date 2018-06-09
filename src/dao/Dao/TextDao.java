package dao.Dao;

import dao.vo.Text;
import dao.vo.TextResult;

import java.util.List;

public interface TextDao {
    List<Text> list_text() throws Exception;
    List<TextResult> text_result() throws Exception;

}
