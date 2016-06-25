package gt.lea.usaid.perfiladorlinguistico.view;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gt.lea.usaid.perfiladorlinguistico.R;

public class DetalleDeveloper extends AppCompatActivity implements View.OnClickListener {

    private CoordinatorLayout coordinatorLayout;

    private TextView tvCarnetDev, tvCorreoDev, tvTelefonoDev, tvTwitterDev;
    private ImageView ivDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_developer);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);


        Bundle canastaRecibida = getIntent().getExtras();

        TextView tvNombreDev = (TextView) findViewById(R.id.tvNombreDev);

        tvCarnetDev = (TextView) findViewById(R.id.tvCarnetDev);
        tvCorreoDev = (TextView) findViewById(R.id.tvCorreoDev);
        tvTelefonoDev = (TextView) findViewById(R.id.tvTelefonoDev);
        tvTwitterDev = (TextView) findViewById(R.id.tvTwitter);
        ivDev = (ImageView) findViewById(R.id.ivDev);

        tvNombreDev.setText(canastaRecibida.getString("NombreDev"));
        tvCarnetDev.setText(canastaRecibida.get("CarnetDev").toString());
        tvCorreoDev.setText(canastaRecibida.get("CorreoDev").toString());
        tvTelefonoDev.setText(canastaRecibida.get("TelefonoDev").toString());
        tvTwitterDev.setText(canastaRecibida.get("TwitterDev").toString());
        ivDev.setImageResource(canastaRecibida.getInt("ImagenDev"));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }
}