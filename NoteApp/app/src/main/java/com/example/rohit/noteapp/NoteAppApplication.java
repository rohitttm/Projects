package com.example.rohit.noteapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class NoteAppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "maPN0F212ZH5rTvdYXXXaCmeIsYkckcDumH7N8Vc", "GBF4ilwu6rPSjYOaaicbBqVMallM93XvEekrf0sL");

    }

}