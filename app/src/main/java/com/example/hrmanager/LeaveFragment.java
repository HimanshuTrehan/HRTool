package com.example.hrmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class LeaveFragment extends Fragment {

    View v;
    private static final String[] paths = {"item 1", "item 2", "item 3"};

    public LeaveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         v = inflater.inflate(R.layout.fragment_leave, container, false);

         findViews();

         return  v;
    }

    private void findViews() {
       Spinner spinner = (Spinner)v.findViewById(R.id.spinner1);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}
