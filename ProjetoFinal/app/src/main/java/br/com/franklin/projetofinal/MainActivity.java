/*
*Universidade federal de Goiàs - Goiás
*Disciplina: M4DADM
*Programação de computadores e Dispositivos Móveis
* Aluno: Franklin Silva de Castro Bonfim
* */

package br.com.franklin.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrar = (Button) findViewById(R.id.btcadastrar);


        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);


            }
        });





    }
}
