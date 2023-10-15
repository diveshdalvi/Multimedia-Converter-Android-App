package com.multimediaconvertor;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class page_13th  extends AppCompatActivity {
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.page_13th);
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
        }

        private void openSetting() {
                Intent intent = new Intent(this, settingPage.class);
                startActivity(intent);

        }
}
