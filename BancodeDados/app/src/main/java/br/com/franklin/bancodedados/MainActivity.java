package br.com.franklin.bancodedados;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBHelper dh;
    Button btInserir, btListar;
    EditText etNome, etEnd, etEmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dh = new DBHelper(this);
        etNome = (EditText) findViewById(R.id.etnome);
        etEnd = (EditText) findViewById(R.id.etendereco);
        etEmp = (EditText) findViewById(R.id.etempresa);

        btInserir = (Button) findViewById(R.id.btinserir);
        btListar = (Button) findViewById(R.id.btlistar);

        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNome.getText().length() > 0 && etEnd.getText().length() > 0 && etEmp.getText().length() > 0) {


                    dh.insert(etNome.getText().toString(), etEnd.getText().toString(), etEmp.getText().toString());

                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("Sucesso");
                    adb.setMessage("Cadastro Realizado!");
                    adb.show();

                    etNome.setText("");
                    etEnd.setText("");
                    etEmp.setText("");

                } else {
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
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
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    adb.setTitle("Mensagem");
                    adb.setMessage("Não há registros cadastrados");
                    adb.show();

                    return;

                }
                for (int i = 0; i < contatos.size(); i++) {
                    Contato contato = (Contato) contatos.get(i);
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
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
