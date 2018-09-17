package com.mike.commonlib.logger;

/**
 * 项目名称: Menu
 * 类描述:SimpleLogAdapterImpl
 * 作者: Mike
 * 创建时间: 2018/8/29 10:14
 * 邮箱:2468139903@qq.com
 */
public class SimpleLogAdapterImpl implements SimpleLogAdapter {
    private String tag;


    public SimpleLogAdapterImpl setTag(String tag) {
        this.tag = tag;
        return this;
    }

    private int logLevel;

    public SimpleLogAdapterImpl setLogLevel(int logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    private boolean isJson;

    public SimpleLogAdapterImpl setJson(boolean json) {
        isJson = json;
        return this;
    }

    private boolean isXml;

    public SimpleLogAdapterImpl setXml(boolean xml) {
        isXml = xml;
        return this;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public int getLogLevel() {
        return logLevel;
    }

    @Override
    public boolean isJson() {
        return isJson;
    }

    @Override
    public boolean isXml() {
        return isXml;
    }

    @Override
    public boolean isLogable() {
        return true;
    }
}
