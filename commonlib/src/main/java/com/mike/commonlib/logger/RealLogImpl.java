package com.mike.commonlib.logger;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.mike.commonlib.json.JsonService;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogcatLogStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.Collection;

/**
 * 项目名称: Menu
 * 类描述:RealLogImpl
 * 作者: Mike
 * 创建时间: 2018/8/29 9:53
 * 邮箱:2468139903@qq.com
 */
public class RealLogImpl implements RealLog {
    public RealLogImpl(){
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(2)         // (Optional) How many method line to show. Default 2
                .methodOffset(3)        // (Optional) Hides internal method calls up to offset. Default 5
                .logStrategy(new LogcatLogStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("PRETTY_LOGGER")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    @Override
    public void log(LogAdapter adapter, Object msg) {
       log(adapter,msg,null);
    }
    @Override
    public void log(LogAdapter adapter, Object msg, Throwable throwable) {
        if(adapter!=null&&adapter instanceof SimpleLogAdapter&&adapter.isLogable()){
            SimpleLogAdapter  simpleLogAdapter= (SimpleLogAdapter) adapter;
            String tag=simpleLogAdapter.getTag();
            if(msg==null){
                Logger.t(tag).d("msg is null");
                return;
            }
            if(VERBOSE==simpleLogAdapter.getLogLevel()){
               Logger.t(tag).v(msg instanceof String?(String)msg:msg.toString());
            }else if(DEBUG==simpleLogAdapter.getLogLevel()){
                if(simpleLogAdapter.isJson()){
                    Logger.t(tag).json((String)msg);
                }else if(simpleLogAdapter.isXml()){
                    Logger.t(tag).xml((String)msg);
                }else{
                    Logger.t(tag).d(msg);
                }
            }else if(INFO==simpleLogAdapter.getLogLevel()){
                Logger.t(tag).i(msg instanceof String?(String)msg:msg.toString());
            }else if(WARN==simpleLogAdapter.getLogLevel()){
                Logger.t(tag).w(msg instanceof String?(String)msg:msg.toString());
            }else if(ERROR==simpleLogAdapter.getLogLevel()){
                if(throwable==null){
                    Logger.t(tag).e(msg instanceof String?(String)msg:msg.toString());
                }else{
                    Logger.t(tag).e(throwable,msg instanceof String?(String)msg:msg.toString());
                }
            }
        }
    }

}
