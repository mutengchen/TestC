package com.example.testc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.aidlservicedemo.IPay;

/**
 * Date: 2020/4/20
 * Time: 16:31
 * author: cmt
 * desc:
 */
public class AppUserPayActivity extends Activity {
    //定义ipay 接口
    private IPay iPay;
    private Button button;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iPay = IPay.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_ipay_layout);
        button = findViewById(R.id.click);
        initBinder();
        init();
    }
    private void initBinder(){
        Intent intent = new Intent();
        intent.setAction("com.example.aidlservicedemo.IPayService");
        intent.setPackage("com.example.aidlservicedemo");
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }
    private void init(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iPay.pay("海联金汇","200");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
