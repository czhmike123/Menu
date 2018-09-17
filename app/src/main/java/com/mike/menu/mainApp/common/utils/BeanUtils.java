package com.mike.menu.mainApp.common.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.github.promeg.pinyinhelper.Pinyin;
import com.mike.commonlib.logger.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 项目名称: Menu
 * 类描述:BeanUtils
 * 作者: Mike
 * 创建时间: 2018/9/9 10:08
 * 邮箱:2468139903@qq.com
 */
public class BeanUtils {
    static Log log=Log.Factory.getInstance().setTag(BeanUtils.class.getSimpleName());

    public static String readAssertResource(Context context, String strAssertFileName) {
        AssetManager assetManager = context.getAssets();
        String strResponse = "";
        try {
            InputStream ims = assetManager.open(strAssertFileName);
            strResponse = getStringFromInputStream(ims);
            log.d(strResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strResponse;
    }

    private static String getStringFromInputStream(InputStream a_is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(a_is));
            while ((line = br.readLine()) != null) {
                String str="";
                if (line.contains(":")&&line.contains("{")) {
                    String[] strings = line.split(":");
                    String chinese= strings[0].replace("\"","");
                    String pinYin=toPinin(chinese);

                    str= "@SerializedName(\""+chinese+"\")\n public "+pinYin+"  "+pinYin+";"+"\n"+" public class "+pinYin+"{ \n";
                    sb.append(str);
                }

                if(line.contains(":")&&line.contains("[")){
                    String[] strings = line.split(":");
                    String chinese= strings[0].replace("\"","");
                    String pinYin=toPinin(chinese);
                    str= "@SerializedName(\""+chinese+"\")\n public List<String>  "+pinYin+";";
                    sb.append(str);
                }

                if(line.contains("}")){
                    sb.append("}");
                }

            }
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return sb.toString();
    }

    public static String toPinin(String line) {
        String str="";
        char[] chars = line.toCharArray();
        int j=0;
        for (int i = 0; i < chars.length; i++) {
            if (Pinyin.isChinese(chars[i])) {
                String pinyin = Pinyin.toPinyin(chars[i]);
                str=str+headUpcase(pinyin);
            }else{
                str=str+String.valueOf(chars[i]);
            }
        }
        return str;
    }

    public static String headUpcase(String pinYin){
        char[] chars=pinYin.toCharArray();
        String str="";
        for (int i = 0; i <chars.length ; i++) {
            str=str+(i==0?String.valueOf(chars[i]):String.valueOf(chars[i]).toLowerCase());
        }
        return str;
    }
}
