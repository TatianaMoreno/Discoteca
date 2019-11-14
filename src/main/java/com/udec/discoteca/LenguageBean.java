/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.discoteca;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *  Clase que se usa para los idiomas
 * @author tmore
 */
 
@ManagedBean(name="idioma")
@SessionScoped
public class LenguageBean implements Serializable{
       
        private static final long serialVersionUID = 1L;
       
        private String localeCode;
       
        private static Map<String,Object> countries;// creamos un map donde esperamos una cadena y un objeto
        static{
                countries = new LinkedHashMap<String,Object>();
                Locale espanol=new Locale("ES");
                countries.put("Español", espanol);
                // donde English es el valor que aparecera en el selectOnemenu y el objeto en que se convertira o traducira.
                countries.put("English", Locale.ENGLISH); 
                // donde fRANCAIS es el valor que aparecera en el selectOnemenu y el objeto en que se convertira o traducira.
                countries.put("Francais",Locale.FRENCH);
               
               
        }

        public Map<String, Object> getCountriesInMap() {
                return countries;
        }

       
        public String getLocaleCode() {
                return localeCode;
        }

        public void setLocaleCode(String localeCode) {
                this.localeCode = localeCode;
        }

        public void countryLocaleCodeChanged(ValueChangeEvent e){
               
                String newLocaleValue = e.getNewValue().toString();
               
       
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
       
                if(entry.getValue().toString().equals(newLocaleValue)){
                       
                        FacesContext.getCurrentInstance()
                                .getViewRoot().setLocale((Locale)entry.getValue());
                       
                }
        }

        }

}