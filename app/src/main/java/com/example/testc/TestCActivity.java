package com.example.testc;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.testc.databinding.BitmapToGrayLayoutBinding;

/**
 * Date: 2020/4/15
 * Time: 18:19
 * author: cmt
 * desc:
 */
public class TestCActivity extends Activity implements View.OnClickListener {
    BitmapToGrayLayoutBinding binding;
    private Bitmap bitmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_to_gray_layout);
        binding = DataBindingUtil.setContentView(this,R.layout.bitmap_to_gray_layout);
        showImg();
        binding.pic2gray.setOnClickListener(this);
        binding.gray2pic.setOnClickListener(this);
    }
    private void showImg(){
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.macu);
        binding.pic.setImageBitmap(bitmap);
    }
    private void gray(){
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int[] pixels = new int[w*h];
        bitmap.getPixels(pixels,0,w,0,0,w,h);
        int[] resultData = OpenCvUtil.bitmap2Mat(pixels,w,h);
        Bitmap resultImage = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        resultImage.setPixels(resultData,0,w,0,0,w,h);
        binding.pic.setImageBitmap(resultImage);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pic2gray:
                gray();
                break;
            case R.id.gray2pic:
                showImg();
                break;
        }
    }
}
