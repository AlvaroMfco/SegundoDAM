package es.studium.ejemplointentexplicito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.textoEvento);
        texto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.textoEvento){
//            Intent intentMain2 = new Intent(this, MainActivity2.class);
//            intentMain2.putExtra("numero", 26);
//            intentMain2.putExtra("nombre", "Álvaro");
            startActivity(new Intent(this, MainActivity2.class)
                    .putExtra("numero", 26)
                    .putExtra("nombre", "Álvaro"));
        }
    }
}