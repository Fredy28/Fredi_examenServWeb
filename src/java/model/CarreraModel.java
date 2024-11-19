/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fredi
 */
public class CarreraModel {
    private int clave;
    private String carrera;
    private int duracion;
    private String campo;
    private String nivel;

    public CarreraModel() {
    }

    public CarreraModel(int clave, String carrera, int duracion, String campo, String nivel) {
        this.clave = clave;
        this.carrera = carrera;
        this.duracion = duracion;
        this.campo = campo;
        this.nivel = nivel;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "CarreraModel{" + "clave=" + clave + ", carrera=" + carrera + ", duracion=" + duracion + ", campo=" + campo + ", nivel=" + nivel + '}';
    }
    
    
}
