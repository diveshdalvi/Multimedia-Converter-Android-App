package com.multimediaconvertor;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.multimediaconvertor.Data.myDBHandler;
import com.multimediaconvertor.model.History;

public class page_17th extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_17th);
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
        Button outputFile = findViewById(R.id.output_btn);
        outputFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDBHandler db = new myDBHandler (page_17th.this);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String currentDate = dateFormat.format(calendar.getTime());
                History history  = new History();
                history.setName("Split PDF");
                history.setPath("android/path/path");
                history.setDate(currentDate);
                db.addHistory(history);
                Log.d("dbHistory","Name "+history.getName());
            }
        });
    }


    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);
    }
    }
