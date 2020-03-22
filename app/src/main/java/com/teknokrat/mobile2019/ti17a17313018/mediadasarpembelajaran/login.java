package com.teknokrat.mobile2019.ti17a17313018.mediadasarpembelajaran;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends Activity {
        ImageView GambarGif;
        Button btn_daftar,btn_masuk;
        EditText email_et,password_et;
        String email_txt,password_txt;
        private FirebaseAuth mAuth;
        private FirebaseAuth.AuthStateListener fStateListener;



    //Login
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_login);

            // animasi GIF

            GambarGif = (ImageView)findViewById(R.id.spons);

            Glide.with(login.this)
                    // LOAD URL DARI LOKAL DRAWABLE
                    .load(R.drawable.sponsbob).asGif()
                    //PENGATURAN CACHE
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(GambarGif);



            //Login
            btn_daftar = findViewById(R.id.btn_register);
            email_et    = findViewById(R.id.emailET);
            password_et = findViewById(R.id.passwordET);
            mAuth = FirebaseAuth.getInstance();
            btn_masuk = findViewById(R.id.btn_login);
            btn_masuk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    email_txt = email_et.getText().toString();
                    password_txt = password_et.getText().toString();
                    if (TextUtils.isEmpty(email_txt)) {
                        Toast.makeText(getApplicationContext(), "Masukan Email !!!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(password_txt)) {
                        Toast.makeText(getApplicationContext(), "Masukan Password !!!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    mAuth.signInWithEmailAndPassword(email_txt, password_txt)
                            .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {



                                        // Login sukses, masuk ke Main Activity
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent = new Intent(login.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        // Jika Login gagal, memberikan pesan
                                        Toast.makeText(login.this, "Proses Login gagal : " +  task.getException(),
                                                Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            });
            //Click listerner, kalau tombol btn_daftar di klik. Membuka activity register
            btn_daftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(login.this, register.class));
                    finish();
                }
            });
        }





}