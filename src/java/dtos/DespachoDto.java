/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Timestamp;

/**
 *
 * @author Tama
 */
public class DespachoDto {
    private String codigo;
    private String sucOrigen;
    private String empGenero;
    private String fhGeneracion;
    private String sucDestino;
    private String empRecepciono;
    private String fhRecepcion;
    private String empresaTransportista;
    private String estado;

    public DespachoDto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSucOrigen() {
        return sucOrigen;
    }

    public void setSucOrigen(String sucOrigen) {
        this.sucOrigen = sucOrigen;
    }

    public String getEmpGenero() {
        return empGenero;
    }

    public void setEmpGenero(String empGenero) {
        this.empGenero = empGenero;
    }

    public String getFhGeneracion() {
        return fhGeneracion;
    }

    public void setFhGeneracion(String fhGeneracion) {
        this.fhGeneracion = fhGeneracion;
    }

    public String getSucDestino() {
        return sucDestino;
    }

    public void setSucDestino(String sucDestino) {
        this.sucDestino = sucDestino;
    }

    public String getEmpRecepciono() {
        return empRecepciono;
    }

    public void setEmpRecepciono(String empRecepciono) {
        this.empRecepciono = empRecepciono;
    }

    public String getFhRecepcion() {
        return fhRecepcion;
    }

    public void setFhRecepcion(String fhRecepcion) {
        this.fhRecepcion = fhRecepcion;
    }

    public String getEmpresaTransportista() {
        return empresaTransportista;
    }

    public void setEmpresaTransportista(String empresaTransportista) {
        this.empresaTransportista = empresaTransportista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
