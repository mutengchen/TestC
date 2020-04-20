package com.example.testc;

import android.graphics.Bitmap;

/**
 * Date: 2020/4/16
 * Time: 16:26
 * author: cmt
 * desc:
 */
public class OpenCvUtil {
    static{
        System.loadLibrary("cmt");
    }
    public static native int[] bitmap2Mat(int[] pixels,int w,int h);
    public static native String sayHello();
}
