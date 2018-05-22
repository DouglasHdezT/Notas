package com.debugps.notas;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.debugps.notas.fragments.ActualizarFragment;
import com.debugps.notas.fragments.BuscarFragment;
import com.debugps.notas.fragments.IngresarFragment;
import com.debugps.notas.fragments.MainFragment;
import com.debugps.notas.fragments.MostrarFragment;
import com.debugps.notas.interfaces.FragControl;

public class MainActivity extends AppCompatActivity implements FragControl {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        NavigationView mNavigationView = findViewById(R.id.nav_layout);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_frame_layout, new MainFragment());
        fragmentTransaction.addToBackStack("MainFrag");

        fragmentTransaction.commit();


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(true);
                mDrawerLayout.closeDrawers();

                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                Fragment f;
                switch (item.getItemId()){
                    case R.id.home_nav:
                        f= new MainFragment();
                        break;

                    case R.id.ingresar_nav:
                        f= new IngresarFragment();
                        break;

                    case R.id.mostrar_nav:
                        f= new MostrarFragment();
                        break;

                    case R.id.actualizar_nav:
                        f = new ActualizarFragment();
                        break;

                    case R.id.buscar_nav:
                        f = new BuscarFragment();
                        break;

                    default:
                        f = new MainFragment();
                        break;
                }

                fragmentTransaction1.replace(R.id.main_frame_layout, f);
                fragmentTransaction1.commit();

                return true;
            }
        });
    }

    @Override
    public void iniciarFragmento(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
