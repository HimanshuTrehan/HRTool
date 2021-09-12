package com.example.hrmanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hrmanager.R;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LeaveAdapter extends RecyclerView.Adapter<LeaveAdapter.UnderShop> {

    private View v;
    int size = 20;
    private Context mContext;

    public LeaveAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LeaveAdapter.UnderShop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leave_adapter, parent, false);
        UnderShop vh = new UnderShop(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LeaveAdapter.UnderShop holder, int position) {




    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class UnderShop extends RecyclerView.ViewHolder {



        public UnderShop(@NonNull View itemView) {
            super(itemView);
        //    mImage = itemView.findViewById(R.id.productImage);

        }
    }
}
