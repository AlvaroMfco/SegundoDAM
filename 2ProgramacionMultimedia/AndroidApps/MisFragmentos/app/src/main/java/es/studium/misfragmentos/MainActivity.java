package es.studium.misfragmentos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAyuda;
    Button btnAcercaDe;
    FragmentManager fm = getSupportFragmentManager();
    Fragment ayuda;
    Fragment acerca;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAyuda = findViewById(R.id.btnAyuda);
        btnAcercaDe = findViewById(R.id.btnAcercaDe);
        btnAyuda.setOnClickListener(this);
        btnAcercaDe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAyuda) {
            ayuda = fm.findFragmentByTag("ayuda");
            if (ayuda == null) {
                //Crear un bundle, que contendrá los datos a pasar
                Bundle datos = new Bundle();
                //Poner todos los datos que se quieran pasar, formato clave:valor
                datos.putLong("id", 123L);
                datos.putInt("edad", 26);
                datos.putString("nombre", "California");
                //crear el fragment
                Fragment fragmento = new Ayuda();
                //Asignarle los datos
                fragmento.setArguments(datos);

                ft = fm.beginTransaction();
                ft.replace(R.id.contenedorFragmento, fragmento, "ayuda");
                ft.commit();
            }
        }
        else{
            acerca = fm.findFragmentByTag("acerca");
            if (acerca == null) {
                ft = fm.beginTransaction();
                ft.replace(R.id.contenedorFragmento, new AcercaDe(), "acerca");
                ft.commit();
            }
        }
    }
}