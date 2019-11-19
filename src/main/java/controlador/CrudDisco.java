/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    public List<String> nombresArtistas = new ArrayList<>();
    /**
     * Creates a new instance of CrudDisco
     */
    public CrudDisco() {
    }
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getExternalContext().getSessionMap().get("listaArtista") == null){
            listaArtista = new ArrayList<>();
        }else{
            listaArtista = (List<Artista>) context.getExternalContext().getSessionMap().get("listaArtista");
        }
        if(context.getExternalContext().getSessionMap().get("listaDiscos")==null){
            listaDisco = new ArrayList<>();
        }
        else{
            listaDisco = (List<Disco>) context.getExternalContext().getSessionMap().get("listaDiscos");
        }
        for(Artista a : listaArtista){
            nombresArtistas.add(a.getNombre()+" "+a.getApellido());
        }
    }
    public void agregarDisco(){
        Disco disc = new Disco(caratula, nombre, artista);
        listaDisco.add(disc);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaDiscos", this.getListaDisco());
        caratula="";
        nombre="";
        artista="";
    }
    public void eliminarDisco(Disco disc){
        listaDisco.remove(disc);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaDiscos", this.getListaDisco());
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

    public List<String> getNombresArtistas() {
        return nombresArtistas;
    }

    public void setNombresArtistas(List<String> nombresArtistas) {
        this.nombresArtistas = nombresArtistas;
    }
    
}
