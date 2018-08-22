package vjsl.cin.ufpe.br.wafercontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            Country[] c = new HttpService().execute().get();
            System.out.println(c[1].getName());
            ListView listView = findViewById(R.id.country_listview);
            ArrayList<Country> countries = new ArrayList<>(Arrays.asList(new HttpService().execute().get()));
            ArrayAdapter adapter = new CountryAdapter(this, countries);
            listView.setAdapter(adapter);

        }catch (ExecutionException e){
            System.out.println(e.getLocalizedMessage());
        }catch (InterruptedException e){
            System.out.println(e.getLocalizedMessage());
        }



    }
}
