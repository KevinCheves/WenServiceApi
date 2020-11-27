package com.appmovil.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnEnviar(View view)
    {
        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        EditText txtId = (EditText) findViewById(R.id.txtId);
        //Creamos la información a pasar entre actividades - Pares Key-Value
        Bundle b = new Bundle();
       b.putString("usr", txtId.getText().toString());

        //Añadimos la información al intent
        intent.putExtras(b);
        // Iniciamos la nueva actividad
        if(txtId.length()>0)
        {
            startActivity(intent);
        }else{
           Snackbar.make(view,"llene todos los campos",Snackbar.LENGTH_SHORT).show();
        }
    }
}