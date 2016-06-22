package gt.lea.usaid.perfiladorlinguistico.view;

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

/**
 * Created by Roberto on 20/06/2016.
 */
public class SonidosEspecificos extends Activity implements View.OnClickListener, OnInitializeComponent {
    private Toolbar toolbar;
    private ViewFlipper vf;
    private TextView tvPelota, tvBota, tvNaranja, tvElote, tvMachete, tvMoto, tvHelado, tvTelefono, tvGallina, tvPerro;
    private RadioButton SiPelota, NoPelota, SiBota, NoBota, SiNaranja, NoNaranja, SiElote, NoElote, SiMachete, NoMachete, SiMoto, NoMoto, SiHelado, NoHelado, SiTelefono, NoTelefono, SiGallina, NoGallina, SiPerro, NoPerro;
    private Switch swPelota, swBota, swNaranja, swElote, swMachete, swMoto, swHelado, swTelefono, swGallina, swPerro;
    private int[] dr = {R.mipmap.book};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonidos_especificos);
        initToolBar();
        setOnInit(null);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.sonidos_especificos);
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SonidosEspecificos.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
                        Intent navigation_menu = new Intent(getApplication(), NavigationMenu.class);
                        startActivity(navigation_menu);

                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SiPelota2:
                vf.showNext();
                break;
            case R.id.NoPelota2:
                vf.showNext();
                break;
            case R.id.SiBota:
                vf.showNext();
                break;
            case R.id.NoBota:
                vf.showNext();
                break;
            case R.id.SiNaranja:
                vf.showNext();
                break;
            case R.id.NoNaranja:
                vf.showNext();
                break;
            case R.id.SiElote:
                vf.showNext();
                break;
            case R.id.NoElote:
                vf.showNext();
                break;
            case R.id.SiMachete:
                vf.showNext();
                break;
            case R.id.NoMachete:
                vf.showNext();
                break;
            case R.id.SiMoto:
                vf.showNext();
                break;
            case R.id.NoMoto:
                vf.showNext();
                break;
            case R.id.SiHelado:
                vf.showNext();
                break;
            case R.id.NoHelado:
                vf.showNext();
                break;
            case R.id.SiTelefono:
                vf.showNext();
                break;
            case R.id.NoTelefono:
                vf.showNext();
                break;
            case R.id.SiGallina:
                vf.showNext();
                break;
            case R.id.NoGallina:
                vf.showNext();
                break;
            case R.id.SiPerro:
                vf.showNext();
                Toast toast0 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast0.show();
                Intent pruebas = new Intent(getApplication(), Gramatica.class);
                startActivity(pruebas);
                break;
            case R.id.NoPerro:
                vf.showNext();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Evaluacion Finalizada", Toast.LENGTH_LONG);

                toast1.show();
                Intent pruebas2 = new Intent(getApplication(), Gramatica.class);
                startActivity(pruebas2);
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
        SiPelota = (RadioButton) findViewById(R.id.SiPelota2);
        NoPelota = (RadioButton) findViewById(R.id.NoPelota2);
        SiBota = (RadioButton) findViewById(R.id.SiBota);
        NoBota = (RadioButton) findViewById(R.id.NoBota);
        SiNaranja = (RadioButton) findViewById(R.id.SiNaranja);
        NoNaranja = (RadioButton) findViewById(R.id.NoNaranja);
        SiElote = (RadioButton) findViewById(R.id.SiElote);
        NoElote = (RadioButton) findViewById(R.id.NoElote);
        SiMachete = (RadioButton) findViewById(R.id.SiMachete);
        NoMachete = (RadioButton) findViewById(R.id.NoMachete);
        SiMoto = (RadioButton) findViewById(R.id.SiMoto);
        NoMoto = (RadioButton) findViewById(R.id.NoMoto);
        SiHelado = (RadioButton) findViewById(R.id.SiHelado);
        NoHelado = (RadioButton) findViewById(R.id.NoHelado);
        SiTelefono = (RadioButton) findViewById(R.id.SiTelefono);
        NoTelefono = (RadioButton) findViewById(R.id.NoTelefono);
        SiGallina = (RadioButton) findViewById(R.id.SiGallina);
        NoGallina = (RadioButton) findViewById(R.id.NoGallina);
        SiPerro = (RadioButton) findViewById(R.id.SiPerro);
        NoPerro = (RadioButton) findViewById(R.id.NoPerro);

        swPelota = (Switch) findViewById(R.id.swPelota2);
        tvPelota = (TextView) findViewById(R.id.tvPelota2);
        swBota = (Switch) findViewById(R.id.swBota);
        tvBota = (TextView) findViewById(R.id.tvBota);
        swNaranja = (Switch) findViewById(R.id.swNaranja);
        tvNaranja = (TextView) findViewById(R.id.tvNaranja);
        swElote = (Switch) findViewById(R.id.swElote);
        tvElote = (TextView) findViewById(R.id.tvElote);
        swMachete = (Switch) findViewById(R.id.swMachete);
        tvMachete = (TextView) findViewById(R.id.tvMachete);
        swMoto = (Switch) findViewById(R.id.swMoto);
        tvMoto = (TextView) findViewById(R.id.tvMoto);
        swHelado = (Switch) findViewById(R.id.swHelado);
        tvHelado = (TextView) findViewById(R.id.tvHelado);
        swTelefono = (Switch) findViewById(R.id.swTelefono);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        swGallina = (Switch) findViewById(R.id.swGallina);
        tvGallina = (TextView) findViewById(R.id.tvGallina);
        swPerro = (Switch) findViewById(R.id.swPerro);
        tvPerro = (TextView) findViewById(R.id.tvPerro);

        SiPelota.setOnClickListener(this);
        NoPelota.setOnClickListener(this);
        SiBota.setOnClickListener(this);
        NoBota.setOnClickListener(this);
        SiNaranja.setOnClickListener(this);
        NoNaranja.setOnClickListener(this);
        SiElote.setOnClickListener(this);
        NoElote.setOnClickListener(this);
        SiMachete.setOnClickListener(this);
        NoMachete.setOnClickListener(this);
        SiMoto.setOnClickListener(this);
        NoMoto.setOnClickListener(this);
        SiHelado.setOnClickListener(this);
        NoHelado.setOnClickListener(this);
        SiTelefono.setOnClickListener(this);
        NoTelefono.setOnClickListener(this);
        SiGallina.setOnClickListener(this);
        NoGallina.setOnClickListener(this);
        SiPerro.setOnClickListener(this);
        NoPerro.setOnClickListener(this);
        swPrincipal();
    }
    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            pelota();
            bota();
            naranja();
            elote();
            machete();
            moto();
            helado();
            telefono();
            gallina();
            perro();
        }
        private void pelota() {
            if (swPelota.isChecked())
                tvPelota.setText("Pelota");
            else
                tvPelota.setText("");
        }

        private void bota() {
            if (swBota.isChecked())
                tvBota.setText("Bota");
            else
                tvBota.setText(" ");
        }

        private void naranja() {
            if (swNaranja.isChecked())
                tvNaranja.setText("Naranja");
            else
                tvNaranja.setText(" ");
        }

        private void elote() {
            if (swElote.isChecked())
                tvElote.setText("Elote");
            else
                tvElote.setText("");
        }

        private void machete() {
            if (swMachete.isChecked())
                tvMachete.setText("Machete");
            else
                tvMachete.setText(" ");
        }

        private void moto() {
            if (swMoto.isChecked())
                tvMoto.setText("Moto");
            else
                tvMoto.setText(" ");
        }

        private void helado() {
            if (swHelado.isChecked())
                tvHelado.setText("Helado");
            else
                tvHelado.setText(" ");
        }

        private void telefono() {
            if (swTelefono.isChecked())
                tvTelefono.setText("Telefono");
            else
                tvTelefono.setText(" ");
        }

        private void gallina() {
            if (swGallina.isChecked())
                tvGallina.setText("Gallina");
            else
                tvGallina.setText(" ");
        }

        private void perro() {
            if (swPerro.isChecked())
                tvPerro.setText("Perro");
            else
                tvPerro.setText(" ");
        }


    };

    private void swPrincipal() {
        swPelota.setOnCheckedChangeListener(list);
        swBota.setOnCheckedChangeListener(list);
        swNaranja.setOnCheckedChangeListener(list);
        swElote.setOnCheckedChangeListener(list);
        swMachete.setOnCheckedChangeListener(list);
        swMoto.setOnCheckedChangeListener(list);
        swHelado.setOnCheckedChangeListener(list);
        swTelefono.setOnCheckedChangeListener(list);
        swGallina.setOnCheckedChangeListener(list);
        swPerro.setOnCheckedChangeListener(list);

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
}