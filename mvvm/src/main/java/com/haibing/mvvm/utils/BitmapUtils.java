package com.haibing.mvvm.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description bitmap工具
 * @Author 王小军
 * @CreateTime 2024年07月10日
 **/

public class BitmapUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, BitmapUtils.class.getSimpleName());

    public static Bitmap createTransparentBitmap(int width, int height, int color, int alpha) {
        LogUtils.d(TAG, StringUtils.concat(
                "==>createTransparentBitmap width = ", String.valueOf(width),
                " height = ", String.valueOf(height), " color = ", String.valueOf(color),
                " alpha = ", String.valueOf(alpha)
        ));
        // 创建一个全黑的Bitmap
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        // 创建Canvas，以bitmap为基础
        Canvas canvas = new Canvas(bitmap);
        // 设置半透明的颜色和透明度
        Paint paint = new Paint();
        paint.setColor(color); // 可以设置为任意颜色
        paint.setAlpha(alpha); // 设置透明度，0是完全透明，255是完全不透明
        // 绘制一个全屏的矩形，使用半透明的颜色
        canvas.drawRect(0, 0, width, height, paint);
        return bitmap;
    }
}
