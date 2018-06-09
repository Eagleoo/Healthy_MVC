package dao.vo;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonTools {
    public static String createJsonString(String key,Object value){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(key, value);
        return jsonObject.toString();

    }
    public static String createJsonInt(String key,int data){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(key, data);
        return jsonObject.toString();

    }

    public static List<Step> Json_To_StepList(String key,String data) throws JSONException {
        List<Step> list = new ArrayList<>();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,data);
        // 返回json的数组
        JSONArray jsonArray=jsonObject.getJSONArray(key);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            Step step = new Step();
            step.setCurDate(jsonObject2.getString("date"));
            step.setTotalSteps(jsonObject2.getString("step"));
            list.add(step);
        }
        return list;
    }

    public static Plan Json_To_PlanList(String key,String data) throws JSONException {
        Plan plan=new Plan();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,data);
        JSONObject jsonObject1=jsonObject.getJSONObject(key);
        plan.setP_name(jsonObject1.getString("p_name"));
        plan.setP_type(jsonObject1.getString("p_type"));
        plan.setP_select(Integer.valueOf(jsonObject1.getString("p_select")));
        return plan;
    }

    public static Food Json_To_Food(String key, String data) throws JSONException {
        Food food=new Food();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,data);
        JSONObject jsonObject1=jsonObject.getJSONObject(key);
        food.setF_name(jsonObject1.getString("f_name"));
        food.setF_ka(jsonObject1.getString("f_ka"));
        food.setF_type(jsonObject1.getString("f_type"));
        return food;
    }

    public static U_Food Json_To_UFood(String key, String data) throws JSONException {
        U_Food u_food=new U_Food();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,data);
        JSONObject jsonObject1=jsonObject.getJSONObject(key);
        u_food.setU_id(jsonObject1.getInt("u_id"));
        u_food.setF_name(jsonObject1.getString("f_name"));
        u_food.setF_ka(jsonObject1.getString("f_ka"));
        u_food.setF_time(jsonObject1.getString("f_time"));
        u_food.setF_date(jsonObject1.getString("f_date"));
        u_food.setF_ke(jsonObject1.getString("f_ke"));
        return u_food;
    }

    public static U_Food Json_To_UFood1(String key,String data) throws JSONException {
        U_Food u_food=new U_Food();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,data);
        JSONObject jsonObject1=jsonObject.getJSONObject(key);
        u_food.setU_id(jsonObject1.getInt("u_id"));
        u_food.setF_name(jsonObject1.getString("f_name"));
        u_food.setF_time(jsonObject1.getString("f_time"));
        u_food.setF_date(jsonObject1.getString("f_date"));
        return u_food;
    }

    public static StepPlan Json_To_StepPlan(String key,String data) throws JSONException {
        StepPlan stepPlan=new StepPlan();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,data);
        JSONObject jsonObject1=jsonObject.getJSONObject(key);
        stepPlan.setP_steps(jsonObject1.getString("p_steps"));
        stepPlan.setP_km(jsonObject1.getString("p_km"));
        stepPlan.setP_ka(jsonObject1.getString("p_ka"));
        stepPlan.setU_id(jsonObject1.getInt("u_id"));
        return stepPlan;
    }

    public String StepPlan_ToJson(StepPlan stepPlan) throws JSONException {
        if (stepPlan== null) return "";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("p_steps",stepPlan.getP_steps());
        jsonObject.put("p_km",stepPlan.getP_km());
        jsonObject.put("p_ka",stepPlan.getP_ka());
        jsonObject.put("u_id",stepPlan.getU_id());

        return jsonObject.toString();
    }

    public static Plan Json_To_PlanList2(String key,String data) throws JSONException {
        Plan plan=new Plan();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,data);
        JSONObject jsonObject1=jsonObject.getJSONObject(key);
        plan.setP_name(jsonObject1.getString("p_name"));
        plan.setP_select(Integer.valueOf(jsonObject1.getString("p_select")));
        return plan;
    }

    public static String Json_To_String(String key,String data){
        String type_string;
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(key, data);
        JSONObject jsonObject1=jsonObject.getJSONObject(key);
        type_string=jsonObject1.getString("type");
        return type_string;

    }

    public static String String_ToJson(String key,String string) throws JSONException {
        if (string== null) return "";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",string);

        return jsonObject.toString();
    }
}
