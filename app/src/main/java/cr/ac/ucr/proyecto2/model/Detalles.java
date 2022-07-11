package cr.ac.ucr.proyecto2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detalles {
    @SerializedName("NOMBRE")
    @Expose
    private String nombre;
    @SerializedName("DESCRIPCION")
    @Expose
    private String descripcion;
    @SerializedName("VIDEO")
    @Expose
    private String video;

    @SerializedName("MAPA")
    @Expose
    private String mapa;
    @SerializedName("IMAGEN")
    @Expose
    private String imagen;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }






}
