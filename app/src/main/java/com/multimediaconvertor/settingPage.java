package com.multimediaconvertor;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class settingPage extends AppCompatActivity {
    @SuppressLint({"UseSwitchCompatOrMaterialCode", "MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_page);

        Switch darkModeSwitch;
        darkModeSwitch = findViewById(R.id.theme_toggle_switch);

        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Enable Dark Mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    // Disable Dark Mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
        ImageView aboutDevBtn;
        TextView aboutDevBtnText;
        aboutDevBtn = findViewById(R.id.aboutDevBtn);
        aboutDevBtnText = findViewById(R.id.aboutDevBtnText);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                if (v == aboutDevBtn) {
                    openAboutDevPage();
                } else if (v == aboutDevBtnText) {
                    openAboutDevPage();
                }
            }
        };
        aboutDevBtn.setOnClickListener(clickListener);
        aboutDevBtnText.setOnClickListener(clickListener);
    }

    private void openAboutDevPage() {
        Intent intent = new Intent(this, about_dev.class);
        startActivity(intent);
    }
}

