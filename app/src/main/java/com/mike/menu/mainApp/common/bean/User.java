package com.mike.menu.mainApp.common.bean;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.acmodel.BaseData;
import com.mike.commonlib.acmodel.SendData;
import com.mike.menu.mainApp.common.Constant;

import cn.bmob.v3.BmobUser;


/**
 * 项目名称: Menu
 * 类描述:User
 * 作者: Mike
 * 创建时间: 2018/9/14 15:38
 * 邮箱:2468139903@qq.com
 */
public class User implements BaseData {
    public String username;
    public String password;
    public String nickName;//昵称
    public int age;
    public static class BUser extends BmobUser{
        public int age;
        public String nikcname;
    }
    public static class Send implements SendData {
        public String username;

        public String getUsername() {
            return username;
        }

        public Send setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public Send setPassword(String password) {
            this.password = password;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Send setAge(int age) {
            this.age = age;
            return this;
        }

        public String password;
        public int age;

        public Action<User,User.Send> buildAction(){
            return new Action<User,User.Send>().setAcionUrl(Constant.REGISTER).sendData(this);
        }
    }
}
