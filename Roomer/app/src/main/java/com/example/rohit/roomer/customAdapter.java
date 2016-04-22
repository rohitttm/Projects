package com.example.rohit.roomer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends ArrayAdapter<User> {


    private List<User> user = null;

    public customAdapter(Context context, int resource, List<User> user){
        super(context,resource,user);
        this.user = user;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_row, null);

        TextView fullName = (TextView) row.findViewById(R.id.fullName);
        TextView city = (TextView) row.findViewById(R.id.city);
        TextView university = (TextView) row.findViewById(R.id.university);
        ImageView imageView = (ImageView) row.findViewById(R.id.image);

        fullName.setText(user.get(position).getFullName());
        city.setText("City: "+user.get(position).getCity());
        university.setText("University: "+user.get(position).getUniversity());
        /*byte[] a=user.get(position).getDataa();
        Bitmap bmp = BitmapFactory.decodeByteArray(a, 0, a.length);
        imageView.setImageBitmap(bmp);*/

        return row;
    }

}