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
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private ProgressDialog progressDialog;
    private String url = "https://atpmedia.vn/wp-content/uploads/2019/12/C%C3%A1ch-s%E1%BB%AD-d%E1%BB%A5ng-th%E1%BA%BB-IMG.jpg";
    private Bitmap bitmap = null;
    private ImageView imageView;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        setTitle("Màn Hình Chính");
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        button.setOnClickListener(this);
    }

    private Handler messageHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Bundle bundle = message.getData();
            String mgs = bundle.getString("Message");
            tvMessage.setText(mgs);
            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };

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
        progressDialog = ProgressDialog.show(Bai2Activity.this, "", "DownLoading....");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = downloadBitmap(url);
                Message message = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMessage = "Image Download Successfully";
                bundle.putString("Message", threadMessage);
                message.setData(bundle);
                messageHandler.sendMessage(message);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    private Bitmap downloadBitmap(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
};