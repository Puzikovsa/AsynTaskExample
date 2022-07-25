package ru.synergy.asyntaskexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class AsyncTaskExample extends AppCompatActivity {

    private TextView mTextView;
    private ProgressBar mProgressBar;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynk_task_example);
        mTextView = findViewById(R.id.tv_text_info);
        mProgressBar = findViewById(R.id.progressBar);
        mButton = findViewById(R.id.button_start);

    }
    
    public void onClick(View view){
        CurierTask curierTask = new CurierTask();
        curierTask.execute();
    }

    public class CurierTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            mTextView.setText("Доставщик зашел в Ваш дом");
            mButton.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mTextView.setText("Этаж " + values[0]);
            mProgressBar.setProgress(values[0]);

        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                int counter = 0;
                for (int i = 0; i < 14; i++){
                    getFlor (counter);
                    publishProgress(++counter);
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            mTextView.setText("Звонок в дверь. Заберите свою покупку :)");
            mButton.setVisibility(View.VISIBLE);
            mProgressBar.setProgress(0);
        }

        private void getFlor(int counter) throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }
    }
}


