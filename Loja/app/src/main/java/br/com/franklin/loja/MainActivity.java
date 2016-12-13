package br.com.franklin.loja;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Button btOk;
    CheckBox cbCsharp, cbAndroid, cbJava;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btOk = (Button) findViewById(R.id.btcomprar);
        cbCsharp = (CheckBox) findViewById(R.id.cb1);
        cbAndroid = (CheckBox) findViewById(R.id.cb2);
        cbJava = (CheckBox) findViewById(R.id.cb3);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mensagem;

                //Caso não selecione livros
                if (!cbAndroid.isChecked() && !cbAndroid.isChecked() && !cbJava.isChecked()){
                    mensagem = "Você não selecioanou livros!: \n\n";
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setMessage(mensagem);
                    alertDialog.show();
                    return;
                }

                mensagem = "Você comprou:\n\n";

                if (cbCsharp.isChecked()){
                    mensagem = mensagem + "CSharp\n";
                }

                if (cbAndroid.isChecked()){
                    mensagem = mensagem + "Android\n";
                }

                if (cbJava.isChecked()){
                    mensagem = mensagem + "Java\n";
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setMessage(mensagem);
                alertDialog.show();

            }
        });

    }
}
