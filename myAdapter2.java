package com.example.erovoutika;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter2 extends FirebaseRecyclerAdapter <model,myAdapter2.myViewHolder>
{



    public myAdapter2(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull model model) {
        holder.itemname.setText(model.getNumber()+ ". " + model.getName());



        holder.itemname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity= (AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.logicgateform,new LogicGateDec(model.getGraph(),model.getName(),model.getDescriplong(),model.getPicture())).addToBackStack(null).commit();
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {


        TextView itemname;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            itemname = itemView.findViewById(R.id.itemname);

        }
    }
}
