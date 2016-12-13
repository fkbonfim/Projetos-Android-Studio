package br.com.franklin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button btvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btvoltar = (Button) findViewById(R.id.btvoltar);
        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volarPrimeira();
            }
        });

    }


    void volarPrimeira() {
        Intent intent =  new Intent();
        //this. dessa para outra, .class a outra
        intent.setClass(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
