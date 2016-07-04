package gt.lea.usaid.perfiladorlinguistico.view.kiche;

/**
 * Created by Roberto on 19/06/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
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

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.ExpresionOral;

public class GramaticaKiche  extends Activity implements View.OnClickListener, OnInitializeComponent {
    private ViewFlipper vf;
    private TextView title_gramatica_kiche, tvInstrGramaticaKiche, tvPelota, tvPelotas, tvMes, tvTaqMes, tvAli, tvTatAchi, tvMamTat, tvAkTux;
    private RadioButton SiPelota, NoPelota, SiPelotas, NoPelotas, SiMes, NoMes, SiTaqMes, NoTaqMes, SiAli, NoAli, SiTatAchi, NoTatAchi, SiMamTat, NoMamTat, SiAkTux, NoAkTux;
    private Switch SwPelota, SwPelotas, SwMes, SwTaqMes, SwAli, SwTatAchi, SwMamTat, SwAkTux;
    private int[] dr = {R.mipmap.book};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gramatica_kiche);

        setOnInit(null);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiPelota:
                vf.showNext();
                tvInstrGramaticaKiche.setText("");
                break;
            case R.id.NoPelota:
                vf.showNext();
                tvInstrGramaticaKiche.setText("");
                break;
            case R.id.SiPelotas:
                vf.showNext();
                break;
            case R.id.NoPelotas:
                vf.showNext();
                break;
            case R.id.SiMes:
                vf.showNext();
                break;
            case R.id.NoMes:
                vf.showNext();
                break;
            case R.id.SiTaqMes:
                vf.showNext();
                title_gramatica_kiche.setText("GENERO GRAMATICAL (MASCULINO Y FEMENINO)");
                tvInstrGramaticaKiche.setText("Responda correctamente cada pregunta planteada en los siguientes casos");
                break;
            case R.id.NoTaqMes:
                vf.showNext();
                title_gramatica_kiche.setText("GENERO GRAMATICAL (MASCULINO Y FEMENINO)");
                tvInstrGramaticaKiche.setText("Responda correctamente cada pregunta planteada en los siguientes casos");
                break;
            case R.id.SiAli:
                vf.showNext();
                tvInstrGramaticaKiche.setText("");
                break;
            case R.id.NoAli:
                vf.showNext();
                tvInstrGramaticaKiche.setText("");
                break;
            case R.id.SiTatAchi:
                vf.showNext();
                break;
            case R.id.NoTatAchi:
                vf.showNext();
                break;
            case R.id.SiMamTat:
                vf.showNext();
                break;
            case R.id.NoMamTat:
                vf.showNext();
                break;
            case R.id.SiAkTux:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent expresionoral = new Intent(getApplication(), ExpresionOral.class);
                startActivity(expresionoral);
                break;
            case R.id.NoAkTux:
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
        SiMes = (RadioButton) findViewById(R.id.SiMes);
        NoMes = (RadioButton) findViewById(R.id.NoMes);
        SiTaqMes = (RadioButton) findViewById(R.id.SiTaqMes);
        NoTaqMes = (RadioButton) findViewById(R.id.NoTaqMes);
        SiAli = (RadioButton) findViewById(R.id.SiAli);
        NoAli = (RadioButton) findViewById(R.id.NoAli);
        SiTatAchi = (RadioButton) findViewById(R.id.SiTatAchi);
        NoTatAchi = (RadioButton) findViewById(R.id.NoTatAchi);
        SiMamTat = (RadioButton) findViewById(R.id.SiMamTat);
        NoMamTat = (RadioButton) findViewById(R.id.NoMamTat);
        SiAkTux = (RadioButton) findViewById(R.id.SiAkTux);
        NoAkTux = (RadioButton) findViewById(R.id.NoAkTux);

        SwPelota = (Switch) findViewById(R.id.swPelota);
        tvPelota = (TextView) findViewById(R.id.tvPelota);
        SwPelotas = (Switch) findViewById(R.id.swPelotas);
        tvPelotas = (TextView) findViewById(R.id.tvPelotas);
        SwTaqMes = (Switch) findViewById(R.id.SwTaqMes);
        tvMes = (TextView) findViewById(R.id.tvMes);
        SwMes = (Switch) findViewById(R.id.SwMes);
        tvTaqMes = (TextView) findViewById(R.id.tvTaqMes);
        SwAli = (Switch) findViewById(R.id.SwAli);
        tvAli = (TextView) findViewById(R.id.tvAli);
        SwTatAchi = (Switch) findViewById(R.id.SwTatAchi);
        tvTatAchi = (TextView) findViewById(R.id.tvTatAchi);
        SwMamTat = (Switch) findViewById(R.id.SwMamTat);
        tvMamTat = (TextView) findViewById(R.id.tvMamTat);
        SwAkTux = (Switch) findViewById(R.id.SwAkTux);
        tvAkTux = (TextView) findViewById(R.id.tvAkTux);
        tvInstrGramaticaKiche = (TextView) findViewById(R.id.tvInstrGramaticaKicheKiche);
        title_gramatica_kiche = (TextView) findViewById(R.id.title_gramatica);

        SiPelota.setOnClickListener(this);
        NoPelota.setOnClickListener(this);
        SiPelotas.setOnClickListener(this);
        NoPelotas.setOnClickListener(this);
        SiMes.setOnClickListener(this);
        NoMes.setOnClickListener(this);
        SiTaqMes.setOnClickListener(this);
        NoTaqMes.setOnClickListener(this);
        SiAli.setOnClickListener(this);
        NoAli.setOnClickListener(this);
        SiTatAchi.setOnClickListener(this);
        NoTatAchi.setOnClickListener(this);
        SiMamTat.setOnClickListener(this);
        NoMamTat.setOnClickListener(this);
        SiAkTux.setOnClickListener(this);
        NoAkTux.setOnClickListener(this);
        swPrincipal();
    }

    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            pelota();
            pelotas();
            mes();
            taqmes();
            ali();
            tatachi();
            mamtat();
            aktux();


        }

        private void pelota() {
            if (SwPelota.isChecked())
                tvPelota.setText("Pelota");
            else
                tvPelota.setText("");
        }

        private void pelotas() {
            if (SwPelotas.isChecked())
                tvPelotas.setText("Pelotas");
            else
                tvPelotas.setText(" ");
        }

        private void mes() {
            if (SwTaqMes.isChecked())
                tvMes.setText("me's");
            else
                tvMes.setText(" ");
        }

        private void taqmes() {
            if (SwMes.isChecked())
                tvTaqMes.setText("taq me's");
            else
                tvTaqMes.setText("");
        }

        private void ali() {
            if (SwAli.isChecked())
                tvAli.setText("ali");
            else
                tvAli.setText("Esta es una Abuela, si fuera hombre ¿cómo se diría?");
        }

        private void tatachi() {
            if (SwTatAchi.isChecked())
                tvTatAchi.setText("tat / achi");
            else
                tvTatAchi.setText("Este es un maestro, si fuera una mujer ¿cómo se diría?");
        }

        private void mamtat() {
            if (SwMamTat.isChecked())
                tvMamTat.setText("mam / tat");
            else
                tvMamTat.setText("Este es un doctor, si fuera mujer ¿cómo se diría?");
        }

        private void aktux() {
            if (SwAkTux.isChecked())
                tvAkTux.setText("ak' / tux ");
            else
                tvAkTux.setText("Este es un cocinero, si fuera mujer ¿cómo se diría?");
        }


    };

    private void swPrincipal() {
        SwTaqMes.setOnCheckedChangeListener(list);
        SwPelota.setOnCheckedChangeListener(list);
        SwPelotas.setOnCheckedChangeListener(list);
        SwTaqMes.setOnCheckedChangeListener(list);
        SwAli.setOnCheckedChangeListener(list);
        SwMes.setOnCheckedChangeListener(list);
        SwTatAchi.setOnCheckedChangeListener(list);
        SwMamTat.setOnCheckedChangeListener(list);
        SwAkTux.setOnCheckedChangeListener(list);
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
