package es.studium.ejercicio2;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.text.InputType;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnBoton = findViewById(R.id.button2);
        btnBoton.setOnClickListener(this);
        texto = findViewById(R.id.editTextTextPassword2);


    }

    @Override
    public void onClick(View view) {
        String palabra = texto.getText().toString();
        if(palabra.isBlank()){
            if(palabra.isBlank() & texto.getInputType() == InputType.TYPE_NUMBER_VARIATION_PASSWORD){
                texto.setInputType(InputType.TYPE_CLASS_TEXT);
            }
            else {
                texto.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
            }

            Toast.makeText(MainActivity.this, R.string.mensajeError, Toast.LENGTH_LONG).show();
            texto.requestFocus();

        }
        else {
            texto.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            Toast.makeText(MainActivity.this, texto.getText(), Toast.LENGTH_LONG).show();
        }
    }
}