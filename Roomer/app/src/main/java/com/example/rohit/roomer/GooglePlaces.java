package com.example.rohit.roomer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class GooglePlaces extends ListActivity {



    public String search="";
    ArrayList<GooglePlace> venuesList;

    final String GOOGLE_KEY = "AIzaSyCOCCimrGi0QwR3dvydhzZ2ck0PgqZIYKI";

    ArrayAdapter<String> myAdapter;
    String temp;
    String apuni,apcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintwo);

        apuni=getIntent().getExtras().getString("University");
//        apcity=getIntent().getExtras().getString("City");


        search=apuni;


//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//
//        alert.setTitle("Search For Closest Apartments on Lease");
//
//        final EditText input = new EditText(this);
//        alert.setView(input);
//
//        alert.setPositiveButton("Search", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int whichButton) {
//                search = input.getText().toString();
//                new googleplaces().execute();

                // Do something with value!
//            }
//        });
//
//        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int whichButton) {
//                // Canceled.
//            }
//        });
//
//        alert.show();

        // start the AsyncTask that makes the call for the venues search.

        new googleplaces().execute();
    }

    private class googleplaces extends AsyncTask<View, Void, String> {

        @Override
        protected String doInBackground(View... urls) {

            String replaceText = search.replace(' ', '+');
            temp = makeCall("https://maps.googleapis.com/maps/api/place/textsearch/json?query="+replaceText+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");

            return "";
        }

        @Override
        protected void onPreExecute() {
            // we can start a progress bar here
        }

        @Override
        protected void onPostExecute(String result) {
            if (temp == null) {
                // we have an error to the call
                // we can also stop the progress bar
            } else {

                venuesList =  parseGoogleParse(temp);
                //tem=makeCall("https://maps.googleapis.com/maps/api/place/textsearch/json?pagetoken="+pageToken+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");

                List<String> listTitle = new ArrayList<String>();

                for (int i = 0; i < venuesList.size(); i++) {
                    // make a list of the venus that are loaded in the list.
                    // show the name, the category and the city
                    int[] colors = {0, 0xFFFF0000, 0}; // red for the example

                    listTitle.add(i, venuesList.get(i).getName() + "\nOpen Now: " + venuesList.get(i).getOpenNow() + "\n" + venuesList.get(i).getAddress() + "");
                    //listTitle.add(i, venuesList1.get(i).getName() + "\nOpen Now: " + venuesList1.get(i).getOpenNow() + "\n" + venuesList1.get(i).getAddress() + "");
                }
                // set the results to the list
                // and show them in the xml
                myAdapter = new ArrayAdapter<String>(GooglePlaces.this, R.layout.row_layout, R.id.listText, listTitle);

                setListAdapter(myAdapter);

            }

        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //String item = (String) getListAdapter().getItem(position);
        //Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();


        String name="";
        String rating="";
        String open=venuesList.get(position).getOpenNow();
        String address="";
        String lati="";
        String longi="";
        String place_id="";
        String picReference="";
        try {
            // make an jsonObject in order to parse the response
            JSONObject jsonObject = new JSONObject(temp);


            // make an jsonObject in order to parse the response
            if (jsonObject.has("results")) {

                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < jsonArray.length(); i++) {

                    if (jsonArray.getJSONObject(position).has("name")) {

                        name=jsonArray.getJSONObject(position).optString("name");
                        rating=jsonArray.getJSONObject(position).optString("rating", " ");
                        address=jsonArray.getJSONObject(position).optString("formatted_address");
                        place_id=jsonArray.getJSONObject(position).optString("place_id");

                        JSONObject e = jsonArray.getJSONObject(position);
                        JSONObject jsonLocation = e.getJSONObject("geometry").getJSONObject("location");

                        if(jsonArray.getJSONObject(i).has("photos")){
                            JSONArray jsonArray1 = jsonArray.getJSONObject(i).getJSONArray("photos");
                            for (int j = 0; j < jsonArray.length(); j++){
                                picReference=jsonArray1.getJSONObject(position).optString("photo_reference");
                            }
                        }

                        lati = jsonLocation.getString("lat");
                        longi = jsonLocation.getString("lng");
                        if (jsonArray.getJSONObject(position).has("opening_hours")) {
                            if (jsonArray.getJSONObject(position).getJSONObject("opening_hours").has("open_now")) {
                                if (jsonArray.getJSONObject(position).getJSONObject("opening_hours").getString("open_now").equals("true")) {
                                    open="YES";
                                } else {
                                    open="NO";
                                }
                            }
                        } else {
                            open="Not Known";
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent=new Intent(GooglePlaces.this,details.class);
        intent.putExtra("name",name);
        intent.putExtra("rating",rating);
        intent.putExtra("open",open);
        intent.putExtra("address",address);
        intent.putExtra("latitude",lati);
        intent.putExtra("longitude",longi);
        intent.putExtra("place_id",place_id);
        intent.putExtra("picReference",picReference);

        startActivity(intent);
    }

    public static String makeCall(String url) {

        // string buffers the url
        StringBuffer buffer_string = new StringBuffer(url);
        String replyString = "";

        // instanciate an HttpClient
        HttpClient httpclient = new DefaultHttpClient();
        // instanciate an HttpGet
        HttpGet httpget = new HttpGet(buffer_string.toString());

        try {
            // get the responce of the httpclient execution of the url
            HttpResponse response = httpclient.execute(httpget);
            InputStream is = response.getEntity().getContent();

            // buffer input stream the result
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayBuffer baf = new ByteArrayBuffer(20);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }
            // the result as a string is ready for parsing
            replyString = new String(baf.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(replyString);

        // trim the whitespaces
        return replyString.trim();
    }

    private static ArrayList<GooglePlace> parseGoogleParse(final String response) {

        ArrayList<GooglePlace> temp1 = new ArrayList<GooglePlace>();
        try {

            // make an jsonObject in order to parse the response
            JSONObject jsonObject = new JSONObject(response);
           /* if(jsonObject.has("next_page_token")){
                pageToken=jsonObject.optString("next_page_token");
            }*/

            // make an jsonObject in order to parse the response
            if (jsonObject.has("results")) {

                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < jsonArray.length(); i++) {
                    //Log.d("Count","123");
                    GooglePlace poi = new GooglePlace();
                    if (jsonArray.getJSONObject(i).has("name")) {
                        poi.setName(jsonArray.getJSONObject(i).optString("name"));
                        poi.setRating(jsonArray.getJSONObject(i).optString("rating", " "));
                        poi.setAddress(jsonArray.getJSONObject(i).optString("formatted_address"));

                        if (jsonArray.getJSONObject(i).has("opening_hours")) {
                            if (jsonArray.getJSONObject(i).getJSONObject("opening_hours").has("open_now")) {
                                if (jsonArray.getJSONObject(i).getJSONObject("opening_hours").getString("open_now").equals("true")) {
                                    poi.setOpenNow("YES");
                                } else {
                                    poi.setOpenNow("NO");
                                }
                            }
                        } else {
                            poi.setOpenNow("Not Known");
                        }

                        if (jsonArray.getJSONObject(i).has("types")) {
                            JSONArray typesArray = jsonArray.getJSONObject(i).getJSONArray("types");

                            for (int j = 0; j < typesArray.length(); j++) {
                                poi.setCategory(typesArray.getString(j) + ", " + poi.getCategory());
                            }
                        }


                    }
                    temp1.add(poi);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<GooglePlace>();
        }

        return temp1;


    }


}
