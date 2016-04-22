package com.example.rohit.roomer;

/**
 * Created by vishesh on 3/9/2015.
 */
import android.app.Application;
import com.parse.Parse;

public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "3K0f8MYuKdLCTuxSSwxGYSUo4iS8NPBR7BHVoJP7", "FaCIcG3mgNWTDN1OHsRP0sGDWz0svslZrfcK3m2g");

    }
}
