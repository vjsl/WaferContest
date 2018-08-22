package vjsl.cin.ufpe.br.wafercontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Country[] country = new HttpService().execute().get();
            Toast.makeText(getBaseContext(), country[0].getName(), Toast.LENGTH_LONG).show();
        }catch (ExecutionException e){
            System.out.println(e.getLocalizedMessage());
        }catch (InterruptedException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
