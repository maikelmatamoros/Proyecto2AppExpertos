package cr.ac.ucr.proyecto2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Atractivo {
    @SerializedName("ID")
    @Expose
    private int id;
    @SerializedName("TIPOLUGAR")
    @Expose
    private String tipoLugar;
    @SerializedName("TIPOTURISTA")
    @Expose
    private String tipoTurista;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoLugar() {
        return tipoLugar;
    }

    public void setTipoLugar(String tipoLugar) {
        this.tipoLugar = tipoLugar;
    }

    public String getTipoTurista() {
        return tipoTurista;
    }

    public void setTipoTurista(String tipoTurista) {
        this.tipoTurista = tipoTurista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    @SerializedName("NOMBRE")
    @Expose
    private String nombre;
    @SerializedName("PRECIO")
    @Expose
    private int precio;
    @SerializedName("IMAGEN")
    @Expose
    private String imagen;
    @SerializedName("ESTRELLAS")
    @Expose
    private Integer estrellas;


}
