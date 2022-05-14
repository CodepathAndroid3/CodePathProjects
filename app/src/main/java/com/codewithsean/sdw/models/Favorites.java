package com.codewithsean.sdw.models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("favorites")
public class Favorites extends ParseObject {
    public static final String KEY_DESCRIPTION = "overview";
    public static final String KEY_IMAGE = "poster_path";
    public static final String KEY_USER = "name";
    public static final String USER = "user";
    public static final String ID = "id";
    public static final String KEY_CREATED_AT = "createdAt";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public String getImage(){
        return getString(KEY_IMAGE);
    }
    public void setImage(String image){
        put(KEY_IMAGE,image);
    }

    public String getUser(){
        return getString(KEY_USER);
    }
    public void setUser(String user){
        put(KEY_USER,user);
    }

    public ParseUser getUserName(){
        return getParseUser(USER);
    }
    public void setUserName(ParseUser user){ put(USER,user); }

    public int getId(){
        return getInt(ID);
    }
    public void setId(int user){
        put(ID,user);
    }
}
