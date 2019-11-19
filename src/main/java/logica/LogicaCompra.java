/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import pojo.Artista;
import pojo.Cancion;
import pojo.Disco;

/**
 *
 * @author AndresChila
 */
public class LogicaCompra {

    //private String usuario;
    private List<Cancion> listaCanciones;
    private List<Disco> listaDiscos;
    private List<Artista> listaArtistas;
    private List<Cancion> compra;
    private double total=0;
    
    public LogicaCompra(List<Cancion> listaCanciones, List<Disco> listaDiscos, List<Artista> listaArtistas, List<Cancion> compra) {
        this.listaCanciones = listaCanciones;
        this.listaDiscos = listaDiscos;
        this.listaArtistas = listaArtistas;
        this.compra = compra;
    }
    public LogicaCompra(){
        
    }
    /*public void porArtista(List<Artista>listaArtistas, List<String> nombreArtistas, List<String> compra){
     this.listaArtistas = listaArtistas;
     this.nombreArtistas = nombreArtistas;
     this.compra = compra;
     }
     public void porDisco(List<Disco>listaDiscos, List<String> nombreDiscos, List<String> compra){
     this.listaDiscos = listaDiscos;
     this.nombreDiscos = nombreDiscos;
     this.compra = compra;
     }
     public void porCancion(List<Cancion>listaCanciones, List<String> nombreCanciones, List<String> compra){
     this.listaCanciones = listaCanciones;
     this.nombreCanciones = nombreCanciones;
     this.compra = compra;
     }*/
    public void compraPorArtista(Artista art) {
        for (Artista a : listaArtistas) {
            if (a.getNombre().equals(art.getNombre())) {
                for (Disco d : listaDiscos) {
                    if (d.getArtista().equals(art.getNombre())) {
                        for (Cancion c : listaCanciones) {
                            if (c.getDisco().equals(d.getNombre())) {
                                compra.add(c);
                            }
                        }
                    }
                }
            }
        }
    }

    public void compraPorDisco(Disco dis) {
        for (Disco d : listaDiscos) {
            if (d.getNombre().equals(dis.getNombre())) {
                for (Cancion c : listaCanciones) {
                    if (c.getDisco().equals(dis.getNombre())) {
                        compra.add(c);
                    }
                }
            }
        }
    }

    public void comprarPorCancion(Cancion can) {
        for (Cancion c : listaCanciones) {
            if (c.getNombre().equals(can.getNombre())) {
                compra.add(c);
            }
        }
    }
    public void finalizarCompra(List<Cancion> compra){
        for(Cancion c : compra){
            total += c.getPrecio();
        }
    }
    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public List<Disco> getListaDiscos() {
        return listaDiscos;
    }

    public void setListaDiscos(List<Disco> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }

    public List<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(List<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    public List<Cancion> getCompra() {
        return compra;
    }

    public void setCompra(List<Cancion> compra) {
        this.compra = compra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
