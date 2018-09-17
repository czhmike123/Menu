package com.mike.commonlib.logger;

/**
 * 项目名称: Menu
 * 类描述:RealLog
 * 作者: Mike
 * 创建时间: 2018/8/29 9:52
 * 邮箱:2468139903@qq.com
 */
public interface RealLog {
    int VERBOSE = 2;
    int DEBUG = 3;
    int INFO = 4;
    int WARN = 5;
    int ERROR = 6;
    int ASSERT = 7;

    void log(LogAdapter adapter, Object msg);

    void log(LogAdapter adapter, Object msg, Throwable throwable);
}
