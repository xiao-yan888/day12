package com.example.administrator.day12;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView mImg;
    /**
     * 倒计时：3秒
     */
    private TextView mTime;
    /**
     * 跳过
     */
    private TextView mTiaog;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mTime = (TextView) findViewById(R.id.time);
        mTiaog = (TextView) findViewById(R.id.tiaog);
// 定时器
        final Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            int num = 5;

            @Override
            public void run() {
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        num--;
                        mTime.setText("倒计时"+num + "秒");

                        if(num ==0){
                            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(intent);
                            timer.cancel();
                        }
                    }
                });

            }
        };

        /**
         * 第一个参数是任务 延迟---第二个参数是：调度后停留多少事件再执行任务；延迟多少事件执行； 间隔---第三个参数
         * 是以后每隔多少时间调用一次；可以理解为任务时间间隔
         */
        timer.schedule(task, 2000, 1000);


        mTiaog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
