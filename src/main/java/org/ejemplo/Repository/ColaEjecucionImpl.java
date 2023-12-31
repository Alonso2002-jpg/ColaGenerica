package org.ejemplo.Repository;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ColaEjecucionImpl<T> implements ColaEjecucion<T>{

    private final ArrayList<T> cola;

    public ColaEjecucionImpl() {
        cola = new ArrayList<T>();
    }

    @Override
    public void encolar(T element) {
        cola.add(element);
    }

    @Override
    public Optional desencolar() {
        if (cola.isEmpty()) {
            return Optional.empty();
        }

        var proceso = cola.remove(0);

        return Optional.of(proceso);
    }

    @Override
    public Optional first() {

       if (cola.isEmpty()) {
            return Optional.empty();
       }

       return Optional.of(cola.get(0));

    }

    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }

    @Override
    public int size() {
        return cola.size();
    }

    @Override
    public void vaciar() {
        cola.clear();
    }

    @Override
    public void mostrar() {
        cola.forEach(System.out::println);
    }

    @Override
    public List<T> filter(Function <T, Boolean> function){
        List<T> result = new ArrayList<>();
        for (T object:cola) {
            if (function.apply(object)){
                result.add(object);
            }
        }
        return result;
    }

    @Override
    public List<T> map(Function<T, T> function) {
        List<T> result = new ArrayList<T>();
        for (T object:cola) {
            result.add(function.apply(object));
        }
        return result;
    }

    @Override
    public Optional find(Function<T, Boolean> function){
        for (T object:cola) {
            if (function.apply(object)){
                return Optional.of(object);
            }
        }
        return Optional.empty();
    }

    @Override
    public Integer findIndex(Function<T,Boolean> function){
        int index = 0;

        for (T object:cola) {
            if (function.apply(object)){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public Optional findLast(Function<T,Boolean> function){

        for(int i = cola.size()-1; i > 0 ;i--){
            var object = cola.get(i);
            if (function.apply(object)){
                return Optional.of(object);
            }
        }

        return Optional.empty();
    }

    @Override
    public Integer findLastIndex(Function<T,Boolean> function){
         for(int i=cola.size()-1; i > 0 ;i--){
            var object = cola.get(i);
            if (function.apply(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void forEach(Function<T,Void> function){
        for(T object :cola){
            function.apply(object);
        }
    }
    @Override
    public List<T> sort(BiFunction<T,T, Boolean> function){
        List<T> result= (List<T>) cola.clone();

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size()-i-1; j++) {
               if (!function.apply(result.get(j),result.get(j+1))) {
                   T t =result.remove(j);
                   result.add(j+1,t);
               }
            }
        }
        return result;
    }

    public ArrayList<T> getCola() {
        return cola;
    }
}
