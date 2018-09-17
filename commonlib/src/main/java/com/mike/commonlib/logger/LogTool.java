package com.mike.commonlib.logger;

/**
 *项目名称: com.mike.commonlib.logger
 *类描述:LogTool
 *作者: Mike
 *创建时间: 2018/8/28 18:42
 *邮箱:2468139903@qq.com
 */
public class LogTool implements Log {

    private String tag="PRETTY_LOGGER";
    private static RealLog realLog;

    @Override
    public LogTool setTag(String tag) {
        this.tag=tag;
        return this;
    }

    public LogTool(){
    }

    public LogTool(String tag){
        this.tag=tag;
    }

    public static void init(){
       realLog=new RealLogImpl();
    }

    @Override
    public void v(Object msg) {
      v(tag,msg);
    }

    @Override
    public void v(String tag, Object msg) {
        realLog.log(new SimpleLogAdapterImpl().setTag(tag).setLogLevel(RealLog.VERBOSE),msg);
    }

    @Override
    public void d(Object msg) {
       d(tag,msg);
    }
    @Override
    public void d(String tag,Object msg){
        realLog.log(new SimpleLogAdapterImpl().setTag(tag).setLogLevel(RealLog.DEBUG),msg);
    }

    @Override
    public void i(Object msg) {
       i(tag,msg);
    }

    @Override
    public void i(String tag, Object msg) {
        realLog.log(new SimpleLogAdapterImpl().setTag(tag).setLogLevel(RealLog.INFO),msg);
    }

    @Override
    public void w(Object msg) {
       w(tag,msg);
    }

    @Override
    public void w(String tag, Object msg) {
        realLog.log(new SimpleLogAdapterImpl().setTag(tag).setLogLevel(RealLog.WARN),msg);
    }

    @Override
    public void e( Object msg, Throwable throwable) {
      e(tag,msg,throwable);
    }

    @Override
    public void e(String tag, Object msg, Throwable throwable) {
        realLog.log(new SimpleLogAdapterImpl().setTag(tag).setLogLevel(RealLog.ERROR),msg,throwable);
    }

    @Override
    public void json(String json) {
        realLog.log(new SimpleLogAdapterImpl().setTag(tag).setLogLevel(RealLog.DEBUG).setJson(true),json);
    }

    @Override
    public void xml(String xml) {
        realLog.log(new SimpleLogAdapterImpl().setTag(tag).setLogLevel(RealLog.DEBUG).setXml(true),xml);
    }
}
