package com.example.retrofitsetup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;

    private TextView textView;

    private final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String title = getIntent().getStringExtra("intent_title");
        String image = getIntent().getStringExtra("intent_image");
        getSupportActionBar().setTitle(title);

        textView = findViewById(R.id.judulTextView);
        textView.setText(title);

        Picasso.get().
                load(image)
                .into((ImageView) findViewById(R.id.imageView));
    }
}