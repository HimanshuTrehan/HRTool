package com.example.hrmanager.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrmanager.Adapter.LeaveAdapter;
import com.example.hrmanager.Adapter.LeaveApprovalAdapter;
import com.example.hrmanager.R;

public class LeaveApproval extends AppCompatActivity {

RecyclerView recyclerView;
LeaveApprovalAdapter leaveAdapter;
ImageView back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_approval);
        findViews();
    }

    private void findViews() {

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        recyclerView = findViewById(R.id.approve_recycler);
        leaveAdapter = new LeaveApprovalAdapter(getApplicationContext());
        LinearLayoutManager groceryManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(groceryManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(leaveAdapter);
    }
}
