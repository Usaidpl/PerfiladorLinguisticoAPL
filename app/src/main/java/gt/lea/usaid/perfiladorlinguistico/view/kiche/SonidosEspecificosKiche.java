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
public class SonidosEspecificosKiche extends Activity implements View.OnClickListener, OnInitializeComponent {

    private ViewFlipper vf;
    private TextView tvInstruccSonidoskiche, tvInst_titulo_kiche,tvKa, tvSiii, tvChee, tvPapalot, tvNosQel, tvChat, tvTzUnun, tvKotzij, tvQam, tvQaq;
    private RadioButton SiKa, NoKa, SiSiii, NoSiii, SiChee, NoChee, SiPapalot, NoPapalot, SiNosQel, NoNosQel, SiChat, NoChat, SiTzUnun, NoTzUnun, SiKotzij, NoKotzij, SiQam, NoQam, SiQaq, NoQaq;
    private Switch swKa, swSiii, swChee, swPapalot, swNosQel, swChat, swTzUnun, swKotzij, swQam, swQaq;
    private int[] dr = {R.mipmap.book};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonidos_especificos_kiche);
        setOnInit(null);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiKa2:
                vf.showNext();
                tvInstruccSonidoskiche.setText("");
                break;
            case R.id.NoKa2:
                vf.showNext();
                tvInstruccSonidoskiche.setText("");
                break;
            case R.id.SiSiii:
                vf.showNext();
                break;
            case R.id.NoSiii:
                vf.showNext();
                break;
            case R.id.SiChee:
                vf.showNext();
                break;
            case R.id.NoChee:
                vf.showNext();
                break;
            case R.id.SiPapalot:
                vf.showNext();
                break;
            case R.id.NoPapalot:
                vf.showNext();
                break;
            case R.id.SiNosQel:
                vf.showNext();
                break;
            case R.id.NoNosQel:
                vf.showNext();
                break;
            case R.id.SiChat:
                vf.showNext();
                tvInst_titulo_kiche.setText(R.string.titulo_sonidos_especificos_kiche);
                tvInstruccSonidoskiche.setText(R.string.inst_sonidos_especificos_kiche);
                break;
            case R.id.NoChat:
                vf.showNext();
                tvInst_titulo_kiche.setText(R.string.titulo_sonidos_especificos_kiche);
                tvInstruccSonidoskiche.setText(R.string.inst_sonidos_especificos_kiche);
                break;
            case R.id.SiTzUnun:
                vf.showNext();
                tvInstruccSonidoskiche.setText("");
                break;
            case R.id.NoTzUnun:
                tvInstruccSonidoskiche.setText("");
                vf.showNext();
                break;
            case R.id.SiKotzij:
                vf.showNext();
                break;
            case R.id.NoKotzij:
                vf.showNext();
                break;
            case R.id.SiQam:
                vf.showNext();
                break;
            case R.id.NoQam:
                vf.showNext();
                break;
            case R.id.SiQaq:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Serie finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent gramatica1 = new Intent(getApplication(), GramaticaKiche.class);
                startActivity(gramatica1);
                break;
            case R.id.NoQaq:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Serie finalizada", Toast.LENGTH_LONG);

                toast1.show();
                Intent gramatica2 = new Intent(getApplication(), GramaticaKiche.class);
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
        SiKa = (RadioButton) findViewById(R.id.SiKa2);
        NoKa = (RadioButton) findViewById(R.id.NoKa2);
        SiSiii = (RadioButton) findViewById(R.id.SiSiii);
        NoSiii = (RadioButton) findViewById(R.id.NoSiii);
        SiChee = (RadioButton) findViewById(R.id.SiChee);
        NoChee = (RadioButton) findViewById(R.id.NoChee);
        SiPapalot = (RadioButton) findViewById(R.id.SiPapalot);
        NoPapalot = (RadioButton) findViewById(R.id.NoPapalot);
        SiNosQel = (RadioButton) findViewById(R.id.SiNosQel);
        NoNosQel = (RadioButton) findViewById(R.id.NoNosQel);
        SiChat = (RadioButton) findViewById(R.id.SiChat);
        NoChat = (RadioButton) findViewById(R.id.NoChat);
        SiTzUnun = (RadioButton) findViewById(R.id.SiTzUnun);
        NoTzUnun = (RadioButton) findViewById(R.id.NoTzUnun);
        SiKotzij = (RadioButton) findViewById(R.id.SiKotzij);
        NoKotzij = (RadioButton) findViewById(R.id.NoKotzij);
        SiQam = (RadioButton) findViewById(R.id.SiQam);
        NoQam = (RadioButton) findViewById(R.id.NoQam);
        SiQaq = (RadioButton) findViewById(R.id.SiQaq);
        NoQaq = (RadioButton) findViewById(R.id.NoQaq);

        swKa = (Switch) findViewById(R.id.swKa2);
        tvKa = (TextView) findViewById(R.id.tvKa2);
        swSiii = (Switch) findViewById(R.id.swSiii);
        tvSiii = (TextView) findViewById(R.id.tvSiii);
        swChee = (Switch) findViewById(R.id.swChee);
        tvChee = (TextView) findViewById(R.id.tvChee);
        swPapalot = (Switch) findViewById(R.id.swPapalot);
        tvPapalot = (TextView) findViewById(R.id.tvPapalot);
        swNosQel = (Switch) findViewById(R.id.swNosQel);
        tvNosQel = (TextView) findViewById(R.id.tvNosQel);
        swChat = (Switch) findViewById(R.id.swChat);
        tvChat = (TextView) findViewById(R.id.tvChat);
        swTzUnun = (Switch) findViewById(R.id.swTzUnun);
        tvTzUnun = (TextView) findViewById(R.id.tvTzUnun);
        swKotzij = (Switch) findViewById(R.id.swKotzij);
        tvKotzij = (TextView) findViewById(R.id.tvKotzij);
        swQam = (Switch) findViewById(R.id.swQam);
        tvQam = (TextView) findViewById(R.id.tvQam);
        swQaq = (Switch) findViewById(R.id.swQaq);
        tvQaq = (TextView) findViewById(R.id.tvQaq);
        tvInstruccSonidoskiche = (TextView) findViewById(R.id.tvInstruccSonidosKiche);
        tvInst_titulo_kiche = (TextView) findViewById(R.id.tvInst_titulo_kiche);
        SiKa.setOnClickListener(this);
        NoKa.setOnClickListener(this);
        SiSiii.setOnClickListener(this);
        NoSiii.setOnClickListener(this);
        SiChee.setOnClickListener(this);
        NoChee.setOnClickListener(this);
        SiPapalot.setOnClickListener(this);
        NoPapalot.setOnClickListener(this);
        SiNosQel.setOnClickListener(this);
        NoNosQel.setOnClickListener(this);
        SiChat.setOnClickListener(this);
        NoChat.setOnClickListener(this);
        SiTzUnun.setOnClickListener(this);
        NoTzUnun.setOnClickListener(this);
        SiKotzij.setOnClickListener(this);
        NoKotzij.setOnClickListener(this);
        SiQam.setOnClickListener(this);
        NoQam.setOnClickListener(this);
        SiQaq.setOnClickListener(this);
        NoQaq.setOnClickListener(this);
        swPrincipal();
    }
    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Ka();
            Siii();
            Chee();
            Papalot();
            NosQel();
            Chat();
            TzUnun();
            Kotzij();
            Qam();
            Qaq();
        }
        private void Ka() {
            if (swKa.isChecked())
                tvKa.setText("Ka'");
            else
                tvKa.setText("");
        }

        private void Siii() {
            if (swSiii.isChecked())
                tvSiii.setText("Si'");
            else
                tvSiii.setText(" ");
        }

        private void Chee() {
            if (swChee.isChecked())
                tvChee.setText("Che'");
            else
                tvChee.setText(" ");
        }

        private void Papalot() {
            if (swPapalot.isChecked())
                tvPapalot.setText("Papalo't");
            else
                tvPapalot.setText("");
        }

        private void NosQel() {
            if (swNosQel.isChecked())
                tvNosQel.setText("No's / Qu'l");
            else
                tvNosQel.setText(" ");
        }

        private void Chat() {
            if (swChat.isChecked())
                tvChat.setText("Ch'at");
            else
                tvChat.setText(" ");
        }

        private void TzUnun() {
            if (swTzUnun.isChecked())
                tvTzUnun.setText("Tz'Unun");
            else
                tvTzUnun.setText(" ");
        }

        private void Kotzij() {
            if (swKotzij.isChecked())
                tvKotzij.setText("Kotz'i'j");
            else
                tvKotzij.setText(" ");
        }

        private void Qam() {
            if (swQam.isChecked())
                tvQam.setText("Q'a'm");
            else
                tvQam.setText(" ");
        }

        private void Qaq() {
            if (swQaq.isChecked())
                tvQaq.setText("Q'aq'");
            else
                tvQaq.setText(" ");
        }


    };

    private void swPrincipal() {
        swKa.setOnCheckedChangeListener(list);
        swSiii.setOnCheckedChangeListener(list);
        swChee.setOnCheckedChangeListener(list);
        swPapalot.setOnCheckedChangeListener(list);
        swNosQel.setOnCheckedChangeListener(list);
        swChat.setOnCheckedChangeListener(list);
        swTzUnun.setOnCheckedChangeListener(list);
        swKotzij.setOnCheckedChangeListener(list);
        swQam.setOnCheckedChangeListener(list);
        swQaq.setOnCheckedChangeListener(list);

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