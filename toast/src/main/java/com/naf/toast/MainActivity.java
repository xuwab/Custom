package com.naf.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private TextView textView2;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text11);
        textView.setOnClickListener(this);
        textView2=(TextView)findViewById(R.id.text22);
        textView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text11:
                ToastUtil.makeText(this,++i+"",ToastUtil.LENGTH_SHORT).show();
                break;
            case R.id.text22:
                ToastUtil.makeText(this,++i+"",ToastUtil.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        ToastUtil.cancelToast();
    }
}
