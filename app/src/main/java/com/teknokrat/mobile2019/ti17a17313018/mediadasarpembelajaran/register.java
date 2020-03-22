package com.teknokrat.mobile2019.ti17a17313018.mediadasarpembelajaran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends Activity {
    Button btn_register;
    EditText email_et,password_et;
    TextView btn_backtologin;
    String email_txt,password_txt;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        btn_backtologin = findViewById(R.id.btn_backtologin);
        email_et    = findViewById(R.id.emailET);
        password_et = findViewById(R.id.passwordET);
        btn_register = findViewById(R.id.btn_register);
        mAuth = FirebaseAuth.getInstance();

        
        btn_backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this, login.class));
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
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
                mAuth.createUserWithEmailAndPassword(email_txt, password_txt)
                        .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>(){
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Daftar sukses, masuk ke Main Activity
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(register.this, login.class);



                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Jika daftar gagal, memberikan pesan
                                    Toast.makeText(register.this, "Proses Pendaftaran gagal : " +  task.getException(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

    }
}
