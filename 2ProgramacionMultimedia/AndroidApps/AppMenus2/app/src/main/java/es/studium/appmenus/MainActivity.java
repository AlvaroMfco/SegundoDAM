package es.studium.appmenus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.mOpen)
        {
            Toast.makeText(this, R.string.mensajeOpen, Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.mSave)
        {
            Toast.makeText(this, R.string.mensajeSave, Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.mSettings)
        {
            Toast.makeText(this, R.string.mensajeSettings, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}