package cr.ac.ucr.proyecto2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cr.ac.ucr.proyecto2.adapters.DetallesListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import java.util.ArrayList;

import cr.ac.ucr.proyecto2.databinding.ActivityDetallesBinding;
import cr.ac.ucr.proyecto2.interfaces.ApiAdapter;
import cr.ac.ucr.proyecto2.model.Detalles;
import retrofit2.Call;

public class DetallesActivity extends AppCompatActivity implements Callback<ArrayList<Detalles>>{

    private ArrayList<Detalles> detalles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        Toast.makeText(this, "Cargando Datos, por favor espere...", Toast.LENGTH_SHORT).show();
        String id= getIntent().getExtras().getString("id");

        Call<ArrayList<Detalles>> call= ApiAdapter.getApiService().getAtractivoPorId(id);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<Detalles>> call, Response<ArrayList<Detalles>> response) {
        if (response.isSuccessful()){
            detalles=response.body();

            DetallesListAdapter adapter=new DetallesListAdapter(detalles,this);
            RecyclerView listaDetalles= (RecyclerView) findViewById(R.id.recyclerViewDetalles);
            listaDetalles.setLayoutManager(new LinearLayoutManager(this));
            listaDetalles.setAdapter(adapter);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Detalles>> call, Throwable t) {
        Toast.makeText(this, "Ocurrió un error, trate más tarde", Toast.LENGTH_SHORT).show();
    }


}