package com.aresix.housingassistant2.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.aresix.housingassistant2.R;

public class RoundImageView extends ImageView {
    private Context context ;
    private int radius = 0 ;
    private int defaultWidth = 0 , defaultHeight = 0 ;
    public RoundImageView(Context context) {
        super(context);
        this.context = context ;
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context ;
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context ;
    }

    /**

     * 获取裁剪后的圆形图片

     * @param radius 半径

     */
    private Bitmap getRoundBitmap (Bitmap bitmap ,int radius) {
        Bitmap squareBitmap;
        int diameter = radius * 2;//直径
        int x = 0, y = 0;
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int squareWidth = 0, squareHeight = 0;
        //以bitmap的短的边的标准，截取一个以bitmap的中心为中心的正方形
        if (bitmapWidth > bitmapHeight) {
            x = bitmapWidth / 2 - bitmapHeight / 2;
            y = 0;
            squareHeight = squareWidth = bitmapHeight;
        } else {
            y = bitmapHeight / 2 - bitmapWidth / 2;
            x = 0;
            squareHeight = squareWidth = bitmapWidth;
        }
        squareBitmap = Bitmap.createBitmap(bitmap, x, y, squareWidth, squareHeight);
        //将squareBitmap缩放成diameter的大小
        squareBitmap = Bitmap.createScaledBitmap(squareBitmap, diameter, diameter, false);
        //新建一个bitmap resultbitmap，大小为squareBitmap的大小
        Bitmap resultbitmap = Bitmap.createBitmap(squareBitmap.getWidth(),
                squareBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultbitmap);
        Paint paint = new Paint();
        //新建一个矩形区域位置为0, 0, squareBitmap.getWidth(),squareBitmap.getHeight()
        Rect rect = new Rect(0, 0, squareBitmap.getWidth(),squareBitmap.getHeight());
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setFilterBitmap(true);//对位图进行滤波处理
        paint.setDither(true);//设置防抖动
        canvas.drawARGB(0, 0, 0, 0);//画背景颜色为透明
        //以（squareBitmap.getWidth() / 2,squareBitmap.getHeight() / 2）为圆心，squareBitmap.getWidth() / 2为半径画圆
        canvas.drawCircle(squareBitmap.getWidth() / 2,
                squareBitmap.getHeight() / 2,
                squareBitmap.getWidth() / 2,
                paint);
        //精髓，因为这句话，canvas原先画的透明背景圆和接下来的squareBitmap重叠部分显示出来
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //在画布中将squareBitmap画出来
        canvas.drawBitmap(squareBitmap, rect, rect, paint);
        bitmap = null ;
        squareBitmap = null;
        //将画布中的内容返回
        return resultbitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //获取图片
        Drawable drawable = getDrawable() ;
        //如果图片为空，直接放返回
        if (drawable == null)
            return;
        //如果控件的宽高其中一个为0，直接返回
        if (getWidth() == 0 || getHeight() == 0)
            return;
        this.measure(0, 0);
        //如果是.9图也无法显示，直接返回
        if(drawable.getClass() == NinePatchDrawable.class)
            return;
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
        //获取控件的宽高
        if (defaultWidth == 0) {
            defaultWidth = getWidth();
        }
        if (defaultHeight == 0) {
            defaultHeight = getHeight();
        }
        //半径的等于宽高中较小的一边的一半
        radius = (defaultHeight > defaultWidth ? defaultWidth :defaultHeight )/2;
        Bitmap roundBitmap = getRoundBitmap(bitmap, radius);
        //以控件的中心为中心画出图片
        canvas.drawBitmap(roundBitmap, defaultWidth / 2 - radius, defaultHeight / 2 - radius, null);
    }

}
