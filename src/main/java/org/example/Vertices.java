package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Vertices {

    private String letra;
    private String nombre;
    private HashMap<Vertices,Integer> verticesAdyacentes = new HashMap<>();
    private ArrayList<String> distanciaCorta = new ArrayList<>();

    public Vertices(){ }
    public Vertices(String letra, String nombre){
        this.letra = letra;
        this.nombre = nombre;
        distanciaCorta.add(letra);
        distanciaCorta.add("999");
    }

    public void agregarVertice(Vertices vertice, Integer distancia){
        verticesAdyacentes.put(vertice,distancia);
    }

    public String getLetra() {
        return letra;
    }

    public ArrayList<String> getDistanciaCorta() {
        return distanciaCorta;
    }

    public void setDistanciaCorta(String vertice, String distancia) {
        distanciaCorta.clear();
        distanciaCorta.add(vertice);
        distanciaCorta.add(distancia);
    }

    public void setVerticesAdyacentes(HashMap<Vertices, Integer> verticesAdyacentes) {
        this.verticesAdyacentes = verticesAdyacentes;
    }

    public HashMap<Vertices, Integer> getVerticesAdyacentes() {
        return verticesAdyacentes;
    }

    public String getNombre() {
        return nombre;
    }
}
