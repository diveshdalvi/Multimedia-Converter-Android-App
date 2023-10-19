package com.multimediaconvertor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import com.multimediaconvertor.Data.myDBHandler;
import com.multimediaconvertor.databinding.ActivityHomeBinding;
import com.multimediaconvertor.model.History;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity  {
    ActivityHomeBinding binding;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        myDBHandler db = new myDBHandler (HomeActivity.this);
        History history  = new History();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String currentDate = dateFormat.format(calendar.getTime());
        history.setName("Compress Image");
        history.setPath("android/path/path");
        history.setDate(currentDate);
        db.addHistory(history);


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

        }



        private void replaceFragment(Fragment fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            final FragmentTransaction replace = fragmentTransaction.replace(R.id.frame_layout , fragment);
            fragmentTransaction.commit();




        }
 }

