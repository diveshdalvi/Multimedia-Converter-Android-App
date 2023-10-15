package com.multimediaconvertor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class page_20th extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_20th);

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

//        int playIcon = R.drawable.ic_play;
//        int pauseIcon = R.drawable.ic_pause;
//
//        ImageView playPauseImageView = findViewById(R.id.playPauseImageView);
//
//        playPauseImageView.setOnClickListener(new View.OnClickListener() {
//
//            boolean isPlaying = false;
//            public void onClick(View v) {
//                if (isPlaying) {
//                    // If playing, pause the audio and change the icon to play
//                    mediaPlayer.pause();
//                    playPauseImageView.setImageResource(playIcon);
//                } else {
//                    // If not playing, start or resume audio and change the icon to pause
//                    mediaPlayer.start();
//                    playPauseImageView.setImageResource(pauseIcon);
//                }
//                isPlaying = !isPlaying; // Toggle the playback state
//            }
//        });
    }

    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);

    }}
