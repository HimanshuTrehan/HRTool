package com.example.hrmanager.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hrmanager.Activity.AddMember;
import com.example.hrmanager.Activity.LeaveApproval;
import com.example.hrmanager.R;

public class AdminFragment extends Fragment {
    View rootView;
    RelativeLayout add_user,leave_approval_lyt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.admin_fragment, container, false);
       findViews();
        return rootView;
    }

    private void findViews() {
        add_user = rootView.findViewById(R.id.add_user);
        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddMember.class);
                startActivity(intent);
            }
        });
        leave_approval_lyt = rootView.findViewById(R.id.leave_approval_lyt);
        leave_approval_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LeaveApproval.class);
                startActivity(intent);
            }
        });
    }
}
