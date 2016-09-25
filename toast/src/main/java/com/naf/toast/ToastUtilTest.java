package com.naf.toast;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by naf on 2016/9/25.
 */

public class ToastUtilTest {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    private static View toastView;
    //    private WindowManager mWindowManager;
    private static int mDuration;
    //    private final int WHAT=100;
//    private static View oldView;
    private static Toast toast;
    //    private static  CharSequence oldText;
//    private static CharSequence currentText;
    private static ToastUtilTest instance=null;
    private static TextView textView;
    private static ImageView imageView;

    private ToastUtilTest(Context context) {
//        mWindowManager=(WindowManager)context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);

        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        toastView = inflater.inflate(R.layout.toast_view, null);
        textView = (TextView) toastView.findViewById(R.id.toast_text);
        imageView=(ImageView)toastView.findViewById(R.id.toast_img);
        toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    private static ToastUtilTest getInstance(Context context){
        if(instance==null){
            synchronized (ToastUtil.class){
                if(instance==null)
                    instance=new ToastUtilTest(context);
            }
        }
        return instance;
    }

    public static ToastUtilTest makeText(Context context, CharSequence text, int duration) {
        ToastUtilTest util=getInstance(context);
        if (toast != null) {
            toast.cancel();
        }
        toast = new Toast(context);
        mDuration = duration;
//        toast.setText(text);
//        currentText=text;
        textView.setText(text);
        imageView.setImageResource(R.mipmap.ic_launcher);
        toast.setDuration(duration);
        toast.setGravity(Gravity.BOTTOM,0,180);
        toast.setView(toastView);
        return util;
    }

    public static ToastUtilTest makeText(Context context, int resId, int duration) {
        ToastUtilTest util = getInstance(context);
        if (toast != null) {
            toast.cancel();
        }
        toast = new Toast(context);
        mDuration = duration;
        toast.setText(resId);
//        currentText=context.getResources().getString(resId);
        textView.setText(context.getResources().getString(resId));
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER,0,-120);
        toast.setView(toastView);
        return util;
    }

    public void show(){
        toast.show();
//        long time=0;
//        switch (mDuration){
//            case LENGTH_SHORT:
//                time=2000;
//                break;
//            case LENGTH_LONG:
//                time=3500;
//                break;
//            default:
//                time=2000;
//                break;
//        }
//        if(currentText.equals(oldText)&&oldView.getParent()!=null){
//            toastHandler.removeMessages(WHAT);
//            toastView=oldView;
//            oldText=currentText;
//
//            toastHandler.sendEmptyMessageDelayed(WHAT,time);
//            return;
//        }
//        cancelOldAlert();
//        toastHandler.removeMessages(WHAT);
//        WindowManager.LayoutParams params=new WindowManager.LayoutParams();
//        params.width=WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height=WindowManager.LayoutParams.WRAP_CONTENT;
//        params.flags=WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
//                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//        params.format= PixelFormat.TRANSLUCENT;
//        params.windowAnimations=android.R.style.Animation_Toast;
//        params.type=WindowManager.LayoutParams.TYPE_TOAST;
//        params.setTitle("Toast");
//        params.gravity=toast.getGravity();
//        params.y=toast.getYOffset();
//        if(toastView.getParent()==null){
//            mWindowManager.addView(toastView,params);
//        }
//        oldView=toastView;
//        oldText=currentText;
//        toastHandler.sendEmptyMessageDelayed(WHAT, time);
    }
    //
//
//
//    private Handler toastHandler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            cancelOldAlert();
//            int id=msg.what;
//            if(WHAT==id){
//                cancelCurrentAlert();
//            }
//        }
//    };
//
//    private void cancelOldAlert(){
//        if(oldView!=null&&oldView.getParent()!=null){
//            mWindowManager.removeView(oldView);
//        }
//    }
//    public void cancelCurrentAlert(){
//        if(toastView!=null&&toastView.getParent()!=null){
//            mWindowManager.removeView(toastView);
//        }
//    }
    public static void cancelToast(){
        if(toast!=null){
            toast.cancel();
        }
    }
}
