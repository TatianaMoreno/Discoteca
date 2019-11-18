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
import pojo.Cancion;
import pojo.Disco;

/**
 *
 * @author AndresChila
 */
@ManagedBean(name = "crudCancion")
@SessionScoped
public class CrudCancion implements Serializable {
    private String nombre, duracion;
    private double precio;
    private List<Cancion> listaCanciones;
    private List<Disco> listaDisco;
    /**
     * Creates a new instance of CrudCancion
     */
    public CrudCancion() {
    }
    @PostConstruct
    public void init(){
        listaCanciones = new ArrayList<>();
        listaDisco = new ArrayList<>();
        ///////llenar listas de .txt
    }
    public void agregarCancion(){
        Cancion can = new Cancion(nombre, duracion, precio);
        listaCanciones.add(can);
        /////actualizar el TXT
    }
    public void eliminarCancion(Cancion can){
        listaCanciones.remove(can);
        /// actualizar el TXT
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
    
}
