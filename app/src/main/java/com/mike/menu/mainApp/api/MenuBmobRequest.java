package com.mike.menu.mainApp.api;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;
import com.mike.commonlib.exception.ErrorThrowable;
import com.mike.commonlib.logger.Log;
import com.mike.commonlib.network.NetOption;
import com.mike.commonlib.network.NetResponseListener;
import com.mike.commonlib.network.bmob.BmobRequest;
import com.mike.menu.mainApp.common.Constant;
import com.mike.menu.mainApp.common.bean.User;
import com.mike.menu.mainApp.core.MenuBmobResponse;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 项目名称: Menu
 * 类描述:MenuBmobRequest
 * 作者: Mike
 * 创建时间: 2018/9/14 14:13
 * 邮箱:2468139903@qq.com
 */
public class MenuBmobRequest extends BmobRequest<MenuBmobResponse> {
    protected Log log= Log.Factory.getInstance().setTag(getClass().getSimpleName());

    @Override
    public <D extends BaseData,S extends SendData> void doNetworkRequest(Action<D,S> action, NetOption option, final NetResponseListener<MenuBmobResponse> responseListener) {
        switch (action.getActionUrl()){
            case Constant.REGISTER:
                User.Send send= (User.Send) action.getSendData();
                User.BUser user=new User.BUser();
                user.setUsername(send.username);
                user.setPassword(send.password);
                user.age= send.age;
                user.signUp(new SaveListener<User.BUser>() {
                    @Override
                    public void done(User.BUser bUser, BmobException e) {
                        if(e==null){
                            User user=new User();
                            user.age=bUser.age;
                            user.username=bUser.getUsername();
                            responseListener.onResponseSuccess(new MenuBmobResponse<User>().setData(user));
                        }else{
                            log.d(e.getMessage());
                            responseListener.onResponseError(new ErrorThrowable(e.getErrorCode(),e.getMessage()));
                        }
                    }
                });
                break;
        }
    }
}
