package com.kubo.bazzaioapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kubo.bazzaioapp.R;
import com.kubo.bazzaioapp.model.Resource;
import com.kubo.bazzaioapp.services.APIClient;
import com.kubo.bazzaioapp.services.APIInterface;
import com.kubo.bazzaioapp.view.adapters.RVAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIInterface apiInterface;
    private RecyclerView rv;
    private static List<Resource.Producto> listaProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        getProductos(apiInterface);
    }

    private void inicializarVista() {
        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(listaProductos, this);
        rv.setAdapter(adapter);
    }

    public void getProductos(APIInterface apiInterface){

        Call<Resource> callResource = apiInterface.getProductosTienda();
        callResource.enqueue(new Callback<Resource>() {
            @Override
            public void onResponse(Call<Resource> call, Response<Resource> response) {
                Log.d("TAG",response.code()+"");

                String displayResponse = "";

                Resource resource = response.body();
                Integer code = resource.code;
                listaProductos = resource.listaProductos;

                displayResponse +=  code + " code\n\n\n";

                for (Resource.Producto producto : listaProductos) {
                    displayResponse += producto.nombre + ", "
                                    + producto.descripcion + ", "
                                    + producto.imagenUrl + ", "
                                    + producto.precio + "\n\n";
                }

                Log.i("LISTA DE PRODUCTOS", displayResponse);
                inicializarVista();

            }

            @Override
            public void onFailure(Call<Resource> call, Throwable t) {
                Log.i("ERROR", "No se pudieron cargar los productos desde API remota");
            }
        });
    }
}
