package com.example.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascota;
    private RecyclerView ListaMascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* CODIGO PARA DECLARAR EL TOOLBAR */
        Toolbar ActionBar = (Toolbar) findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        /*    */

        tabLayout = (TabLayout) findViewById(R.id.feed);
        viewPagers = (ViewPager) findViewById(R.id.viewPagers);
        SetUpViewPager();


        /*


            */

            if(toolbar !=null){
                setSupportActionBar(toolbar);

            }


        /*
        ArrayList<String> nombresMascota = new ArrayList<>();
        for(Mascota mascotas: mascota)
        {
            nombresMascota.add(mascotas.getNombre());
        }
        */



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
    return true;
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.contacto:
                Intent inten = new Intent(this,Contacto.class);
                startActivity(inten);
                break;

            case R.id.acerca:
                Intent intent = new Intent(this,Acerca_de.class);
                    startActivity(intent);
                break;



        }


        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragments());
        fragments.add(new Fragment2());

        return fragments;


    }

    private  void SetUpViewPager(){
        viewPagers.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPagers);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.profile);




    }







    public void Click(View view) {

        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);

    }



}