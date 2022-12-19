package com.example.aplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {
    private Button btnRegistro;
    private EditText editEmailReg, editPasswordReg, editPasswordConfirReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        editEmailReg = (EditText) findViewById(R.id.editEmailReg);
        editPasswordReg = (EditText) findViewById(R.id.editPasswordReg);
        editPasswordConfirReg =(EditText) findViewById(R.id.editPasswordConfirReg);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmailReg.getText().toString();
                String pass = editPasswordReg.getText().toString();
                String confirm = editPasswordConfirReg.getText().toString();

                if(pass.compareTo(confirm) == 0){
                    FirebaseAuth mAuth;
                    // ...
                    // Initialize Firebase Auth
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email, pass);
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "Contraseña no coinside", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}