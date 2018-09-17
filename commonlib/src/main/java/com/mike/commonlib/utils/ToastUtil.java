package com.mike.commonlib.utils;

import android.content.Context;
import android.widget.Toast;
/**
 *项目名称: com.mike.commonlib.utils
 *类描述:ToastUtil
 *作者: Mike
 *创建时间: 2018/8/30 11:19
 *邮箱:2468139903@qq.com
 */
public class ToastUtil {
    private static Toast sToast;

    public static void showToast(Context context, String msg) {
        showToast(context,msg, Toast.LENGTH_SHORT);
    }
    public static void showToast(Context context, int resouceId) {
        if(context==null){
            return;
        }
        showToast(context,context.getString(resouceId), Toast.LENGTH_SHORT);
    }
    public static void showLongToast(Context context, String msg) {
        showToast(context,msg, Toast.LENGTH_LONG);
    }
    public static void showLongToast(Context context, int resouceId) {
        if(context==null){
            return;
        }
        showToast(context,context.getString(resouceId), Toast.LENGTH_LONG);
    }
    public static void showToast(Context context, String msg, int duration ) {
        if(msg == null || msg.trim().length() == 0) {
            return;
        }
        if (sToast == null) {
            sToast = Toast.makeText(context.getApplicationContext(), msg, duration);
            sToast.show();
        } else {
            sToast.setText(msg);
            sToast.setDuration(duration);
            sToast.show();
        }
    }

    public static void cancelToast() {
        if (sToast != null) {
            sToast.cancel();
            sToast=null;
        }
    }
}
