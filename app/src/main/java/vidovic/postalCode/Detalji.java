package vidovic.postalCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalji extends AppCompatActivity {

    private TextView tvIme;
    private TextView tvPrezime;
    private Button btnNazad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);
        poveziKomponente();
        definirajDogadaje();
    }

    private void definirajDogadaje() {
        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nazad();
            }
        });
        Intent i = getIntent();
        Place place = (Place) i.getSerializableExtra("place");
        tvIme.setText(place.getLatitude());
        tvPrezime.setText(place.getLongitude());
    }

    private void nazad() {
        finish();
    }

    private void poveziKomponente() {
        tvIme = findViewById(R.id.tvIme);
        tvPrezime=findViewById(R.id.tvPrezime);
        btnNazad = findViewById(R.id.btnNazad);
    }
}