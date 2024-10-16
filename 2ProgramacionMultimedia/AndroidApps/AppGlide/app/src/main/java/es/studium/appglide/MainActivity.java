package es.studium.appglide;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = findViewById(R.id.imageView);
        Glide.with(this)
                .load("https://www.graficosapuntodecruz.com/images/stories/virtuemart/product/Q1657.jpg").into(imagen);
    }
}