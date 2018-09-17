package com.mike.commonlib.mvp;

/**
 * 项目名称: Menu
 * 类描述:MvpPresenterFactoryImpl
 * 作者: Mike
 * 创建时间: 2018/8/31 17:15
 * 邮箱:2468139903@qq.com
 */
public class MvpPresenterFactoryImpl<V extends BaseMvpView,P extends BaseMvpPresenter<V>> implements MvpPresenterFactory<V,P> {

    private Class<P> pClass;
    @Override
    public P createMvpPresenter() {
        try {
            return pClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreateMvpPresenter(xx.class)注解");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreateMvpPresenter(xx.class)注解");
        }
    }
    public static <V extends BaseMvpView,P extends BaseMvpPresenter<V>> MvpPresenterFactoryImpl<V ,P> createFactory(Class<?> viewClass){
      CreateMvpPresenter presenter=viewClass.getAnnotation(CreateMvpPresenter.class);
        Class<P> pClass;
        if(presenter==null){
            throw new RuntimeException("未声明@CreateMvpPresenter(xx.class)注解");
        }else{
            pClass= (Class<P>) presenter.value();
            return new MvpPresenterFactoryImpl<>(pClass);
        }
    }

    private MvpPresenterFactoryImpl(Class<P> pClass){
        this.pClass=pClass;
    }
}
