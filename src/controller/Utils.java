package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {

    public static String getPicName(String ip){
        StringBuffer fileName = new StringBuffer();
        String[] arr = ip.split("\\.");
        for (int i=0;i<arr.length;i++){
            StringBuffer sbf = new StringBuffer();
            sbf.append(arr[i]);
            while (sbf.length()<3){
                sbf.insert(0,"0");
            }
            fileName.append(sbf);
        }
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time = simpleDateFormat.format(new Date());
        Random random = new Random();
        StringBuffer randomStr = new StringBuffer();
        while(randomStr.length()<3){
            randomStr.append(random.nextInt(10));
        }
        return fileName.toString()+time+randomStr.toString();
    }
}
