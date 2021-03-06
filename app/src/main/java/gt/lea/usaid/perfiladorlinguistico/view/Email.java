package gt.lea.usaid.perfiladorlinguistico.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class Email extends Activity implements OnInitializeComponent, View.OnClickListener {

    private EditText nombre, codigo, grado, seccion, correo, asunto;
    private ImageView envia;
    private String ce,n, c, g, s, a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.activity_email);
            setOnInit(null);
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        nombre = (EditText) findViewById(R.id.etNombre);
        codigo = (EditText) findViewById(R.id.etCodigo);
        grado = (EditText) findViewById(R.id.etGrado);
        seccion = (EditText) findViewById(R.id.etSeccion);
        correo = (EditText) findViewById(R.id.etCorreo);
        asunto = (EditText) findViewById(R.id.etAsunto);
        envia = (ImageView) findViewById(R.id.ivCorreo);
        envia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ediTextToString();
        String[] cuerpo = null;

        String direccion_correo[] = {ce};
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL, direccion_correo);
        i.putExtra(Intent.EXTRA_SUBJECT, "Android App");
        i.setType("image/png");
        i.putExtra(Intent.EXTRA_TEXT, cuerpo);
        i.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.back));
        startActivity(i);
    }

    private void ediTextToString(){
        ce = correo.toString().trim();
        n = nombre.toString().trim();
        c = codigo.toString().trim();
        g = grado.toString().trim();
        s = seccion.toString().trim();

        a = asunto.toString().trim();
    }
}