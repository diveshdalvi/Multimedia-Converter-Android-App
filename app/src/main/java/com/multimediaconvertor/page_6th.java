package com.multimediaconvertor;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class page_6th extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_6th);
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
//        Menu menu = bottomNavigationView.getMenu();
//
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            int itemId = item.getItemId();
//            if (itemId == R.id.home) {
//                startActivity(new Intent(this, HomeActivity.class));
//                return true;
//
//            } else if (itemId == R.id.history) {
//                startActivity(new Intent(this, HistoryPage.class));
//                return true;
//            } else {
//                return false;
//            }
//        });
    }
}
