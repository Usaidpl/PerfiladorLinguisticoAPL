package gt.lea.usaid.perfiladorlinguistico.view.mam;

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
public class VocabularioMam extends Activity implements View.OnClickListener, OnInitializeComponent {
    private ViewFlipper vf;
    private TextView tvInstruccVocalario,tvJaA, tvWatbilKuxlil, tvXikXiky, tvChej, tvJosTpaqik, tvBixBich, tvKyix, tvWitz, tvBEe, tvMuj;
    private RadioButton SiJaA, NoJaA, SiWatbilKuxlil, NoWatbilKuxlil, SiXikXiky, NoXikXiky, SiChej, NoChej, SiJosTpaqik, NoJosTpaqik, SiBixBich, NoBixBich, SiKyix, NoKyix, SiWitz, NoWitz, SiBEe, NoBEe, SiMuj, NoMuj;
    private Switch swJaA, swWatbilKuxlil, swXikXiky, swChej, swJosTpaqik, swBixBich, swKyix, swWitz, swBEe, swMuj;
    private int[] dr = {R.mipmap.book};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabulario_mam);
        //DialogoAlerta.alertDialog("Hola", "Desea Continuar", false, this);
        setOnInit(null);

    }

    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            JaA();
            WatbilKuxlil();
            XikXiky();
            Chej();
            JosTpaqik();
            BixBich();
            Kyix();
            Witz();
            BEe();
            Muj();
        }

        private void JaA() {
            if (swJaA.isChecked())
                tvJaA.setText("JaA");
            else
                tvJaA.setText("");
        }

        private void WatbilKuxlil() {
            if (swWatbilKuxlil.isChecked())
                tvWatbilKuxlil.setText("WatbilKuxlil");
            else
                tvWatbilKuxlil.setText(" ");

        }

        private void XikXiky() {
            if (swXikXiky.isChecked())
                tvXikXiky.setText("XikXiky");
            else
                tvXikXiky.setText(" ");
        }

        private void Chej() {
            if (swChej.isChecked())
                tvChej.setText("Chej");
            else
                tvChej.setText("");
        }

        private void JosTpaqik() {
            if (swJosTpaqik.isChecked())
                tvJosTpaqik.setText("JosTpaqik");
            else
                tvJosTpaqik.setText(" ");
        }

        private void BixBich() {
            if (swBixBich.isChecked())
                tvBixBich.setText("BixBich");
            else
                tvBixBich.setText(" ");
        }

        private void Kyix() {
            if (swKyix.isChecked())
                tvKyix.setText("Kyix");
            else
                tvKyix.setText(" ");
        }

        private void Witz() {
            if (swWitz.isChecked())
                tvWitz.setText("Witz");
            else
                tvWitz.setText(" ");
        }

        private void BEe() {
            if (swBEe.isChecked())
                tvBEe.setText("BEe");
            else
                tvBEe.setText(" ");
        }

        private void Muj() {
            if (swMuj.isChecked())
                tvMuj.setText("Muj");
            else
                tvMuj.setText(" ");
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiJaA:
                vf.showNext();
                tvInstruccVocalario.setText("");
                break;
            case R.id.NoJaA:
                vf.showNext();
                tvInstruccVocalario.setText("");
                break;
            case R.id.SiWatbilKuxlil:
                vf.showNext();
                break;
            case R.id.NoWatbilKuxlil:
                vf.showNext();
                break;
            case R.id.SiXikXiky:
                vf.showNext();
                break;
            case R.id.NoXikXiky:
                vf.showNext();
                break;
            case R.id.SiChej:
                vf.showNext();
                break;
            case R.id.NoChej:
                vf.showNext();
                break;
            case R.id.SiJosTpaqik:
                vf.showNext();
                break;
            case R.id.NoJosTpaqik:
                vf.showNext();
                break;
            case R.id.SiBixBich:
                vf.showNext();
                break;
            case R.id.NoBixBich:
                vf.showNext();
                break;
            case R.id.SiKyix:
                vf.showNext();
                break;
            case R.id.NoKyix:
                vf.showNext();
                break;
            case R.id.SiWitz:
                vf.showNext();
                break;
            case R.id.NoWitz:
                vf.showNext();
                break;
            case R.id.SiBEe:
                vf.showNext();
                break;
            case R.id.NoBEe:
                vf.showNext();
                break;
            case R.id.SiMuj:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent pruebas2 = new Intent(getApplication(), SonidosEspecificosMam.class);
                startActivity(pruebas2);
                break;
            case R.id.NoMuj:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);
                toast1.show();
                Intent pruebas = new Intent(getApplication(), SonidosEspecificosMam.class);
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
        SiJaA = (RadioButton) findViewById(R.id.SiJaA);
        NoJaA = (RadioButton) findViewById(R.id.NoJaA);
        SiWatbilKuxlil = (RadioButton) findViewById(R.id.SiWatbilKuxlil);
        NoWatbilKuxlil = (RadioButton) findViewById(R.id.NoWatbilKuxlil);
        SiXikXiky = (RadioButton) findViewById(R.id.SiXikXiky);
        NoXikXiky = (RadioButton) findViewById(R.id.NoXikXiky);
        SiChej = (RadioButton) findViewById(R.id.SiChej);
        NoChej = (RadioButton) findViewById(R.id.NoChej);
        SiJosTpaqik = (RadioButton) findViewById(R.id.SiJosTpaqik);
        NoJosTpaqik = (RadioButton) findViewById(R.id.NoJosTpaqik);
        SiBixBich = (RadioButton) findViewById(R.id.SiBixBich);
        NoBixBich = (RadioButton) findViewById(R.id.NoBixBich);
        SiKyix = (RadioButton) findViewById(R.id.SiKyix);
        NoKyix = (RadioButton) findViewById(R.id.NoKyix);
        SiWitz = (RadioButton) findViewById(R.id.SiWitz);
        NoWitz = (RadioButton) findViewById(R.id.NoWitz);
        SiBEe = (RadioButton) findViewById(R.id.SiBEe);
        NoBEe = (RadioButton) findViewById(R.id.NoBEe);
        SiMuj = (RadioButton) findViewById(R.id.SiMuj);
        NoMuj = (RadioButton) findViewById(R.id.NoMuj);

        swJaA = (Switch) findViewById(R.id.swJaA);
        tvJaA = (TextView) findViewById(R.id.tvJaA);
        swWatbilKuxlil = (Switch) findViewById(R.id.swWatbilKuxlil);
        tvWatbilKuxlil = (TextView) findViewById(R.id.tvWatbilKuxlil);
        swXikXiky = (Switch) findViewById(R.id.swXikXiky);
        tvXikXiky = (TextView) findViewById(R.id.tvXikXiky);
        swChej = (Switch) findViewById(R.id.swChej);
        tvChej = (TextView) findViewById(R.id.tvChej);
        swJosTpaqik = (Switch) findViewById(R.id.swJosTpaqik);
        tvJosTpaqik = (TextView) findViewById(R.id.tvJosTpaqik);
        swBixBich = (Switch) findViewById(R.id.swBixBich);
        tvBixBich = (TextView) findViewById(R.id.tvBixBich);
        swKyix = (Switch) findViewById(R.id.swKyix);
        tvKyix = (TextView) findViewById(R.id.tvKyix);
        swWitz = (Switch) findViewById(R.id.swWitz);
        tvWitz = (TextView) findViewById(R.id.tvWitz);
        swBEe = (Switch) findViewById(R.id.swBEe);
        tvBEe = (TextView) findViewById(R.id.tvBEe);
        swMuj = (Switch) findViewById(R.id.swMuj);
        tvMuj = (TextView) findViewById(R.id.tvMuj);
        tvInstruccVocalario = (TextView) findViewById(R.id.tvInstruccVocalario);

        SiJaA.setOnClickListener(this);
        NoJaA.setOnClickListener(this);
        SiWatbilKuxlil.setOnClickListener(this);
        NoWatbilKuxlil.setOnClickListener(this);
        SiXikXiky.setOnClickListener(this);
        NoXikXiky.setOnClickListener(this);
        SiChej.setOnClickListener(this);
        NoChej.setOnClickListener(this);
        SiJosTpaqik.setOnClickListener(this);
        NoJosTpaqik.setOnClickListener(this);
        SiBixBich.setOnClickListener(this);
        NoBixBich.setOnClickListener(this);
        SiKyix.setOnClickListener(this);
        NoKyix.setOnClickListener(this);
        SiWitz.setOnClickListener(this);
        NoWitz.setOnClickListener(this);
        SiBEe.setOnClickListener(this);
        NoBEe.setOnClickListener(this);
        SiMuj.setOnClickListener(this);
        NoMuj.setOnClickListener(this);
        swPrincipal();
    }

    private void swPrincipal() {
        swJaA.setOnCheckedChangeListener(list);
        swWatbilKuxlil.setOnCheckedChangeListener(list);
        swXikXiky.setOnCheckedChangeListener(list);
        swChej.setOnCheckedChangeListener(list);
        swJosTpaqik.setOnCheckedChangeListener(list);
        swBixBich.setOnCheckedChangeListener(list);
        swKyix.setOnCheckedChangeListener(list);
        swWitz.setOnCheckedChangeListener(list);
        swBEe.setOnCheckedChangeListener(list);
        swMuj.setOnCheckedChangeListener(list);

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