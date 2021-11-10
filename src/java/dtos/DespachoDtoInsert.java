/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.ArrayList;

/**
 *
 * @author Tama
 */
public class DespachoDtoInsert {
    private String sucOrigen;
    private String sucDestino;
    private String empresaTransp;
    private ArrayList<DetalleDespachoDtoInsert> detalle;

    public String getSucOrigen() {
        return sucOrigen;
    }

    public void setSucOrigen(String sucOrigen) {
        this.sucOrigen = sucOrigen;
    }

    public String getSucDestino() {
        return sucDestino;
    }

    public void setSucDestino(String sucDestino) {
        this.sucDestino = sucDestino;
    }

    public String getEmpresaTransp() {
        return empresaTransp;
    }

    public void setEmpresaTransp(String empresaTransp) {
        this.empresaTransp = empresaTransp;
    }

    public ArrayList<DetalleDespachoDtoInsert> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<DetalleDespachoDtoInsert> detalle) {
        this.detalle = detalle;
    }
    
    
}
