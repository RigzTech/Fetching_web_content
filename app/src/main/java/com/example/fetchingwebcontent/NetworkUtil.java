package com.example.fetchingwebcontent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.URL;

public class NetworkUtil {

    public static Bitmap fetchImage(String url) {
        Bitmap bitmapImage = null;
        try {
            InputStream inputstream = new URL(url).openStream();
            bitmapImage = BitmapFactory.decodeStream(inputstream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmapImage;
    }
}
