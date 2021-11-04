/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Tama
 */
public class Despacho {
    private String codigo;
    private Sucursal sucursalOrigen;
    private Empleado empleadoGeneracion;
    private Timestamp fhGeneracion;
    private Sucursal sucursalDestino;
    private Empleado empleadoRecepcion;
    private Timestamp fhRecepcion;
    private EmpresaTransportista empresaTransportista;
    private EstadoDespacho estado;
    private ArrayList<DetalleDespacho> detalle;

    public Despacho() {
    }

    public Despacho(String codigo, Sucursal sucursalOrigen, Empleado empleadoGeneracion, Timestamp fhGeneracion, Sucursal sucursalDestino, Empleado empleadoRecepcion, Timestamp fhRecepcion, EmpresaTransportista empresaTransportista, EstadoDespacho estado, ArrayList<DetalleDespacho> detalle) {
        this.codigo = codigo;
        this.sucursalOrigen = sucursalOrigen;
        this.empleadoGeneracion = empleadoGeneracion;
        this.fhGeneracion = fhGeneracion;
        this.sucursalDestino = sucursalDestino;
        this.empleadoRecepcion = empleadoRecepcion;
        this.fhRecepcion = fhRecepcion;
        this.empresaTransportista = empresaTransportista;
        this.estado = estado;
        this.detalle = detalle;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Sucursal getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(Sucursal sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public Empleado getEmpleadoGeneracion() {
        return empleadoGeneracion;
    }

    public void setEmpleadoGeneracion(Empleado empleadoGeneracion) {
        this.empleadoGeneracion = empleadoGeneracion;
    }

    public Timestamp getFhGeneracion() {
        return fhGeneracion;
    }

    public void setFhGeneracion(Timestamp fhGeneracion) {
        this.fhGeneracion = fhGeneracion;
    }

    public Sucursal getSucursalDestino() {
        return sucursalDestino;
    }

    public void setSucursalDestino(Sucursal sucursalDestino) {
        this.sucursalDestino = sucursalDestino;
    }

    public Empleado getEmpleadoRecepcion() {
        return empleadoRecepcion;
    }

    public void setEmpleadoRecepcion(Empleado empleadoRecepcion) {
        this.empleadoRecepcion = empleadoRecepcion;
    }

    public Timestamp getFhRecepcion() {
        return fhRecepcion;
    }

    public void setFhRecepcion(Timestamp fhRecepcion) {
        this.fhRecepcion = fhRecepcion;
    }

    public EmpresaTransportista getEmpresaTransportista() {
        return empresaTransportista;
    }

    public void setEmpresaTransportista(EmpresaTransportista empresaTransportista) {
        this.empresaTransportista = empresaTransportista;
    }

    public EstadoDespacho getEstado() {
        return estado;
    }

    public void setEstado(EstadoDespacho estado) {
        this.estado = estado;
    }

    public ArrayList<DetalleDespacho> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<DetalleDespacho> detalle) {
        this.detalle = detalle;
    }
    
    
}
