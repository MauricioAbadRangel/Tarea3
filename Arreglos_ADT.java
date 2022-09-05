/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empleado;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Mau
 * @param <T>
 */
public class Arreglos_ADT<T> {

    public static void main(String[] args) {
        Arreglos_ADT lista = new Arreglos_ADT(12); //Constructor
        System.out.println("Dato inicial: " + lista.getElemento(5)); //getElemento
        lista.setElemento("Soy un dato...", 5); //setElemento
        lista.setElemento(new Empleado(18, "MAURICIO", "ABAD", "RANGEL", 18, 35000, 2003), 1);
        System.out.println("Dato modificado: " + lista.getElemento(5));
        System.out.println("Tamaño de la lista: " + lista.getLenght()); //getLenght
        Iterator a = lista.getIterator();
        System.out.println("Impresión utilizando el iterador");
        while (a.hasNext()) {
            System.out.println("-" + a.next());
        }
        System.out.println("-------------------------------");
        lista.clear(5); //clear
        System.out.println("Impresión utilizando toString");
        System.out.println(lista.toString()); //toString
    }

    private final ArrayList<T> datos;

    /**
     * Constructor: crea un ArrayList con el tamaño especificado y almacena null
     * como valor de inicio en cada espacio
     *
     */
    public Arreglos_ADTnt tamanio) {
        this.datos = new ArrayList<>(tamanio);
        for (int indice = 0; indice < tamanio; indice++) {
            datos.add(null);
        }
    }

    Arreglos_ADT(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Arreglos_ADT(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param indice
     * @return Regresa el valor almacenado en el indice indicado, si el indice
     * indicado esta fuera del rango del arreglo regresa null
     */
    public T getElemento(int indice) {
        if (indice >= 0 && indice < datos.size()) {
            return (T) (datos.get(indice));
        }
        return null;
    }

    /**
     * Remplaza el dato almacenado en el indice indicado por el nuevo tipo de
     * dato que se indique
     * @param elemento
     * @param indice
     */
    public void setElemento(T elemento, int indice) { //Setter
        if (indice >= 0 && indice < datos.size()) {
            datos.set(indice, elemento);
        } 
    }

    /**
     *
     * @return Regresa el tamaño de la lista
     */
    public int getLenght() {
        return datos.size();
    }

    /**
     * Remplaza todos los datos almacenados en la lista por un dato indicado
     *
     * @param elemento
     */
    public void clear(T elemento) {
        for (int indice = 0; indice < datos.size(); indice++) {
            datos.set(indice, elemento);
        }
    }

    public Iterator getIterator() {
        return datos.listIterator();
    }

    public Iterator getIterator(int indice) {
        return datos.listIterator(indice);
    }

    /**
     * Imprime todo los datos almacenados en la lista
     */
    @Override
    public String toString() {
//        String salida = "";
//        salida = datos.stream().map(elemento -> elemento + ", ").reduce(salida, String::concat);
        return datos.toString();
    }

    void setItem(int Columnas, Empleado Emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Empleado getItem(int rozmita) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class Arreglos_ADTnt {

        public Arreglos_ADTnt() {
        }
    }
}