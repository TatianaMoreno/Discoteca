/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import logica.LogicaCrudArtista;
import pojo.Artista;

/**
 *
 * @author AndresChila
 */
@ManagedBean(name = "crudArtista")
@SessionScoped
public class CrudArtista implements Serializable {
    private String apellido, nombre;
    private Date fechana;
    private List<Artista> lista;
    /**
     * Creates a new instance of CrudArtista
     */
    public CrudArtista() {
    }
    @PostConstruct
    public void init(){
        lista = new ArrayList<>();
    }
    public void agregaArtista(){
        Artista art = new Artista(nombre, apellido, fechana, apellido);
        lista.add(art);
    }
    public void eliminarArtista(Artista art){
        LogicaCrudArtista logica = new LogicaCrudArtista(lista, art);
        logica.eliminarArtista();
        this.setLista(logica.getLista());
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechana() {
        return fechana;
    }

    public void setFechana(Date fechana) {
        this.fechana = fechana;
    }

    public List<Artista> getLista() {
        return lista;
    }

    public void setLista(List<Artista> lista) {
        this.lista = lista;
    }
    
}
