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


public class mainFragment extends Fragment {

    public mainFragment() {

    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    Integer counter = 0;
    RecyclerView recview;
    myAdapter adapter;




    // TODO: Rename and change types and number of parameters
    public static mainFragment newInstance(String param1, String param2) {
        mainFragment fragment = new mainFragment();

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
    String phase;

       View view = inflater.inflate(R.layout.fragment_main, container, false);

       recview = (RecyclerView) view.findViewById(R.id.recview);
       recview.setLayoutManager(new LinearLayoutManager(getContext()));

       TextView txt_types = view.findViewById(R.id.txt_types);
       TextView txt_Description = (TextView)view.findViewById(R.id.txtDefinition);




       txt_Description.setText("\t\t\tWhat is LED : A Light Emitting Diode (LED) is a semiconductor device, which can emit light when an electric current passes through it. To do this, holes from p-type semiconductors recombine with electrons from n-type semiconductors to produce light. The wavelength of the light emitted depends on the bandgap of the semiconductor material.");
       txt_types.setText("Types of LED:");

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Itemtype").child("LED"), model.class)
                        .build();

        adapter = new myAdapter(options);






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