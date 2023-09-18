package org.ejemplo.Tda;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface Cola<T> {

    void encolar(T element);

    Optional<T> desencolar();


    Optional<T> first();


    boolean esVacia();


    int size();

    void vaciar();


    void mostrar();

    List<T> filter(Function<T, Boolean> function);

    List<T> map(Function<T, T> function);

    Optional find(Function<T, Boolean> function);

    Integer findIndex(Function<T,Boolean> function);

    Optional findLast(Function<T,Boolean> function);

    Integer findLastIndex(Function<T,Boolean> function);

    void  forEach(Function<T,Void> function);

    List<T> sort(Function<T,Boolean> function);
}