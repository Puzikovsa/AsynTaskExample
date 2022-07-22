package ru.synergy.asyntaskexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view){
        switch (view.getId()){
            case R.id.asyncTask:
                Intent intent = new Intent(this, AsyncTaskExample.class);
                startActivity(intent);
        }
    }
}