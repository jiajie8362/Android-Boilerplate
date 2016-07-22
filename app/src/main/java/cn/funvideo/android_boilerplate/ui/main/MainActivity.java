package cn.funvideo.android_boilerplate.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import java.util.List;

import cn.funvideo.android_boilerplate.R;
import cn.funvideo.android_boilerplate.data.SyncService;
import cn.funvideo.android_boilerplate.data.model.Ribot;
import cn.funvideo.android_boilerplate.data.model.Subject;
import cn.funvideo.android_boilerplate.ui.base.BaseActivity;

@EActivity
public class MainActivity extends BaseActivity implements MainMvpView {

    @Bean
    MainPresenter mainPresenter;
    private RecyclerView recyclerView;
    private RibotsAdapter ribotsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @AfterViews
    public void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ribotsAdapter = new RibotsAdapter();
        recyclerView.setAdapter(ribotsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainPresenter.attachView(this);
        mainPresenter.loadMovides();

        startService(SyncService.getStartIntent(this));
    }

    @Override
    public void showRibots(List<Ribot> ribots) {
        ribotsAdapter.setRibots(ribots);
        ribotsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSubjects(List<Subject> subjects) {
        Log.d("subjects", subjects.toString());
    }

    @Override
    public void showRibotsEmpty() {

    }

    @Override
    public void showError() {

    }
}
