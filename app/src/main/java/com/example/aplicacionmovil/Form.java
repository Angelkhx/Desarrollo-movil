package com.example.aplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aplicacionmovil.DB.DBFirebase;
import com.example.aplicacionmovil.Entidades.Producto;

public class Form extends AppCompatActivity {
    private Button btnForm;
    private DBFirebase dbFirebase;
    private EditText editNameForm, editDescriptionForm, editPriceForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnForm = (Button) findViewById(R.id.btnForm);
        editNameForm = (EditText) findViewById(R.id.editTextNameForm);
        editDescriptionForm =(EditText) findViewById(R.id.editTextDescriptionForm);
        editPriceForm =(EditText) findViewById(R.id.editTextPriceForm);
        dbFirebase = new DBFirebase();

        Intent intentIn = getIntent();
        if (intentIn.getBooleanExtra("edit",false)){
            editNameForm.setText(intentIn.getStringExtra("name"));
            editDescriptionForm.setText(intentIn.getStringExtra("description"));
            editPriceForm.setText(intentIn.getStringExtra("price"));

        }

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Producto producto = new Producto(
                        editNameForm.getText().toString(),
                        editDescriptionForm.getText().toString(),
                        Integer.parseInt(editPriceForm.getText().toString()),
                        Integer.parseInt(""),
                        "",
                        ""
                );
                dbFirebase.insertData(producto);

                if (intentIn.getBooleanExtra("edit",false)){
                    producto.setId(intentIn.getStringExtra("id"));
                    dbFirebase.updateData(producto);

                }else{
                    dbFirebase.insertData(producto);

                }
                dbFirebase.insertData(producto);
                Intent intent = new Intent(getApplicationContext(),Catalogo.class);
                startActivity(intent);


            }
        });


    }
}