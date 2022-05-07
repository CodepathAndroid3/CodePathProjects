package com.codewithsean.sdw;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
=======
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
>>>>>>> 6fcf52c6072c157c151277f71c144ecdc5acc94d
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
<<<<<<< HEAD
import android.os.Bundle;
import android.util.Log;
=======
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
>>>>>>> 6fcf52c6072c157c151277f71c144ecdc5acc94d

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codewithsean.sdw.adapters.ShowsAdapter;
<<<<<<< HEAD
import com.codewithsean.sdw.models.Shows;
=======
import com.codewithsean.sdw.fragment.HomeFragment;
import com.codewithsean.sdw.fragment.ProfileFragment;
import com.codewithsean.sdw.models.Shows;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
>>>>>>> 6fcf52c6072c157c151277f71c144ecdc5acc94d

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String GET_TV = "https://api.themoviedb.org/3/tv/popular?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG ="MainActivity";
<<<<<<< HEAD

    List<Shows> shows;
=======
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();
>>>>>>> 6fcf52c6072c157c151277f71c144ecdc5acc94d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        RecyclerView rvShows = findViewById(R.id.rvShows);
        shows = new ArrayList<>();

        //create an adapter
        ShowsAdapter showsAdapter = new ShowsAdapter(this, shows);

        //set the adapter to RV
        rvShows.setAdapter(showsAdapter);

        //set layout manager to Rv
        rvShows.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(GET_TV, new JsonHttpResponseHandler() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "OnSuccess" + json);
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(TAG,  "Results: " + results);
                    shows.addAll(Shows.fromJsonArray(results));
                    //movies = Movie.fromJsonArray(results);
                    showsAdapter.notifyDataSetChanged();
                    Log.i(TAG, "Shows: " + shows.size());

                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception", e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }

        });

    }
=======
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


>>>>>>> 6fcf52c6072c157c151277f71c144ecdc5acc94d
}