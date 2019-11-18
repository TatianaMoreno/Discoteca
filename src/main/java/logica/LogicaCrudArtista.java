/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import pojo.Disco;
import pojo.Artista;

/**
 *
 * @author AndresChila
 */
public class LogicaCrudArtista {
    private List<Artista> listaArtista;
    private Artista artista;
    private Disco disco;
    private List<Disco> listaDiscos;
    public LogicaCrudArtista(List<Artista> lista, Artista artista) {
        this.listaArtista = lista;
        this.artista = artista;
    }
    
    public void eliminarArtista(){
        if(validarDiscos())
        listaArtista.remove(artista);
    }

    public List<Artista> getLista() {
        return listaArtista;
    }

    public void setLista(List<Artista> lista) {
        this.listaArtista = lista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public List<Disco> getListaDiscos() {
        return listaDiscos;
    }

    public void setListaDiscos(List<Disco> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }
    
    public boolean validarDiscos(){
        if(listaDiscos.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    public void LecturaFichero(){
        try{
            File archivo = new File ("Archivos/discos.txt");
            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            String linea = br.readLine();
            String palabra[] = linea.split(";");
            for(int i=0;i<palabra.length;i++){
                String bufer[] = palabra[i].split(",");
                disco = new Disco(bufer[0], bufer[1], bufer[2]);
                if(bufer[2].equals(artista.getNombre()))
                listaDiscos.add(disco);
            }
        }
        catch(FileNotFoundException e){
             System.out.print("se revento en lectura fichero" );
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
