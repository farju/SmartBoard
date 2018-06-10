package com.example.hiran.smartboard;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by hiran on 1/18/2018.
 */

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    String[] name;
    ArrayList<InputStream> inp;

    adapter(Context context, String[] s, ArrayList<InputStream> ip)
    {
        Log.i("ABC",s.toString());
        this.context=context;
        name=s;
        inp=ip;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.row_act,parent,false);
        item itm=new item(row);

        return itm;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Log.i("triallllll",name.toString());
        ((item)holder).textView.setText(name[position]);
        ((item)holder).imageView.setImageBitmap(BitmapFactory.decodeStream(inp.get(position)));



    }



    @Override
    public int getItemCount() {
        return name.length;
    }


    class item extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        ImageView imageView;
        CardView cardView;
        public item(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView=(TextView)itemView.findViewById(R.id.textView1);
            imageView=(ImageView)itemView.findViewById(R.id.imagee);
            cardView=(CardView)itemView.findViewById(R.id.itnotice);

        }

        @Override
        public void onClick(View view) {
            int a=getAdapterPosition();

//            Toast.makeText(context, this.textView.getText(),Toast.LENGTH_SHORT).show();
            Bundle data=new Bundle();
//            TextView tv=view.findViewById(R.id.textView);
            data.putString("100",this.textView.toString());
            Fragment fragment=new ITfragment();
            FragmentTransaction fragmentManager=((Activity)context).getFragmentManager().beginTransaction();
            fragmentManager.replace(R.id.frame, fragment);




        }
    }



}