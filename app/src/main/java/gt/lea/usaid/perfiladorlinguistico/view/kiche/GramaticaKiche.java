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
    private TextView title_gramatica, tvInstruccGramatica, tvCasa, tvCama, tvAvion, tvSilla, tvConejo, tvCaballo, tvZanahoria, tvGuisquil;
    private RadioButton SiCasa, NoCasa, SiCama, NoCama, SiAvion, NoAvion, SiSilla, NoSilla, SiConejo, NoConejo, SiCaballo, NoCaballo, SiZanahoria, NoZanahoria, SiGuisquil, NoGuisquil;
    private Switch SwCasa, SwCama, SwAvion, SwSilla, SwConejo, SwCaballo, SwZanahoria, SwGuisquil;
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
            case R.id.SiCasa:
                vf.showNext();
                tvInstruccGramatica.setText("");
                break;
            case R.id.NoCasa:
                vf.showNext();
                tvInstruccGramatica.setText("");
                break;
            case R.id.SiCama:
                vf.showNext();
                break;
            case R.id.NoCama:
                vf.showNext();
                break;
            case R.id.SiAvion:
                vf.showNext();
                break;
            case R.id.NoAvion:
                vf.showNext();
                break;
            case R.id.SiSilla:
                vf.showNext();
                title_gramatica.setText("GENERO GRAMATICAL (MASCULINO Y FEMENINO)");
                tvInstruccGramatica.setText("Responda correctamente cada pregunta planteada en los siguientes casos");
                break;
            case R.id.NoSilla:
                vf.showNext();
                title_gramatica.setText("GENERO GRAMATICAL (MASCULINO Y FEMENINO)");
                tvInstruccGramatica.setText("Responda correctamente cada pregunta planteada en los siguientes casos");
                break;
            case R.id.SiConejo:
                vf.showNext();
                tvInstruccGramatica.setText("");
                break;
            case R.id.NoConejo:
                vf.showNext();
                tvInstruccGramatica.setText("");
                break;
            case R.id.SiCaballo:
                vf.showNext();
                break;
            case R.id.NoCaballo:
                vf.showNext();
                break;
            case R.id.SiZanahoria:
                vf.showNext();
                break;
            case R.id.NoZanahoria:
                vf.showNext();
                break;
            case R.id.SiGuisquil:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent expresionoral = new Intent(getApplication(), ExpresionOral.class);
                startActivity(expresionoral);
                break;
            case R.id.NoGuisquil:
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


        SiCasa = (RadioButton) findViewById(R.id.SiCasa);
        NoCasa = (RadioButton) findViewById(R.id.NoCasa);
        SiCama = (RadioButton) findViewById(R.id.SiCama);
        NoCama = (RadioButton) findViewById(R.id.NoCama);
        SiAvion = (RadioButton) findViewById(R.id.SiAvion);
        NoAvion = (RadioButton) findViewById(R.id.NoAvion);
        SiSilla = (RadioButton) findViewById(R.id.SiSilla);
        NoSilla = (RadioButton) findViewById(R.id.NoSilla);
        SiConejo = (RadioButton) findViewById(R.id.SiConejo);
        NoConejo = (RadioButton) findViewById(R.id.NoConejo);
        SiCaballo = (RadioButton) findViewById(R.id.SiCaballo);
        NoCaballo = (RadioButton) findViewById(R.id.NoCaballo);
        SiZanahoria = (RadioButton) findViewById(R.id.SiZanahoria);
        NoZanahoria = (RadioButton) findViewById(R.id.NoZanahoria);
        SiGuisquil = (RadioButton) findViewById(R.id.SiGuisquil);
        NoGuisquil = (RadioButton) findViewById(R.id.NoGuisquil);

        SwCasa = (Switch) findViewById(R.id.swCasa);
        tvCasa = (TextView) findViewById(R.id.tvCasa);
        SwCama = (Switch) findViewById(R.id.swCama);
        tvCama = (TextView) findViewById(R.id.tvCama);
        SwSilla = (Switch) findViewById(R.id.swSilla);
        tvAvion = (TextView) findViewById(R.id.tvAvion);
        SwAvion = (Switch) findViewById(R.id.swAvion);
        tvSilla = (TextView) findViewById(R.id.tvSilla);
        SwConejo = (Switch) findViewById(R.id.swConejo);
        tvConejo = (TextView) findViewById(R.id.tvConejo);
        SwCaballo = (Switch) findViewById(R.id.swCaballo);
        tvCaballo = (TextView) findViewById(R.id.tvCaballo);
        SwZanahoria = (Switch) findViewById(R.id.swZanahoria);
        tvZanahoria = (TextView) findViewById(R.id.tvZanahoria);
        SwGuisquil = (Switch) findViewById(R.id.swGuisquil);
        tvGuisquil = (TextView) findViewById(R.id.tvGuisquil);
        tvInstruccGramatica = (TextView) findViewById(R.id.tvInstruccGramaticaKiche);
        title_gramatica = (TextView) findViewById(R.id.title_gramatica_kiche);

        SiCasa.setOnClickListener(this);
        NoCasa.setOnClickListener(this);
        SiCama.setOnClickListener(this);
        NoCama.setOnClickListener(this);
        SiAvion.setOnClickListener(this);
        NoAvion.setOnClickListener(this);
        SiSilla.setOnClickListener(this);
        NoSilla.setOnClickListener(this);
        SiConejo.setOnClickListener(this);
        NoConejo.setOnClickListener(this);
        SiCaballo.setOnClickListener(this);
        NoCaballo.setOnClickListener(this);
        SiZanahoria.setOnClickListener(this);
        NoZanahoria.setOnClickListener(this);
        SiGuisquil.setOnClickListener(this);
        NoGuisquil.setOnClickListener(this);
        swPrincipal();
    }

    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            casa();
            cama();
            avion();
            silla();
            conejo();
            caballo();
            zanahoria();
            guisquil();


        }

        private void casa() {
            if (SwCasa.isChecked())
                tvCasa.setText("Pelota");
            else
                tvCasa.setText("");
        }

        private void cama() {
            if (SwCama.isChecked())
                tvCama.setText("Pelotas");
            else
                tvCama.setText(" ");
        }

        private void avion() {
            if (SwSilla.isChecked())
                tvAvion.setText("Lapices");
            else
                tvAvion.setText(" ");
        }

        private void silla() {
            if (SwAvion.isChecked())
                tvSilla.setText("Lapiz");
            else
                tvSilla.setText("");
        }

        private void conejo() {
            if (SwConejo.isChecked())
                tvConejo.setText("Abuelo");
            else
                tvConejo.setText("Esta es una Abuela, si fuera hombre ¿cómo se diría?");
        }

        private void caballo() {
            if (SwCaballo.isChecked())
                tvCaballo.setText("Maestra");
            else
                tvCaballo.setText("Este es un maestro, si fuera una mujer ¿cómo se diría?");
        }

        private void zanahoria() {
            if (SwZanahoria.isChecked())
                tvZanahoria.setText("Doctora");
            else
                tvZanahoria.setText("Este es un doctor, si fuera mujer ¿cómo se diría?");
        }

        private void guisquil() {
            if (SwGuisquil.isChecked())
                tvGuisquil.setText("Cociera / ");
            else
                tvGuisquil.setText("Este es un cocinero, si fuera mujer ¿cómo se diría?");
        }


    };

    private void swPrincipal() {
        SwSilla.setOnCheckedChangeListener(list);
        SwCasa.setOnCheckedChangeListener(list);
        SwCama.setOnCheckedChangeListener(list);
        SwSilla.setOnCheckedChangeListener(list);
        SwConejo.setOnCheckedChangeListener(list);
        SwAvion.setOnCheckedChangeListener(list);
        SwCaballo.setOnCheckedChangeListener(list);
        SwZanahoria.setOnCheckedChangeListener(list);
        SwGuisquil.setOnCheckedChangeListener(list);
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