package com.example.erovoutika;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class LEDdecfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String  reference, application, caption, symbol, name, descriplong,  picture;
    public LEDdecfragment() {

    }

    public LEDdecfragment(String reference,String application, String caption, String symbol, String name, String descriplong, String picture  ) {
        this.reference =reference;
        this.application = application;
        this.caption = caption;
        this.symbol = symbol;
        this.name = name;
        this.descriplong = descriplong;
        this.picture = picture;
    }


    public static LEDdecfragment newInstance(String param1, String param2) {
        LEDdecfragment fragment = new LEDdecfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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

        View view =  inflater.inflate(R.layout.fragment_l_e_ddecfragment, container, false);
        ImageView imgsymbol = view.findViewById(R.id.img_symbol);
        ImageView imgholder = view.findViewById(R.id.imagegholder);

        TextView txt_reference = view.findViewById(R.id.txt_reference);
        TextView txt_caption = view.findViewById(R.id.txt_captionsymbol);
        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView descriptionholder = view.findViewById(R.id.courseholder);
        TextView textviewtop = view.findViewById(R.id.textViewTop);
        TextView txt_application = view.findViewById(R.id.txt_application);

        txt_reference.setText(reference);
        txt_application.setText(application);
        txt_caption.setText(caption);
        textviewtop.setText(name);
        nameholder.setText(name);
        descriptionholder.setText(descriplong);
        Glide.with(getContext()).load(picture).into(imgholder);
        Glide.with(getContext()).load(symbol).into(imgsymbol);

        return view;
    }

    public void onBackPressed()

    {

        AppCompatActivity activity= (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainform,new mainFragment()).addToBackStack(null).commit();
    }
}