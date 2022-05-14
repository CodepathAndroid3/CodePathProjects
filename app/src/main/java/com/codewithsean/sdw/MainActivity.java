package com.codewithsean.sdw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codewithsean.sdw.adapters.ShowsAdapter;
import com.codewithsean.sdw.fragment.FavoriteFragment;
import com.codewithsean.sdw.fragment.HomeFragment;
import com.codewithsean.sdw.fragment.ProfileFragment;
import com.codewithsean.sdw.models.Shows;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String GET_TV = "https://api.themoviedb.org/3/tv/popular?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG ="MainActivity";
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_profile://goes to profile page
                        fragment = new ProfileFragment();
                        Toast.makeText(MainActivity.this,"profile", Toast.LENGTH_SHORT).show();
                        break;
//                    case R.id.action_login:
//                        goLoginActivity();
//                        break;
//                        //  goLoginActivity();
                    case R.id.action_home://goes to home
                    default:
                        Toast.makeText(MainActivity.this,"home", Toast.LENGTH_SHORT).show();
                        fragment = new HomeFragment();
                        break;

                    case R.id.action_favorite://goes to favorite list
                        fragment = new FavoriteFragment();
                        Toast.makeText(MainActivity.this,"favorite",Toast.LENGTH_SHORT).show();

                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        //default view
        bottomNavigationView.setSelectedItemId(R.id.action_home);


    }

    //makes the menu be shown on menu_main
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom_navigation, menu);
        return true;
    }

    private void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }


}