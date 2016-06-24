package gt.lea.usaid.perfiladorlinguistico.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gt.lea.usaid.perfiladorlinguistico.R;


/**
 * Created by brimc on 21/04/2016.
 */
public class CreditosAdapter extends RecyclerView.Adapter<CreditosAdapter.Holder> {
    private List<Developer> developerList;
    private Activity contexto;

    public CreditosAdapter(Activity contexto, List<Developer> sesionList) {
        this.contexto = contexto;
        this.developerList = sesionList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_creditos, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Developer dev = developerList.get(position);
        holder.tvNombreDev.setText(dev.getNombre());
        holder.civImagenDev.setImageResource(dev.getFoto());
        holder.position = position;


    }

    @Override
    public int getItemCount() {
        return developerList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView tvNombreDev;
        public CircleImageView civImagenDev;
        public int position;

        public Holder(View item) {
            super(item);
            tvNombreDev = (TextView) item.findViewById(R.id.tvNombreDev);
            civImagenDev = (CircleImageView) item.findViewById(R.id.civImagenDev);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Developer dev = developerList.get(position);
                    Intent iDetalleDev = new Intent(contexto, DetalleDeveloper.class);
                    Bundle canasta = new Bundle();
                    canasta.putString("NombreDev", dev.getNombre());
                    canasta.putString("CarnetDev", dev.getCarnet());
                    canasta.putString("CorreoDev", dev.getCorreo());
                    canasta.putString("TelefonoDev", dev.getTelefono());
                    canasta.putString("TwitterDev", dev.getTwitter());
                    canasta.putInt("ImagenDev", dev.getFoto());
                    iDetalleDev.putExtras(canasta);
                    contexto.startActivity(iDetalleDev);

                }
            });

        }
    }
}
