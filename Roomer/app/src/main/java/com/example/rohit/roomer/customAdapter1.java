package com.example.rohit.roomer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class customAdapter1 extends ArrayAdapter<GooglePlace> {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    //    ImageLoader imageLoader;
    private List<GooglePlace> googlePlace = null;
    private ArrayList<GooglePlace> arraylist;
    //private final List<Animals> animalsList;

    public customAdapter1(Context context, int resource, List<GooglePlace> googlePlace) {
        super(context, resource, googlePlace);
        this.googlePlace = googlePlace;
    }

   /* public customAdapter(Context context,int resource, List<User> user) {
        //super(context,user);
        this.context = context;
        this.user = user;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<User>();
        this.arraylist.addAll(user);
        imageLoader = new ImageLoader(context);
    }*/



    /*public class ViewHolder {
        TextView fullName;
        TextView city;
        TextView university;
        ImageView image;
    }*//*

    @Override
    public int getCount() {
        return user.size();
    }

    *//*@Override
    public Object getItem(int position) {
        return user.get(position);
    }*//*

    @Override
    public long getItemId(int position) {
        return position;
    }*/

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);



        View row = inflater.inflate(R.layout.custom_row, null);
        // Locate the TextViews in listview_item.xml
        TextView name = (TextView) row.findViewById(R.id.fullName);
        TextView address = (TextView) row.findViewById(R.id.city);
        TextView rating = (TextView) row.findViewById(R.id.university);
        // Locate the ImageView in listview_item.xml
        //ImageView image = (ImageView) row.findViewById(R.id.image);


        // Set the results into TextViews
        name.setText(googlePlace.get(position).getName());
        address.setText(googlePlace.get(position).getAddress());
        rating.setText(googlePlace.get(position).getRating());
        ImageView imageView = (ImageView) row.findViewById(R.id.image);

        //imageView.setImageBitmap(user.get(position).getImage());

        /*row.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(context, SingleItemView.class);
                // Pass all data rank
                intent.putExtra("fullName",
                        (user.get(position).getFullName()));
                // Pass all data country
                intent.putExtra("city",
                        (user.get(position).getCity()));
                // Pass all data population
                intent.putExtra("university",(user.get(position).getUniversity()));
                // Pass all data flag
                intent.putExtra("flag",
                        (user.get(position).getImage()));
                // Start SingleItemView Class
                context.startActivity(intent);
            }
        });*/
        return row;
    }

}