package com.multimediaconvertor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class page_4rth extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_4th);
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
        Button compressBtn = findViewById(R.id.compress_btn);
        Button mp3ToMp4Btn = findViewById(R.id.mp4_to_mp3_btn);
        Button trimBtn = findViewById(R.id.trim_btn);


        compressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencompressPage();
            }
        });
        mp3ToMp4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMp3ToMp4Page();
            }
        });
        trimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrimPage();
            }
        });
    }

    private void openTrimPage() {
        Intent intent = new Intent(this, page_19th.class);
        startActivity(intent);
    }

    private void openMp3ToMp4Page() {
        Intent intent = new Intent(this, page_16th.class);
        startActivity(intent);
    }

    private void opencompressPage() {
        Intent intent = new Intent(this, page_10th.class);
        startActivity(intent);
    }

    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);

    }
}
