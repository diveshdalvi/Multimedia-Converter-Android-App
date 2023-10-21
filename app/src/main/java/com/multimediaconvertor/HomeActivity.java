package com.multimediaconvertor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.multimediaconvertor.Data.myDBHandler;
import com.multimediaconvertor.databinding.ActivityHomeBinding;
import com.multimediaconvertor.model.History;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class HomeActivity extends AppCompatActivity  {
    ActivityHomeBinding binding;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        replaceFragment(new HomeFragment());
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.history) {
                replaceFragment(new HistoryFragment());
            }
            return true;
        });
//        myDBHandler db = new myDBHandler(HomeActivity.this);
//        List<History> allHistory = db.getHistory();
//        for(History history : allHistory){
//            Log.d("dbHistory","Id " + history.getId() + " Name " + history.getName() +" Path " + history.getPath() +" Date " + history.getDate() );
//        }
        }
        private void replaceFragment(Fragment fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            final FragmentTransaction replace = fragmentTransaction.replace(R.id.frame_layout , fragment);
            fragmentTransaction.commit();




        }
 }

