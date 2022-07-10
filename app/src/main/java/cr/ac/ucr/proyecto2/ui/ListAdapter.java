package cr.ac.ucr.proyecto2.ui;

import android.content.Context;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import cr.ac.ucr.proyecto2.ListElement;
import cr.ac.ucr.proyecto2.MainActivity;
import cr.ac.ucr.proyecto2.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private static Context context;
    private ViewGroup Gparent;

    public ListAdapter(List<ListElement> itemList, Context context){

        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;

    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Gparent = parent;

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element, parent, false);

        return new ListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    public void setItems(List<ListElement> items){
        mData = items;
    }

    public static Context getContext() {
        return context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        ViewHolder(View itemView){
            super(itemView);




        }




        //Este metodo dice que cambios va a tener cada elemento
        void binData(final ListElement item){


//        try
//        {
//            InputStream ims = getContext().getAssets().open("img/"+item.getRutaImagen());
//            Drawable d = Drawable.createFromStream(ims, null);
//            rutasImagen.setImageDrawable(d);
//            ims.close();
//        }
//        catch(IOException ex)
//        {
//            return;
//        }



        }

    }



}
