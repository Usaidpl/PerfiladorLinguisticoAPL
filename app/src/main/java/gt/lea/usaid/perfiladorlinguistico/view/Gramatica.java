package gt.lea.usaid.perfiladorlinguistico.view;

/**
 * Created by Roberto on 19/06/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.NavigationMenu;
import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class Gramatica extends Activity implements View.OnClickListener, OnInitializeComponent {
    Toolbar toolbar;
    private ViewFlipper vf;
    private TextView tvPelota, tvPelotas, tvLapices, tvLapiz, tvAbuelo, tvMaestra, tvDoctora, tvChef;
    private RadioButton SiPelota, NoPelota, SiPelotas, NoPelotas, SiLapices, NoLapices, SiLapiz, NoLapiz, SiAbuelo, NoAbuelo, SiMaestra, NoMaestra, SiDoctora, NoDoctora, SiChef, NoChef;
    private Switch SwPelota, SwPelotas, SwLapiz, SwLapices, SwAbuelo, SwMaestra, SwDoctora, SwChef;
    private int[] dr = {R.mipmap.book};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gramatica);
        initToolBar();
        setOnInit(null);

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.gramatica);
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Gramatica.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
                        Intent navigation_menu = new Intent(getApplication(),NavigationMenu.class );
                        startActivity(navigation_menu);

                    }
                }
        );
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiPelota:
                vf.showNext();
                break;
            case R.id.NoPelota:
                vf.showNext();
                break;
            case R.id.SiPelotas:
                vf.showNext();
                break;
            case R.id.NoPelotas:
                vf.showNext();
                break;
            case R.id.SiLapices:
                vf.showNext();
                break;
            case R.id.NoLapices:
                vf.showNext();
                break;
            case R.id.SiLapiz:
                vf.showNext();
                break;
            case R.id.NoLapiz:
                vf.showNext();
                break;
            case R.id.SiAbuelo:
                vf.showNext();
                break;
            case R.id.NoAbuelo:
                vf.showNext();
                break;
            case R.id.SiMaestra:
                vf.showNext();
                break;
            case R.id.NoMaestra:
                vf.showNext();
                break;
            case R.id.SiDoctora:
                vf.showNext();
                break;
            case R.id.NoDoctora:
                vf.showNext();
                break;
            case R.id.SiChef:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent expresionoral = new Intent(getApplication(), ExpresionOral.class);
                startActivity(expresionoral);
                break;
            case R.id.NoChef:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast1.show();
                Intent expresionoral2 = new Intent(getApplication(), ExpresionOral.class);
                startActivity(expresionoral2);
                break;
            default:
                break;
        }

    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        vf = (ViewFlipper) findViewById(R.id.viewflipper);
        vf.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        vf.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));
        adapter ad = new adapter(this, dr);
        for (int i = 0; i < dr.length; i++) {
            vf.addView(ad.getView(i, null, null));
        }


        SiPelota = (RadioButton) findViewById(R.id.SiPelota);
        NoPelota = (RadioButton) findViewById(R.id.NoPelota);
        SiPelotas = (RadioButton) findViewById(R.id.SiPelotas);
        NoPelotas = (RadioButton) findViewById(R.id.NoPelotas);
        SiLapices = (RadioButton) findViewById(R.id.SiLapices);
        NoLapices = (RadioButton) findViewById(R.id.NoLapices);
        SiLapiz = (RadioButton) findViewById(R.id.SiLapiz);
        NoLapiz = (RadioButton) findViewById(R.id.NoLapiz);
        SiAbuelo = (RadioButton) findViewById(R.id.SiAbuelo);
        NoAbuelo = (RadioButton) findViewById(R.id.NoAbuelo);
        SiMaestra = (RadioButton) findViewById(R.id.SiMaestra);
        NoMaestra = (RadioButton) findViewById(R.id.NoMaestra);
        SiDoctora = (RadioButton) findViewById(R.id.SiDoctora);
        NoDoctora = (RadioButton) findViewById(R.id.NoDoctora);
        SiChef = (RadioButton) findViewById(R.id.SiChef);
        NoChef = (RadioButton) findViewById(R.id.NoChef);

        SwPelota = (Switch) findViewById(R.id.swPelota);
        tvPelota = (TextView) findViewById(R.id.tvPelota);
        SwPelotas = (Switch) findViewById(R.id.swPelotas);
        tvPelotas = (TextView) findViewById(R.id.tvPelotas);
        SwLapices = (Switch) findViewById(R.id.swLapices);
        tvLapices = (TextView) findViewById(R.id.tvLapices);
        SwLapiz = (Switch) findViewById(R.id.swLapiz);
        tvLapiz = (TextView) findViewById(R.id.tvLapiz);
        SwAbuelo = (Switch) findViewById(R.id.swAbuelo);
        tvAbuelo = (TextView) findViewById(R.id.tvAbuelo);
        SwMaestra = (Switch) findViewById(R.id.swMaestra);
        tvMaestra = (TextView) findViewById(R.id.tvMaestra);
        SwDoctora = (Switch) findViewById(R.id.swDoctora);
        tvDoctora = (TextView) findViewById(R.id.tvDoctora);
        SwChef = (Switch) findViewById(R.id.swChef);
        tvChef = (TextView) findViewById(R.id.tvChef);

        SiPelota.setOnClickListener(this);
        NoPelota.setOnClickListener(this);
        SiPelotas.setOnClickListener(this);
        NoPelotas.setOnClickListener(this);
        SiLapices.setOnClickListener(this);
        NoLapices.setOnClickListener(this);
        SiLapiz.setOnClickListener(this);
        NoLapiz.setOnClickListener(this);
        SiAbuelo.setOnClickListener(this);
        NoAbuelo.setOnClickListener(this);
        SiMaestra.setOnClickListener(this);
        NoMaestra.setOnClickListener(this);
        SiDoctora.setOnClickListener(this);
        NoDoctora.setOnClickListener(this);
        SiChef.setOnClickListener(this);
        NoChef.setOnClickListener(this);
        swPrincipal();
    }

    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            pelota();
            pelotas();
            lapices();
            lapiz();
            abuelo();
            maestra();
            doctora();
            chef();


        }

        private void pelota(){
            if(SwPelota.isChecked())
                tvPelota.setText("Pelota");
            else
                tvPelota.setText("");
        }
        private void pelotas(){
            if(SwPelotas.isChecked())
                tvPelotas.setText("Pelotas");
            else
                tvPelotas.setText(" ");
        }
        private void lapices(){
            if(SwLapices.isChecked())
                tvLapices.setText("Lapices");
            else
                tvLapices.setText(" ");
        }
        private void lapiz(){
            if(SwLapiz.isChecked())
                tvLapiz.setText("Lapiz");
            else
                tvLapiz.setText("");
        }
        private void abuelo(){
            if(SwAbuelo.isChecked())
                tvAbuelo.setText("Abuelo");
            else
                tvAbuelo.setText("Esta es una Abuela, \nsi fuera hombre ¿cómo se diría?");
        }
        private void maestra(){
            if(SwMaestra.isChecked())
                tvMaestra.setText("Maestra");
            else
                tvMaestra.setText(" ");
        }
        private void doctora(){
            if(SwDoctora.isChecked())
                tvDoctora.setText("Doctora");
            else
                tvDoctora.setText(" ");
        }
        private void chef(){
            if(SwChef.isChecked())
                tvChef.setText("Chef / Cocinera");
            else
                tvChef.setText(" ");
        }


    };

    private void swPrincipal(){
        SwLapices.setOnCheckedChangeListener(list);
        SwPelota.setOnCheckedChangeListener(list);
        SwPelotas.setOnCheckedChangeListener(list);
        SwLapices.setOnCheckedChangeListener(list);
        SwAbuelo.setOnCheckedChangeListener(list);
        SwLapiz.setOnCheckedChangeListener(list);
        SwMaestra.setOnCheckedChangeListener(list);
        SwDoctora.setOnCheckedChangeListener(list);
        SwChef.setOnCheckedChangeListener(list);
    }


    class adapter extends BaseAdapter {

        int[] drawables = null;
        private Context mcontext;

        public adapter(Context context, int[] draw) {
            mcontext = context;
            drawables = draw;
        }

        @Override
        public int getCount() {
            return drawables.length;
        }

        @Override
        public Object getItem(int position) {
            return drawables[position];
        }

        @Override
        public long getItemId(int position) {
            return drawables[position];
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView im = new ImageView(mcontext);
            im.setImageDrawable(getResources().getDrawable(drawables[position]));
            return im;
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}