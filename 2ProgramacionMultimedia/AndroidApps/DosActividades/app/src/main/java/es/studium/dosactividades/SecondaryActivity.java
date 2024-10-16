package es.studium.dosactividades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondaryActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secondary);
        btnVolver = findViewById(R.id.vovlerBoton);
        btnVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        setContentView(R.layout.activity_main);
    }
}