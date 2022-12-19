package com.example.aplicacionmovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.aplicacionmovil.Adaptador.ProductoAdapter;
import com.example.aplicacionmovil.DB.DBFirebase;
import com.example.aplicacionmovil.Entidades.Producto;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    private ListView listViewProducts;
    private DBFirebase dbFirebase;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProducts = (ListView) findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();
        /*
        //****Productos
        Producto producto1 = new Producto("Lapislázuli","Este cristal está ligado energéticamente al chakra que se encuentra a la altura de la garganta (Como el cuarzo azul). ",10000,R.drawable.lapizlazuli,"","");
        Producto producto2 = new Producto("Hematoide","Tiene una relación con el chakra base, el rojo por lo que sus usos tienen relación con la sanación de la sexualidad",8000,R.drawable.hematoide,"","");
        Producto producto3 = new Producto("Cuarzo Arcoiris","Tiene la facultad de poder usarse para equilibrar cualquiera de los 7 chakras.",12000,R.drawable.arcoiris,"","");
        Producto producto4 = new Producto("Ojo de Tigre","Los antiguos egipcios las utilizaran es sus esculturas como representación del poder del sol y sus dioses protectores.",5000,R.drawable.ojodetigre,"","");
        Producto producto5 = new Producto("Jaspe Rojo","tiene la facultad de dar protección y romper con malas rachas en situaciones académicas, de estudios y ayuda a estimular la inteligencia.",15000,R.drawable.jaspe,"","");
        Producto producto6 = new Producto("Cuarzo Azul","Este cristal azul se relaciona con el quinto chakra, se le atribuye voluntad, tranquilidad y equilibrio emocional.",14000,R.drawable.azul,"","");
        Producto producto7 = new Producto(" Citrino","Es una de las piedras preciosas más raras del mundo por tener un color amarillento o anaranjado no común en el cuarzo.",20000,R.drawable.citrino,"","");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);
        arrayProductos.add(producto7);
        */
        productoAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productoAdapter);
        dbFirebase.getData(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(),Form.class);
                startActivity(intent);
                return  true;
            case R.id.itemMap:
                intent = new Intent(getApplicationContext(),Map.class);
                startActivity(intent);
                return  true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
