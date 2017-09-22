
#include "../../../../../../../Library/Android/sdk/ndk-bundle/sysroot/usr/include/jni.h"

#ifndef _Included_com_czg_fastblur_StackNative
#define _Included_com_czg_fastblur_StackNative

extern "C" {
/*com_czg_fastblur_StackNative
 * Class:     com_czg_fastblur_blur_StackNative
 * Method:    blurPixels
 * Signature: ([IIII)V
 */
JNIEXPORT void JNICALL
        Java_com_czg_fastblur_StackNative_blurPixels
        (JNIEnv
         *, jclass, jintArray, jint, jint, jint);

/*
 * Class:     net_qiujuer_genius_blur_StackNative
 * Method:    blurBitmap
 * Signature: (Landroid/graphics/Bitmap;I)V
 */
JNIEXPORT void JNICALL
        Java_com_czg_fastblur_StackNative_blurBitmap
        (JNIEnv
         *, jclass, jobject, jint);

#ifdef __cplusplus
}
#endif
#endif
