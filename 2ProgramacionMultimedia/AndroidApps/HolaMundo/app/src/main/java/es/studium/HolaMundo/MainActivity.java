package es.studium.HolaMundo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG Ciclo", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Aplicación iniciada", Toast.LENGTH_SHORT).show();
        Log.i("TAG Ciclo de Vida", "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG Ciclo de Vida", "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG Ciclo de Vida", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG Ciclo de Cida", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG Ciclo de Vida", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG Ciclo de Vida", "onDestroy()");
    }
}