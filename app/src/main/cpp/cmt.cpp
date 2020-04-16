#include <jni.h>
#include <string>
#include "include/opencv2/opencv.hpp"
#include <iostream>

using namespace cv;
using namespace std;
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testc_JNIUtils_sayHello(JNIEnv *env, jobject thiz) {
    // TODO: implement sayHello()
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_testc_OpenCvUtil_bitmap2Mat(JNIEnv *env, jclass clazz, jintArray buf, jint w,jint h) {
    jint *cbuf;
    jboolean ptfalse = false;
    cbuf = env -> GetIntArrayElements(buf,&ptfalse);
    if(cbuf == NULL){
        return 0;
    }

    Mat imgData(h, w, CV_8UC4, (unsigned char*)cbuf);
    // 注意，Android的Bitmap是ARGB四通道,而不是RGB三通道
    cvtColor(imgData,imgData,CV_BGRA2GRAY);
    cvtColor(imgData,imgData,CV_GRAY2BGRA);

    int size=w * h;
    jintArray result = env->NewIntArray(size);
    env->SetIntArrayRegion(result, 0, size, (jint*)imgData.data);
    env->ReleaseIntArrayElements(buf, cbuf, 0);
    return result;
}