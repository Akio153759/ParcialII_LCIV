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
}
