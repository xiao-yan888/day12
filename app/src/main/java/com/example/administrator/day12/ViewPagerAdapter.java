package com.example.administrator.day12;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<Integer> list;
    private Context context;


    public ViewPagerAdapter(List<Integer> list, Context context) {
        super();
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        //设置图片  src 按照比例进行展示图片  Background  全部充满展示
        imageView.setImageResource(list.get(position));
        //拉伸
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
