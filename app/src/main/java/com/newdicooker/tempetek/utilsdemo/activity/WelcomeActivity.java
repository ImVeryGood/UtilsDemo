package com.newdicooker.tempetek.utilsdemo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.newdicooker.tempetek.utilsdemo.R;
import com.newdicooker.tempetek.utilsdemo.base.BaseActivity;
import com.zhengsr.viewpagerlib.bean.PageBean;
import com.zhengsr.viewpagerlib.callback.PageHelperListener;
import com.zhengsr.viewpagerlib.indicator.ZoomIndicator;
import com.zhengsr.viewpagerlib.view.GlideViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.go_into)
    Button goInto;
    @BindView(R.id.glid_view_pager)
    GlideViewPager glidViewPager;
    @BindView(R.id.zoom_indicator)
    ZoomIndicator zoomIndicator;
    private List<Integer> images;

    @Override
    protected int getLayoutId() {
        return R.layout.welcome_activity;
    }

    @Override
    public void initView() {
        setSplash();
    }

    @Override
    public void setData() {


    }

    @Override
    public void setSplash() {
        super.setSplash();
        images = new ArrayList<>();
        images.add(R.mipmap.guide1);
        images.add(R.mipmap.guide2);
        images.add(R.mipmap.guide3);
        images.add(R.mipmap.guide4);
        PageBean bean = new PageBean.Builder<Integer>()
                .setDataObjects(images)
                .setIndicator(zoomIndicator)
                .setOpenView(goInto)
                .builder();
        glidViewPager.setPageListener(bean, R.layout.image_layout, new PageHelperListener<Integer>() {
            @Override
            public void getItemView(View view, Integer o) {
                //通过获取到这个view，你可以随意定制你的内容
                ImageView imageView = view.findViewById(R.id.icon);
                imageView.setImageResource(o);
            }
        });
    }

    @OnClick(R.id.go_into)
    public void onViewClicked() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
    }

}
