package com.example.retrofitlibrary;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Viewholder extends RecyclerView.ViewHolder {

    TextView t1_userid, t2_id, t3_title, t4_boby;

    public Viewholder(@NonNull View itemView) {
        super(itemView);

        t1_userid = itemView.findViewById(R.id.userid_id);
        t2_id = itemView.findViewById(R.id.id_id);
        t3_title = itemView.findViewById(R.id.title_id);
        t4_boby = itemView.findViewById(R.id.boby_id);

    }
}
