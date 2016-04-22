package com.example.rohit.photonotes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class details extends ActionBarActivity {
    String caption;
    String imagePath;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        caption=getIntent().getExtras().getString("caption");
        imagePath=getIntent().getExtras().getString("imageFilePath");

        textView=(TextView) findViewById(R.id.textView);
        textView.setText(caption);

        imageView=(ImageView) findViewById(R.id.imageView);

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        BitmapFactory.decodeFile(imagePath, bmOptions);
        bmOptions.inSampleSize = 8;
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath, bmOptions);

        // create a matrix object
        Matrix matrix = new Matrix();
        matrix.postRotate(90); // anti-clockwise by 90 degrees
        // create a new bitmap from the original using the matrix to transform the result
        Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap , 0, 0, bitmap .getWidth(), bitmap .getHeight(), matrix, true);

        // display the rotated bitmap
        imageView.setImageBitmap(rotatedBitmap);
        //imageView.setImageBitmap(bitmap);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.uninstall)
        {
            Uri packageURI = Uri.parse("package:com.example.rohit.photonotes");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
        }

        return super.onOptionsItemSelected(item);
    }

}
