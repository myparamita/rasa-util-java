package com.rasa.util.common;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {


    /**
     * 用InputStreamReader方式读取文件到数组
     *
     * @param name
     * @return
     */
    public static ArrayList<String> toArrayByInputStreamReader(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            File file = new File(name);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回数组
        return arrayList;
    }

    public static void main(String[] args) {

        try {

            File directory = new File("");// 参数为空
            String filePath = directory.getCanonicalPath()+"/data/restaurants.json";
            System.out.println(filePath);

            ArrayList<String> arrays=FileUtil.toArrayByInputStreamReader(filePath);
            System.out.println();
        } catch (Exception e) {

        }


    }
}
