package com.bw.day114_mvp_demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bw.day114_mvp_demo3.presenter.Presenter;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends AppCompatActivity implements contract.IView {
    private XBanner xbannerPointId;
    private ListView lv;
    private Presenter presenter;
    private String http = "http://blog.zhaoliang5156.cn/api/news/lawyer.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new Presenter();
        presenter.onAttch(this);
        presenter.onStart(http);
        setContentView(R.layout.activity_main);


        xbannerPointId = findViewById(R.id.xbanner_pointId);
        lv = findViewById(R.id.lv);

    }

    @Override
    public void Success(String json) {
        Gson gson = new Gson();
        StudentBean studentBean = gson.fromJson(json, StudentBean.class);
        final List<StudentBean.BannerdataBean> bannerdata = studentBean.getBannerdata();
        xbannerPointId.setBannerData(bannerdata);
        xbannerPointId.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, final View view, int position) {
                NetUtil.getInstance().doPhoto(bannerdata.get(position).getImageUrl(), new NetUtil.Shared() {
                    @Override
                    public void doGetSuccess(String json) {

                    }

                    @Override
                    public void doGetFiled(String error) {

                    }

                    @Override
                    public void doPhotoSuccess(Bitmap json) {
                        ((ImageView) view).setImageBitmap(json);
                    }

                    @Override
                    public void doPhotoFiled(String error) {

                    }
                });
            }
        });
        List<StudentBean.ListdataBean> listdata = studentBean.getListdata();
        lv.setAdapter(new MyBaseAdapter(MainActivity.this,listdata));
    }

    @Override
    public void Filed(String error) {

    }
}
