LOCAL_PATH		:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := genius_blur
LOCAL_SRC_FILES := stackblur.c load.c com_czg_fastblur_StackNative.c

LOCAL_LDLIBS    := -lm -llog -ljnigraphics

include $(BUILD_SHARED_LIBRARY)