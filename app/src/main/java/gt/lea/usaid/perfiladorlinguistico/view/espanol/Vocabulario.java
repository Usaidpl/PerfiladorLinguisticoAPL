package gt.lea.usaid.perfiladorlinguistico.view.espanol;

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
import gt.lea.usaid.perfiladorlinguistico.utils.DialogoAlerta;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Roberto on 20/06/2016.
 */
public class Vocabulario extends Activity implements View.OnClickListener, OnInitializeComponent {
    private ViewFlipper vf;
    private TextView tvInstruccVocalario,tvCasa, tvCama, tvAvion, tvSilla, tvConejo, tvCaballo, tvZanahoria, tvGuisquil, tvGallo, tvManzana;
    private RadioButton SiCasa, NoCasa, SiCama, NoCama, SiAvion, NoAvion, SiSilla, NoSilla, SiConejo, NoConejo, SiCaballo, NoCaballo, SiZanahoria, NoZanahoria, SiGuisquil, NoGuisquil, SiGallo, NoGallo, SiManzana, NoManzana;
    private Switch swCasa, swCama, swAvion, swSilla, swConejo, swCaballo, swZanahoria, swGuisquil, swGallo, swManzana;
    private int[] dr = {R.mipmap.book};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabulario);

        setOnInit(null);
        DialogoAlerta.alertDialog("Hola", "Desea Continuar", false, this);
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
            gallo();
            manzana();
        }

        private void casa() {
            if (swCasa.isChecked())
                tvCasa.setText("Casa");
            else
                tvCasa.setText("");
        }

        private void cama() {
            if (swCama.isChecked())
                tvCama.setText("Cama");
            else
                tvCama.setText(" ");

        }

        private void avion() {
            if (swAvion.isChecked())
                tvAvion.setText("Avion");
            else
                tvAvion.setText(" ");
        }

        private void silla() {
            if (swSilla.isChecked())
                tvSilla.setText("Silla");
            else
                tvSilla.setText("");
        }

        private void conejo() {
            if (swConejo.isChecked())
                tvConejo.setText("Conejo");
            else
                tvConejo.setText(" ");
        }

        private void caballo() {
            if (swCaballo.isChecked())
                tvCaballo.setText("Caballo");
            else
                tvCaballo.setText(" ");
        }

        private void zanahoria() {
            if (swZanahoria.isChecked())
                tvZanahoria.setText("Zanahoria");
            else
                tvZanahoria.setText(" ");
        }

        private void guisquil() {
            if (swGuisquil.isChecked())
                tvGuisquil.setText("Guisquil");
            else
                tvGuisquil.setText(" ");
        }

        private void gallo() {
            if (swGallo.isChecked())
                tvGallo.setText("Gallo");
            else
                tvGallo.setText(" ");
        }

        private void manzana() {
            if (swManzana.isChecked())
                tvManzana.setText("Manzana");
            else
                tvManzana.setText(" ");
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiCasa:
                vf.showNext();
                tvInstruccVocalario.setText("");
                break;
            case R.id.NoCasa:
                vf.showNext();
                tvInstruccVocalario.setText("");
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
                break;
            case R.id.NoSilla:
                vf.showNext();
                break;
            case R.id.SiConejo:
                vf.showNext();
                break;
            case R.id.NoConejo:
                vf.showNext();
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
                break;
            case R.id.NoGuisquil:
                vf.showNext();
                break;
            case R.id.SiGallo:
                vf.showNext();
                break;
            case R.id.NoGallo:
                vf.showNext();
                break;
            case R.id.SiManzana:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent pruebas2 = new Intent(getApplication(), SonidosEspecificos.class);
                startActivity(pruebas2);
                break;
            case R.id.NoManzana:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);
                toast1.show();
                Intent pruebas = new Intent(getApplication(), SonidosEspecificos.class);
                startActivity(pruebas);
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
        SiGallo = (RadioButton) findViewById(R.id.SiGallo);
        NoGallo = (RadioButton) findViewById(R.id.NoGallo);
        SiManzana = (RadioButton) findViewById(R.id.SiManzana);
        NoManzana = (RadioButton) findViewById(R.id.NoManzana);

        swCasa = (Switch) findViewById(R.id.swCasa);
        tvCasa = (TextView) findViewById(R.id.tvCasa);
        swCama = (Switch) findViewById(R.id.swCama);
        tvCama = (TextView) findViewById(R.id.tvCama);
        swAvion = (Switch) findViewById(R.id.swAvion);
        tvAvion = (TextView) findViewById(R.id.tvAvion);
        swSilla = (Switch) findViewById(R.id.swSilla);
        tvSilla = (TextView) findViewById(R.id.tvSilla);
        swConejo = (Switch) findViewById(R.id.swConejo);
        tvConejo = (TextView) findViewById(R.id.tvConejo);
        swCaballo = (Switch) findViewById(R.id.swCaballo);
        tvCaballo = (TextView) findViewById(R.id.tvCaballo);
        swZanahoria = (Switch) findViewById(R.id.swZanahoria);
        tvZanahoria = (TextView) findViewById(R.id.tvZanahoria);
        swGuisquil = (Switch) findViewById(R.id.swGuisquil);
        tvGuisquil = (TextView) findViewById(R.id.tvGuisquil);
        swGallo = (Switch) findViewById(R.id.swGallo);
        tvGallo = (TextView) findViewById(R.id.tvGallo);
        swManzana = (Switch) findViewById(R.id.swManzana);
        tvManzana = (TextView) findViewById(R.id.tvManzana);
        tvInstruccVocalario = (TextView) findViewById(R.id.tvInstruccVocalario);

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
        SiGallo.setOnClickListener(this);
        NoGallo.setOnClickListener(this);
        SiManzana.setOnClickListener(this);
        NoManzana.setOnClickListener(this);
        swPrincipal();
    }

    private void swPrincipal() {
        swCasa.setOnCheckedChangeListener(list);
        swCama.setOnCheckedChangeListener(list);
        swAvion.setOnCheckedChangeListener(list);
        swSilla.setOnCheckedChangeListener(list);
        swConejo.setOnCheckedChangeListener(list);
        swCaballo.setOnCheckedChangeListener(list);
        swZanahoria.setOnCheckedChangeListener(list);
        swGuisquil.setOnCheckedChangeListener(list);
        swGallo.setOnCheckedChangeListener(list);
        swManzana.setOnCheckedChangeListener(list);

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
            //@SuppressWarnings();
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