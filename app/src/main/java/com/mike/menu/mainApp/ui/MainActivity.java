package com.mike.menu.mainApp.ui;

import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.mike.commonlib.acmodel.Action;
import com.mike.commonlib.base.BaseActivity;
import com.mike.commonlib.mvp.CreateMvpPresenter;
import com.mike.menu.R;
import com.mike.menu.mainApp.common.Constant;
import com.mike.menu.mainApp.common.bean.MenuList;
import com.mike.menu.mainApp.common.bean.MenuType;
import com.mike.menu.mainApp.common.bean.User;
import com.mike.menu.mainApp.core.MainPresenter;
import com.mike.menu.mainApp.core.MainView;

/**
 * 项目名称: Menu
 * 类描述:MainActivity
 * 作者: Mike
 * 创建时间: 2018/8/30 18:53
 * 邮箱:2468139903@qq.com
 */
@CreateMvpPresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {
    WebView webView;
    @Override
    public void initUI() {
        webView=findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new JsInterface(), "control");

        webView.loadUrl("file:///android_asset/haha.html");
    }

    public class JsInterface {

        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
            log("show toast success");
        }

        public void log(final String msg){
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl("javascript: log(" + "'" + msg + "'" + ")");
                }
            });
        }
    }


    @Override
    public void initData() {
        findViewById(R.id.btnRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMvpPresenter().getMenuList(new Action<MenuList,MenuList.Send>().setAcionUrl(Constant.MENU_LIST));
            }
        });
        findViewById(R.id.btnType).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getMvpPresenter() .getMenuType(new Action<MenuType>().setAcionUrl(Constant.MENU_TYPE));
                getMvpPresenter().register(new User.Send()
                        .setUsername("mike6")
                        .setPassword("111111")
                        .setAge(1).buildAction());
            }
        });
    }

    @Override
    public int getRootViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onGetMenuListSuccess(Action<MenuList,MenuList.Send> action) {
        MenuList list = action.getData();
        log.d(list.allNum);
    }

    @Override
    public void onGetMenuTypeSuccess(Action<MenuType,MenuType.Send> action) {
        MenuType type = action.getData();
        log.d(type.DanNaiDouZhiPin.DanLei);
        log.d(type.flag);
    }

    @Override
    public void onRegisterSuccess(Action<User,User.Send> action) {
        log.d(action.getData().username);
    }

    @Override
    public void onActionError(Action action) {
        super.onActionError(action);
    }
}
