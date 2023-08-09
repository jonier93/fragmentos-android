package com.example.bara_navegacion_clase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView barraNav;
    private Fragment fragmentHome;
    private Fragment fragmentProfile;
    private Fragment fragmentHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        visualizar_fragmento(fragmentHome);
        barraNav.setOnItemSelectedListener(item -> {
            int item_id = item.getItemId();
            if (item_id == R.id.menuInicio) {
                visualizar_fragmento(fragmentHome);
            }
            else if (item_id == R.id.menuPerfil) {
                visualizar_fragmento(fragmentProfile);
            }
            else if (item_id == R.id.menuAyuda) {
                visualizar_fragmento(fragmentHelp);
            }
            return true;
        });

    }

    private void inicializar() {
        barraNav = findViewById(R.id.barraNav);
        fragmentHome = new HomeFragment();
        fragmentProfile = new ProfileFragment();
        fragmentHelp = new HelpFragment();
    }

    private void visualizar_fragmento(Fragment fragmentSeleccionado) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragmentSeleccionado).commit();
    }
}