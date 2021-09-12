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

public class LeaveApprovalAdapter extends RecyclerView.Adapter<LeaveApprovalAdapter.UnderShop> {

    private View v;
    int size = 10;
    private Context mContext;

    public LeaveApprovalAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LeaveApprovalAdapter.UnderShop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leave_approval_adapter, parent, false);
        UnderShop vh = new UnderShop(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LeaveApprovalAdapter.UnderShop holder, int position) {




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
