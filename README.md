Original App Design Project - README Template
===

# SDW Shows

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
An app that allows users to look at the most popular TV shows at the moment and see some data about those TV shows.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:**
    Entertainment
- **Mobile:**
    Taking picture for the user profile picture.
- **Story:**
    Do you ever get tired of having to keep track of the episodes and TV shows you've watched on a text document or mentally keep track? This app is designed to resolve those issues! 

- **Market:**
    Anyone who watches TV shows and wants to be up to date.
- **Habit:**
    Users will often sometimes to check up on their favorite TV shows
- **Scope:** 
    A few weeks to flesh out the basics and establish a foundation.
    
    
## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* [] The app needs to retrieves TV show data from the network and present this data within the app
* [] Home Page
    *[]Contain list of popular TV shows.
* [] Detail Page
    * []Contain TV shows picture,overview.
    * []Adding favorite button.
* [] Profile Page
    * []Camera for profile picture.
    * []Any personal user note.
* [] Login page that allows users to log in or sign up

**Optional Nice-to-have Stories**

* [] Detail Page:
    * []Contain trailer for the show.
    * []Genre tag.
    * []Episode watch count(Through user writing a note)
* [] Notification of new episode, to shows they favorite.
* ...

### 2. Screen Archetypes

* Login 
* Register - User signs up or logs into their account
   * Upon Download/Reopening of the application, the user is prompted to log in to gain access to their profile information to be properly matched with another            person. 
* Home Screen
   * List of TV shows on a  main page.
   * Has a bottom bar connecting to profile, home and favorites page
* Profile Screen 
   * Allows user to upload a photo and fill in information that is interesting to them and others
   * ....
* Detail view
   * When a TV show is clicked on the main page, navigates to here
   * Shows a trailer of the TV show and list of episodes
   * ....
* Favorites List
   * Shows a list of TV shows that the user wants to keep track of
   * ....

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* [Home (List of TV shows]
* [Favorite Tab (Shows your favorite shows, or those you mark to keep track of)]
* [Profile]

**Flow Navigation** (Screen to Screen)

* [Home (List of TV shows)]
   * []Favorite Window
   * []Profile Window
   * Shows Details
* [] Favorite Window
   * [] Shows
   * ...

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="wireframe.unit8.png" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Unit 9
## Schema 

### Models
#### TV Popular

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | poster_path   | String or null   | link to a picture or poster of this TV show |
   | popularity        | number | stars, says rating  |
   | original_name       | String     | name of TV show |
   | overview       | String   | Description of TV show |
   | id        | String | ID number of this TV show |
   
#### TV Videos
   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | key  | String    | key to youtube link of trailer |
   | id        | String | id number of this video  |
   | name      | String     | name of TV show trailer |
   | overview       | String   | Description of TV show |
   
#### TV Seasons
   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | season_number  | integer    | season number of TV show |
   | tv_id      | integer | id number of the TV show  |
   | episodes    | array[object] | List of TV episodes for the season |
   | name      | String     | name of this episode |
  
#### Favorite TV Shows
   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | poster_path   | String or null   | link to a picture or poster of this TV show |
   | popularity        | number | stars, says rating  |
   | original_name       | String     | name of TV show |
   | overview       | String   | Description of TV show |
   | id        | String | ID number of this TV show |
   
### Networking
#### List of network requests by screen
   - Home Feed Screen
      - (GET) get a list of TV shows
         ```swift
         client.get(https://api.themoviedb.org/3/tv/popular?api_key={api_key}), new JsonHttpResponseHandler() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "OnSuccess" + json);
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");

                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception", e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "OnFailure");
            }
        });
         ``` List endpoints if using existing API such as Yelp]
- 
### Movie Database API
Base URL - https://api.themoviedb.org/3


| HTTP Verb | Endpoint | Description |
|------------- | -------- | ------------|
|GET|/tv/popular|List of Popular TV Shows|
|GET|/tv/{tv_id}/season/{season_number}|Details for Season|
|GET|/tv/{tv_id}/videos|Videos for TV Show|
| | |


**Milestone 1** | Unit 10: Deadline April 22nd:
Required:
-Getting the popular shows and putting it into a recyler view
-Making details page for each show.
-Detail page should have TV picture,overview, # of seasons and episodes.

Optional:
-App Logo

-TV Detail Page
Adding a trailer


**Milestone 2** | Unit 11: Deadline April 29th:
Required:
-Make login screen.
-Set up back4 (User data)
-Establish structure for user accounts.
-Set up camera for profile picture.


**Milestone 3** | Unit 12: Deadline May 6th:
Required:
-Favorite tab
-Incoporating favoriting, having the data saved for the account
-Unfavoriting.
-Favorite tab, when clicking on episode, you go to the tv show detail.


**Milestone 4** | Unit 13: Deadline May 13th:
Required:
Note feature for TV shows in favorite. (Basically any notes the user want to make note of for that show)

Optional:

-----
Note: 
For favoriting, onclicklistener for a button on the details.

----
https://developers.themoviedb.org/3/tv-episodes/get-tv-episode-details
Notes:

Screens:
Login Screen - GET,Update/PUT for SignUp
Home Screen - Read/GET TV Popular Shows,
Details Screen - Read/Get , Update/PUT
Profile Screen - Update/PUT
Favorite Screen - Read/GET User's favorite,


Options:
Genre tag for the shows.
Watch providers for the shows.

App Logo
