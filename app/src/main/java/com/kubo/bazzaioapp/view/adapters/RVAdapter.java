package com.kubo.bazzaioapp.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kubo.bazzaioapp.R;
import com.kubo.bazzaioapp.model.Resource;
import com.kubo.bazzaioapp.view.DetalleActivity;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ProductoViewHolder> {

    List<Resource.Producto> productos;
    final Context context;

    public RVAdapter(List<Resource.Producto> productos, Context context){
        this.productos = productos;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_producto, viewGroup, false);
        ProductoViewHolder pvh = new ProductoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder productoViewHolder, final int i) {
        productoViewHolder.nombreProducto.setText(productos.get(i).nombre);
        productoViewHolder.precioProducto.setText("$" + productos.get(i).precio);
        productoViewHolder.nombreProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleActivity.class);
                intent.putExtra("NOMBRE PRODUCTO", productos.get(i).nombre);
                intent.putExtra("DESCRIPCION PRODUCTO", productos.get(i).descripcion);
                intent.putExtra("IMAGEN PRODUCTO", productos.get(i).imagenUrl);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombreProducto;
        TextView precioProducto;

        ProductoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            nombreProducto = (TextView)itemView.findViewById(R.id.nombreProducto);
            precioProducto = (TextView)itemView.findViewById(R.id.precioProducto);
        }
    }
}
