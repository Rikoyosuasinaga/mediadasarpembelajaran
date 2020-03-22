package com.teknokrat.mobile2019.ti17a17313018.mediadasarpembelajaran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {
    ImageView GambarGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Tulisan Gif

        GambarGif = (ImageView)findViewById(R.id.huruf);

        Glide.with(MainActivity.this)
                // LOAD URL DARI LOKAL DRAWABLE
                .load(R.drawable.huruf).asGif()
                //PENGATURAN CACHE
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(GambarGif);

        GambarGif = (ImageView)findViewById(R.id.angka);

        Glide.with(MainActivity.this)
                // LOAD URL DARI LOKAL DRAWABLE
                .load(R.drawable.angka).asGif()
                //PENGATURAN CACHE
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(GambarGif);

        GambarGif = (ImageView)findViewById(R.id.profil);

        Glide.with(MainActivity.this)
                // LOAD URL DARI LOKAL DRAWABLE
                .load(R.drawable.profil).asGif()
                //PENGATURAN CACHE
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(GambarGif);

    }



// Menu Share
    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.share_menu, menu);
        return true;
    }


    public boolean onOptionItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.share:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String bodyText = "Masukan Text di sini";
                intent.putExtra(Intent.EXTRA_SUBJECT,  "Jika Ingin Masukan Subjek, Masukan Disini");
                intent.putExtra(intent.EXTRA_TEXT, bodyText);
                startActivity(Intent.createChooser(intent, "Sharing Option"));
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }


    //inten huruf
    public void alfabet(View view) {
        Intent intent = new Intent(MainActivity.this, huruf.class);
        startActivity(intent);
    }

    public void angka(View view) {
        Intent intent = new Intent(MainActivity.this, angka.class);
        startActivity(intent);
    }

    public void profil(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

}



