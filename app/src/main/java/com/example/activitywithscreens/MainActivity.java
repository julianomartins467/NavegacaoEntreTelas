package com.example.activitywithscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText edValor1, edValor2;
    private Button btArmazenar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // associação visual
        edValor1 = (EditText) findViewById(R.id.edValor1);
        edValor2 = (EditText) findViewById(R.id.edValor2);
        btArmazenar = (Button) findViewById(R.id.btArmazenar);

        // clique do botão
        btArmazenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // instancia a intenty definindo TelaResultado como "destino"
                intent = new Intent(MainActivity.this, Resultado.class);

                SharedPreferences sharedPref = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                //colocando valor no sharedprefrence
                editor.putString("valor2", edValor2.getText().toString());
                editor.commit();

                // passa o valor via intent para a tela 2
                intent.putExtra("valor1", edValor1.getText().toString());

                // lança a Activity com o intent por parametro
                startActivity(intent);
            }
        });
    }
}