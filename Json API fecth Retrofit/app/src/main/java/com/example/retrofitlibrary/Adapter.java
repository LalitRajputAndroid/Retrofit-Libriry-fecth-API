package com.example.retrofitlibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitlibrary.Modals.Modal1;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Viewholder> {

    List<Modal1> list;

    public Adapter(List<Modal1> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlerow,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.t1_userid.setText(String.valueOf(list.get(position).getUserId()));
        holder.t2_id.setText(String.valueOf(list.get(position).getId()));
        holder.t3_title.setText(list.get(position).getTitle());
        holder.t4_boby.setText(list.get(position).getBoby());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
