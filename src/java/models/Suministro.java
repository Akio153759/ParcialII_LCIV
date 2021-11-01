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
public class Suministro {
    private String codigo;
    private String nombre;
    private String descripcion;
    private boolean ventaLibre;
    private float precioUnitario;
    private TipoSuministro tipoSuministro;
    private float contenidoNeto;
    private UnidadMedida unidadMedida;

    public Suministro(String codigo, String nombre, String descripcion, boolean ventaLibre, float precioUnitario, TipoSuministro tipoSuministro, float contenidoNeto, UnidadMedida unidadMedida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ventaLibre = ventaLibre;
        this.precioUnitario = precioUnitario;
        this.tipoSuministro = tipoSuministro;
        this.contenidoNeto = contenidoNeto;
        this.unidadMedida = unidadMedida;
    }

    public Suministro() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isVentaLibre() {
        return ventaLibre;
    }

    public void setVentaLibre(boolean ventaLibre) {
        this.ventaLibre = ventaLibre;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public TipoSuministro getTipoSuministro() {
        return tipoSuministro;
    }

    public void setTipoSuministro(TipoSuministro tipoSuministro) {
        this.tipoSuministro = tipoSuministro;
    }

    public float getContenidoNeto() {
        return contenidoNeto;
    }

    public void setContenidoNeto(float contenidoNeto) {
        this.contenidoNeto = contenidoNeto;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    
}
