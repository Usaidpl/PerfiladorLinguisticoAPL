package gt.lea.usaid.perfiladorlinguistico.view.guias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 16/08/2016.
 */
public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] ivGuiaNavegacion;
    String[] tvGuiaNavegacion;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] Textos, int[] Images) {
        this.context = applicationContext;
        this.ivGuiaNavegacion = Images;
        this.tvGuiaNavegacion = Textos;
        inflter = (LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return tvGuiaNavegacion.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.list_guia_navegacion, null);
        TextView textos_flipper = (TextView) view.findViewById(R.id.tvGuiaNavegacion);
        ImageView images_flipper = (ImageView) view.findViewById(R.id.ivGuiaNavegacion);
        textos_flipper.setText(tvGuiaNavegacion[position]);
        images_flipper.setImageResource(ivGuiaNavegacion[position]);
        return view;
    }
}