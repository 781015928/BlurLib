package com.czg.blurSample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.czg.fastblur.BlurUtils;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private Bitmap mBitmap;
    private SeekBar sb_radius;
    private TextView tv_time;
    private ImageView iv_image;
    TextView tv_radius;
    Switch sw_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_image = (ImageView) findViewById(R.id.iv_image);
        sb_radius = (SeekBar) findViewById(R.id.sb_radius);
        tv_radius = (TextView) findViewById(R.id.tv_radius);
        tv_time = (TextView) findViewById(R.id.tv_time);
        sw_image = (Switch) findViewById(R.id.sw_image);
        sb_radius.setOnSeekBarChangeListener(this);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tree);
        sw_image.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sw_image.setText(b ? "大图" : "小图");
                mBitmap = BitmapFactory.decodeResource(getResources(), b ? R.mipmap.tree : R.mipmap.tree_2);
                iv_image.setImageBitmap(mBitmap);
            }
        });
    }

    int radius = 1;

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.sb_radius:
                tv_radius.setText(String.valueOf(i));
                radius = i;
                break;

        }
        long threadTimeMillis = SystemClock.currentThreadTimeMillis();

        Bitmap bitmap = BlurUtils.doBlur(mBitmap, 1, radius);
        iv_image.setImageBitmap(bitmap);
        tv_time.setText(String.valueOf(SystemClock.currentThreadTimeMillis() - threadTimeMillis) + "ms");

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
