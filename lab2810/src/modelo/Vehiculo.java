/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Estudiante
 */
public class Vehiculo {
    private String placa;
    private short modelo,valor;
    private byte tipo;
    private Date fecha;

    public Vehiculo() {
    }

    public Vehiculo(String placa, short modelo, short valor, byte tipo, Date fecha) {
        this.placa = placa;
        this.modelo = modelo;
        this.valor = valor;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public short getModelo() {
        return modelo;
    }

    public void setModelo(short modelo) {
        this.modelo = modelo;
    }

    public short getValor() {
        return valor;
    }

    public void setValor(short valor) {
        this.valor = valor;
    }

    public byte getTipo() {
        return tipo;
    }

    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
