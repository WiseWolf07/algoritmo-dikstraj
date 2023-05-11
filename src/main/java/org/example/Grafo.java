package org.example;

import java.util.*;

public class Grafo {
    private Vertices vInicial = new Vertices("A", "Escuela");
    private Vertices vB = new Vertices("B","Hospital");
    private Vertices vC = new Vertices("C", "Feria");
    private Vertices vD = new Vertices("D", "Estadio");
    private Vertices vE = new Vertices("E", "Tienda de Golosinas");
    private Vertices vF = new Vertices("F", "Banco");
    private Vertices vH = new Vertices("H", "Iglesia");
    private Vertices vFinal = new Vertices("G", "Cine");

    private List<Vertices> listaVertices = Arrays.asList(vInicial,vB,vC,vD,vE,vF,vH,vFinal);
    public Grafo(){
        unirVertices();
        vInicial.setDistanciaCorta("A","0");
    }

    private void unirVertices(){
        listaVertices.get(0).agregarVertice(vB,10);
        listaVertices.get(0).agregarVertice(vC,25);
        listaVertices.get(0).agregarVertice(vD,32);
        listaVertices.get(1).agregarVertice(vE,5);
        listaVertices.get(1).agregarVertice(vF,8);
        listaVertices.get(2).agregarVertice(vD,12);
        listaVertices.get(3).agregarVertice(vFinal,15);
        listaVertices.get(4).agregarVertice(vH,7);
        listaVertices.get(5).agregarVertice(vD,5);
        listaVertices.get(5).agregarVertice(vE,3);
        listaVertices.get(5).agregarVertice(vFinal,17);
        listaVertices.get(6).agregarVertice(vFinal,11);
    }

    public void recorrerGrafo(){
        for(int i = 0; i < listaVertices.size(); i++){
            String letraPadre = listaVertices.get(i).getLetra();
            int distanciaVertice = Integer.parseInt(listaVertices.get(i).getDistanciaCorta().get(1));
            for (Map.Entry<Vertices,Integer> entry: listaVertices.get(i).getVerticesAdyacentes().entrySet()) {
                int distancia = 0;
                int distanciaActual = Integer.parseInt(entry.getKey().getDistanciaCorta().get(1));
                distancia += entry.getValue() + distanciaVertice;
                if(esMenorDistancia(distanciaActual, distancia)){
                    cambiarDistancia(entry.getKey() ,letraPadre ,distancia + "");
                }
            }
        }
    }

    private boolean esMenorDistancia(Integer distanciaActual, Integer distanciaNueva){
        return (distanciaNueva < distanciaActual);
    }

    private void cambiarDistancia(Vertices vertice,String letraVertice, String distancia){
        vertice.setDistanciaCorta(letraVertice,distancia);
    }

    public String encontrarCaminoCorto(){
        String mensaje = "";
        String letra = vFinal.getDistanciaCorta().get(0);
        String nombreLetra;
        while(!(letra.equalsIgnoreCase( "A"))) {
            for (Vertices vertice : listaVertices) {
                if (vertice.getLetra().equalsIgnoreCase(letra)) {
                    nombreLetra = vertice.getNombre();
                    letra = vertice.getDistanciaCorta().get(0);
                    mensaje = nombreLetra + mensaje;
                }
            }
            mensaje = "-->" + mensaje;
        }
        return "El camino más corto es: " + vInicial.getNombre() + mensaje + "-->" + vFinal.getNombre();
    }
}
