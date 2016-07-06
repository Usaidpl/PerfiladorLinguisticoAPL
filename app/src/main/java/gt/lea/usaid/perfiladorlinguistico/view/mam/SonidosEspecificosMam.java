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
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Gramatica;

/**
 * Created by Roberto on 20/06/2016.
 */
public class SonidosEspecificosMam extends Activity implements View.OnClickListener, OnInitializeComponent {

    private ViewFlipper vf;
    private TextView tvInstruccSonidosEsp, tvKaKya, tvChew, tvSiI, tvUJj, tvXar, tvPwaq, tvLaq, tvQaq, tvKum, tvBoch;
    private RadioButton SiKaKya, NoKaKya, SiChew, NoChew, SiSiI, NoSiI, SiUJj, NoUJj, SiXar, NoXar, SiPwaq, NoPwaq, SiLaq, NoLaq, SiQaq, NoQaq, SiKum, NoKum, SiBoch, NoBoch;
    private Switch swKaKya, swChew, swSiI, swUJj, swXar, swPwaq, swLaq, swQaq, swKum, swBoch;
    private int[] dr = {R.mipmap.book};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonidos_especificos_mam);
        setOnInit(null);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiKaKya2:
                vf.showNext();
                tvInstruccSonidosEsp.setText("");
                break;
            case R.id.NoKaKya2:
                vf.showNext();
                tvInstruccSonidosEsp.setText("");
                break;
            case R.id.SiChew:
                vf.showNext();
                break;
            case R.id.NoChew:
                vf.showNext();
                break;
            case R.id.SiSiI:
                vf.showNext();
                break;
            case R.id.NoSiI:
                vf.showNext();
                break;
            case R.id.SiUJj:
                vf.showNext();
                break;
            case R.id.NoUJj:
                vf.showNext();
                break;
            case R.id.SiXar:
                vf.showNext();
                break;
            case R.id.NoXar:
                vf.showNext();
                break;
            case R.id.SiPwaq:
                vf.showNext();
                break;
            case R.id.NoPwaq:
                vf.showNext();
                break;
            case R.id.SiLaq:
                vf.showNext();
                break;
            case R.id.NoLaq:
                vf.showNext();
                break;
            case R.id.SiQaq:
                vf.showNext();
                break;
            case R.id.NoQaq:
                vf.showNext();
                break;
            case R.id.SiKum:
                vf.showNext();
                break;
            case R.id.NoKum:
                vf.showNext();
                break;
            case R.id.SiBoch:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent gramatica1 = new Intent(getApplication(), GramaticaMam.class);
                startActivity(gramatica1);
                break;
            case R.id.NoBoch:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast1.show();
                Intent gramatica2 = new Intent(getApplication(), GramaticaMam.class);
                startActivity(gramatica2);
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
        SiKaKya = (RadioButton) findViewById(R.id.SiKaKya2);
        NoKaKya = (RadioButton) findViewById(R.id.NoKaKya2);
        SiChew = (RadioButton) findViewById(R.id.SiChew);
        NoChew = (RadioButton) findViewById(R.id.NoChew);
        SiSiI = (RadioButton) findViewById(R.id.SiSiI);
        NoSiI = (RadioButton) findViewById(R.id.NoSiI);
        SiUJj = (RadioButton) findViewById(R.id.SiUJj);
        NoUJj = (RadioButton) findViewById(R.id.NoUJj);
        SiXar = (RadioButton) findViewById(R.id.SiXar);
        NoXar = (RadioButton) findViewById(R.id.NoXar);
        SiPwaq = (RadioButton) findViewById(R.id.SiPwaq);
        NoPwaq = (RadioButton) findViewById(R.id.NoPwaq);
        SiLaq = (RadioButton) findViewById(R.id.SiLaq);
        NoLaq = (RadioButton) findViewById(R.id.NoLaq);
        SiQaq = (RadioButton) findViewById(R.id.SiQaq);
        NoQaq = (RadioButton) findViewById(R.id.NoQaq);
        SiKum = (RadioButton) findViewById(R.id.SiKum);
        NoKum = (RadioButton) findViewById(R.id.NoKum);
        SiBoch = (RadioButton) findViewById(R.id.SiBoch);
        NoBoch = (RadioButton) findViewById(R.id.NoBoch);

        swKaKya = (Switch) findViewById(R.id.swKaKya2);
        tvKaKya = (TextView) findViewById(R.id.tvKaKya2);
        swChew = (Switch) findViewById(R.id.swChew);
        tvChew = (TextView) findViewById(R.id.tvChew);
        swSiI = (Switch) findViewById(R.id.swSiI);
        tvSiI = (TextView) findViewById(R.id.tvSiI);
        swUJj = (Switch) findViewById(R.id.swUJj);
        tvUJj = (TextView) findViewById(R.id.tvUJj);
        swXar = (Switch) findViewById(R.id.swXar);
        tvXar = (TextView) findViewById(R.id.tvXar);
        swPwaq = (Switch) findViewById(R.id.swPwaq);
        tvPwaq = (TextView) findViewById(R.id.tvPwaq);
        swLaq = (Switch) findViewById(R.id.swLaq);
        tvLaq = (TextView) findViewById(R.id.tvLaq);
        swQaq = (Switch) findViewById(R.id.swQaq);
        tvQaq = (TextView) findViewById(R.id.tvQaq);
        swKum = (Switch) findViewById(R.id.swKum);
        tvKum = (TextView) findViewById(R.id.tvKum);
        swBoch = (Switch) findViewById(R.id.swBoch);
        tvBoch = (TextView) findViewById(R.id.tvBoch);
        tvInstruccSonidosEsp = (TextView) findViewById(R.id.tvInstruccSonidosEsp);
        SiKaKya.setOnClickListener(this);
        NoKaKya.setOnClickListener(this);
        SiChew.setOnClickListener(this);
        NoChew.setOnClickListener(this);
        SiSiI.setOnClickListener(this);
        NoSiI.setOnClickListener(this);
        SiUJj.setOnClickListener(this);
        NoUJj.setOnClickListener(this);
        SiXar.setOnClickListener(this);
        NoXar.setOnClickListener(this);
        SiPwaq.setOnClickListener(this);
        NoPwaq.setOnClickListener(this);
        SiLaq.setOnClickListener(this);
        NoLaq.setOnClickListener(this);
        SiQaq.setOnClickListener(this);
        NoQaq.setOnClickListener(this);
        SiKum.setOnClickListener(this);
        NoKum.setOnClickListener(this);
        SiBoch.setOnClickListener(this);
        NoBoch.setOnClickListener(this);
        swPrincipal();
    }

    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            KaKya();
            Chew();
            SiI();
            UJj();
            Xar();
            Pwaq();
            Laq();
            Qaq();
            Kum();
            Boch();
        }

        private void KaKya() {
            if (swKaKya.isChecked())
                tvKaKya.setText("KaKya");
            else
                tvKaKya.setText("");
        }

        private void Chew() {
            if (swChew.isChecked())
                tvChew.setText("Chew");
            else
                tvChew.setText(" ");
        }

        private void SiI() {
            if (swSiI.isChecked())
                tvSiI.setText("SiI");
            else
                tvSiI.setText(" ");
        }

        private void UJj() {
            if (swUJj.isChecked())
                tvUJj.setText("UJj");
            else
                tvUJj.setText("");
        }

        private void Xar() {
            if (swXar.isChecked())
                tvXar.setText("Xar");
            else
                tvXar.setText(" ");
        }

        private void Pwaq() {
            if (swPwaq.isChecked())
                tvPwaq.setText("Pwaq");
            else
                tvPwaq.setText(" ");
        }

        private void Laq() {
            if (swLaq.isChecked())
                tvLaq.setText("Laq");
            else
                tvLaq.setText(" ");
        }

        private void Qaq() {
            if (swQaq.isChecked())
                tvQaq.setText("Qaq");
            else
                tvQaq.setText(" ");
        }

        private void Kum() {
            if (swKum.isChecked())
                tvKum.setText("Kum");
            else
                tvKum.setText(" ");
        }

        private void Boch() {
            if (swBoch.isChecked())
                tvBoch.setText("Boch");
            else
                tvBoch.setText(" ");
        }


    };

    private void swPrincipal() {
        swKaKya.setOnCheckedChangeListener(list);
        swChew.setOnCheckedChangeListener(list);
        swSiI.setOnCheckedChangeListener(list);
        swUJj.setOnCheckedChangeListener(list);
        swXar.setOnCheckedChangeListener(list);
        swPwaq.setOnCheckedChangeListener(list);
        swLaq.setOnCheckedChangeListener(list);
        swQaq.setOnCheckedChangeListener(list);
        swKum.setOnCheckedChangeListener(list);
        swBoch.setOnCheckedChangeListener(list);

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