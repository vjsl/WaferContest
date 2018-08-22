package vjsl.cin.ufpe.br.wafercontest;

import android.os.AsyncTask;
import android.widget.Toast;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class HttpService extends AsyncTask<Void, Void, Country[]>{

    /*This class implements a function to get Json from server in a separated thread
     *After convert received Json to Java Class
     */

    @Override
    protected Country[] doInBackground(Void... voids) {
        StringBuilder json = new StringBuilder();
        try{
            URL url = new URL("https://restcountries.eu/rest/v2/all");
            HttpsURLConnection connector = (HttpsURLConnection) url.openConnection();
            connector.setRequestMethod("GET");
            connector.setRequestProperty("Content-type", "application/json");
            connector.setRequestProperty("Accept", "application/json");
            connector.setDoOutput(true);
            connector.setConnectTimeout(3000);
            connector.connect();

            Scanner in = new Scanner(url.openStream());
            while(in.hasNext()){
                json.append(in.next());
            }
            System.out.println("");


        }catch (MalformedURLException e){
            Toast.makeText(null, "Can't connect to the repository", Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Toast.makeText(null, "Cannot open connection to the server", Toast.LENGTH_LONG).show();
        }
        Country[] countries = new Gson().fromJson(json.toString(), Country[].class);

        return countries;
    }
}
