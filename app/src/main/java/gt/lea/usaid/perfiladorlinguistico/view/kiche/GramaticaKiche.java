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

public class GramaticaKiche  extends Activity implements View.OnClickListener, OnInitializeComponent {
    private ViewFlipper vf;
    private TextView title_gramatica_kiche, tvInstrGramaticaKiche, tvXajab, tvTaqXajab, tvMes, tvTaqMes, tvAli, tvTatAchi, tvMamTat, tvAkTux;
    private RadioButton SiXajab, NoXajab, SiTaqXajab, NoTaqXajab, SiMes, NoMes, SiTaqMes, NoTaqMes, SiAli, NoAli, SiTatAchi, NoTatAchi, SiMamTat, NoMamTat, SiAkTux, NoAkTux;
    private Switch SwXajab, SwTaqXajab, SwMes, SwTaqMes, SwAli, SwTatAchi, SwMamTat, SwAkTux;
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
            case R.id.SiXajab:
                vf.showNext();
                tvInstrGramaticaKiche.setText("");
                break;
            case R.id.NoXajab:
                vf.showNext();
                tvInstrGramaticaKiche.setText("");
                break;
            case R.id.SiTaqXajab:
                vf.showNext();
                break;
            case R.id.NoTaqXajab:
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
                title_gramatica_kiche.setText("UCH'AB'EXIK (AMA, ATIT)\nGÉNERO GRAMATICAL (MASCULINO FEMENINO");
                tvInstrGramaticaKiche.setText("Ub'eyal / Instrucciones\n" +
                        "K'utu la chikijujunal taq ru wachib'al, kata la ri k'otb'al chi', k'ate k'uri', katz'ib'aj la ri utzalaj tzalim tzij chi uach ri wuj.");
                break;
            case R.id.NoTaqMes:
                vf.showNext();
                title_gramatica_kiche.setText("UCH'AB'EXIK (AMA, ATIT)\n" +
                        "GÉNERO GRAMATICAL (MASCULINO FEMENINO");
                tvInstrGramaticaKiche.setText("Ub'eyal / Instrucciones\nK'utu la chikijujunal taq ru wachib'al, kata la ri k'otb'al chi', k'ate k'uri', katz'ib'aj la ri utzalaj tzalim tzij chi uach ri wuj.");
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
                                "Serie finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent expresionoral = new Intent(getApplication(), ExpresionOralKiche.class);
                startActivity(expresionoral);
                break;
            case R.id.NoAkTux:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Serie finalizada", Toast.LENGTH_LONG);

                toast1.show();
                Intent expresionoral2 = new Intent(getApplication(), ExpresionOralKiche.class);
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


        SiXajab = (RadioButton) findViewById(R.id.SiXajab);
        NoXajab = (RadioButton) findViewById(R.id.NoXajab);
        SiTaqXajab = (RadioButton) findViewById(R.id.SiTaqXajab);
        NoTaqXajab = (RadioButton) findViewById(R.id.NoTaqXajab);
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

        SwXajab = (Switch) findViewById(R.id.swXajab);
        tvXajab = (TextView) findViewById(R.id.tvXajab);
        SwTaqXajab = (Switch) findViewById(R.id.swTaqXajab);
        tvTaqXajab = (TextView) findViewById(R.id.tvTaqXajab);
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
        title_gramatica_kiche = (TextView) findViewById(R.id.title_gramatica_kiche_kiche);

        SiXajab.setOnClickListener(this);
        NoXajab.setOnClickListener(this);
        SiTaqXajab.setOnClickListener(this);
        NoTaqXajab.setOnClickListener(this);
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
            Xajab();
            TaqXajab();
            mes();
            taqmes();
            ali();
            tatachi();
            mamtat();
            aktux();


        }

        private void Xajab() {
            if (SwXajab.isChecked())
                tvXajab.setText("Xajab");
            else
                tvXajab.setText("");
        }

        private void TaqXajab() {
            if (SwTaqXajab.isChecked())
                tvTaqXajab.setText("TaqXajab");
            else
                tvTaqXajab.setText(" ");
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
                tvAli.setText("Ali");
            else
                tvAli.setText("Are jun ala.\n¿Su ub'ixik we k'o ruq?");
        }

        private void tatachi() {
            if (SwTatAchi.isChecked())
                tvTatAchi.setText("Tat / Achi");
            else
                tvTatAchi.setText("Are jun chichu'.\n¿Su ub'ixk we k'o rismachi?");
        }

        private void mamtat() {
            if (SwMamTat.isChecked())
                tvMamTat.setText("Mam / Tat");
            else
                tvMamTat.setText("Are jun ti't.\n¿Si ib'ixik we k'o upwi?");
        }

        private void aktux() {
            if (SwAkTux.isChecked())
                tvAkTux.setText("ak' / tux ");
            else
                tvAkTux.setText("pregunta pendiente por falta de material en la guía..");
        }


    };

    private void swPrincipal() {
        SwTaqMes.setOnCheckedChangeListener(list);
        SwXajab.setOnCheckedChangeListener(list);
        SwTaqXajab.setOnCheckedChangeListener(list);
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
