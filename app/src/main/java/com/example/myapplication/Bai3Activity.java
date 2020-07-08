package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai3Activity extends AppCompatActivity implements View.OnClickListener,Listener {
    private Button button;
    private ImageView imageView;
    private TextView tvMessage;

    public static final String IMAGE_URL = "https://atpmedia.vn/wp-content/uploads/2019/12/C%C3%A1ch-s%E1%BB%AD-d%E1%BB%A5ng-th%E1%BA%BB-IMG.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        setTitle("Bài 3");
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.button:
                new LoadImageTask((com.example.myapplication.Listener) this,this).execute(IMAGE_URL);
                break;
        }
    }
    public void onImageLoaded(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
        tvMessage.setText("Image Downloaded");
}
     public void onError(){
        tvMessage.setText("Error Download Image");
     }

}