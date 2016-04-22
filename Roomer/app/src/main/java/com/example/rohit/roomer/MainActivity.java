package com.example.rohit.roomer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;


public class MainActivity extends ActionBarActivity {
    private static final String LOG_TAG = "";
    TextView textView;
//    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, "3K0f8MYuKdLCTuxSSwxGYSUo4iS8NPBR7BHVoJP7", "FaCIcG3mgNWTDN1OHsRP0sGDWz0svslZrfcK3m2g");
        ParseFacebookUtils.initialize("1606718206225575");

//        session=ParseFacebookUtils.getSession();

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            loadLoginView();
        }
        else {
            String currentUser1 = (String) ParseUser.getCurrentUser().get("username");
            textView = (TextView) findViewById(R.id.textView);
            textView.setText(currentUser1);


//            new Request(
//                    session,
//                    "/2692926356774/members",
//                    null,
//                    HttpMethod.GET,
//                    new Request.Callback()
//                    {
//                        public void onCompleted(Response response)
//                        {
//                    /* handle the result */
//                            Log.e(LOG_TAG,"Members: " + response.toString());
//                        }
//                    }
//            ).executeAsync();


        }

    }

    private void loadLoginView() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   /* @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }*//*

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }*/

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
        if(id==R.id.profile){
            Intent intent1=new Intent(getApplicationContext(),Profile.class);
            startActivity(intent1);

        }


        return super.onOptionsItemSelected(item);
    }
}
