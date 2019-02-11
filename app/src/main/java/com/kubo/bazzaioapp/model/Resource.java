package com.kubo.bazzaioapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Resource {

    @SerializedName("code")
    public Integer code;

    @SerializedName("data")
    public List<Producto> listaProductos;

    public class Producto{
        @SerializedName("nombre")
        public String nombre;

        @SerializedName("descripcion")
        public String descripcion;

        @SerializedName("imagen")
        public String imagenUrl;

        @SerializedName("precio")
        public Double precio;

        public double cantidad;
    }

}
