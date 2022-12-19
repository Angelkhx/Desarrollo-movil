package com.example.aplicacionmovil.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aplicacionmovil.Catalogo;
import com.example.aplicacionmovil.DB.DBFirebase;
import com.example.aplicacionmovil.Entidades.Producto;
import com.example.aplicacionmovil.Form;
import com.example.aplicacionmovil.Info;
import com.example.aplicacionmovil.R;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> arrayProducto;

    public ProductoAdapter(Context context, ArrayList<Producto> arrayProducto) {
        this.context = context;
        this.arrayProducto = arrayProducto;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Producto> getArrayProducto() {
        return arrayProducto;
    }

    public void setArrayProducto(ArrayList<Producto> arrayProducto) {
        this.arrayProducto = arrayProducto;
    }

    @Override
    public int getCount() {
        return arrayProducto.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProducto.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater= LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.producto_template,null);

        Producto producto = arrayProducto.get(i);
        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);

        TextView textNameProduct = (TextView) view.findViewById(R.id.textNameProduct);
        TextView textDesciptionProduct = (TextView) view.findViewById(R.id.textDesciptionProduct);
        TextView textPriceProduct = (TextView) view.findViewById(R.id.textPriceProduct);
        Button btnDeleteProduct =(Button) view.findViewById(R.id.btnDeleteProduct);
        Button btnEditProduct =(Button) view.findViewById(R.id.btnEditProduct);

        imgProduct.setImageResource(producto.getImage());
        textNameProduct.setText(producto.getName());
        textDesciptionProduct.setText(producto.getDescription());
        textPriceProduct.setText(String.valueOf(producto.getPrice()));

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, Info.class);
                intent.putExtra("name",producto.getName());
                intent.putExtra("description",producto.getDescription());
                intent.putExtra("price",producto.getPrice());

                context.startActivity(intent);
            }
        });
        btnEditProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Form.class);
                intent.putExtra("edit",true);
                intent.putExtra("id",producto.getId());
                intent.putExtra("name", producto.getName());
                intent.putExtra("description",producto.getDescription());
                intent.putExtra("price",String.valueOf(producto.getPrice()));
                intent.putExtra("image",String.valueOf(producto.getImage()));
                intent.putExtra("latitud",producto.getLatitud());
                intent.putExtra("longitud",producto.getLongitud());
                context.startActivity(intent);


            }
        });

        btnDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBFirebase dbFirebase = new DBFirebase();
                dbFirebase.deleteData(producto.getId());
                Intent intent = new Intent(context, Catalogo.class);
                context.startActivity(intent);

            }
        });


        return view;
    }
}
