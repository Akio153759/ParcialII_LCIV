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
public class Sucursal {
    private String codigo;
    private String nombre;
    private String direccion;
    private Barrio barrio;
    private Empleado responsable;

    public Sucursal() {
    }

    public Sucursal(String codigo, String nombre, String direccion, Barrio barrio, Empleado responsable) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.barrio = barrio;
        this.responsable = responsable;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }
    
    
}
