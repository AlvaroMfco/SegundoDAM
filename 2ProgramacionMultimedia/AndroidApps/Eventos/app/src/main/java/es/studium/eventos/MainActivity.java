package es.studium.eventos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBoton = findViewById(R.id.button);
        btnBoton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Me pulsaste...", Toast.LENGTH_SHORT).show();
    }
}