package com.example.erovoutika;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toolbar;


import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class DiodeFragment extends Fragment {

    public DiodeFragment() {

    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    Integer counter = 0;
    RecyclerView recview;
    myAdapter adapter;




    // TODO: Rename and change types and number of parameters
    public static DiodeFragment newInstance(String param1, String param2) {
        DiodeFragment fragment = new DiodeFragment();

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
        setHasOptionsMenu(true);


        View view = inflater.inflate(R.layout.fragment_diode, container, false);

        recview = (RecyclerView) view.findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));
        Button btn_diode = (Button)view.findViewById(R.id.btn_diode);
        Button btn_LED = (Button)view.findViewById(R.id.btn_LED);
        Button btn_resistor = (Button)view.findViewById(R.id.btn_Sensor);
        TextView txt_types = view.findViewById(R.id.txt_types);
        TextView txt_Description = (TextView)view.findViewById(R.id.txtDefinition);



        txt_Description.setText("\t\t\t What is Diode?: A diode is an electronic component with two terminals that conducts electricity primarily in one direction. On one end, it has a lot of resistance and on the other, it has a lot of resistance. Let's take a closer look at what a diode is in this article.");
        txt_types.setText("Types of Diodes:");

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Itemtype").child("diodes"), model.class)
                        .build();

        adapter = new myAdapter(options);
        counter = 0;


        recview.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }


    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}