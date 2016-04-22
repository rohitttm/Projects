package com.example.rohit.animallist;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class customAdapter extends ArrayAdapter<Animals>{

    private final List<Animals> animalsList;

    public customAdapter(Context context, int resource, List<Animals> animalsList) {
        super(context, resource, animalsList);
        this.animalsList = animalsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_row, null);

        TextView textView = (TextView) row.findViewById(R.id.rowText);
        textView.setText(animalsList.get(position).getName());

        try {
            ImageView imageView = (ImageView) row.findViewById(R.id.rowImage);
            InputStream inputStream = getContext().getAssets().open(animalsList.get(position).getFileName());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }

}
