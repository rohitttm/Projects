package com.example.rohit.animallist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    Animals animal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        ListView listView = (ListView) findViewById(R.id.listView);
        final List<Animals> animalsList = new ArrayList<>();
        animalsList.add(new Animals("Dog", "dog.jpg"));

        animalsList.add(new Animals("Elephant","elephant.jpg"));
        animalsList.add(new Animals("Lion","lion.jpg"));
        animalsList.add(new Animals("Horse", "horse.jpg"));
        animalsList.add(new Animals("Panda","panda.jpg"));
        listView.setAdapter(new customAdapter(this, R.layout.custom_row, animalsList));



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                animal=animalsList.get(position);

                if(position==4)
                {
                    alertDialogBuilder.setTitle("Warning!");
                    alertDialogBuilder.setMessage("This Animal is very Scary!\nAre you sure you want to proceed?")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    Intent intent=new Intent(MainActivity.this,Details.class);
                                    intent.putExtra("name",animal.getName());
                                    startActivity(intent);

                                }
                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {

                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();

                    alertDialog.show();
                }
                else
                {
                    Intent intent=new Intent(MainActivity.this,Details.class);
                    intent.putExtra("name",animal.getName());
                    startActivity(intent);
                }
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id==R.id.information)
        {

            Intent informationActivity = new Intent(this,informationActivity.class);
            startActivity(informationActivity);
        }

        if(id==R.id.uninstall)
        {
            Uri packageURI = Uri.parse("package:com.example.rohit.animallist");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
