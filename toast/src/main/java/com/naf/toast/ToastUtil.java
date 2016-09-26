package com.naf.toast;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

/**
 * Created by naf on 2016/9/25.
 */
public class ToastUtil {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    private static View toastView;
    private static Toast toast;
    private static ToastUtil instance=null;
    private static TextView textView;
    private static ImageView imageView;

    private ToastUtil(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        toastView = inflater.inflate(R.layout.toast_view, null);
        textView = (TextView) toastView.findViewById(R.id.toast_text);
        imageView=(ImageView)toastView.findViewById(R.id.toast_img);
        toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    private static ToastUtil getInstance(Context context){
        if(instance==null){
            synchronized (ToastUtil.class){
                if(instance==null)
                    instance=new ToastUtil(context);
            }
        }
        return instance;
    }

    public static ToastUtil makeText(Context context, CharSequence text, int duration) {
        ToastUtil util=getInstance(context);
        if (toast != null) {
            toast.cancel();
        }
        toast = new Toast(context);
        textView.setText(text);
        imageView.setImageResource(R.mipmap.ic_launcher);
        toast.setDuration(duration);
        toast.setGravity(Gravity.BOTTOM,0,180);
        toast.setView(toastView);
        return util;
    }

    public static ToastUtil makeText(Context context, int resId, int duration) {
        ToastUtil util = getInstance(context);
        if (toast != null) {
            toast.cancel();
        }
        toast = new Toast(context);
        toast.setText(resId);
        textView.setText(context.getResources().getString(resId));
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER,0,-120);
        toast.setView(toastView);
        return util;
    }

    public void show(){
        toast.show();
    }
    public static void cancelToast(){
        if(toast!=null){
            toast.cancel();
        }
    }

}
