package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.newsapp.Features.CalculatorActivity;
import com.example.newsapp.Features.NotificationActivity;
import com.example.newsapp.Features.ShowLocActivity;
import com.example.newsapp.Features.StorageActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.newsapp.Features.ChatBot.ChatBotMainActivity.class);
                startActivity(intent);

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.HomeFragment,
                R.id.AajTakFragment, R.id.IndiaTVFragment, R.id.NDTVFragment,
                R.id.AlJazeeraFragment, R.id.BBCFragment, R.id.SkyNewsFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings)
        {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Loading ", Toast.LENGTH_SHORT).show();

        }
        if(id == R.id.Logout)
        {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            Toast.makeText(this, "Logged out successfully ", Toast.LENGTH_SHORT).show();
        }
//        else if(id == R.id.CalculatorActivity)
//        {
//            Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
//            startActivity(intent);
//            Toast.makeText(this, "Successfull... ", Toast.LENGTH_SHORT).show();
//
//        }
//        else if(id == R.id.NotificationActivity)
//        {
//            Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
//            startActivity(intent);
//            Toast.makeText(this, "Successfull... ", Toast.LENGTH_SHORT).show();
//        }
//        else if(id == R.id.StorageActivity)
//        {
//            Intent intent = new Intent(MainActivity.this, StorageActivity.class);
//            startActivity(intent);
//            Toast.makeText(this, "Successfull... ", Toast.LENGTH_SHORT).show();
//        }
//        else if(id == R.id.ShowLocActivity)
//        {
//            Intent intent = new Intent(MainActivity.this, ShowLocActivity.class);
//            startActivity(intent);
//            Toast.makeText(this, "Successfull... ", Toast.LENGTH_SHORT).show();
//        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}