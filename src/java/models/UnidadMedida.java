/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Tama
 */
public class UnidadMedida {
    private int id;
    private String descripcion;
    private String abreviacion;

    public UnidadMedida() {
    }

    public UnidadMedida(int id, String descripcion, String abreviacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.abreviacion = abreviacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }
    
    
}
