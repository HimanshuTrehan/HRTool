package com.example.hrmanager.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.example.hrmanager.Fragments.AdminFragment;
import com.example.hrmanager.Fragments.HomeFragment;
import com.example.hrmanager.Fragments.LeaveFragment;
import com.example.hrmanager.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    public static FragmentManager fragmentManager;
    public static Boolean isStackClear = false;
    public static Boolean isDoubleClicked = false;
    public static BottomNavigationView navigation;
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.person:
                    InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm1.isAcceptingText()) {
                        imm1.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    }

                    item.getIcon().setTint(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));

                    // clearAllStack();
//                    navigation.setSelectedItemId(R.id.navigation_home);
                    HomeFragment home = new HomeFragment();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.containerBody, home); // give your fragment container id in first parameter
                    //        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                    return true;

                case R.id.home:

                    InputMethodManager imm2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm2.isAcceptingText()) {
                        imm2.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    }
                    // clearAllStack();
                    item.getIcon().setTint(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));

                    LeaveFragment someFragment = new LeaveFragment();
                    FragmentTransaction transaction5 = fragmentManager.beginTransaction();
                    transaction5.replace(R.id.containerBody, someFragment); // give your fragment container id in first parameter
                    transaction5.addToBackStack("Home Dashboard");  // if written, this transaction will be added to backstack
                    transaction5.commit();

                    return true;

                case R.id.admin:

                    InputMethodManager imm3 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm3.isAcceptingText()) {
                        imm3.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    }
                    // clearAllStack();
                    item.getIcon().setTint(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));

                    AdminFragment adminfragment = new AdminFragment();
                    FragmentTransaction transaction2 = fragmentManager.beginTransaction();
                    transaction2.replace(R.id.containerBody, adminfragment); // give your fragment container id in first parameter
                    transaction2.addToBackStack("Home Dashboard");  // if written, this transaction will be added to backstack
                    transaction2.commit();

                    return true;


            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            findViews();

            HomeFragment home = new HomeFragment();
//         IntroVideoFragment home = new IntroVideoFragment();
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().
                    replace(R.id.containerBody, home, home.getTag())
                    /*.addToBackStack("Home Dashboard")*/.commit();
        } catch (Exception ex) {
        }
    }

    private void findViews() {
        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
