package com.czg.fastblur;

import android.graphics.Bitmap;
import android.graphics.Canvas;


/**
 * Version 2.1.1
 * <p>
 * Date: 16/8/16 11:25
 * Author: zhendong.wu@shoufuyou.com
 * <p>
 * Copyright © 2014-2016 Shanghai Xiaotu Network Technology Co., Ltd.
 */
public class BlurUtils {
    public static final int SCALED_WITH_FILTER = 1;
    public static int scaledType;
    public static Bitmap doBlur( Bitmap src, float scaled, int radius) {
        Bitmap result = null;
        try {
            Bitmap s = getScaledBitmap(src, scaled);
            result= StackBlur.blurNativelyPixels(s, radius, true);
        }catch (Exception e){
                return src;
        }
        return result;
    }
    private static Bitmap getScaledBitmap(Bitmap src, float scaled) {
        switch (scaledType) {
            case SCALED_WITH_FILTER:
                return getScaledBitmapWithFilter(src, scaled);
            default:
                return getScaledBitmapDefault(src, scaled);
        }
    }
    private static Bitmap getScaledBitmapDefault(Bitmap src, float scaled) {
        Bitmap result = Bitmap.createBitmap((int) (src.getWidth() * scaled), (int) (src.getHeight() * scaled), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        canvas.scale(scaled, scaled);
        canvas.drawBitmap(src, 0, 0, null);
        return result;
    }


    private static Bitmap getScaledBitmapWithFilter(Bitmap src, float scaled) {
        return Bitmap.createScaledBitmap(src, (int) (src.getWidth() * scaled), (int) (src.getHeight() * scaled), true);
    }

}
