package cr.ac.ucr.proyecto2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hotels {

    @SerializedName("NOMBRE")
    @Expose
    private String nombre;
    @SerializedName("DESCRIPCION")
    @Expose
    private String descripcion;
    @SerializedName("TELEFONO")
    @Expose
    private String telefono;
    @SerializedName("SITIO_WEB")
    @Expose
    private String sitioWeb;
    @SerializedName("IMAGEN")
    @Expose
    private String imagen;
    @SerializedName("ESTRELLAS")
    @Expose
    private Integer estrellas;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
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

}