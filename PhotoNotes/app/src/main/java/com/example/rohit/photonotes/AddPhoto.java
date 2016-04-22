package com.example.rohit.photonotes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.app.Activity.*;


public class AddPhoto extends ActionBarActivity {

    Button button;
    Button button2;
    final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView mImageView;
    String mCurrentPhotoPath;
    Editable caption;
   // Editable caption;
    EditText editText;
    TextView textView;
    private List<String> posts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        textView=(TextView) findViewById(R.id.textView);
        editText=(EditText) findViewById(R.id.editText);
        caption=editText.getText();



        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Ensure that there's a camera activity to handle the intent
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    // Create the File where the photo should go
                    File photoFile = null;

                    try {

                        photoFile = createImageFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(photoFile));
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }
            }

        });

        button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(caption.toString(),mCurrentPhotoPath);
                finish();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      /*  if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            *//*Bundle extras = data.getExtras();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;  // Experiment with different sizes
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);*//*
        }*/
    }
    private File createImageFile() throws IOException {
        // Create an image file name

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_photo, menu);
        return true;
    }

    private void update() {
        SQLiteDatabase db = new NoteClass(this).getWritableDatabase();
        String whereClause = NoteClass.ID_COLUMN + "= ?";
        String[] whereArgs = {"1"};

        ContentValues newValues = new ContentValues();
        newValues.put(NoteClass.CAPTION_COLUMN, "alpaca");
        newValues.put(NoteClass.PHOTO_PATH_COLUMN, "An alpaca is ugly.");


        db.update(NoteClass.DATABASE_TABLE, newValues, whereClause, whereArgs);
    }

    private void delete() {
        SQLiteDatabase db = new NoteClass(this).getWritableDatabase();
        String whereClause = NoteClass.ID_COLUMN + "=?";
        String[] whereArgs = {"2"};
        db.delete(NoteClass.DATABASE_TABLE, whereClause, whereArgs);
    }


    private void insert(String caption, String path) {
        SQLiteDatabase db = new NoteClass(this).getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put(NoteClass.CAPTION_COLUMN, caption);
        newValues.put(NoteClass.PHOTO_PATH_COLUMN, path);
        db.insert(NoteClass.DATABASE_TABLE, null, newValues);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if(id==R.id.uninstall)
        {
            Uri packageURI = Uri.parse("package:com.example.rohit.photonotes");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
