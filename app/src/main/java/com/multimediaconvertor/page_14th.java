package com.multimediaconvertor;
import android.content.Intent;

import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.util.Log;
import com.multimediaconvertor.Data.myDBHandler;
import com.multimediaconvertor.model.History;


public class page_14th  extends AppCompatActivity {

    private Button upload_text_file_btn;







    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_14th);
        upload_text_file_btn = findViewById(R.id.upload_text_file_btn);




        ImageButton backButton = findViewById(R.id.back_btn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton settingButton = findViewById(R.id.setting_btn);
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
                myDBHandler db = new myDBHandler(page_14th.this);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String currentDate = dateFormat.format(calendar.getTime());
                History history = new History();
                history.setName("Text File To Uppercase");
                history.setPath("android/path/path");
                history.setDate(currentDate);
                db.addHistory(history);
                Log.d("dbHistory", "Name " + history.getName());
            }
        });
    }





    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);

    }

}

