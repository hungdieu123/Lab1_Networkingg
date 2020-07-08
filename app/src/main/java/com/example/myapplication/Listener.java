package com.example.myapplication;

import android.graphics.Bitmap;

public interface Listener {
    void onImageLoaded(Bitmap bitmap);
    void onError();
}
