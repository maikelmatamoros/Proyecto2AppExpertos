package cr.ac.ucr.proyecto2.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cr.ac.ucr.proyecto2.DetallesActivity;
import cr.ac.ucr.proyecto2.R;
import cr.ac.ucr.proyecto2.model.Atractivo;

public class AtractivosListAdapter extends  RecyclerView.Adapter<AtractivosListAdapter.AtractivosViewHolder>{
    private List<Atractivo> atractivosList;
    private Context context;

    public Context getContext() {
        return context;
    }
    public AtractivosListAdapter(ArrayList<Atractivo> atractivosList, Context context) {
        this.atractivosList = atractivosList;
        this.context = context;
    }
    public LayoutInflater inflater;
    @NonNull
    @Override
    public AtractivosListAdapter.AtractivosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.fragment_list_atractivo_item, parent, false);
        AtractivosListAdapter.AtractivosViewHolder viewHolder = new AtractivosListAdapter.AtractivosViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AtractivosListAdapter.AtractivosViewHolder holder, int position) {

        final Atractivo atractivos = atractivosList.get(position);
        holder.nombre.setText(atractivos.getNombre());
        holder.nombre.setTextColor(Color.BLUE);
        holder.tipoLugar.setText("Lugar:"+atractivos.getTipoLugar());
        holder.tipoTurista.setText("Ambiente:"+atractivos.getTipoTurista());
        holder.estrellas.setText("Estrellas:"+atractivos.getEstrellas());
        holder.precio.setText("Precio:"+atractivos.getPrecio());


        try {
            InputStream ims = getContext().getAssets().open("img_atractivos/"+atractivos.getImagen());
            Drawable d = Drawable.createFromStream(ims, null);
            holder.img1.setImageDrawable(d);
            ims.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //holder.img.setBackgroundResource(R.drawable.tips);

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), DetallesActivity.class);
                intent.putExtra("id", String.valueOf(atractivos.getId()));
                v.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        //Toast.makeText(context, "Tamaño de lista: "+paisesList.size(), Toast.LENGTH_SHORT).show();
        return atractivosList.size();
    }


    //View holder para lograr llenar el contenido de cada item
    public static class AtractivosViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView tipoTurista;
        public TextView tipoLugar;
        public TextView precio;
        public TextView estrellas;
        public ImageView img1;
        public LinearLayout itemLayout;

        public AtractivosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nombre = (TextView) itemView.findViewById(R.id.tv_nombre_atractivo);
            this.tipoTurista = (TextView) itemView.findViewById(R.id.tv_tipo_turista_atractivo);
            this.tipoLugar = (TextView) itemView.findViewById(R.id.tv_tipo_lugar_atractivo);
            this.precio = (TextView) itemView.findViewById(R.id.tv_precio_atractivo);
            this.estrellas = (TextView) itemView.findViewById(R.id.tv_estrellas_atractivo);
            this.img1 = (ImageView) itemView.findViewById(R.id.imgv_imagen1_atractivo);
            this.itemLayout = (LinearLayout) itemView.findViewById(R.id.ly_atractivos);
        }
    }
}
