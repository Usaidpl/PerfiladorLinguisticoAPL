package gt.lea.usaid.perfiladorlinguistico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by programadormd on 12/08/16.
 */
public class Dos extends BaseAdapter{
    private Context context;

    public Dos(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return AdapterFlipper.ITEMS.length;
    }

    @Override
    public Object getItem(int position) {
        return AdapterFlipper.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.guia_pruebas, parent, false);
        }

        ImageView imageFlipper = (ImageView) convertView.findViewById(R.id.ivGuiaNavegacion);
        TextView textFlipper = (TextView) convertView.findViewById(R.id.tvGuiaNavegacion);
        final AdapterFlipper item = (AdapterFlipper) getItem(position);
        imageFlipper.setImageResource(item.getImageFlipper());
        textFlipper.setText(item.getTextFlipper());
        return convertView;
    }
}
