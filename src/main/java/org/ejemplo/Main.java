package org.ejemplo;

import org.ejemplo.Model.Proceso;
import org.ejemplo.Repository.ColaEjecucionImpl;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public void colaString(){
        ColaEjecucionImpl<String> colaStrings = new ColaEjecucionImpl<String>();
        colaStrings.encolar("Hola");
        colaStrings.encolar("Adios");
        colaStrings.encolar("paka1");
        colaStrings.encolar("Goodbye");
        colaStrings.encolar("Hola");
        colaStrings.encolar("paka2");
        colaStrings.encolar("Goodmorning");


        List<String> res = colaStrings.filter( x ->  x.length() > 5);
        System.out.println("Uso de Filter : ");
        res.forEach(System.out::println);

        List<String> res2 = colaStrings.map( x -> x.concat("!"));
        System.out.print("Uso de Map : ");
        res2.forEach(System.out::println);

        var res3 = colaStrings.find(x -> x.contains("p"));
        System.out.println("Uso de Find : " + res3.get());

        var res4 = colaStrings.findIndex(x -> x.equals("Hola"));
        System.out.println("Uso de FindIndex : " + res4);

        var res5 = colaStrings.findLast( x -> x.contains("p"));
        System.out.println("Uso de FindLast : " + res5.get());

        var res6 = colaStrings.findLastIndex(x -> x.equals("Hola"));
        System.out.println("Uso de FindLastIndex : " + res6);

        System.out.println("Uso de ForEach : ");
         colaStrings.forEach(x -> {
            System.out.println("Imprimo : "+x);
            return null;
         });

         var res7 = colaStrings.sort((x,y) -> x.length() < y.length());
         System.out.println("Uso de sort : " + res7);
    }
    
    public void colaInteger(){
        ColaEjecucionImpl<Integer> colaInteger = new ColaEjecucionImpl<Integer>();
        colaInteger.encolar(5);
        colaInteger.encolar(10);
        colaInteger.encolar(7);
        colaInteger.encolar(50);
        colaInteger.encolar(32);

        List<Integer> res = colaInteger.filter( x ->  x > 10);
        System.out.println("Uso de Filter : ");
        res.forEach(System.out::println);

        List<Integer> res2 = colaInteger.map( x -> x * 10);
        System.out.println("Uso de Map : ");
        res2.forEach(System.out::println);

        var res3 = colaInteger.find(x -> x < 10);
        System.out.println("Uso de Find : " + res3.get());

        var res4 = colaInteger.findIndex(x -> x < 10);
        System.out.println("Uso de FindIndex : " + res4);

        var res5 = colaInteger.findLast( x -> x < 10);
        System.out.println("Uso de FindLast : " + res5.get());

        var res6 = colaInteger.findLastIndex(x -> x < 10);
        System.out.println("Uso de FindLastIndex : " + res6);

        System.out.println("Uso de ForEach : ");
         colaInteger.forEach(x -> {
             System.out.println(Math.pow(x,2));
            return null;});

         var res7 = colaInteger.sort((x,y) -> x < y);
         System.out.println("Uso de sort : " + res7);
    }

    public void colaProceso(){
    ColaEjecucionImpl<Proceso> colaProcesos = new ColaEjecucionImpl<Proceso>();
        colaProcesos.encolar(new Proceso("P1",10,4));
        colaProcesos.encolar(new Proceso("P2",30,7));
        colaProcesos.encolar(new Proceso("P3",22,5));
        colaProcesos.encolar(new Proceso("P4",13,1));
        colaProcesos.encolar(new Proceso("P5",24,8));

        List<Proceso> res = colaProcesos.filter( x ->  x.getPriority() >= 5);
        System.out.println("Uso de Filter : ");
        res.forEach(x -> System.out.println(x.getName() + " - " + x.getPriority()));

        List<Proceso> res2 = colaProcesos.map( x -> x);
        System.out.println("Uso de Map : ");
        res2.forEach(x -> System.out.println(x.getName() + " " + x.getPriority()));

        var res3 = colaProcesos.find(x -> x.getPriority() <= 5);
        System.out.println("Uso de Find : " + res3.get());

        var res4 = colaProcesos.findIndex(x -> x.getPriority() <= 5);
        System.out.println("Uso de FindIndex : " + res4);

        var res5 = colaProcesos.findLast( x -> x.getPriority() <= 5);
        System.out.println("Uso de FindLast : " + res5.get());

        var res6 = colaProcesos.findLastIndex(x -> x.getPriority() <= 5);
        System.out.println("Uso de FindLastIndex : " + res6);

        System.out.println("Uso de ForEach : ");
         colaProcesos.forEach(x -> {
            System.out.println("Imprimo : "+ x.getName() + " " + x.getPriority());
            return null;});

         List<Proceso> res7 = colaProcesos.sort((x, y) -> x.getPriority() < y.getPriority());
         System.out.println("Uso de sort : ");
         res7.forEach(x -> System.out.println(x.getName() + " - " + x.getPriority()));
    }
    public static void main(String[] args) {
        Main m = new Main();

        //m.colaString();
        //m.colaInteger();
        m.colaProceso();
    }
}
