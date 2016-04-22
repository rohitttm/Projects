package com.example.rohit.animallist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class Details extends ActionBarActivity {

    String name;
    TextView textView3;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name=getIntent().getExtras().getString("name");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(name);

        textView3=(TextView) findViewById(R.id.textView3);
        imageView=(ImageView) findViewById(R.id.imageView);



        if(name.compareToIgnoreCase("dog")==0)
        {

            textView3.setText("The domestic dog is a canid that is known as man's best friend. The dog was the first domesticated animal and has been widely kept as a working, hunting, and pet companion.");
            imageView.setImageResource(R.drawable.dog);
        }
        if(name.compareToIgnoreCase("elephant")==0)
        {
            textView3.setText("Elephants are large mammals of the family Elephantidae. All elephants have several features the most notable of which is a long trunk or proboscis, used for particularly breathing, lifting water and grasping objects. Their incisors grow into tusks, which can serve as weapons and as tools for moving objects");
            imageView.setImageResource(R.drawable.elephant);

        }
        if(name.compareToIgnoreCase("lion")==0)
        {
            textView3.setText("The lion is one of the five big cats in the genus Panthera and a member of the family Felidae. With some males exceeding 250 kg (550 lb) in weight, it is the second-largest living cat after the tiger. Lions live for 10–14 years in the wild, while in captivity they can live longer than 20 years.");
            imageView.setImageResource(R.drawable.lion);

        }
        if(name.compareToIgnoreCase("panda")==0)
        {

            textView3.setText("The giant panda also known as panda bear or simply panda, is a bear native to south central China. It is easily recognized by the large, distinctive black patches around its eyes, over the ears, and across its round body. Though it belongs to the order Carnivora, the giant panda's diet is over 99% bamboo.");
            imageView.setImageResource(R.drawable.panda);

        }
        if(name.compareToIgnoreCase("horse")==0)
        {

            textView3.setText("The horse is one of two extant subspecies of Equus ferus. It is an odd-toed ungulate mammal. Horses' anatomy enables them to make use of speed to escape predators and they have a well-developed sense of balance. Horses and humans interact in a wide variety of sport competitions and non-competitive recreational pursuits.");
            imageView.setImageResource(R.drawable.horse);

        }




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
