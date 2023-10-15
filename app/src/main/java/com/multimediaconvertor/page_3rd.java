package com.multimediaconvertor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class page_3rd extends top_rect {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_3rd);

        ImageButton backButton = findViewById(R.id.back_btn);
        ImageButton settingButton = findViewById(R.id.setting_btn);
        Button compressBtn = findViewById(R.id.compress_btn);
        Button cropBtn = findViewById(R.id.crop_btn);
        Button imgToPdfBtn = findViewById(R.id.image_to_pdf_btn);


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
        compressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCompress();
            }
        });
        cropBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCrop();
            }
        });
        imgToPdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImgToPdf();
            }
        });

    }



    private void openImgToPdf() {
        Intent intent = new Intent(this, page_12th.class);
        startActivity(intent);
    }

    private void openCrop() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);
    }

    private void openCompress() {
        Intent intent = new Intent(this, page_12th.class);
        startActivity(intent);
    }


    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);
    }

}
