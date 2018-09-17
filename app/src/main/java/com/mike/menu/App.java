package com.mike.menu;

import android.app.Application;

import com.mike.commonlib.logger.LogTool;
import com.mike.commonlib.network.bmob.BmobService;
import com.mike.commonlib.utils.LeakCanaryService;

/**
 * 项目名称: Menu
 * 类描述:App
 * 作者: Mike
 * 创建时间: 2018/8/30 9:28
 * 邮箱:2468139903@qq.com
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanaryService.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanaryService.init(this);
        LogTool.init();
        BmobService.init(this);
    }
}
