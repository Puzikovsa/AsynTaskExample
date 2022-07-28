package ru.synergy.asyntaskexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample extends AppCompatActivity {
    int mCounter = 1;

    ExecutorService service = Executors.newFixedThreadPool(3);

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView mInfoTextView = findViewById(R.id.textViewInfo);
            mInfoTextView.setText("Сегодня ворон было " + mCounter++ + " штук");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);
    }

    public void onClick(View view) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long endTime = System.currentTimeMillis() + 20 * 100;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };

        service.execute(runnable);


    }
}