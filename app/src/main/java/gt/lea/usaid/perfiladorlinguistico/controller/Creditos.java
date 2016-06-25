package gt.lea.usaid.perfiladorlinguistico.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.NavigationMenu;
import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 22/06/16.
 */
public class Creditos extends Activity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditos);
        initToolBar();
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.gramatica);
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Creditos.this, "Pruebas!", Toast.LENGTH_SHORT).show();
                        Intent navigation_menu = new Intent(getApplication(),NavigationMenu.class );
                        startActivity(navigation_menu);

                    }
                }
        );

    }

}
