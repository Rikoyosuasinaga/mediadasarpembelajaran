package com.teknokrat.mobile2019.ti17a17313018.mediadasarpembelajaran;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class splashscreen extends Activity {
    ImageView GambarGif;
    private int waktu_loading=9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        GambarGif = (ImageView)findViewById(R.id.splash);


    //Animasi Gif



        Glide.with(splashscreen.this)
            // LOAD URL DARI LOKAL DRAWABLE
            .load(R.drawable.splashscreen).asGif()
    //PENGATURAN CACHE
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(GambarGif);

        //Splashnya
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent MainActivity = new Intent(splashscreen.this, login.class);
                startActivity(MainActivity);
                finish();

            }
        }, waktu_loading);


    }
}