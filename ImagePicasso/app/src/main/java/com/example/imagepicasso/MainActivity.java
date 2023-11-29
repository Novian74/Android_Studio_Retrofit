package com.example.imagepicasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image_url = findViewById(R.id.image_url);

        Picasso.get().load("https://cdnid.janfurnit.com/furnitur/img/meja-makan-minimalis-ext.jpg")
                .placeholder(R.drawable.images)
                .error(R.drawable.images)
                .into(image_url);
    }
}