package com.caucaragp.worldskills.turisapp.controllers;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.caucaragp.worldskills.turisapp.R;
import com.caucaragp.worldskills.turisapp.fragments.HotelesFragment;
import com.caucaragp.worldskills.turisapp.fragments.RestaurantesFragment;
import com.caucaragp.worldskills.turisapp.fragments.SitiosFragment;
import com.caucaragp.worldskills.turisapp.models.Lugares;

public class MenuT extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static Lugares lugar = new Lugares();
    String nombre ="Inicio";

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_t);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        navigationView.setItemTextColor(ColorStateList.valueOf(getColor(R.color.cafe)));
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
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_t, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment;
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            nombre = "Inicio";
            getSupportActionBar().setTitle(nombre);

            //getActionBar().setTitle("Inicio");

        } else if (id == R.id.nav_gallery) {
            fragment = new HotelesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();

            nombre = "Hoteles";
            getSupportActionBar().setTitle(nombre);


        } else if (id == R.id.nav_slideshow) {
            fragment = new RestaurantesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();

            nombre = "Restaurantes";
            getSupportActionBar().setTitle(nombre);


        } else if (id == R.id.nav_slideshow) {



        } else if (id == R.id.nav_manage) {
            fragment = new SitiosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();

            nombre = "Sitios";
            getSupportActionBar().setTitle(nombre);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
