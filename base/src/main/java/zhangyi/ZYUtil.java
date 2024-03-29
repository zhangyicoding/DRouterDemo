package zhangyi;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

public class ZYUtil {

    public static final String TAG = "zhangyi";

    public static void screenInfo(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        float density = dm.density;
        int densityDpi = dm.densityDpi;
        float sw = width / density;
        e("logScreenInfo", "width: " + width
                + ", height: " + height
                + ", density: " + density
                + ", sw: " + sw
                + ", densityDpi: " + densityDpi);
    }

    public static int statusBarHeight(Context context) {
        int resId =
                context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resId);
    }

    public static void e() {
        e("", "-------------------------------------------------------------------------");
    }

    public static void i(String tag, Object obj) {
        e(tag, obj);
    }

    public static void d(String tag, Object obj) {
        e(tag, obj);
    }

    public static void w(String tag, Object obj) {
        e(tag, obj);
    }

    public static void v(String tag, Object obj) {
        e(tag, obj);
    }

    public static void e(Object obj) {
        e("", obj);
    }

    public static void e(String tag, Object obj) {
        Log.i(TAG, tag + " -> " + obj);
    }
}



