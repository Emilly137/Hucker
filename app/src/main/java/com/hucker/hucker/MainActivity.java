package com.hucker.hucker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import fragments.Fragment_AboutUs;
import fragments.Fragment_Events;
import fragments.Fragment_Feedback;
import fragments.Fragment_Lessons;
import fragments.Fragment_News;
import fragments.Fragment_Places;
import fragments.Fragment_Products;
import fragments.Fragment_Progress;
import fragments.Fragment_Question_Discuss;
import fragments.Fragment_Session_Notes;
import fragments.Fragment_Settings;
import fragments.Fragment_Share;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
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


    Fragment fragment = null;
    Class fragmentClass = null;

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lessons) {
            fragmentClass = Fragment_Lessons.class;
        } else if (id == R.id.nav_progress) {
            fragmentClass = Fragment_Progress.class;
        } else if (id == R.id.nav_news) {
            fragmentClass = Fragment_News.class;
        } else if (id == R.id.nav_events) {
            fragmentClass = Fragment_Events.class;
        } else if (id == R.id.nav_products) {
            fragmentClass = Fragment_Products.class;
        } else if (id == R.id.nav_sessionnotes) {
            fragmentClass = Fragment_Session_Notes.class;
        } else if (id == R.id.nav_discuss) {
            fragmentClass = Fragment_Question_Discuss.class;
        } else if (id == R.id.nav_places) {
            fragmentClass = Fragment_Places.class;
        } else if (id == R.id.nav_settings ) {
            fragmentClass = Fragment_Settings.class;
        } else if (id == R.id.nav_share) {
            fragmentClass = Fragment_Share.class;
        } else if (id == R.id.nav_feedback ) {
            fragmentClass = Fragment_Feedback.class;
        } else if (id == R.id.nav_aboutus) {
            fragmentClass = Fragment_AboutUs.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Вставляем фрагмент, заменяя текущий фрагмент
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке
        setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
