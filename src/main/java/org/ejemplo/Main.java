package org.ejemplo;

import org.ejemplo.Repository.ColaEjecucionImpl;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        ColaEjecucionImpl<String> colaStrings = new ColaEjecucionImpl<String>();
        colaStrings.encolar("Hola");
        colaStrings.encolar("Adios");
        colaStrings.encolar("Goodbye");
        colaStrings.encolar("Goodmorning");



        var res2 = colaStrings.find(x -> x.equals("Hola"));
        System.out.println("Uso de Find : " + res2.get());



    }
}
