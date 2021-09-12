package com.example.hrmanager.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hrmanager.Activity.ApplyLeave;
import com.example.hrmanager.Activity.MainActivity;
import com.example.hrmanager.R;

public class HomeFragment extends Fragment {

    TextView leave;
    View rootView;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rootView = inflater.inflate(R.layout.fragment_home, container, false);
            findViews();
        return rootView;

    }

    private void findViews() {

        leave = rootView.findViewById(R.id.leave);
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ApplyLeave.class);
                startActivity(intent);
            }
        });
    }

}