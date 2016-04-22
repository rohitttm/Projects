package com.example.rohit.roomer;

/**
 * Created by vishesh on 3/7/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class listViewAdapter extends ArrayAdapter<Ad> {

    Context context;
    LayoutInflater inflater;

    private List<Ad> ads = null;
    private ArrayList<Ad> arraylist1;

    public listViewAdapter(Context context, int resource, List<Ad> ads) {
        super(context, resource, ads);
        this.ads = ads;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.rowadlist, null);

        TextView title = (TextView) row.findViewById(R.id.adtitleList);
        TextView fullname = (TextView) row.findViewById(R.id.adFullNameList);
        TextView description = (TextView) row.findViewById(R.id.adDescriptionList);


        title.setText(ads.get(position).getTitleAd());
        fullname.setText("Description: " + ads.get(position).getFullNameAd());
        description.setText("Posted By: " + ads.get(position).getDescriptionAd());
        return row;
    }
}












//        public class ViewHolder {
//            TextView title;
//            TextView fullname ;
//            TextView university;
//
//        }
//
//        @Override
//        public int getCount() {
//            return adList1.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return adList1.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        public View getView(final int position, View view, ViewGroup parent) {
//            final ViewHolder holder;
//            if (view == null) {
//                holder = new ViewHolder();
//                view = inflater.inflate(R.layout.rowadlist, null);
//// Locate the TextViews in listview_item.xml
//                holder.title = (TextView) view.findViewById(R.id.adtitleList);
//                holder.fullname = (TextView) view.findViewById(R.id.adFullNameList);
////                holder.university = (TextView) view.findViewById(R.id.adUniversityList);
////                view.setTag(holder);
////            } else {
////                holder = (ViewHolder) view.getTag();
////            }
////// Set the results into TextViews
////            holder.title.setText(adList1.get(position).getTitle());
////            holder.fullname.setText(adList1.get(position).getFullNameAd());
////            holder.university.setText(adList1.get(position)
////                    .getUniversityAd());
//// Listen for ListView Item Click
////            view.setOnClickListener(new OnClickListener() {
////
////                @Override
////                public void onClick(View arg0) {
////// Send single item click data to SingleItemView Class
////                    Intent intent = new Intent(context, SingleItemView.class);
////// Pass all data rank
////                    intent.putExtra("rank",
////                            (worldpopulationlist.get(position).getRank()));
////// Pass all data country
////                    intent.putExtra("country",
////                            (worldpopulationlist.get(position).getCountry()));
////// Pass all data population
////                    intent.putExtra("population",
////                            (worldpopulationlist.get(position).getPopulation()));
////// Pass all data flag
////                    intent.putExtra("flag",
////                            (worldpopulationlist.get(position).getFlag()));
////// Start SingleItemView Class
////                    context.startActivity(intent);
////                }
////            });
//            return view;
//        }
//
//    }
//
//
//
//
//
