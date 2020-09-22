package com.eric.bottombarlibrary.view;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by eric on 2019/12/8.
 * 邮箱：1944633835@qq.com
 */

public class AppUtil {

    private Context context;

    private AppUtil() {
    }

    public AppUtil(Context context) {
        this.context = context;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 获取屏幕宽
     */
    public int getScreenWidth() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }
    /**
     * 获取屏幕高
     */
    public int getScreenHeight() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }
}
