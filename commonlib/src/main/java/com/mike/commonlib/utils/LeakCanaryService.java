package com.mike.commonlib.utils;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * 项目名称: Menu
 * 类描述:LeakCanaryService
 * 作者: Mike
 * 创建时间: 2018/9/15 14:02
 * 邮箱:2468139903@qq.com
 */
public class LeakCanaryService {
//       if (LeakCanary.isInAnalyzerProcess(application)) {
//        // This process is dedicated to LeakCanary for heap analysis.
//        // You should not init your app in this process.
//        return;
//    }
//        LeakCanary.install(application);
    public static void init (Application application){
        LeakCanary.install(application);
    }

    public static boolean isInAnalyzerProcess(Application application){
        return LeakCanary.isInAnalyzerProcess(application);
    }
}
