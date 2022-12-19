package com.example.aplicacionmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private Button btnLogin, getBtnLoginRegister;
    private EditText editEmailLogin, editPasswordLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        getBtnLoginRegister = (Button) findViewById(R.id.btnLoginRegister);
        editEmailLogin = (EditText) findViewById(R.id.editEmailLogin);
        editPasswordLogin = (EditText) findViewById(R.id.editPasswordLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmailLogin.getText().toString();
                String pass = editPasswordLogin.getText().toString();
                FirebaseAuth mAuth;
                // ...
                // Initialize Firebase Auth
                mAuth = FirebaseAuth.getInstance();

                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent intent = new Intent(getApplicationContext(),Catalogo.class);
                                    startActivity(intent);

                                }

                            }
                        });

            }
        });
        getBtnLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Registro.class);
                startActivity(intent);
            }
        });
    }
}