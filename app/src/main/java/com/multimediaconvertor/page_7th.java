package com.multimediaconvertor;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class page_7th  extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_7th);

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

        Button convertToDocxBtn = findViewById(R.id.convertToDocx);
        Button mergePdfBtn = findViewById(R.id.mergePdfBtn);
        Button pdfSplitBtn = findViewById(R.id.pdfSplitBtn);


        convertToDocxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConvertToDocxPage();
            }
        });
        mergePdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMergePdfPage();
            }
        });
        pdfSplitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfSplitPage();
            }
        });
    }

    private void openConvertToDocxPage() {
        Intent intent = new Intent(this, page_18th.class);
        startActivity(intent);
    }

    private void openPdfSplitPage() {
        Intent intent = new Intent(this, page_17th.class);
        startActivity(intent);
    }

    private void openMergePdfPage() {
        Intent intent = new Intent(this, page_11th.class);
        startActivity(intent);
    }

    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);

    }}
