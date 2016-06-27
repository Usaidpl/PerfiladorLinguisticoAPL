package gt.lea.usaid.perfiladorlinguistico.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 24/06/16.
 */
public class Creditos extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    Toolbar toolbar;
    private List<Developer> developers, asesores, instructores;
    private CreditosAdapter creditosAdapter;
    private ArrayList<Developer> developers1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditos);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Creditos");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        iniciar();
    }

    private void iniciar() {
        developers =   new ArrayList<>();
        asesores = new ArrayList<>();
        instructores = new ArrayList<>();

        developers.add(new Developer("Roberto Ramos", "2013-039152", "robertoramos784@gmail.com", "42569138", "@", R.mipmap.develop));
        developers.add(new Developer("Bryan Juarez", "2013-039152", "btyanjuarez@gmail.com", "42285013", "@", R.mipmap.develop));
        developers.add(new Developer("Fernando Alcantara", "2013-039152", "fernandoalcantara@gmail.com", "40794142", "@", R.mipmap.develop));


        instructores.add(new Developer("Manuel Doño", "", "mdono@intecap.edu.gt", "", "", R.mipmap.dev_manuel_dono));


        RecyclerView rvDevs = (RecyclerView) findViewById(R.id.gvDevs);

        RecyclerView rvInstructores = (RecyclerView) findViewById(R.id.rvInstructores);

        //rvDevs.setHasFixedSize(true);
        rvDevs.setLayoutManager(new GridLayoutManager(this, 3));
        rvDevs.setAdapter(new CreditosAdapter(this, developers));



        rvInstructores.setHasFixedSize(true);
        rvInstructores.setLayoutManager(new GridLayoutManager(this, 3));
        rvInstructores.setAdapter(new CreditosAdapter(this, instructores));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Developer dev = developers.get(position);
        Intent iDetalleDev = new Intent(Creditos.this, DetalleDeveloper.class);
        Bundle canasta = new Bundle();
        canasta.putString("NombreDev", dev.getNombre());
        canasta.putString("CarnetDev", dev.getCarnet());
        canasta.putString("CorreoDev", dev.getCorreo());
        canasta.putString("TelefonoDev", dev.getTelefono());
        canasta.putString("TwitterDev", dev.getTwitter());
        canasta.putInt("ImagenDev", dev.getFoto());
        iDetalleDev.putExtras(canasta);
        startActivity(iDetalleDev);
    }
}
