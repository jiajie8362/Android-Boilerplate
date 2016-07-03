package cn.funvideo.android_boilerplate.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cn.funvideo.android_boilerplate.R;
import cn.funvideo.android_boilerplate.data.model.Ribot;
import cn.funvideo.android_boilerplate.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView {

    private MainPresenter mainPresenter;
    private RecyclerView recyclerView;
    private RibotsAdapter ribotsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
    }

    @Override
    public void showRibots(List<Ribot> ribots) {

    }

    @Override
    public void showRibotsEmpty() {

    }

    @Override
    public void showError() {

    }
}
