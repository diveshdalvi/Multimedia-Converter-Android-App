package com.multimediaconvertor;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spannable;
import android.text.style.UnderlineSpan;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
public class page_8th extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_8th);


        TextView myTextView = findViewById(R.id.textView9);
        String text = "Underlined Text";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        myTextView.setText(spannableString);

    }}
