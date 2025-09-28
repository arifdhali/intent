package com.example.tictac;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Apple extends AppCompatActivity {
    TextToSpeech tts;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apple_activity);


        String fruitName = getIntent().getStringExtra("fruits_name");
        tts = new TextToSpeech(this, status -> {
            if (status != TextToSpeech.ERROR) {
                tts.setLanguage(Locale.US);
                speakFruits(fruitName);
            }
        });


    }

    protected void speakFruits(String f) {
        if (f != null) {

            tts.speak(f, TextToSpeech.QUEUE_FLUSH, null, null);
        }

    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();

        }
        super.onDestroy();
    }
}
