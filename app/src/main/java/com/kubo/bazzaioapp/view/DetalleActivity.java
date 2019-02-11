package com.kubo.bazzaioapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kubo.bazzaioapp.R;

public class DetalleActivity extends AppCompatActivity {

    ImageView ivDetalle;
    TextView tvTitulo;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        ivDetalle = findViewById(R.id.ivImagenDetalle);
        tvTitulo = findViewById(R.id.tvTituloDetalle);
        tvDescripcion = findViewById(R.id.tvDescripcionDetalle);

        Intent intent = getIntent();
        Glide.with(this).load(intent.getStringExtra("IMAGEN_PRODUCTO")).into(ivDetalle);

        tvTitulo.setText(intent.getStringExtra("NOMBRE_PRODUCTO"));
        tvDescripcion.setText(intent.getStringExtra("DESCRIPCION_PRODUCTO"));

    }
}
