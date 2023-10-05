package vidovic.postalCode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements AdapterListe.ItemClickInterface {

    private RecyclerView recyclerView;
    private AdapterListe adapterListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poveziKomponente();
        dohvatiPodatke();
    }

    private void dohvatiPodatke() {
        adapterListe = new AdapterListe(this);
        adapterListe.setItemClickInterface(this);
        recyclerView.setAdapter(adapterListe);
        dohvatiRESTosobe();

    }

    private void dohvatiRESTosobe(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Background work here

                try {
                    URL url = new URL("http://api.zippopotam.us/hr/53000");
                    HttpURLConnection httpURLConnection =
                            (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.connect();
                    InputStreamReader inputStreamReader =
                            new InputStreamReader(httpURLConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    Mjesta odgovor = new Gson().fromJson(bufferedReader,Mjesta.class);
                    bufferedReader.close();
                    inputStreamReader.close();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            adapterListe.setPlacesList(odgovor.getPlaces());
                            adapterListe.notifyDataSetChanged();
                        }
                    });


                }catch(Exception e){
                    Log.d("REST exception",e.getMessage());
                    e.printStackTrace();
                    //Toast toast=Toast. makeText(getApplicationContext(),"greska",Toast. LENGTH_SHORT);
                }
            }
        });
    }

    private void poveziKomponente() {
        recyclerView=findViewById(R.id.rvLista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onItemClick(Place place) {
        Intent i = new Intent(this,Detalji.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("place", place);
        i.putExtras(bundle);
        startActivity(i);
    }
}