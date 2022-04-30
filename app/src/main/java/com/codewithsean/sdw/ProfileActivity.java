package com.codewithsean.sdw;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;

public class ProfileActivity extends AppCompatActivity {
    private EditText etDescription;
    private Button btnTakePic;
    private ImageView ivPostImage;
    private Button btnSubmit;
    private Button btnLogout;
    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 123;
    private File photoFile;
    public String photoFileName = "photo.jpg";
    public static final String TAG ="Profile";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etDescription = findViewById(R.id.etDescription);
        btnTakePic = findViewById(R.id.btnTakePic);
        ivPostImage = findViewById(R.id.ivPostImage);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnLogout = findViewById(R.id.btnLogout);

//        btnTakePic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //launchCamera();
//            }
//        });
        //queryPosts();

//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "onCLick logout button");
//
//                //ParseUser.logOut();
//                //ParseUser currentUser = ParseUser.getCurrentUser();
//                goMainActivity();
//            }
//        });




//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String description = etDescription.getText().toString();
//                if (description.isEmpty()) {
//                    Toast.makeText(ProfileActivity.this, "Description cannot be emtpy", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (photoFile == null || ivPostImage.getDrawable() == null) {
//                    Toast.makeText(ProfileActivity.this, "There's no image", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                ParseUser currentUser = ParseUser.getCurrentUser();
//                savePost(description, currentUser, photoFile);
//
//            }
//
//        });


//        private void launchCamera () {
//            // create Intent to take a picture and return control to the calling application
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            // Create a File reference for future access
//            photoFile = getPhotoFileUri(photoFileName);
//
//            // wrap File object into a content provider
//            // required for API >= 24
//            // See https://guides.codepath.com/android/Sharing-Content-with-Intents#sharing-files-with-api-24-or-higher
//            Uri fileProvider = FileProvider.getUriForFile(getContext(), "com.codepath.fileprovider", photoFile);
//            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);
//
//            // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
//            // So as long as the result is not null, it's safe to use the intent.
//            if (intent.resolveActivity(getContext().getPackageManager()) != null) {
//                // Start the image capture intent to take photo
//
//                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
//
//                //registerForActivityResult(intent, );
//            }
//        }




//        @Override
//        public void onActivityResult ( int requestCode, int resultCode, Intent data){
//            super.onActivityResult(requestCode, resultCode, data);
//            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
//                if (resultCode == RESULT_OK) {
//                    // by this point we have the camera photo on disk
//                    Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
//                    // RESIZE BITMAP, see section below
//
//                    // Load the taken image into a preview
//
//                    ivPostImage.setImageBitmap(takenImage);
//                } else { // Result was a failure
//                    Toast.makeText(getContext(), "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }

        // Returns the File for a photo stored on disk given the fileName
//        public File getPhotoFileUri (String fileName){
//            // Get safe storage directory for photos
//            // Use `getExternalFilesDir` on Context to access package-specific directories.
//            // This way, we don't need to request external read/write runtime permissions.
//            File mediaStorageDir = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), ARG_PARAM1);
//
//            // Create the storage directory if it does not exist
//            if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
//                Log.d(ARG_PARAM1, "failed to create directory");
//            }
//
//            // Return the file target for the photo based on filename
//            return new File(mediaStorageDir.getPath() + File.separator + fileName);


        }
/*
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        CaptureI();
                    }
                }
            });   */

//    private void savePost(String description, ParseUser currentUser, File photoFile) {
//        Post post = new Post();
//        post.setDescription((description));
//        post.setImage(new ParseFile(photoFile));
//
//        post.setUser(currentUser);
//        post.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e != null) {
//                    Log.e(ARG_PARAM1, "Error while saving", e);
//                    Toast.makeText(getContext(), "Error while saving", Toast.LENGTH_SHORT).show();
//                }
//                Log.i(ARG_PARAM1, "Post was saved properly");
//                etDescription.setText("");
//                ivPostImage.setImageResource(0);
//            }
//        });
//
//    }
//    }
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

