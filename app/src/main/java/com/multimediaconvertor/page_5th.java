package com.multimediaconvertor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class page_5th extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_5th);

        ImageButton backButton = findViewById(R.id.back_btn);
        ImageButton settingButton = findViewById(R.id.setting_btn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetting();
            }
        });
        Button mp3ToWavBtn = findViewById(R.id.mp3_to_wav_btn);
        Button trimBtn = findViewById(R.id.trim_btn);



        mp3ToWavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMp3ToWavPage();
            }
        });
        trimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetting();
            }
        });
    }

    private void openMp3ToWavPage() {
        Intent intent = new Intent(this, page_9th.class);
        startActivity(intent);
    }

    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);

//
    }
}
