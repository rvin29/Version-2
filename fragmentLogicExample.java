package com.example.erovoutika;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class fragmentLogicExample extends Fragment {

    public fragmentLogicExample() {

    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    RecyclerView recviews;
    myAdapter2 adapter;





    public static fragmentLogicExample newInstance(String param1, String param2) {
        fragmentLogicExample fragment = new fragmentLogicExample();
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

        String phase;

        View view = inflater.inflate(R.layout.fragment_logic_example, container, false);

        recviews = (RecyclerView) view.findViewById(R.id.recviews);
        recviews.setLayoutManager(new LinearLayoutManager(getContext()));
        TextView txt_definition = (TextView)view.findViewById(R.id.txtdescriptionlogic);
        TextView txt_type = (TextView)view.findViewById(R.id.txt_typeslogic);

        txt_definition.setText("\t\t\tWhat is Logic Gates: \n\n \t\t\t\tA logic gate is a component in digital circuits that serves as a building block. They carry out basic logical operations that are essential in digital circuits. Logic gates are found in almost every electronic device we use today.  ");
        txt_type.setText("Types of Logical Gates:");

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Itemtype").child("examples"), model.class)
                        .build();

        adapter = new myAdapter2(options);
        recviews.setAdapter(adapter);
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