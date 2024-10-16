package es.studium.ejemplointentexplicito;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    EditText editTextNumero;
    EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        editTextNumero = findViewById(R.id.editTextNumero);
        editTextNombre = findViewById(R.id.editTextNombre);

        //Recuperar parámetros del Intent
        //Bundle: Conjunto de elementos clave:valor.
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            int numero = extras.getInt("numero");
            String nombre = extras.getString("nombre");
            editTextNombre.setText(nombre);
            editTextNumero.setText(String.valueOf(numero));
        }
    }
}