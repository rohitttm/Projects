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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SignUpActivity extends ActionBarActivity {

    public String N,E,Pa,Ph,A,I,U,C,FN,Pa1;

    final int REQUEST_TAKE_PHOTO = 1;
    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);


        Parse.initialize(this, "3K0f8MYuKdLCTuxSSwxGYSUo4iS8NPBR7BHVoJP7", "FaCIcG3mgNWTDN1OHsRP0sGDWz0svslZrfcK3m2g");
        final EditText Name=(EditText) findViewById(R.id.userName);
        final EditText fullName=(EditText) findViewById(R.id.name);
        final EditText Age=(EditText) findViewById(R.id.age);
        final EditText Email=(EditText) findViewById(R.id.userEmail);
        final EditText Password=(EditText) findViewById(R.id.userPassword);
        final EditText Password1=(EditText) findViewById(R.id.userPassword1);
        final EditText Phone=(EditText) findViewById(R.id.phone);
        final EditText UW=(EditText) findViewById(R.id.university);
        final EditText city=(EditText) findViewById(R.id.city);


        Button addPP=(Button) findViewById(R.id.addProfilePicture);
        addPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Ensure that there's a camera activity to handle the intent
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    // Create the File where the photo should go
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException ex) {

                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(photoFile));
                        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                    }
                }




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
        });

        Button create= (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FN=fullName.getText().toString();
                N= Name.getText().toString();
                E=Email.getText().toString();
                Pa=Password.getText().toString();
                Pa1=Password1.getText().toString();
                Ph=Phone.getText().toString();
                A= Age.getText().toString();
                U= UW.getText().toString();
                C= city.getText().toString();

                N=N.trim();E=E.trim();Pa=Pa.trim();Ph=Ph.trim();A=A.trim();A=A.trim();U=U.trim();C=C.trim();FN=FN.trim();


                if (N.isEmpty() || E.isEmpty() || Pa.isEmpty() ||  C.isEmpty() || FN.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    builder.setMessage(R.string.signup_error_message)
                            .setTitle(R.string.signup_error_title)
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else{
                    if(!Pa.equals(Pa1)){
                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                        builder.setMessage(R.string.password_error)
                                .setTitle("Password Error!")
                                .setPositiveButton(android.R.string.ok, null);
                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }

                    else {
                        setSupportProgressBarIndeterminateVisibility(true);

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
                        final ParseFile file = new ParseFile("picture.jpeg", image);

                        // Upload the image into Parse Cloud
                        file.saveInBackground();
                        setSupportProgressBarIndeterminateVisibility(true);

                        file.saveInBackground(new SaveCallback() { @Override public void done(ParseException e)
                        {

                            ParseUser newUser = new ParseUser(); newUser.setUsername(N); newUser.put("FullName", FN);

                            newUser.setEmail(E); newUser.setPassword(Pa); newUser.put("Phone", Ph); newUser.put("Age",A); newUser.put("University",U); newUser.put("City",C); newUser.put("imageUpload",file); newUser.signUpInBackground(new SignUpCallback() { @Override public void done(ParseException e) { setSupportProgressBarIndeterminateVisibility(false);

                                if (e == null) { // Success!
                                Intent intent = new Intent(SignUpActivity.this, MainActivity2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }
                                else
                                {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                    builder.setMessage(e.getMessage())
                                            .setTitle(R.string.signup_error_title)
                                            .setPositiveButton(android.R.string.ok, null);
                                    AlertDialog dialog = builder.create(); dialog.show();
                                } } });

                        } });

                        setSupportProgressBarIndeterminateVisibility(true);

                        setSupportProgressBarIndeterminateVisibility(true);

                    } } } }); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }
}
