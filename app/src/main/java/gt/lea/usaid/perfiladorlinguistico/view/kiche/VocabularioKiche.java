package gt.lea.usaid.perfiladorlinguistico.view.kiche;

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

/**
 * Created by Roberto on 20/06/2016.
 */
public class VocabularioKiche extends Activity implements View.OnClickListener, OnInitializeComponent {
    private ViewFlipper vf;
    private TextView tvInstruccVocalario,tvKar, tvJar, tvLej, tvKumatz, tvKej, tvKoy, tvTzi, tvKix, tvMukunKum, tvQatzuQanxul;
    private RadioButton SiKar, NoKar, SiJar, NoJar, SiLej, NoLej, SiKumatz, NoKumatz, SiKej, NoKej, SiKoy, NoKoy, SiTzi, NoTzi, SiKix, NoKix, SiMukunKum, NoMukunKum, SiQatzuQanxul, NoQatzuQanxul;
    private Switch swKar, swJar, swLej, swKumatz, swKej, swKoy, swTzi, swKix, swMukunKum, swQatzuQanxul;
    private int[] dr = {R.mipmap.book};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabulario_kiche);

        setOnInit(null);
        //DialogoAlerta.alertDialog("Hola", "Desea Continuar", false, this);
    }

    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Kar();
            Jar();
            Lej();
            Kumatz();
            Kej();
            Koy();
            Tzi();
            Kix();
            MukunKum();
            QatzuQanxul();
        }

        private void Kar() {
            if (swKar.isChecked())
                tvKar.setText("Kar");
            else
                tvKar.setText("");
        }

        private void Jar() {
            if (swJar.isChecked())
                tvJar.setText("Jar");
            else
                tvJar.setText(" ");

        }

        private void Lej() {
            if (swLej.isChecked())
                tvLej.setText("Lej");
            else
                tvLej.setText(" ");
        }

        private void Kumatz() {
            if (swKumatz.isChecked())
                tvKumatz.setText("Kumatz");
            else
                tvKumatz.setText("");
        }

        private void Kej() {
            if (swKej.isChecked())
                tvKej.setText("Kej");
            else
                tvKej.setText(" ");
        }

        private void Koy() {
            if (swKoy.isChecked())
                tvKoy.setText("Koy");
            else
                tvKoy.setText(" ");
        }

        private void Tzi() {
            if (swTzi.isChecked())
                tvTzi.setText("Tzi");
            else
                tvTzi.setText(" ");
        }

        private void Kix() {
            if (swKix.isChecked())
                tvKix.setText("Kix");
            else
                tvKix.setText(" ");
        }

        private void MukunKum() {
            if (swMukunKum.isChecked())
                tvMukunKum.setText("MukunKum");
            else
                tvMukunKum.setText(" ");
        }

        private void QatzuQanxul() {
            if (swQatzuQanxul.isChecked())
                tvQatzuQanxul.setText("QatzuQanxul");
            else
                tvQatzuQanxul.setText(" ");
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiKar:
                vf.showNext();
                tvInstruccVocalario.setText("");
                break;
            case R.id.NoKar:
                vf.showNext();
                tvInstruccVocalario.setText("");
                break;
            case R.id.SiJar:
                vf.showNext();
                break;
            case R.id.NoJar:
                vf.showNext();
                break;
            case R.id.SiLej:
                vf.showNext();
                break;
            case R.id.NoLej:
                vf.showNext();
                break;
            case R.id.SiKumatz:
                vf.showNext();
                break;
            case R.id.NoKumatz:
                vf.showNext();
                break;
            case R.id.SiKej:
                vf.showNext();
                break;
            case R.id.NoKej:
                vf.showNext();
                break;
            case R.id.SiKoy:
                vf.showNext();
                break;
            case R.id.NoKoy:
                vf.showNext();
                break;
            case R.id.SiTzi:
                vf.showNext();
                break;
            case R.id.NoTzi:
                vf.showNext();
                break;
            case R.id.SiKix:
                vf.showNext();
                break;
            case R.id.NoKix:
                vf.showNext();
                break;
            case R.id.SiMukunKum:
                vf.showNext();
                break;
            case R.id.NoMukunKum:
                vf.showNext();
                break;
            case R.id.SiQatzuQanxul:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent pruebas2 = new Intent(getApplication(), SonidosEspecificosKiche.class);
                startActivity(pruebas2);
                break;
            case R.id.NoQatzuQanxul:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);
                toast1.show();
                Intent pruebas = new Intent(getApplication(), SonidosEspecificosKiche.class);
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
        SiKar = (RadioButton) findViewById(R.id.SiKar);
        NoKar = (RadioButton) findViewById(R.id.NoKar);
        SiJar = (RadioButton) findViewById(R.id.SiJar);
        NoJar = (RadioButton) findViewById(R.id.NoJar);
        SiLej = (RadioButton) findViewById(R.id.SiLej);
        NoLej = (RadioButton) findViewById(R.id.NoLej);
        SiKumatz = (RadioButton) findViewById(R.id.SiKumatz);
        NoKumatz = (RadioButton) findViewById(R.id.NoKumatz);
        SiKej = (RadioButton) findViewById(R.id.SiKej);
        NoKej = (RadioButton) findViewById(R.id.NoKej);
        SiKoy = (RadioButton) findViewById(R.id.SiKoy);
        NoKoy = (RadioButton) findViewById(R.id.NoKoy);
        SiTzi = (RadioButton) findViewById(R.id.SiTzi);
        NoTzi = (RadioButton) findViewById(R.id.NoTzi);
        SiKix = (RadioButton) findViewById(R.id.SiKix);
        NoKix = (RadioButton) findViewById(R.id.NoKix);
        SiMukunKum = (RadioButton) findViewById(R.id.SiMukunKum);
        NoMukunKum = (RadioButton) findViewById(R.id.NoMukunKum);
        SiQatzuQanxul = (RadioButton) findViewById(R.id.SiQatzuQanxul);
        NoQatzuQanxul = (RadioButton) findViewById(R.id.NoQatzuQanxul);

        swKar = (Switch) findViewById(R.id.swKar);
        tvKar = (TextView) findViewById(R.id.tvKar);
        swJar = (Switch) findViewById(R.id.swJar);
        tvJar = (TextView) findViewById(R.id.tvJar);
        swLej = (Switch) findViewById(R.id.swLej);
        tvLej = (TextView) findViewById(R.id.tvLej);
        swKumatz = (Switch) findViewById(R.id.swKumatz);
        tvKumatz = (TextView) findViewById(R.id.tvKumatz);
        swKej = (Switch) findViewById(R.id.swKej);
        tvKej = (TextView) findViewById(R.id.tvKej);
        swKoy = (Switch) findViewById(R.id.swKoy);
        tvKoy = (TextView) findViewById(R.id.tvKoy);
        swTzi = (Switch) findViewById(R.id.swTzi);
        tvTzi = (TextView) findViewById(R.id.tvTzi);
        swKix = (Switch) findViewById(R.id.swKix);
        tvKix = (TextView) findViewById(R.id.tvKix);
        swMukunKum = (Switch) findViewById(R.id.swMukunKum);
        tvMukunKum = (TextView) findViewById(R.id.tvMukunKum);
        swQatzuQanxul = (Switch) findViewById(R.id.swQatzuQanxul);
        tvQatzuQanxul = (TextView) findViewById(R.id.tvQatzuQanxul);
        tvInstruccVocalario = (TextView) findViewById(R.id.tvInstruccVocalario);

        SiKar.setOnClickListener(this);
        NoKar.setOnClickListener(this);
        SiJar.setOnClickListener(this);
        NoJar.setOnClickListener(this);
        SiLej.setOnClickListener(this);
        NoLej.setOnClickListener(this);
        SiKumatz.setOnClickListener(this);
        NoKumatz.setOnClickListener(this);
        SiKej.setOnClickListener(this);
        NoKej.setOnClickListener(this);
        SiKoy.setOnClickListener(this);
        NoKoy.setOnClickListener(this);
        SiTzi.setOnClickListener(this);
        NoTzi.setOnClickListener(this);
        SiKix.setOnClickListener(this);
        NoKix.setOnClickListener(this);
        SiMukunKum.setOnClickListener(this);
        NoMukunKum.setOnClickListener(this);
        SiQatzuQanxul.setOnClickListener(this);
        NoQatzuQanxul.setOnClickListener(this);
        swPrincipal();
    }

    private void swPrincipal() {
        swKar.setOnCheckedChangeListener(list);
        swJar.setOnCheckedChangeListener(list);
        swLej.setOnCheckedChangeListener(list);
        swKumatz.setOnCheckedChangeListener(list);
        swKej.setOnCheckedChangeListener(list);
        swKoy.setOnCheckedChangeListener(list);
        swTzi.setOnCheckedChangeListener(list);
        swKix.setOnCheckedChangeListener(list);
        swMukunKum.setOnCheckedChangeListener(list);
        swQatzuQanxul.setOnCheckedChangeListener(list);

    }

    class adapter extends BaseAdapter {

        int[] drawables = null;
        int [] mipmap = null;
        private Context mcontext;

        public adapter(Context context, int[] draw) {
            mcontext = context;
            drawables = draw;
            mipmap = mipmap;
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