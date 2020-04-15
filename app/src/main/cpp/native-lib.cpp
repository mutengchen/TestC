#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_testc_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testc_JNIUtils_stringFromJNI(JNIEnv *env, jobject thiz) {
    return env -> NewStringUTF("Hello, I'm from jni");
}