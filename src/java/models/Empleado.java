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
public class Empleado {
    private String codigo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Sucursal sucursalPerteneciente;

    public Empleado() {
    }

    public Empleado(String codigo, String nombre, String apellido, String email, String telefono, Sucursal sucursalPerteneciente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.sucursalPerteneciente = sucursalPerteneciente;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Sucursal getSucursalPerteneciente() {
        return sucursalPerteneciente;
    }

    public void setSucursalPerteneciente(Sucursal sucursalPerteneciente) {
        this.sucursalPerteneciente = sucursalPerteneciente;
    }
    
    
}
