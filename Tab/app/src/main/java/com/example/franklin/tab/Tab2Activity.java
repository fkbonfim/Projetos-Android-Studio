package com.example.franklin.tab;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

public class Tab2Activity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setTextSize(25);
        tv.setGravity(Gravity.CENTER);
        tv.setText("This Is Tab2 Activity");

        setContentView(tv);
    }
}
