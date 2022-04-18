package com.codewithsean.sdw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.codewithsean.sdw.models.Shows;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);

        String title = getIntent().getStringExtra("title");
        Shows shows = Parcels.unwrap(getIntent().getParcelableExtra("shows"));
        tvTitle.setText(shows.getOriginal_name());
        tvOverview.setText(shows.getOverview());


    }
}