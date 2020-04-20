package com.example.aidlservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

/**
 * Date: 2020/4/20
 * Time: 16:16
 * author: cmt
 * desc:
 */
public class IPayService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

//    class MyBinder extends IPay.Stub{
//        @Override
//        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
//
//        }
//
//        public void pay(String key,String value){
//            payService(key,value);
//        }
//    }
    public void payService(String key,String value){
        Log.d(TAG, "payService: "+key+"value:"+value);
    }
}
