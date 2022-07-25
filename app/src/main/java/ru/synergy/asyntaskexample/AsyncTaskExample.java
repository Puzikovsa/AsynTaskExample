package ru.synergy.asyntaskexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AsyncTaskExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynk_task_example);

        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute("Hello, World");
    }
    
    public void onClick(View view){
        // TODO: 25.07.2022  
    }
}

class MyAsyncTask extends AsyncTask<String, Integer, Integer>{

    @Override
    protected Integer doInBackground(String... strings) {
        int myProgress = 0;
        publishProgress(myProgress);
        int result = myProgress++;
        return result;
    }
    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}