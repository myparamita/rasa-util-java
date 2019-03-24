package com.rasa.util.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {

    /**
     * get JSONObject from file
     * @param filePath file path in os
     * @return
     */
    public static JSONObject getJSONObjectFromFile(String filePath){
        try {
            InputStream inputStream=new FileInputStream(filePath);
            String text= IOUtils.toString(inputStream,"utf8");
            JSONObject jsonObject= JSON.parseObject(text);
            return jsonObject;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
