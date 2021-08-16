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

public class LogicGateDec extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String  graph, name, descriplong,  picture ;
    public LogicGateDec() {

    }

    public LogicGateDec(String graph, String name, String descriplong, String picture   ) {
        this.graph = graph;
        this.name = name;
        this.descriplong = descriplong;
        this.picture = picture;

    }


    public static LogicGateDec newInstance(String param1, String param2) {
        LogicGateDec fragment = new LogicGateDec();
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

        View view =  inflater.inflate(R.layout.fragment_logic_gate_dec, container, false);
        ImageView imggraph = view.findViewById(R.id.img_graph);
        ImageView imgholder = view.findViewById(R.id.imagegholder);
        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView descriptionholder = view.findViewById(R.id.courseholder);

        TextView textviewtop = view.findViewById(R.id.txt_bartop);
        textviewtop.setText(name);
        nameholder.setText(name);
        descriptionholder.setText("\t\t\t\t\t" + descriplong);
        Glide.with(getContext()).load(picture).into(imgholder);
        Glide.with(getContext()).load(graph).into(imggraph);


        return view;
    }

    public void onBackPressed()

    {

        AppCompatActivity activity= (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.logicgateform,new fragmentLogicGates()).addToBackStack(null).commit();
    }
}