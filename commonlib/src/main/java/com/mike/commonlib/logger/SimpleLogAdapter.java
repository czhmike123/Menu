package com.mike.commonlib.logger;
/**
 *项目名称: com.mike.commonlib.logger
 *类描述:SimpleLogAdapter
 *作者: Mike
 *创建时间: 2018/8/28 18:42
 *邮箱:2468139903@qq.com
 */
public interface SimpleLogAdapter extends LogAdapter {
    String getTag();
    int getLogLevel();
    boolean isJson();
    boolean isXml();
}
