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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pojo.Cancion;
import pojo.Disco;

/**
 *
 * @author AndresChila
 */
@ManagedBean(name = "crudCancion")
@RequestScoped
public class CrudCancion implements Serializable {

    private String nombre, duracion, disco;
    private double precio;
    private List<Cancion> listaCanciones;
    private List<Disco> listaDisco;
    private List<String> nombreDiscos;

    /**
     * Creates a new instance of CrudCancion
     */
    public CrudCancion() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getExternalContext().getSessionMap().get("listaCanciones") == null) {
            listaCanciones = new ArrayList<>();
        }else{
            listaCanciones = (List<Cancion>) context.getExternalContext().getSessionMap().get("listaCanciones");
        }
        if(context.getExternalContext().getSessionMap().get("listaDiscos") == null){
            listaDisco = new ArrayList<>();
        }else{
            listaDisco = (List<Disco>) context.getExternalContext().getSessionMap().get("listaDiscos");
            nombreDiscos = new ArrayList<>();
            for(Disco d : listaDisco){
                nombreDiscos.add(d.getNombre());
            }
        }
    }

    public void agregarCancion() {
        Cancion can = new Cancion(nombre, duracion, precio, disco);
        listaCanciones.add(can);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaCanciones", this.getListaCanciones());
        nombre="";
        duracion="";
        precio=0;
        disco="";
    }

    public void eliminarCancion(Cancion can) {
        listaCanciones.remove(can);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("listaCanciones", this.getListaCanciones());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public List<Disco> getListaDisco() {
        return listaDisco;
    }

    public void setListaDisco(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }

    public List<String> getNombreDiscos() {
        return nombreDiscos;
    }

    public void setNombreDiscos(List<String> nombreDiscos) {
        this.nombreDiscos = nombreDiscos;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

}
