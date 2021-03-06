package gt.lea.usaid.perfiladorlinguistico;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import gt.lea.usaid.perfiladorlinguistico.controller.usaid.GuiaEvaluacion;
import gt.lea.usaid.perfiladorlinguistico.controller.usaid.IniciarEvaluacion;
import gt.lea.usaid.perfiladorlinguistico.controller.usaid.ResultadosAula;
import gt.lea.usaid.perfiladorlinguistico.utils.Localizacion;
import gt.lea.usaid.perfiladorlinguistico.view.Creditos;
import gt.lea.usaid.perfiladorlinguistico.view.Email;
import gt.lea.usaid.perfiladorlinguistico.view.InitEvaluacion;
import gt.lea.usaid.perfiladorlinguistico.view.RegistroEvaluar;

public class NavigationMenu
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        GuiaEvaluacion.OnFragmentInteractionListener, IniciarEvaluacion.OnFragmentInteractionListener,
        ResultadosAula.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Fabric.with(this, new Crashlytics());
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new GuiaEvaluacion();
        fragmentManager.beginTransaction().replace(R.id.content_navigation_menu, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.enviar_informacion) {
            Intent intent = new Intent(this, Localizacion.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.sincronizar){
            Intent intent = new Intent(this, Email.class);
            startActivity(intent);
        }
        if (id == R.id.creditos){
            Intent intent = new Intent(this, Creditos.class);
            startActivity(intent);
        }
        if (id == R.id.registro_evaluar){
            Intent intent = new Intent(this, RegistroEvaluar.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent i = null;
        Class<?> clas = null;

        boolean FragmentTransaction = false;
        Fragment fragment = null;

        if (id == R.id.nav_iniciar_evaluacion) {
            //fragment = new IniciarEvaluacion();
            clas = InitEvaluacion.class;
            FragmentTransaction = false;
        } else if (id == R.id.nav_guia_evaluador) {
            fragment = new GuiaEvaluacion();
            FragmentTransaction = true;
        } else if (id == R.id.nav_resultados_por_aula) {
            fragment = new ResultadosAula();
            FragmentTransaction = true;

        }else if (id ==  R.id.nav_entrevista) {
            clas = Entrevistas.class;
            //Intent i = new Intent(NavigationMenu.this, clas);
            //startActivity(i);
        }


        if (FragmentTransaction == true) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_navigation_menu, fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }else {
            if(clas != null){
                i = new Intent(NavigationMenu.this, clas);
                startActivity(i);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
