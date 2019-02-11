package com.kubo.bazzaioapp.services;


import com.kubo.bazzaioapp.model.Resource;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("listados/listar_productos_tienda/298/0/0")
    Call<Resource> getProductosTienda();
}
