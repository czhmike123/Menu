package com.mike.commonlib.logger;

/**
 *项目名称: com.mike.commonlib.logger
 *类描述:Log
 *作者: Mike
 *创建时间: 2018/8/28 18:41
 *邮箱:2468139903@qq.com
 */
public interface Log {
   void v(Object msg);
   void v(String tag,Object msg);
   void d(Object msg);//调试日志,预先设置过滤tag
   void d(String tag,Object msg);//调试日志,带过滤tag
   void i(Object msg);
   void i(String tag,Object msg);
   void w(Object msg);
   void w(String tag,Object msg);
   void e(Object msg,Throwable throwable);//错误日志,,预先设置过滤tag
   void e(String tag,Object msg,Throwable throwable);//错误日志,带过滤tag
   void json(String json);
   void xml(String xml);
    Log setTag(String tag);

    class Factory {
      public static Log getInstance() {
         return new LogTool();
      }
   }
}
