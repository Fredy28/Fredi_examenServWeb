/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fredi
 */
public class ListaCarrera {
    private List<CarreraModel> listaCarrera = new ArrayList<>();

    public void agregarCarrera(CarreraModel bean) {
        listaCarrera.add(bean);
    }

    public List<CarreraModel> getListaDatos() {
        return listaCarrera;
    }
}
