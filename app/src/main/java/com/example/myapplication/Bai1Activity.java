package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai1Activity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private ImageView imageView,imageView3;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        setTitle("Màn Hình Chính");
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        button.setOnClickListener(this);
    }

    private Bitmap loadImage(String link) {
        URL url;
        Bitmap bmp = null;
        try {
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }


    @Override
    public void onClick(View v) {
         Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            final Bitmap bitmap = loadImage("https://upload.wikimedia.org/wikipedia/commons/7/7d/Eagle_Owl_IMG_9203.JPG");
          imageView.post(new Runnable() {
              @Override
              public void run() {
                  tvMessage.setText("Image Downloaded");
                  imageView.setImageBitmap(bitmap);
              }
          });
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap1 = loadImage("https://atpmedia.vn/wp-content/uploads/2019/12/C%C3%A1ch-s%E1%BB%AD-d%E1%BB%A5ng-th%E1%BA%BB-IMG.jpg");
               imageView3.post(new Runnable() {
                   @Override
                   public void run() {
                       tvMessage.setText("Image Downloaded");
                       imageView3.setImageBitmap(bitmap1);
                   }
               });
            }
        });

        thread1.start();
    }}