package cr.ac.ucr.proyecto2;

public class ListElement {

    public String nombre;
    public String descripcion;
    public String telefono;
    public String sitioWeb;
    public String imagen;
    public Integer estrellas;

    public ListElement(String nombre, String descripcion, String telefono, String sitioWeb, String imagen, Integer estrellas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.sitioWeb = sitioWeb;
        this.imagen = imagen;
        this.estrellas = estrellas;
    }

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
