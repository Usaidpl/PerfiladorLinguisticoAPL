package gt.lea.usaid.perfiladorlinguistico.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.net.URI;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.ResultadosAula;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class Email extends Activity implements OnInitializeComponent, View.OnClickListener {

    private EditText nombre, codigo, grado, seccion, correo, asunto;
    private ImageView envia;
    private String ce,n, c, g, s, a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        nombre = (EditText) findViewById(R.id.etNombre);
        codigo = (EditText) findViewById(R.id.etCodigo);
        grado = (EditText) findViewById(R.id.etGrado);
        seccion = (EditText) findViewById(R.id.etSeccion);
        correo = (EditText) findViewById(R.id.etDireccion);
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

    private String consulta(String[] condicion){
        String sentencia = "SELECT * FROM table1 INNER JOIN table2 INNER JOIN tableN " +
                "WHERE " ;
        for(int i = 0; i < condicion.length; i ++){
            if((i + 1) != condicion.length){
                sentencia += condicion[i] + " AND ";
            }else
                sentencia += condicion[i];
        }
        return sentencia;
    }
}
