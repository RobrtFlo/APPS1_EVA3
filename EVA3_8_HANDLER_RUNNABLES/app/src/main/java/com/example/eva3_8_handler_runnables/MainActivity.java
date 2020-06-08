package com.example.eva3_8_handler_runnables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtVwMensa;
Handler miHandler = new Handler();
int i;
Runnable backGroundRun = new Runnable() {
    @Override
    public void run() {
        int i = 0;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                miHandler.post(foreGroundRun);
            }
            Message msg = miHandler.obtainMessage(10000, i);
            miHandler.sendMessage(msg);

            Log.wtf("MiRunnable",i+ "");

            i++;
        }
    }
};
Runnable foreGroundRun = new Runnable() {
    @Override
    public void run() {
txtVwMensa.append("valor i = "+ i + "\n");
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensa = findViewById(R.id.txtVwMensa);
Thread tHilo = new Thread(backGroundRun);
tHilo.start();
    }
}
