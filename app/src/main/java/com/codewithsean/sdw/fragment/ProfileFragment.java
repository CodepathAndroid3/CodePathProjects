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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codewithsean.sdw.R;
import com.codewithsean.sdw.adapters.ShowsAdapter;
import com.codewithsean.sdw.models.Shows;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

import okhttp3.Headers;


public class ProfileFragment extends Fragment {

    private EditText etDescription;
    private Button btnTakePic;
    private ImageView ivPostImage;
    private Button btnSubmit;
    private Button btnLogout;
    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 123;
    private File photoFile;
    public String photoFileName = "photo.jpg";

    private ImageView pfpUserImage;
    private TextView pfpUserName;



    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pfpUserImage = view.findViewById(R.id.pfpUserImage);
        pfpUserName = view.findViewById(R.id.pfpUserName);



//        etDescription = view.findViewById(R.id.etDescription);
//        btnTakePic = view.findViewById(R.id.btnTakePic);
//        ivPostImage = view.findViewById(R.id.ivPostImage);
//        btnSubmit = view.findViewById(R.id.btnSubmit);
//        btnLogout = view.findViewById(R.id.btnLogout);

//        btnTakePic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                launchCamera();
//            }
//        });


    }



}