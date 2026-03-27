package mx.unam.aragon.ico.te.BD.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Libro {
    @Id
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private String correoElectronicoEditorial;
    private Integer precio;
    private String genero;

    public Libro(int id, String titulo, String autor, String editorial, String correoElectronicoEditorial, int precio,
                 String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.correoElectronicoEditorial = correoElectronicoEditorial;
        this.precio = precio;
        this.genero = genero;
    }

    public Libro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCorreoElectronicoEditorial() {
        return correoElectronicoEditorial;
    }

    public void setCorreoElectronicoEditorial(String correoElectronicoEditorial) {
        this.correoElectronicoEditorial = correoElectronicoEditorial;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
