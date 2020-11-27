package com.appmovil.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.appmovil.webservice.WebService.Asynchtask;
import com.appmovil.webservice.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://jsonplaceholder.typicode.com/posts/"
                + bundle.getString("usr")+"/comments",
                datos, MainActivity2.this, MainActivity2.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        EditText txtResult = (EditText) findViewById(R.id.txtResult);
        String lstComment="";
        JSONArray JSONlista =  new JSONArray(result);
        for(int i=0; i< JSONlista.length();i++){
            JSONObject comment=  JSONlista.getJSONObject(i);
            lstComment = lstComment + "\nAsunto:" + comment.getString("name").toString()
                    + "\nEmail: " + comment.getString("email").toString()
                    + "\nComentario: " + comment.getString("body").toString()
            +"\n";

        }

        txtResult.setText("Respuesta WS; \n" +  lstComment);
    }
}