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
import pojo.Admin;

/**
 *
 * @author AndresChila
 */
public class LogicaLogin {
    private String usuario, clave, redirecciona;
    private Admin admin;

    public LogicaLogin(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public void loguearse(){
        LecturaFichero();
        if(admin.getUsuario().equals(usuario) && admin.getClave().equals(clave)){
            this.setRedirecciona("menuAdmin.xhtml");
        }
        else{
            this.setRedirecciona("");
        }
    }
    public void LecturaFichero(){
        try{
            File archivo = new File ("Archivos/admin.txt");
            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            String linea = br.readLine();
            String palabra[] = linea.split(";");
            for(int i=0;i<palabra.length;i++){
                String bufer[] = palabra[i].split(",");
                admin = new Admin(bufer[0], bufer[1]);
            }
        }
        catch(FileNotFoundException e){
             System.out.print("se revento en lectura fichero" );
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRedirecciona() {
        return redirecciona;
    }

    public void setRedirecciona(String redirecciona) {
        this.redirecciona = redirecciona;
    }
    
}
