package com.example.rohit.roomer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link postAd.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link postAd#newInstance} factory method to
 * create an instance of this fragment.
 */
public class postAd extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public boolean FLAG_PHOTO=false;
    EditText aTitle;
    EditText aDescrip;
    Button button1;
    String mCurrentPhotoPath;
    final int REQUEST_TAKE_PHOTO = 1;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment postAd.
     */
    // TODO: Rename and change types and number of parameters
    public static postAd newInstance(String param1, String param2) {
        postAd fragment = new postAd();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public postAd() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_ad, container, false);
        aTitle = (EditText) view.findViewById(R.id.addTitle);
        aDescrip = (EditText) view.findViewById(R.id.addDescription);
        Button search = (Button) view.findViewById(R.id.searchAd);
        search.setOnClickListener(this);

        button1=(Button) view.findViewById(R.id.addPhotoAd);



       // button1= (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Ensure that there's a camera activity to handle the intent
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    // Create the File where the photo should go
                    File photoFile = null;
                    try {
//                            FLAG_PHOTO=true;
                        photoFile = createImageFile();
                    } catch (IOException ex) {

                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        FLAG_PHOTO=true;
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(photoFile));
                        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                    }
                }
            }
        });

        return view;
    }
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath =image.getAbsolutePath();
        return image;
    }


    @Override
    public void onClick(View v) {


        final String ad=aDescrip.getText().toString();
        final String at=aTitle.getText().toString();
        ParseObject ad1 = new ParseObject("Ad");


        if(FLAG_PHOTO)
        {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;  // Experiment with different sizes
            Bitmap b = BitmapFactory.decodeFile(mCurrentPhotoPath, options);
            // Convert it to byte
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            // Compress image to lower quality scale 1 - 100
            //                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            b.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] image = stream.toByteArray();
            // Create the ParseFile
            ParseFile file = new ParseFile("picture.jpeg", image);
            // Upload the image into Parse Cloud
            file.saveInBackground();

            ad1.put("imageUpload",file);
        }


        String name1=(String) ParseUser.getCurrentUser().get("FullName");
        String phone1=(String) ParseUser.getCurrentUser().get("Phone");
        String age1=(String) ParseUser.getCurrentUser().get("Age");
        String university1=(String) ParseUser.getCurrentUser().get("University");
        String city1=(String) ParseUser.getCurrentUser().get("City");


        //ParseObject ad1 = new ParseObject("Ad");
        ad1.put("Title", at);
        ad1.put("Description", ad);
        ad1.put("FullName",name1);
        ad1.put("Phone",phone1);
        ad1.put("University",university1);
        ad1.put("City",city1);
//      ad1.put("Email",(String) ParseUser.getCurrentUser().get("email"));
        ad1.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                startActivity(new Intent(getActivity(),MainActivity2Activity.class));

            }
        });




    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
