package cr.ac.ucr.proyecto2.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.proyecto2.R;
import cr.ac.ucr.proyecto2.model.RentCars;

public class RentCarsListAdapter extends RecyclerView.Adapter<RentCarsListAdapter.RentCarsViewHolder> {


    private List<RentCars> rentCarsList;
    private Context context;



    public RentCarsListAdapter(ArrayList<RentCars> rentCarsList, Context context) {
        this.rentCarsList = rentCarsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RentCarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.list_element, parent, false);
        RentCarsViewHolder viewHolder = new RentCarsViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RentCarsViewHolder holder, int position) {

        final RentCars rentCars = rentCarsList.get(position);
        holder.nombre.setText(rentCars.getNombre());
        holder.descripcion.setText(rentCars.getDescripcion());
        holder.telefono.setText("Telefono: "+rentCars.getTelefono());
        holder.estrellas.setText("Estrellas: "+rentCars.getEstrellas());
        holder.web.setText(rentCars.getSitioWeb());
        holder.web.setTextColor(Color.BLUE);
        holder.img.setBackgroundResource(R.drawable.tips);

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent= new Intent(v.getContext(), DetallesActivity.class);
                //intent.putExtra("pais", pais.getCountry());
                //v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Toast.makeText(context, "Tamaño de lista: "+paisesList.size(), Toast.LENGTH_SHORT).show();
        return rentCarsList.size();
    }


    //View holder para lograr llenar el contenido de cada item
    public static class RentCarsViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView descripcion;
        public TextView telefono;
        public TextView web;
        public TextView estrellas;
        public ImageView img;
        public LinearLayout itemLayout;

        public RentCarsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            this.descripcion = (TextView) itemView.findViewById(R.id.tv_descripcion);
            this.telefono = (TextView) itemView.findViewById(R.id.tv_telefono);
            this.web = (TextView) itemView.findViewById(R.id.tv_web);
            this.estrellas = (TextView) itemView.findViewById(R.id.tv_estrellas);
            this.img = (ImageView) itemView.findViewById(R.id.imgv_imagen);
            this.itemLayout = (LinearLayout) itemView.findViewById(R.id.ly_rentCars);
        }
    }
}
