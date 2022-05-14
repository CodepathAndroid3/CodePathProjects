package com.codewithsean.sdw.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codewithsean.sdw.R;
import com.codewithsean.sdw.adapters.ShowsAdapter;
import com.codewithsean.sdw.models.Shows;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;


public class HomeFragment extends Fragment {


    public static final String GET_TV = "https://api.themoviedb.org/3/tv/popular?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG ="HomeFragment";
    List<Shows> shows;
    List<Shows> newShows;
    private RecyclerView rvShows;
    protected ShowsAdapter showsAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvShows = view.findViewById(R.id.rvShows);

        shows = new ArrayList<>();
        //create an adapter
        showsAdapter = new ShowsAdapter(getContext(), shows);



        //set the adapter to RV
        rvShows.setAdapter(showsAdapter);

        //set layout manager to Rv
        rvShows.setLayoutManager(new LinearLayoutManager(getContext()));

        ProduceShows();


        //queryPost();


    }

    public void ProduceShows() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(GET_TV, new JsonHttpResponseHandler() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "OnSuccess" + json);
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(TAG, "Results: " + results);
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
                Log.d(TAG, "OnJSONFailure" + response);
            }
        });
    }
    protected void queryPost() {}
}