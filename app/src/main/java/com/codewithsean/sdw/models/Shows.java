package com.codewithsean.sdw.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Shows {

    String poster_path;
    double vote_average;
    String original_name;
    String overview;
    int id;

    //requird by parcel
    public Shows(){}

    public Shows(JSONObject jsonObject) throws JSONException{
        poster_path = jsonObject.getString("poster_path");
        //vote_average = jsonObject.getDouble("poster_path");
        original_name = jsonObject.getString("original_name");
        overview = jsonObject.getString("overview");
    }

    public static List<Shows> fromJsonArray(JSONArray showsJsonArray) throws JSONException{
        List<Shows> shows = new ArrayList<>();

        for(int i=0; i<showsJsonArray.length(); i++){
            shows.add(new Shows(showsJsonArray.getJSONObject(i)));
        }
        return shows;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", poster_path);
    }

    public int getId() {
        return id;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public String getOverview() {
        return overview;
    }
}
