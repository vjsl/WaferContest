package vjsl.cin.ufpe.br.wafercontest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country>{

    private final Context context;
    private final ArrayList<Country> countries;

    public CountryAdapter(Context context, ArrayList<Country> countries){
        super(context, R.layout.list_line, countries);
        this.context = context;
        this.countries = countries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_line, parent, false);

        TextView countryName = rowView.findViewById(R.id.countryName);
        TextView language = rowView.findViewById(R.id.language);
        TextView currency = rowView.findViewById(R.id.currencies);
        ImageView flag = rowView.findViewById(R.id.flags);

        countryName.setText(countries.get(position).getName());
        language.setText(countries.get(position).getLanguages()[0].getName());
        currency.setText(countries.get(position).getCurrencies()[0].getName());


        return rowView;
    }

}
