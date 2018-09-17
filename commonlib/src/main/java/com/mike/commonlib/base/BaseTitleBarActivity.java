package com.mike.commonlib.base;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mike.commonlib.R;
import com.mike.commonlib.mvp.BaseMvpPresenter;
import com.mike.commonlib.mvp.BaseMvpView;

/**
 * 项目名称: Menu
 * 类描述:BaseTitleBarActivity
 * 作者: Mike
 * 创建时间: 2018/9/3 18:22
 * 邮箱:2468139903@qq.com
 */
public abstract class BaseTitleBarActivity<V extends BaseMvpView, P extends BaseMvpPresenter<V>> extends BaseActivity<V, P> {
    protected TextView tvLeft;
    protected TextView tvRight;
    protected FrameLayout flContent;
    protected TextView tvTitle;

    @Override
    public int getRootViewLayoutId() {
        return R.layout.activity_base_titlebar;
    }

    public abstract int getContentLayoutId();

    @Override
    protected View inflateRootView(LayoutInflater inflater) {
        View rootView = super.inflateRootView(inflater);
        tvLeft = rootView.findViewById(R.id.tvLeft);
        tvRight = rootView.findViewById(R.id.tvRight);
        tvTitle = rootView.findViewById(R.id.tvTitle);
        flContent = rootView.findViewById(R.id.flContent);
        flContent.removeAllViews();
        flContent.addView(inflater.inflate(getContentLayoutId(), null));
        return rootView;
    }
}
