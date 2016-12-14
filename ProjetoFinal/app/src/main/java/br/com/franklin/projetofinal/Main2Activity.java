package br.com.franklin.projetofinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    //
    private DBHelper dh;
    Button btListar, btInserir, btVoltar;
    EditText etNome, etCpf, etIdade, etTelefone, etEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //
        this.dh = new DBHelper(this);

        etNome = (EditText) findViewById(R.id.etnome);
        etCpf = (EditText) findViewById(R.id.etcpf);
        etIdade = (EditText) findViewById(R.id.etidade);
        etTelefone = (EditText) findViewById(R.id.ettelefone);
        etEmail = (EditText) findViewById(R.id.etemail);

        btInserir = (Button) findViewById(R.id.btinserir);
        btListar = (Button) findViewById(R.id.btlistar);
        btVoltar = (Button) findViewById(R.id.btvoltar);

        //
        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                if (etNome.getText().length() > 0 && etCpf.getText().length() > 0 && etIdade.getText().length() > 0
                        && etTelefone.getText().length() > 0 && etEmail.getText().length() > 0) {

                    //
                    dh.insert(etNome.getText().toString(), etCpf.getText().toString(), etIdade.getText().toString(),
                            etTelefone.getText().toString(), etEmail.getText().toString());
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Sucesso");
                    adb.setMessage("Cadastro Realizado!");
                    adb.show();

                    etNome.setText("");
                    etIdade.setText("");
                    etTelefone.setText("");
                    etEmail.setText("");
                    etCpf.setText("");
                    //
                } else {
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Erro");
                    adb.setMessage("Todos os campos devem ser preenchidos");
                    adb.show();

                    etNome.setText("");
                    etIdade.setText("");
                    etTelefone.setText("");
                    etEmail.setText("");
                    etCpf.setText("");

                }

            }
        });

        //
        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                List<Contato> contatos = dh.queryGetAll();
                //
                if (contatos == null) {
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Mensagem");
                    adb.setMessage("Não há registros cadastrados");
                    adb.show();

                    return;

                }
                //
                for (int i = 0; i < contatos.size(); i++) {
                    Contato contato = (Contato) contatos.get(i);
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Regristro nº " + i);
                    //
                    adb.setMessage("Nome: " + contato.getNome() + "\nIdade: " + contato.getCpf() +
                            "\nE-mail: " + contato.getIdade() + "\nCPF: " + contato.getTelefone() +
                            "\nE-mail: " + contato.getEmail());
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    adb.show();

                }

            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
