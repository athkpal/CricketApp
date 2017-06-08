package com.example.windows7.cricket;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Windows 7 on 6/7/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MatchHolder> {


    private static ArrayList<String> matchName;
    private static ArrayList<String> id;

    public RecyclerAdapter(ArrayList<String> matchList,ArrayList<String> idList) {
        matchName = matchList;
        id = idList;
    }

    public static class MatchHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNameOfMatch;
        private static final String MATCH_KEY = "MATCH";

        public MatchHolder(View v) {
            super(v);
            mNameOfMatch = (TextView) v.findViewById(R.id.nameOfMatch);
            v.setOnClickListener(this);
        }

        public  void showMatch(String name){
        mNameOfMatch.setText(name+"\n");
        }

        @Override
        public void onClick(View v) {
            Log.d("RecyclerView", "CLICK!");
            Context context = itemView.getContext();
            Intent newintent = new Intent(context, MatchDetails.class);
            newintent.putExtra("id",id.get(getAdapterPosition()));
            newintent.putExtra("matchName",matchName.get(getAdapterPosition()));
            context.startActivity(newintent);
        }
    }

    @Override
    public RecyclerAdapter.MatchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new MatchHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MatchHolder holder, int position) {
    String name = matchName.get(position);
        holder.showMatch(name);
    }

    @Override
    public int getItemCount() {
        return matchName.size();
    }
}
