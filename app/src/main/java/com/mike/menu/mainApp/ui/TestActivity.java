package com.mike.menu.mainApp.ui;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;

import com.mike.menu.R;

/**
 * 项目名称: Menu
 * 类描述:TestActivity
 * 作者: Mike
 * 创建时间: 2018/9/26 10:30
 * 邮箱:2468139903@qq.com
 */
public class TestActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.leak_canary_icon_foreground);
        //Palette用来更漂亮地展示配色
        Palette.from(BitmapFactory.decodeResource(getResources(),R.drawable.leak_canary_notification))
                .generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(@NonNull Palette palette) {
                        int color=palette.getVibrantColor(getResources().getColor(R.color.colorAccent));
                        collapsingToolbarLayout.setContentScrimColor(color);
                        //因为我暂时没有找到比较好的透明状态栏来适配这一套效果布局。
                        //因此就直接替换掉StatusBar的颜色，这样其实也蛮好看的。
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(color);
                        }
                    }
                });
        //CollapsingToolbarLayout
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle("我是一个标题啊哈哈哈");
    }

}
