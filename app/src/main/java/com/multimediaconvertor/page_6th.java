package com.multimediaconvertor;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class page_6th extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_6th);


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
        Button convertToUpperBtn = findViewById(R.id.convertToUpperBtn);
        Button convertToLowerBtn = findViewById(R.id.convertToLowerBtn);
        Button changeStylingBtn = findViewById(R.id.changeStyling_btn);


        convertToUpperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openConvertToUppercase();
            }
        });
        convertToLowerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConvertToLowerCase();
            }
        });
        changeStylingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChangeStylingPage();
            }
        });
    }

    private void openConvertToLowerCase() {
        Intent intent = new Intent(this, page_15th.class);
        startActivity(intent);
    }

    private void openConvertToUppercase() {
        Intent intent = new Intent(this, page_14th.class);
        startActivity(intent);
    }

    private void openChangeStylingPage() {
        Intent intent = new Intent(this, page_8th.class);
        startActivity(intent);
    }

    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);

    }
}
