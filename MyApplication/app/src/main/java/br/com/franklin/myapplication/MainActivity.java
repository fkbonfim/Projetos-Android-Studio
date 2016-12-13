package br.com.franklin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btSegunda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSegunda =  (Button) findViewById(R.id.btSegunda);
        btSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamaSegunda();
            }
        });

    }


    void chamaSegunda(){
        Intent intent = new Intent ();
        //.this onde estou, .class second onde quero ir
        intent.setClass(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

}
