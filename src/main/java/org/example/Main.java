package org.example;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.recorrerGrafo();
        System.out.println(grafo.encontrarCaminoCorto());
    }
}