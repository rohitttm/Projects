package com.example.rohit.roomer;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Profile extends ActionBarActivity {

    public boolean FLAG_PHOTO=false;
    EditText name,phone,age,university,city;
    Button button;
    public String Ph,A,U,C,FN;
    final ParseUser currentUser = ParseUser.getCurrentUser();
    final int REQUEST_TAKE_PHOTO = 1;
    Button button1;
    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Parse.initialize(this, "3K0f8MYuKdLCTuxSSwxGYSUo4iS8NPBR7BHVoJP7", "FaCIcG3mgNWTDN1OHsRP0sGDWz0svslZrfcK3m2g");
        //ParseFacebookUtils.initialize("1606718206225575");

        name=(EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.phone);
        age=(EditText) findViewById(R.id.age);
        university=(EditText) findViewById(R.id.university);
        city=(EditText) findViewById(R.id.city);
        button=(Button) findViewById(R.id.button2);

        if (currentUser == null) {
            loadLoginView();
        }
        else {
                            ParseFile fileObject = (ParseFile) ParseUser.getCurrentUser().get("imageUpload");
                            fileObject.getDataInBackground(new GetDataCallback() {

                                        public void done(byte[] data,
                                                         ParseException e) {
                                            if (e == null) {
                                                Log.d("test",
                                                        "We've got data in data.");
                                                Bitmap bmp = BitmapFactory
                                                        .decodeByteArray(
                                                                data, 0,
                                                                data.length);
                                                ImageView image = (ImageView) findViewById(R.id.imageView);

                                                image.setImageBitmap(bmp);

                                            } else {
                                                Log.d("test",
                                                        "There was a problem downloading the data.");
                                            }
                                        }
                                    });
        }

            String name1=(String) ParseUser.getCurrentUser().get("FullName");
            String phone1=(String) ParseUser.getCurrentUser().get("Phone");
            String age1=(String) ParseUser.getCurrentUser().get("Age");
            String university1=(String) ParseUser.getCurrentUser().get("University");
            String city1=(String) ParseUser.getCurrentUser().get("City");

            name.setText(name1);
            phone.setText(phone1);
            age.setText(age1);
            university.setText(university1);
            city.setText(city1);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FN = name.getText().toString();
                    Ph = phone.getText().toString();
                    A = age.getText().toString();
                    U = university.getText().toString();
                    C = city.getText().toString();

                    Ph = Ph.trim();
                    A = A.trim();
                    A = A.trim();
                    U = U.trim();
                    C = C.trim();
                    FN = FN.trim();

                    if (Ph.isEmpty() || A.isEmpty() || U.isEmpty() || C.isEmpty() || FN.isEmpty()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                        builder.setMessage(R.string.signup_error_message)
                                .setTitle(R.string.signup_error_title)
                                .setPositiveButton(android.R.string.ok, null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {

//                        Toast.makeText(Profile.this, "Image Uploaded",
//                        Toast.LENGTH_SHORT).show();

                        if(FLAG_PHOTO)
                        {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = 8;  // Experiment with different sizes
                            Bitmap b = BitmapFactory.decodeFile(mCurrentPhotoPath, options);
                            // Convert it to byte
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            // Compress image to lower quality scale 1 - 100
                            //                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            b.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                            byte[] image = stream.toByteArray();
                            // Create the ParseFile
                            ParseFile file = new ParseFile("picture.jpeg", image);
                            // Upload the image into Parse Cloud
                            file.saveInBackground();
                            currentUser.put("imageUpload",file);
                        }

                        setSupportProgressBarIndeterminateVisibility(true);
                        currentUser.put("FullName",FN);
                        currentUser.put("Phone", Ph);
                        currentUser.put("Age", A);
                        currentUser.put("University", U);
                        currentUser.put("City", C);



                        currentUser.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    // Success!
                                    Intent intent = new Intent(Profile.this, MainActivity2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                                    builder.setMessage(e.getMessage())
                                            .setTitle(R.string.signup_error_title)
                                            .setPositiveButton(android.R.string.ok, null);
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }

                            }
                        });
                    }
                }
            });

            button1= (Button) findViewById(R.id.button);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    // Ensure that there's a camera activity to handle the intent
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        // Create the File where the photo should go
                        File photoFile = null;
                        try {
//                            FLAG_PHOTO=true;
                            photoFile = createImageFile();
                        } catch (IOException ex) {

                        }
                        // Continue only if the File was successfully created
                        if (photoFile != null) {
                            FLAG_PHOTO=true;
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                    Uri.fromFile(photoFile));
                            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                        }
                    }
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    private void loadLoginView() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id==R.id.action_logout)
        {
            ParseUser.logOut();
            loadLoginView();
        }

        return super.onOptionsItemSelected(item);
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath =image.getAbsolutePath();
        return image;
    }

}
