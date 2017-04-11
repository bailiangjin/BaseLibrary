#include "com_kevin_baselibrary_instance_jni_NdkJniUtils.h"
/*
 * Class:     io_github_yanbober_ndkapplication_NdkJniUtils
 * Method:    getCLanguageString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_kevin_baselibrary_instance_jni_NdkJniUtils_getCLanguageString(JNIEnv *env, jobject obj){
    return (*env)->NewStringUTF(env,"This just a test for Android Studio NDK JNI developer!");
}
