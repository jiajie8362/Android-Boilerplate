package cn.funvideo.android_boilerplate.ui.main;

import cn.funvideo.android_boilerplate.data.DataManager;
import cn.funvideo.android_boilerplate.ui.base.BasePresenter;
import rx.Subscription;

public class MainPresenter extends BasePresenter<MainMvpView> {
    private final DataManager dataManager;
    private Subscription subscription;

    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadRibots() {
        checkViewAttached();
//        subscription = dataManager.getRibots()
    }
}
