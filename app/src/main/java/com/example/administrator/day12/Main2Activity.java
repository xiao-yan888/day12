package com.example.administrator.day12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mPager;
    private RadioButton mButton01;
    private RadioButton mButton02;
    private RadioButton mButton03;
    private RadioButton mButton04;
    private RadioButton mButton05;
    private RadioGroup mGroup;
    private List<Integer> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mPager = (ViewPager) findViewById(R.id.pager);

        mButton01 = (RadioButton) findViewById(R.id.button01);
        mButton02 = (RadioButton) findViewById(R.id.button02);
        mButton03 = (RadioButton) findViewById(R.id.button03);
        mButton04 = (RadioButton) findViewById(R.id.button04);
        mButton05 = (RadioButton) findViewById(R.id.button05);
        mGroup = (RadioGroup) findViewById(R.id.group);

        //添加数据
        list = new ArrayList<Integer>();

        list.add(R.drawable.g2);
        list.add(R.drawable.g3);
        list.add(R.drawable.g4);
        list.add(R.drawable.g5);
        //创建适配器
        ViewPagerAdapter adapter = new ViewPagerAdapter(list, this);
        mPager.setAdapter(adapter);
        //页选中监听
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //选择的页
            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                //当选中第？页时，选择对应的Button
                switch (position) {
                    case 0:
                        mGroup.check(R.id.button01);
                        break;
                    case 1:
                        mGroup.check(R.id.button02);
                        break;
                    case 2:
                        mGroup.check(R.id.button03);
                        break;
                    case 3:
                        mGroup.check(R.id.button04);
                        break;
                    case 4:
                        mGroup.check(R.id.button05);

                       /* TextView textView = new TextView(Main2Activity.this);
                        textView.setText("跳转");*/
                        mPager.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                                startActivity(intent);
                            }
                        });
                        break;

                    default:
                        break;
                }
            }
            //页的偏移量
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                // TODO Auto-generated method stub

            }
            //页的状态
            @Override
            public void onPageScrollStateChanged(int state) {
                // TODO Auto-generated method stub

            }
        });

        //设置点击监听事件  切换页
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                switch (checkedId) {
                    case R.id.button01:
                        mPager.setCurrentItem(0);//默认选择展示的图片
                        break;
                    case R.id.button02:
                        mPager.setCurrentItem(1);//默认选择展示的图片
                        break;
                    case R.id.button03:
                        mPager.setCurrentItem(2);//默认选择展示的图片
                        break;
                    case R.id.button04:
                        mPager.setCurrentItem(3);//默认选择展示的图片
                        break;
                    case R.id.button05:
                        mPager.setCurrentItem(4);//默认选择展示的图片
                        break;


                    default:
                        break;
                }

            }
        });
    }
}
