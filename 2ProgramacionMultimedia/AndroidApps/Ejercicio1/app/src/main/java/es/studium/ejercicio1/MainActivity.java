package es.studium.ejercicio1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnBoton;
    EditText texto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBoton = findViewById(R.id.button);
        btnBoton.setOnClickListener(this);
        texto = findViewById(R.id.editTextText);
    }

    @Override
    public void onClick(View view) {
        String palabra = texto.getText().toString();
        if(palabra.isBlank()){
            Toast.makeText(MainActivity.this, R.string.mensajeError, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, texto.getText(), Toast.LENGTH_LONG).show();
        }
    }
}