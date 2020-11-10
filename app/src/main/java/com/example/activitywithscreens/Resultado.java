package com.example.activitywithscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    private TextView tvResultado1;
    private TextView tvResultado2;
    private Button btRetornar;
    private Intent intent;
    private String valor1;
    private String valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // associa os componentes visuais
        tvResultado1 = (TextView) findViewById(R.id.txtResultado1);
        tvResultado2 = (TextView) findViewById(R.id.txtResultado2);
        btRetornar = (Button) findViewById(R.id.btVoltar);

        // recebe a intent enviada pela tela principal
        intent = getIntent();

        // obtem o parâmetro enviados pela intent
        valor1 = intent.getStringExtra("valor1");

        // joga o resultado1 para tela
        tvResultado1.setText(valor1);

        SharedPreferences preferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        valor2 = preferences.getString ("valor2", "");

        //joga o resultado1 para tela
        tvResultado2.setText(valor2);

        // clique do botão
        btRetornar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish(); // isso fecha e retorna a Activity que me chamou - o mesmo que o hardbutton "BACK"
            }
        });
    }
}