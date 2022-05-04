package com.codewithsean.sdw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.codewithsean.sdw.models.Shows;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvOverview;
    Button favButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        favButton = findViewById(R.id.favButton);

        String title = getIntent().getStringExtra("title");
        Shows shows = Parcels.unwrap(getIntent().getParcelableExtra("shows"));
        tvTitle.setText(shows.getOriginal_name());
        tvOverview.setText(shows.getOverview());

        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Favorite Button Clicked", Toast.LENGTH_SHORT).show();

            }
        });



    }
}