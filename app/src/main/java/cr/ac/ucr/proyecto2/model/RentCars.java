package cr.ac.ucr.proyecto2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RentCars {

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
    @SerializedName("TIPO_VEHICULO")
    @Expose
    private Integer tipoVehiculo;
    @SerializedName("ESTRELLAS")
    @Expose
    private Integer estrellas;
    @SerializedName("PROVINCIAS")
    @Expose
    private Integer provincias;

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

    public Integer getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Integer tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public Integer getProvincias() {
        return provincias;
    }

    public void setProvincias(Integer provincias) {
        this.provincias = provincias;
    }

}