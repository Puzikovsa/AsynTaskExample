package ru.synergy.asyntaskexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThreadExample extends AppCompatActivity {
    int mCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);
    }

    public void onClick(View view){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long endTime = System.currentTimeMillis() + 20 * 100;
                while (System.currentTimeMillis() < endTime){
                    synchronized (this){
                        try {
                            wait(endTime - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                TextView mInfoTextView = findViewById(R.id.textViewInfo);
                mInfoTextView.setText("Сегодня ворон было " + mCounter++ + " штук");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}