/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casoestudioprogramacion.modelos;

import java.util.Date;

/**
 *
 * @author serhe
 */
public class Serie {
    
    //private int id;
    private String codigo;
    private String titulo;
    private String fecha;
    private int temporadas;
    private String genero;
    private String actores;
    private String sinopsis;

    public Serie(String codigo, String titulo, String fecha, int temporadas, String genero, String actores, String sinopsis) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fecha = fecha;
        this.temporadas = temporadas;
        this.genero = genero;
        this.actores = actores;
        this.sinopsis = sinopsis;
    }

    /**
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    **/
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "Serie{" + "codigo=" + codigo + ", titulo=" + titulo + ", fecha=" + fecha + ", temporadas=" + temporadas + ", genero=" + genero + ", actores=" + actores + ", sinopsis=" + sinopsis + '}';
    }
    
    
    
    
}
