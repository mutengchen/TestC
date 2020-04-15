package com.example.testc;

/**
 * Date: 2020/4/15
 * Time: 16:40
 * author: cmt
 * desc: jniutils工具类
 */
public class JNIUtils {
    static {
        System.loadLibrary("native-lib");
    }
    public native String stringFromJNI();
}
