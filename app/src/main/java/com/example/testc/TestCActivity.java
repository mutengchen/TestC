package com.example.testc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Date: 2020/4/15
 * Time: 18:19
 * author: cmt
 * desc:
 */
public class TestCActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,new JNIUtils().stringFromJNI(),Toast.LENGTH_LONG).show();
    }
}
