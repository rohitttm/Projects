package com.example.rohit.roomer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseUser;

//import com.facebook.HttpMethod;
//import com.facebook.Request;
//import com.facebook.Response;
//import com.facebook.Session;


public class MainActivity2Activity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        fragmentApartments.OnFragmentInteractionListener,
        fragmentHome.OnFragmentInteractionListener,
        fragmentRoommates.OnFragmentInteractionListener,
        postAd.OnFragmentInteractionListener,
        viewAd.OnFragmentInteractionListener

{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private static final String LOG_TAG = "";
//    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);


        Parse.initialize(this, "3K0f8MYuKdLCTuxSSwxGYSUo4iS8NPBR7BHVoJP7", "FaCIcG3mgNWTDN1OHsRP0sGDWz0svslZrfcK3m2g");
//        ParseFacebookUtils.initialize("1606718206225575");

//        session=ParseFacebookUtils.getSession();

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            loadLoginView();
        }
        else {
//            String currentUser1 = (String) ParseUser.getCurrentUser().get("username");
//            textView = (TextView) findViewById(R.id.textView);
//            textView.setText(currentUser1);


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
//                            Log.e(LOG_TAG, "Members: " + response.toString());
//                        }
//                    }
//            ).executeAsync();


        }






        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    private void loadLoginView() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    @Override
    public void onNavigationDrawerItemSelected(int position)
    {
        // update the main content by replacing fragments
        switch (position) {
            case 0:
                fragmentHome fragmenthome=new fragmentHome();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragmenthome)
                        .commit();
                break;
            case 1:
                fragmentRoommates fragmentroommates=new fragmentRoommates();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container,fragmentroommates )
                        .commit();
                break;
            case 2:
                fragmentApartments fragmentapartments=new fragmentApartments();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container,fragmentapartments )
                        .commit();
                break;
            case 3:
                postAd postad=new postAd();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container,postad )
                        .commit();
                break;
            case 4:
                viewAd viewad=new viewAd();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container,viewad )
                        .commit();
                break;

            default:
                break;
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = "Home";
                break;
            case 2:
                mTitle = "Roommates";
                break;
            case 3:
                mTitle = "Apartments";
                break;
            case 4:
                mTitle= "Post an Ad";
                break;
            case 5:
                mTitle="View Ad";
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main_activity2, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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
        if(id==R.id.profile){
            Intent intent1=new Intent(getApplicationContext(),Profile.class);
            startActivity(intent1);

        }




        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
