package com.mike.menu.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 项目名称: Menu
 * 类描述:AlarmReceiver
 * 作者: Mike
 * 创建时间: 2018/8/30 10:04
 * 邮箱:2468139903@qq.com
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, AlarmBuyService.class));
    }
}
