package cr.ac.ucr.proyecto2.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import cr.ac.ucr.proyecto2.R;
import cr.ac.ucr.proyecto2.model.Detalles;

public class DetallesListAdapter extends  RecyclerView.Adapter<DetallesListAdapter.DetallesViewHolder>{
    private List<Detalles> detallesList;
    private Context context;



    public DetallesListAdapter(List<Detalles> detallesList, Context context) {
        this.detallesList = detallesList;
        this.context = context;
    }


    /*
    Permite construir cada item en base al layout que asigne
    */
    @NonNull
    @Override
    public DetallesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.fragment_detalles_list_, parent, false);
        DetallesViewHolder viewHolder = new DetallesViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetallesViewHolder holder, int position) {

        final Detalles detalle = detallesList.get(position);
        holder.nombre.setText(detalle.getNombre());
        holder.nombre.setTextColor(Color.BLUE);
        holder.descripcion.setText(detalle.getDescripcion());
        holder.video.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.loadVideo(detalle.getVideo(), 0);
                youTubePlayer.pause();
            }
        });

        try {
            InputStream ims = context.getAssets().open("img_atractivos/"+detalle.getImagen());
            Drawable d = Drawable.createFromStream(ims, null);
            holder.img1.setImageDrawable(d);
            ims.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     Me permite conocer el tamaño de la lista en tiempo real
     */
    @Override
    public int getItemCount() {

        return detallesList.size();
    }


    //View holder para lograr llenar el contenido de cada item
    public static class DetallesViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView descripcion;
        public YouTubePlayerView video;
        public LinearLayout itemLayout;
        public ImageView img1;

        public DetallesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nombre = (TextView) itemView.findViewById(R.id.detallesNombre);
            this.descripcion = (TextView) itemView.findViewById(R.id.detallesDescripcion);
            this.video = (YouTubePlayerView) itemView.findViewById(R.id.youtube_player_view_detalles);
            this.img1 = (ImageView) itemView.findViewById(R.id.imgv_imagen1_detalles);
            this.itemLayout = (LinearLayout) itemView.findViewById(R.id.detalles_ly);
        }
    }
}
