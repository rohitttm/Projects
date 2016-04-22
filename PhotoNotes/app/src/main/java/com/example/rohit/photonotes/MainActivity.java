package com.example.rohit.photonotes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> items1 = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        query(-1);


        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                query(position+1);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

       query(-1);


        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                query(position+1);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.addPhoto) {
            Intent intent = new Intent(this, AddPhoto.class);
            startActivity(intent);
            return true;
        }

        if(id==R.id.uninstall)
        {
            Uri packageURI = Uri.parse("package:com.example.rohit.photonotes");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void query(int position) {
        SQLiteDatabase db = new NoteClass(this).getWritableDatabase();
        String where = null;
        String whereArgs[] = null;
        String groupBy = null;
        String having = null;
        String order = null;
        String[] resultColumns = {NoteClass.ID_COLUMN, NoteClass.CAPTION_COLUMN, NoteClass.PHOTO_PATH_COLUMN};
        Cursor cursor = db.query(NoteClass.DATABASE_TABLE, resultColumns, where, whereArgs, groupBy, having, order);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String caption = cursor.getString(1);
            String imageFilepath = cursor.getString(2);

            if(position!=-1){
                if(id==position){
                    Intent i=new Intent(getApplicationContext(),details.class);
                    i.putExtra("caption",caption);
                    i.putExtra("imageFilePath",imageFilepath);
                    startActivity(i);

                }
            }
            else {
                if(items.contains(caption))
                {

                }
                else
                    items.add(caption);
            }
        }
    }

}