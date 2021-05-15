package com.loteria.mega.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Numeros {

    public static String sortear(){

        ArrayList<Integer> listaNumero;
        listaNumero = new ArrayList<>();

        Random numerosSorteados = new Random();

        for (int n = 0; n < 6; ) {
            Integer dezena = numerosSorteados.nextInt(60) + 1;
            if (!listaNumero.contains(dezena)) {
                listaNumero.add(dezena);
                n++;
            }
        }
        Collections.sort(listaNumero);

        return listaNumero.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
