package gt.lea.usaid.perfiladorlinguistico;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.models.BaseHelper;

public class Entrevistas extends AppCompatActivity {

    EditText  et_nombre, et_cargo, et_fecha, et_escuela, et_codigo, et_municipio, et_departamento, et_ciclo ;
    Button  bt_mostrar, bt_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrevistas);

        et_nombre    =(EditText) findViewById(R.id.et_nombre);
        et_cargo     =(EditText) findViewById(R.id.et_cargo);
        et_fecha     =(EditText) findViewById(R.id.et_fecha);
        et_escuela   =(EditText) findViewById(R.id.et_escuela);
        et_codigo    =(EditText) findViewById(R.id.et_codigo);
        et_municipio =(EditText) findViewById(R.id.et_municipio);
        et_departamento =(EditText) findViewById(R.id.et_departamento);
        et_ciclo     =(EditText) findViewById(R.id.et_ciclo);

        bt_guardar =(Button) findViewById(R.id.bt_guardar);
        bt_mostrar = (Button)findViewById(R.id.bt_mostrar);

        bt_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(et_nombre.getText().toString(), et_cargo.getText().toString(), et_fecha.getText().toString(), et_escuela.getText().toString(),
                        et_codigo.getText().toString(), et_municipio.getText().toString(), et_departamento.getText().toString(),et_ciclo.getText().toString());
            }
        });
        bt_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(Entrevistas.this, Listado.class) );
            }
        });

    }

    private void guardar(String Nombre, String Cargo, String Fecha,String Escuela, String Codigo,
                         String Municipio, String Departamento, String Ciclo){

        BaseHelper helper = new BaseHelper(this, "Perfilador",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            ContentValues c= new ContentValues();
            c.put("Nombre", Nombre);
            c.put("Cargo", Cargo);
            c.put("Fecha", Fecha);
            c.put("Escuela",Escuela);
            c.put("Codigo", Codigo);
            c.put("Municipio", Municipio);
            c.put("Departamento", Departamento);
            c.put("Ciclo", Ciclo);


            db.insert("entrevistador", null, c);
            db.close();
            Toast.makeText(this,"Registro insertado",Toast.LENGTH_SHORT).show();


        }catch (Exception e ){

            Toast.makeText(this,"Error: " + e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    }
}

