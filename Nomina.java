/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.empleado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mau
 */
public class Nomina {

    public static void main(String[] args) throws FileNotFoundException {
        File Arch = new File("D:\\descargas chrome/julio(1).dat"); 
        Nomina Prueba = new Nomina(Arch);
        Prueba.Lista_Sueldo();
        System.out.println("--------------------|-|-|-|-|--------------------");
        Prueba.Mayor_Ant();
        Prueba.Menor_Ant();
    }

    int rozmiar = 0;
    ArrayList<ArrayList<String>> OutterArray = new ArrayList();
    Arreglos_ADT<Empleado> Nomina;
    String[] Lineas;
    String[] TamLis;
    Empleado Emp;
    Empleado Imp;
    Empleado Maximus;
    Empleado MediumMax;
    Empleado Minumus;
    Empleado MediumMin;

    public Nomina(File Arch) throws IOException { 
        Path Ruta = Arch.toPath();
        BufferedReader lector = Files.newBufferedReader(Ruta);
        String Leido;
        while ((Leido = lector.readLine()) != null) {
            Lineas = Leido.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            TamLis = Leido.split("\n");
            rozmiar += TamLis.length;
            ArrayList<String> InnerArray = new ArrayList();
            InnerArray.addAll(Arrays.asList(Lineas));
            OutterArray.add(InnerArray);
        }
        
        Nomina = new Arreglos_ADT(rozmiar - 1);
        int Columnas = 0;
        for (int Filas = 1; Filas < OutterArray.size(); Filas++) {
            Emp = new Empleado(Integer.parseInt(OutterArray.get(Filas).get(0)), OutterArray.get(Filas).get(1), OutterArray.get(Filas).get(2), OutterArray.get(Filas).get(3), Integer.parseInt(OutterArray.get(Filas).get(4)), Integer.parseInt(OutterArray.get(Filas).get(5)), Integer.parseInt(OutterArray.get(Filas).get(6)));
            Nomina.setItem(Columnas, Emp);
            Columnas++;
        }

    }

    public void Lista_Sueldo() {
        for (int rozmita = 0; rozmita < Nomina.getLenght(); rozmita++) {
            Imp = Nomina.getItem(rozmita);
            System.out.println("Id: " + Imp.get_NumTrabajador() + "; Sueldo: " + Imp.CalcularSueldo());
        }
    }

    public void Mayor_Ant() {
        int Max = 2023;
        String Who = "";
        String SeWho = "";
        for (int ind = 0; ind < Nomina.getLenght(); ind++) {
            Maximus = Nomina.getItem(ind);
            if (Maximus.get_AñoIngreso() < Max) {
                Max = Maximus.get_AñoIngreso();
                Who = Maximus.get_Nombres();
            }
        }
        System.out.println("Persona con mayor antiguedad: " + Who + ", desde: " + Max);

        for (int ind = 0; ind < Nomina.getLenght(); ind++) {
            MediumMax = Nomina.getItem(ind);
            if (MediumMax.get_AñoIngreso() < Max && MediumMax.get_Nombres().equals(Who)) {
                //Si lo encuentra, no hace nada.
            } else {
                Max = MediumMax.get_AñoIngreso();
                SeWho = MediumMax.get_Nombres();
            }
        }
        System.out.println("La segunda persona con mayor antiguedad: " + SeWho + ", desde: " + Max);
    }

    public void Menor_Ant() {
        int Max2 = 2016;
        String Who2 = "";
        String SeWho2 = "";
        for (int ind = 0; ind < Nomina.getLenght(); ind++) {
            Minumus = Nomina.getItem(ind);
            if (Minumus.get_AñoIngreso() > Max2) {
                Max2 = Minumus.get_AñoIngreso();
                Who2 = Minumus.get_Nombres();
            }
        }
        System.out.println("Persona mas antigua: " + Who2 + ", desde: " + Max2);

        for (int ind = 0; ind < Nomina.getLenght(); ind++) {
            MediumMin = Nomina.getItem(ind);
            if (MediumMin.get_AñoIngreso() == Max2) {
                if (MediumMin.get_Nombres().equals(Who2)) {
                    //Si lo encuentra, no hace nada.
                } else {
                    Max2 = MediumMin.get_AñoIngreso();
                    SeWho2 = MediumMin.get_Nombres();
                }
            }
        }
        System.out.println("La segunda persona con menor antiguedad: " + SeWho2 + ", desde: " + Max2);
    }

}