/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.Artista;
import pojo.Disco;

/**
 *
 * @author AndresChila
 */
@ManagedBean(name = "crudDisco")
@SessionScoped
public class CrudDisco implements Serializable {
    public String caratula, nombre, artista;
    public List<Artista> listaArtista;
    public List<Disco> listaDisco;
    /**
     * Creates a new instance of CrudDisco
     */
    public CrudDisco() {
    }
    @PostConstruct
    public void init(){
        listaArtista = new ArrayList<>();
        listaDisco = new ArrayList<>();
    }
    public void agregarDisco(){
        Disco disc = new Disco(caratula, nombre, artista);
        listaDisco.add(disc);
    }
    public void eliminarDisco(Disco disc){
        listaDisco.remove(disc);
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public List<Disco> getListaDisco() {
        return listaDisco;
    }

    public void setListaDisco(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }
    
}
