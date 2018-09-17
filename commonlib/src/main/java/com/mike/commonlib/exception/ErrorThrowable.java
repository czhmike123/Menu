package com.mike.commonlib.exception;
/**
 *项目名称: com.mike.commonlib.exception
 *类描述:ErrorThrowable
 *作者: Mike
 *创建时间: 2018/9/4 14:02
 *邮箱:2468139903@qq.com
 */
public class ErrorThrowable extends Throwable {

    public int code;

    public String msg;

    public ErrorThrowable(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg:" + msg;
    }
}
