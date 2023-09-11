package com.example.fetchingwebcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    public void DownloadImage(View view) {
        String mUrl = "https://upload.wikimedia.org/wikipedia/commons/4/42/Travis_Scott_The_DAMN._Tour_%40_TD_Garden_%28Boston%2C_MA%29_%2835709832840%29.jpg";

        Log.i("interaction","Button Tapped");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView downloadedImg = (ImageView) findViewById(R.id.ImageView);

        ExecutorService service = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        service.execute(new Runnable() {
            @Override
            public void run() {

                String mUrl = "https://upload.wikimedia.org/wikipedia/commons/4/42/Travis_Scott_The_DAMN._Tour_%40_TD_Garden_%28Boston%2C_MA%29_%2835709832840%29.jpg";
                Bitmap bitmap = NetworkUtil.fetchImage(mUrl);

               /*runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       if (bitmap != null)
                           downloadedImg.setImageBitmap(bitmap);
                   }
               });*/

               handler.post(new Runnable() {
                   @Override
                   public void run() {

                       if (bitmap != null)
                           downloadedImg.setImageBitmap(bitmap);

                   }
               });

            }
        });

    }


}