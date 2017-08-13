package br.com.franklin.loja

import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox

class MainActivity : AppCompatActivity() {

    lateinit internal var btOk: Button
    lateinit internal var cbCsharp: CheckBox
    lateinit internal var cbAndroid: CheckBox
    lateinit internal var cbJava: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btOk = findViewById(R.id.btcomprar) as Button
        cbCsharp = findViewById(R.id.cb1) as CheckBox
        cbAndroid = findViewById(R.id.cb2) as CheckBox
        cbJava = findViewById(R.id.cb3) as CheckBox

        btOk.setOnClickListener(View.OnClickListener {
            var mensagem: String

            //Caso não selecione livros
            if (!cbAndroid.isChecked && !cbAndroid.isChecked && !cbJava.isChecked) {
                mensagem = "Você não selecioanou livros!: \n\n"
                val alertDialog = AlertDialog.Builder(this@MainActivity)
                alertDialog.setMessage(mensagem)
                alertDialog.show()
                return@OnClickListener
            }

            mensagem = "Você comprou:\n\n"

            if (cbCsharp.isChecked) {
                mensagem = mensagem + "CSharp\n"
            }

            if (cbAndroid.isChecked) {
                mensagem = mensagem + "Android\n"
            }

            if (cbJava.isChecked) {
                mensagem = mensagem + "Java\n"
            }

            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setMessage(mensagem)
            alertDialog.show()
        })

    }
}
