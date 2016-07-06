package gt.lea.usaid.perfiladorlinguistico.view.mam;

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

public class GramaticaMam extends Activity implements View.OnClickListener, OnInitializeComponent {

    private ViewFlipper vf;
    private TextView title_gramatica_mam, tvInstruccGramaticaMam, tvIx, tvQeoxKyajix, tvWix, tvQewixOxwix, tvTtxuTxyan, tvTtxuEkTtxuik, tvTtxritKnel, Txubaj;
    private RadioButton SiIx, NoIx, SiQeoxKyajix, NoQeoxKyajix, SiWix, NoWix, SiQewixOxwix, NoQewixOxwix, SiTtxuTxyan, NoTtxuTxyan, SiTtxuEkTtxuik, NoTtxuEkTtxuik, SiTtxritKnel, NoTtxritKnel, SiTxubaj, NoSiTxubaj;
    private Switch SwIx, SwQeoxKyajix, SwQewixOxwix, SwWix, SwTtxuTxyan, SwTtxuEkTtxuik, SwTtxritKnel, SwChef;
    private int[] dr = {R.mipmap.book};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gramatica_mam);

        setOnInit(null);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiIx:
                vf.showNext();
                tvInstruccGramaticaMam.setText("");
                break;
            case R.id.NoIx:
                vf.showNext();
                tvInstruccGramaticaMam.setText("");
                break;
            case R.id.SiQeoxKyajix:
                vf.showNext();
                break;
            case R.id.NoQeoxKyajix:
                vf.showNext();
                break;
            case R.id.SiWix:
                vf.showNext();
                break;
            case R.id.NoWix:
                vf.showNext();
                title_gramatica_mam.setText(R.string.titulo_gramatica_mam_masculino_femenino);
                tvInstruccGramaticaMam.setText(R.string.instr_gramatica_mam_masculino_femenino);
                break;
            case R.id.SiQewixOxwix:
                vf.showNext();
                title_gramatica_mam.setText("GENERO GRAMATICAL (MASCULINO Y FEMENINO)");
                tvInstruccGramaticaMam.setText("Responda correctamente cada pregunta planteada en los siguientes casos");
                break;
            case R.id.NoQewixOxwix:
                vf.showNext();
                title_gramatica_mam.setText("GENERO GRAMATICAL (MASCULINO Y FEMENINO)");
                tvInstruccGramaticaMam.setText("Responda correctamente cada pregunta planteada en los siguientes casos");
                break;
            case R.id.SiTtxuTxyan:
                vf.showNext();
                tvInstruccGramaticaMam.setText("");
                break;
            case R.id.NoTtxuTxyan:
                vf.showNext();
                tvInstruccGramaticaMam.setText("");
                break;
            case R.id.SiTtxuEkTtxuik:
                vf.showNext();
                break;
            case R.id.NoTtxuEkTtxuik:
                vf.showNext();
                break;
            case R.id.SiTtxritKnel:
                vf.showNext();
                break;
            case R.id.NoTtxritKnel:
                vf.showNext();
                break;
            case R.id.SiTxubaj:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent expresionoral = new Intent(getApplication(), ExpresionOralMam.class);
                startActivity(expresionoral);
                break;
            case R.id.NoSiTxubaj:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast1.show();
                Intent expresionoral2 = new Intent(getApplication(), ExpresionOralMam.class);
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


        SiIx = (RadioButton) findViewById(R.id.SiIx);
        NoIx = (RadioButton) findViewById(R.id.NoIx);
        SiQeoxKyajix = (RadioButton) findViewById(R.id.SiQeoxKyajix);
        NoQeoxKyajix = (RadioButton) findViewById(R.id.NoQeoxKyajix);
        SiWix = (RadioButton) findViewById(R.id.SiWix);
        NoWix = (RadioButton) findViewById(R.id.NoWix);
        SiQewixOxwix = (RadioButton) findViewById(R.id.SiQewixOxwix);
        NoQewixOxwix = (RadioButton) findViewById(R.id.NoQewixOxwix);
        SiTtxuTxyan = (RadioButton) findViewById(R.id.SiTtxuTxyan);
        NoTtxuTxyan = (RadioButton) findViewById(R.id.NoTtxuTxyan);
        SiTtxuEkTtxuik = (RadioButton) findViewById(R.id.SiTtxuEkTtxuik);
        NoTtxuEkTtxuik = (RadioButton) findViewById(R.id.NoTtxuEkTtxuik);
        SiTtxritKnel = (RadioButton) findViewById(R.id.SiTtxritKnel);
        NoTtxritKnel = (RadioButton) findViewById(R.id.NoTtxritKnel);
        SiTxubaj = (RadioButton) findViewById(R.id.SiTxubaj);
        NoSiTxubaj = (RadioButton) findViewById(R.id.NoSiTxubaj);

        SwIx = (Switch) findViewById(R.id.swIx);
        tvIx = (TextView) findViewById(R.id.tvIx);
        SwQeoxKyajix = (Switch) findViewById(R.id.swQeoxKyajix);
        tvQeoxKyajix = (TextView) findViewById(R.id.tvQeoxKyajix);
        SwWix = (Switch) findViewById(R.id.swWix);
        tvWix = (TextView) findViewById(R.id.tvWix);
        SwQewixOxwix = (Switch) findViewById(R.id.swQewixOxwix);
        tvQewixOxwix = (TextView) findViewById(R.id.tvQewixOxwix);
        SwTtxuTxyan = (Switch) findViewById(R.id.swTtxuTxyan);
        tvTtxuTxyan = (TextView) findViewById(R.id.tvTtxuTxyan);
        SwTtxuEkTtxuik = (Switch) findViewById(R.id.swTtxuEkTtxuik);
        tvTtxuEkTtxuik = (TextView) findViewById(R.id.tvTtxuEkTtxuik);
        SwTtxritKnel = (Switch) findViewById(R.id.swTtxritKnel);
        tvTtxritKnel = (TextView) findViewById(R.id.tvTtxritKnel);
        SwChef = (Switch) findViewById(R.id.swChef);
        Txubaj = (TextView) findViewById(R.id.Txubaj);
        tvInstruccGramaticaMam = (TextView) findViewById(R.id.tvInstruccGramaticaMam);
        title_gramatica_mam = (TextView) findViewById(R.id.title_gramatica_mam);

        SiIx.setOnClickListener(this);
        NoIx.setOnClickListener(this);
        SiQeoxKyajix.setOnClickListener(this);
        NoQeoxKyajix.setOnClickListener(this);
        SiWix.setOnClickListener(this);
        NoWix.setOnClickListener(this);
        SiQewixOxwix.setOnClickListener(this);
        NoQewixOxwix.setOnClickListener(this);
        SiTtxuTxyan.setOnClickListener(this);
        NoTtxuTxyan.setOnClickListener(this);
        SiTtxuEkTtxuik.setOnClickListener(this);
        NoTtxuEkTtxuik.setOnClickListener(this);
        SiTtxritKnel.setOnClickListener(this);
        NoTtxritKnel.setOnClickListener(this);
        SiTxubaj.setOnClickListener(this);
        NoSiTxubaj.setOnClickListener(this);
        swPrincipal();
    }

    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Ix();
            QeoxKyajix();
            Wix();
            QewixOxwix();
            TtxuTxyan();
            TtxuEkTtxuik();
            TtxritKnel();
            chef();


        }

        private void Ix() {
            if (SwIx.isChecked())
                tvIx.setText("I'x");
            else
                tvIx.setText("");
        }

        private void QeoxKyajix() {
            if (SwQeoxKyajix.isChecked())
                tvQeoxKyajix.setText("Qe'ox / Kyaj i'x");
            else
                tvQeoxKyajix.setText(" ");
        }

        private void Wix() {
            if (SwWix.isChecked())
                tvWix.setText("Wix");
            else
                tvWix.setText(" ");
        }

        private void QewixOxwix() {
            if (SwQewixOxwix.isChecked())
                tvQewixOxwix.setText("Qe'wix / Ox wix / Oxe wix");
            else
                tvQewixOxwix.setText("");
        }

        private void TtxuTxyan() {
            if (SwTtxuTxyan.isChecked())
                tvTtxuTxyan.setText("TtxuTxyan");
            else
                tvTtxuTxyan.setText("Esta es una Abuela, si fuera hombre ¿cómo se diría?");
        }

        private void TtxuEkTtxuik() {
            if (SwTtxuEkTtxuik.isChecked())
                tvTtxuEkTtxuik.setText("TtxuEkTtxuik");
            else
                tvTtxuEkTtxuik.setText("Este es un maestro, si fuera una mujer ¿cómo se diría?");
        }

        private void TtxritKnel() {
            if (SwTtxritKnel.isChecked())
                tvTtxritKnel.setText("TtxritKnel");
            else
                tvTtxritKnel.setText("Este es un doctor, si fuera mujer ¿cómo se diría?");
        }

        private void chef() {
            if (SwChef.isChecked())
                Txubaj.setText("Cociera / ");
            else
                Txubaj.setText("Este es un cocinero, si fuera mujer ¿cómo se diría?");
        }


    };

    private void swPrincipal() {
        SwWix.setOnCheckedChangeListener(list);
        SwIx.setOnCheckedChangeListener(list);
        SwQeoxKyajix.setOnCheckedChangeListener(list);
        SwWix.setOnCheckedChangeListener(list);
        SwTtxuTxyan.setOnCheckedChangeListener(list);
        SwQewixOxwix.setOnCheckedChangeListener(list);
        SwTtxuEkTtxuik.setOnCheckedChangeListener(list);
        SwTtxritKnel.setOnCheckedChangeListener(list);
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