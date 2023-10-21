package com.multimediaconvertor;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.multimediaconvertor.Data.myDBHandler;
import com.multimediaconvertor.model.History;

public class page_9th extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_9th);

        ImageButton backButton = findViewById(R.id.back_btn);
        ImageButton settingButton = findViewById(R.id.setting_btn);


        Button outputFile = findViewById(R.id.output_btn);
        outputFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDBHandler db = new myDBHandler (page_9th.this);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String currentDate = dateFormat.format(calendar.getTime());
                History history  = new History();
                history.setName("MP3 To WAV");
                history.setPath("android/path/path");
                history.setDate(currentDate);
                db.addHistory(history);
                Log.d("dbHistory","Name "+history.getName());
            }
        });

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
    }

    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);

    }
}
