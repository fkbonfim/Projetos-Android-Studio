package br.com.franklin.afinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private DBHelper dh;
    Button btInserir, btListar;
    EditText etNome, etEnd, etEmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dh = new DBHelper(this);

        etNome = (EditText) findViewById(R.id.etnome);
        etEnd = (EditText) findViewById(R.id.etcpf);
        etEmp = (EditText) findViewById(R.id.etidade);
        etEmp = (EditText) findViewById(R.id.ettelefone);
        etEmp = (EditText) findViewById(R.id.etemail);


        btInserir = (Button) findViewById(R.id.btinserir);
        btListar = (Button) findViewById(R.id.btlistar);

        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNome.getText().length() > 0 && etEnd.getText().length() > 0 && etEmp.getText().length() > 0) {


                    dh.insert(etNome.getText().toString(), etEnd.getText().toString(), etEmp.getText().toString());

                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Sucesso");
                    adb.setMessage("Cadastro Realizado!");
                    adb.show();

                    etNome.setText("");
                    etEnd.setText("");
                    etEmp.setText("");

                } else {
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Erro");
                    adb.setMessage("Todos os campos devem ser preenchidos");
                    adb.show();

                    etNome.setText("");
                    etEnd.setText("");
                    etEmp.setText("");

                }

            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Contato> contatos = dh.queryGetAll();
                if (contatos == null) {
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Mensagem");
                    adb.setMessage("Não há registros cadastrados");
                    adb.show();

                    return;

                }
                for (int i = 0; i < contatos.size(); i++) {
                    Contato contato = (Contato) contatos.get(i);
                    AlertDialog.Builder adb = new AlertDialog.Builder(Main2Activity.this);
                    adb.setTitle("Regristro nº " + i);
                    adb.setMessage("Nome: " + contato.getNome() + "\nEndereço: " + contato.getEndereco() + "\nEmpresa: " + contato.getEmpresa());
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

    }
}
