package com.codewithsean.sdw.fragment;

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

import com.codewithsean.sdw.R;
import com.codewithsean.sdw.adapters.ShowsAdapter;
import com.codewithsean.sdw.models.Favorites;
import com.codewithsean.sdw.models.Shows;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class FavoriteFragment extends Fragment {

    public static final String TAG = "FavoriteFragment";
    List<Shows> allShows = new ArrayList<>();
    RecyclerView rvFavorites;
    protected ShowsAdapter showsAdapter;

    protected void queryPost() {
        // Specify which class to query
        ParseQuery<Favorites> query = ParseQuery.getQuery(Favorites.class);
        query.include(Favorites.USER);
        query.whereEqualTo(Favorites.USER, ParseUser.getCurrentUser());
        query.setLimit(10);
        query.addDescendingOrder(Favorites.KEY_CREATED_AT);
        query.findInBackground(new FindCallback<Favorites>() {
            @Override
            public void done(List<Favorites> favorites, ParseException e) {
                if(e != null){
                    Log.e(TAG, "Issue with getting posts ", e);
                }
                for (Favorites favorite : favorites){
                    Log.i(TAG, "Post:" + favorite.getDescription() + ", username: " + favorite.getUserName().getUsername());
                    allShows.add(new Shows(favorite.getDescription(), favorite.getImage(), favorite.getUser()));
                }

                //shows = new ArrayList<>();
                //shows.addAll(allShows);
                showsAdapter.notifyDataSetChanged();

            }
        });
    }


//    public FavoriteFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_favorite, container, false);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFavorites = view.findViewById(R.id.rvFavorites);

        allShows = new ArrayList<>();
        //create an adapter
        showsAdapter = new ShowsAdapter(getContext(), allShows);



        //set the adapter to RV
        rvFavorites.setAdapter(showsAdapter);

        //set layout manager to Rv
        rvFavorites.setLayoutManager(new LinearLayoutManager(getContext()));

        queryPost();


    }
}