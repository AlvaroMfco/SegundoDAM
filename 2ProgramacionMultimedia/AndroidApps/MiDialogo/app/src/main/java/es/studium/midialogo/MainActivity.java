package es.studium.midialogo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements OnNuevoDialogoListener, View.OnClickListener {

    DlgNombre dlgNombre;
    String[] datosPj = new String[4];
    String frase;
    String nombrePj;
    String sexoPj;
    String razaPj;
    String clasePj;
    ImageButton btnImg;
    Fragment fragmento;
    FragmentTransaction ft;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnImg = findViewById(R.id.btnImg);
        btnImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mostrarDlgNombre();
        ocultarComenzar();
    }

    @Override
    public void mostrarDlgNombre() {
        dlgNombre = new DlgNombre();
        dlgNombre.setCancelable(false);
        dlgNombre.show(getSupportFragmentManager(), getString(R.string.DlgNombre));
    }

    @Override
    public void mostrarDlgSexo() {
        DlgSexo dlgSexo = new DlgSexo();
        dlgSexo.setCancelable(false);
        dlgSexo.show(getSupportFragmentManager(), getString(R.string.DlgSexo));
    }

    @Override
    public void mostrarDlgRaza() {
        DlgRaza dlgRaza = new DlgRaza();
        dlgRaza.setCancelable(false);
        dlgRaza.show(getSupportFragmentManager(), getString(R.string.DlgRaza));
    }

    @Override
    public void mostrarDlgClase() {
        DlgClase dlgClase = new DlgClase();
        dlgClase.setCancelable(false);
        dlgClase.show(getSupportFragmentManager(), getString(R.string.DlgClase));
    }


    @Override
    public void setDatosPj(String dato, int pos){
        datosPj[pos] = dato;
        nombrePj = datosPj[0];
        sexoPj = datosPj[1];
        razaPj = datosPj[2];
        clasePj = datosPj[3];
        frase = sexoPj + "_" + razaPj + "_" + clasePj;
    }

    public void enviarDatos(){
        fragmento = fm.findFragmentByTag(getString(R.string.Fragmento));
        if(fragmento == null){
            Bundle datos = new Bundle();
            datos.putString("nombre", nombrePj);
            datos.putString("frase", frase);
            Fragment fragmento = new Fragmento();
            fragmento.setArguments(datos);

            ft = fm.beginTransaction();
            //Mostrar Fragment
            findViewById(R.id.fragmentContainerView).setVisibility(View.VISIBLE);
            ft.replace(R.id.fragmentContainerView, fragmento);
            ft.commit();
        }
    }

    @Override
    public void ocultarComenzar() {
        btnImg.setVisibility(View.GONE);
    }

    @Override
    public void mostrarComenzar() {
        btnImg.setVisibility(View.VISIBLE);
    }
}

